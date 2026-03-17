#!/bin/bash
# Nucleus Validator - Check consistency across framework documents

set -e

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$REPO_ROOT"

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

PASS_COUNT=0
FAIL_COUNT=0
WARN_COUNT=0

check_pass() {
    echo -e "${GREEN}✓${NC} $1"
    PASS_COUNT=$((PASS_COUNT + 1))
}

check_fail() {
    echo -e "${RED}✗${NC} $1"
    FAIL_COUNT=$((FAIL_COUNT + 1))
}

check_warn() {
    echo -e "${YELLOW}⚠${NC} $1"
    WARN_COUNT=$((WARN_COUNT + 1))
}

echo "========================================"
echo "Nucleus Framework Validator"
echo "========================================"
echo ""

# Check 1: AGENTS.md framework header
echo "Check 1: AGENTS.md framework header"
if grep -q "λ engage(nucleus)\." AGENTS.md; then
    check_pass "AGENTS.md has framework header"
else
    check_fail "AGENTS.md missing framework header"
fi

# Check 2: All symbols present in framework header
echo ""
echo "Check 2: Required symbols in framework"
SYMBOLS=("phi" "fractal" "euler" "tao" "pi" "mu" "∃" "∀" "Δ" "λ" "Ω" "∞/0" "ε/φ" "Σ/μ" "c/h" "OODA")
FRAMEWORK_HEADER=$(grep -A 2 "λ engage(nucleus)\." AGENTS.md || true)

for symbol in "${SYMBOLS[@]}"; do
    if echo "$FRAMEWORK_HEADER" | grep -q "$symbol"; then
        check_pass "Symbol '$symbol' present"
    else
        check_fail "Symbol '$symbol' missing"
    fi
done

# Check 3: VSM layers defined
echo ""
echo "Check 3: VSM layers defined in AGENTS.md"
VSM_LAYERS=("S5 — Identity" "S4 — Intelligence" "S3 — Control" "S2 — Coordination" "S1 — Operations")
for layer in "${VSM_LAYERS[@]}"; do
    if grep -q "$layer" AGENTS.md; then
        check_pass "VSM layer '$layer' defined"
    else
        check_fail "VSM layer '$layer' missing"
    fi
done

# Check 4: Eight Keys as lambdas
echo ""
echo "Check 4: Eight Keys lambdas in AGENTS.md"
EIGHT_KEYS=("λ vitality" "λ clarity" "λ purpose" "λ wisdom" "λ synthesis" "λ directness" "λ truth" "λ vigilance")
for key in "${EIGHT_KEYS[@]}"; do
    if grep -q "$key" AGENTS.md; then
        check_pass "Eight Key '$key' defined"
    else
        check_fail "Eight Key '$key' missing"
    fi
done

# Check 5: Core identity lambdas
echo ""
echo "Check 5: Core identity lambdas"
CORE_LAMBDAS=("λ nucleus" "λ attention" "λ identity" "λ testable" "λ collaboration")
for lambda in "${CORE_LAMBDAS[@]}"; do
    if grep -q "$lambda" AGENTS.md; then
        check_pass "Core lambda '$lambda' defined"
    else
        check_fail "Core lambda '$lambda' missing"
    fi
done

# Check 6: Protected files lambda in S3
echo ""
echo "Check 6: Protected files lambda"
if grep -q "λ protected" AGENTS.md && grep -q "ask_permission" AGENTS.md; then
    check_pass "Protected files lambda defined"
else
    check_fail "Protected files lambda missing"
fi

# Check 7: Upstream constraint in S3
echo ""
echo "Check 7: Upstream file constraint"
if grep -q "λ upstream" AGENTS.md && grep -q "ALWAYS_REJECT" AGENTS.md; then
    check_pass "Upstream file constraint documented"
else
    check_warn "Upstream file constraint may need clarification"
fi

# Check 8: Document map references exist
echo ""
echo "Check 8: Document map references"
DOCS=("VSM.md" "VSM_FIVE.md" "SYSTEM_DESIGN.md" "README.md")
for doc in "${DOCS[@]}"; do
    if [ -f "$doc" ]; then
        check_pass "Document '$doc' exists"
    else
        check_fail "Document '$doc' missing"
    fi
done

# Check 9: Skills directory structure
echo ""
echo "Check 9: Skills directory"
if [ -d "skills" ]; then
    check_pass "skills/ directory exists"
    SKILL_COUNT=$(find skills -name "SKILL.md" 2>/dev/null | wc -l | tr -d ' ')
    if [ "$SKILL_COUNT" -gt 0 ]; then
        check_pass "Found $SKILL_COUNT skill(s) defined"
    else
        check_warn "No SKILL.md files found in skills/"
    fi
else
    check_fail "skills/ directory missing"
fi

# Check 10: Documentation links
echo ""
echo "Check 10: Documentation link integrity"
BROKEN_LINKS=0
for md_file in *.md; do
    if [ -f "$md_file" ]; then
        LINKS=$(grep -o '\[.*\](.*\.md)' "$md_file" 2>/dev/null || true)
        if [ -n "$LINKS" ]; then
            while IFS= read -r link; do
                LINK_FILE=$(echo "$link" | sed 's/.*(\(.*\.md\)).*/\1/')
                if [ ! -f "$LINK_FILE" ] && [ ! -f "skills/$LINK_FILE" ] && [ ! -f "eca/$LINK_FILE" ]; then
                    check_warn "$md_file links to non-existent file: $LINK_FILE"
                    BROKEN_LINKS=$((BROKEN_LINKS + 1))
                fi
            done <<< "$LINKS"
        fi
    fi
done
if [ $BROKEN_LINKS -eq 0 ]; then
    check_pass "All documentation links resolve"
fi

# Check 11: Framework version
echo ""
echo "Check 11: Framework version"
if grep -q "Framework Version" AGENTS.md; then
    VERSION=$(grep "Framework Version" AGENTS.md | head -1 | sed 's/.*Version: //' | tr -d '`')
    check_pass "Framework version: $VERSION"
else
    check_warn "Framework version not specified"
fi

# Summary
echo ""
echo "========================================"
echo "Validation Summary"
echo "========================================"
echo -e "${GREEN}Passed:${NC} $PASS_COUNT"
echo -e "${YELLOW}Warnings:${NC} $WARN_COUNT"
echo -e "${RED}Failed:${NC} $FAIL_COUNT"
echo ""

if [ $FAIL_COUNT -eq 0 ]; then
    echo -e "${GREEN}✓ All critical checks passed${NC}"
    exit 0
else
    echo -e "${RED}✗ Validation failed${NC}"
    exit 1
fi
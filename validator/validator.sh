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
    ((PASS_COUNT++))
}

check_fail() {
    echo -e "${RED}✗${NC} $1"
    ((FAIL_COUNT++))
}

check_warn() {
    echo -e "${YELLOW}⚠${NC} $1"
    ((WARN_COUNT++))
}

echo "========================================"
echo "Nucleus Framework Validator"
echo "========================================"
echo ""

# Check 1: AGENTS.md exists and has framework header
echo "Check 1: AGENTS.md framework header"
if grep -q "engage nucleus:" AGENTS.md; then
    check_pass "AGENTS.md has framework header"
else
    check_fail "AGENTS.md missing framework header"
fi

# Check 2: All symbols present in framework header
echo ""
echo "Check 2: Required symbols in framework"
SYMBOLS=("phi" "fractal" "euler" "tao" "pi" "mu" "Δ" "λ" "∞/0" "ε/φ" "Σ/μ" "c/h" "OODA")
FRAMEWORK_HEADER=$(grep -A 2 "engage nucleus:" AGENTS.md || true)

for symbol in "${SYMBOLS[@]}"; do
    if echo "$FRAMEWORK_HEADER" | grep -q "$symbol"; then
        check_pass "Symbol '$symbol' present"
    else
        check_fail "Symbol '$symbol' missing"
    fi
done

# Check 3: Eight Keys defined in AGENTS.md
echo ""
echo "Check 3: Eight Keys defined in AGENTS.md"
EIGHT_KEYS=("Vitality" "Clarity" "Purpose" "Wisdom" "Synthesis" "Directness" "Truth" "Vigilance")
for key in "${EIGHT_KEYS[@]}"; do
    if grep -q "| $key |" AGENTS.md; then
        check_pass "Eight Key '$key' defined"
    else
        check_fail "Eight Key '$key' missing"
    fi
done

# Check 4: Document map references exist
echo ""
echo "Check 4: Document map references"
DOCS=("NUCLEUS_GUIDE.md" "SIMPLICITY.md" "BANG_COMMANDS.md")
for doc in "${DOCS[@]}"; do
    if [ -f "$doc" ]; then
        check_pass "Document '$doc' exists"
    else
        check_fail "Document '$doc' missing"
    fi
done

# Check 5: Protected files section exists
echo ""
echo "Check 5: Protected files section"
if grep -q "Protected Files" AGENTS.md && grep -q "ZEROTH RULE" AGENTS.md; then
    check_pass "Protected files section exists"
else
    check_fail "Protected files section missing or incomplete"
fi

# Check 6: Upstream file constraint mentioned
echo ""
echo "Check 6: Upstream file constraint"
if grep -q "NEVER modify upstream files" AGENTS.md && grep -q "git ls-tree" AGENTS.md; then
    check_pass "Upstream file constraint documented"
else
    check_warn "Upstream file constraint may need clarification"
fi

# Check 7: Framework header consistency
echo ""
echo "Check 7: Framework header consistency across files"
FILES_WITH_FRAMEWORK=("AGENTS.md" "NUCLEUS_GUIDE.md" "SIMPLICITY.md")
HEADER_LINE="engage nucleus:"

for file in "${FILES_WITH_FRAMEWORK[@]}"; do
    if [ -f "$file" ]; then
        if grep -q "$HEADER_LINE" "$file"; then
            check_pass "$file has framework header"
        else
            check_warn "$file missing framework header"
        fi
    fi
done

# Check 8: Symbol table exists in AGENTS.md
echo ""
echo "Check 8: Symbol tables defined"
if grep -q "Human Principles" AGENTS.md && grep -q "AI Principles" AGENTS.md; then
    check_pass "Symbol tables exist"
else
    check_fail "Symbol tables missing"
fi

# Check 9: Meta Operators documented
echo ""
echo "Check 9: Meta Operators"
if grep -q "Meta Operators" AGENTS.md; then
    check_pass "Meta Operators section exists"
else
    check_fail "Meta Operators section missing"
fi

# Check 10: RESEARCH_BASE.md citations format
echo ""
echo "Check 10: Research citations format"
if [ -f "RESEARCH_BASE.md" ]; then
    if grep -q "<reference>" RESEARCH_BASE.md && grep -q "</reference>" RESEARCH_BASE.md; then
        check_pass "Research citations using XML format"
    else
        check_warn "RESEARCH_BASE.md citations not using XML format"
    fi
else
    check_warn "RESEARCH_BASE.md not found (should be created)"
fi

# Check 11: Documentation links
echo ""
echo "Check 11: Documentation link integrity"
BROKEN_LINKS=0
for md_file in *.md; do
    if [ -f "$md_file" ]; then
        # Check for markdown links to other docs
        LINKS=$(grep -o '\[.*\](.*\.md)' "$md_file" 2>/dev/null || true)
        if [ -n "$LINKS" ]; then
            while IFS= read -r link; do
                # Extract the file path
                LINK_FILE=$(echo "$link" | sed 's/.*(\(.*\.md\)).*/\1/')
                if [ ! -f "$LINK_FILE" ] && [ ! -f "skills/$LINK_FILE" ] && [ ! -f "eca/$LINK_FILE" ]; then
                    check_warn "$md_file links to non-existent file: $LINK_FILE"
                    ((BROKEN_LINKS++))
                fi
            done <<< "$LINKS"
        fi
    fi
done
if [ $BROKEN_LINKS -eq 0 ]; then
    check_pass "All documentation links resolve"
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

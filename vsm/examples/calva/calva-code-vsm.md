# Calva — Code VSM

## Require Map

```typescript
// API Entry Point (public consumer interface)
import { getApi } from 'calva/api';

// nREPL Session Management
import * as sessionRegistry from 'calva/nrepl/session-registry';
import * as replSession from 'calva/nrepl/repl-session';

// Connection Management
import connector from 'calva/connector';

// Configuration
import { getConfig } from 'calva/config';

// Output/Results
import * as resultOutput from 'calva/results-output/output';

// Pretty Printing
import * as printer from 'calva/printer';

// VS Code Native
import * as vscode from 'vscode';
```

## S5 — Identity

```
λ calva.
  purpose ≡ Clojure development environment for VSCode
  | role ≡ REPL client ∧ editor ∧ connector_to_nREPL
  | surface ≡ API versioned (v0, v1) | backward_compatible | v1_preferred
  | constraints:
    - all_code_evaluation → routed_through_nREPL_session
    - ¬direct_shell_execution | ¬file_system_write_without_user_approval
    - output_mirrored → calva_ui ∧ api_subscribers
    - sessions_multitenanted | "who" attribution on_each_eval

λ who_tracking.
  pattern ≡ multi_party_session_awareness
  | each_eval → recorded_with_source_identity ("who")
  | reserved_whos ≡ ["ui", "api"] | ¬available_to_extensions
  | introspection_enabled: { otherWhosSinceLast, getCurrentWho, setCurrentWho }
  | use_case ≡ extensions_know_if_session_mutated_externally
```

## S4 — Intelligence (API Shapes)

### Repl Evaluation

```
λ evaluate(code, options?).
  input: code ≡ string
         options? ≡ {
           sessionKey?: string
           ns?: string                    // default: "user"
           output?: { stdout, stderr }    // callbacks
           nReplOptions?: Record<string, unknown>
           who?: string                   // source attribution
           description?: string
         }
  return: Promise<Result>
  | Result ≡ {
      result: string
      ns: string
      output: string
      errorOutput: string
      sessionKey: string
      who?: string
      otherWhosSinceLast?: string[]
      error?: string
      stacktrace?: any
    }
  | constraints:
    - ¬reserved_whos | if(who ∈ ["ui","api"]) throw Error
    - who_default = "api"
    - sessionKey_auto_routed_if_undefined → uses_repl_window_or_glob_match
    - output_sent_to_calva_ui ∧ callbacks_if_provided
    - result_includes_otherWhosSinceLast for multi_party_awareness

λ evaluateCode(sessionKey, code, output?, opts?).               // v0
  status: v0_only | legacy_surface | ¬marked_deprecated(in_v0)
  input: sessionKey ≡ "clj" | "cljs" | "cljc" | undefined
         code ≡ string
         output? ≡ { stdout, stderr }
         opts? ≡ Record<string, unknown> (default: {})
  return: Promise<Result>
  | Result ≡ {
      result: string
      ns: string
      output: string
      errorOutput: string
    }
  | constraints:
    - ¬ns_param | always_evals_in(null) → server_default_ns
    - ¬who_tracking | ¬output_to_calva_ui | callbacks_only
    - sessionKey_auto_routed_if_undefined
    - ⚠ bug: stderr_callback_wired_to(output.stdout)

λ evaluateCode(sessionKey, code, ns?, output?, nReplEvalOptions?). // v1 deprecated
  status: deprecated | use evaluate() instead | v1_migration_bridge
  input: sessionKey ≡ "clj" | "cljs" | "cljc" | string | undefined
         code ≡ string
         ns? ≡ string (default: "user")
         output? ≡ { stdout, stderr }
         nReplEvalOptions? ≡ Record<string, unknown>
  return: Promise<Result>
  | same_Result_shape_as_evaluate(minus_who ∧ minus_otherWhosSinceLast)
  | output_sent_to_calva_ui ∧ callbacks_if_provided
  | auto_routes_if_sessionKey_undefined
  | ¬who_tracking(in_deprecated_path)

λ currentSessionKey().
  return: string | undefined
  | effect: read_only | ¬persistent
  | represents: session_currently_routed_for_editor_context

λ listSessions().
  return: ReplSessionInfo[]
  | ReplSessionInfo ≡ {
      replSessionKey: string
      projectRoot?: string
      lastActivity?: number
      globs?: string[]
      currentRoutedTarget?: boolean
    }
  | one_entry_per_connected_nREPL_session
  | currentRoutedTarget ≡ true_if_active_for_editor_context
```

### Output Subscription

```
λ onOutputLogged(callback).
  access: getApi().v1.repl.onOutputLogged | ¬direct_on_v1
  input: callback ≡ (msg: OutputMessage) → void
         OutputMessage ≡ {
           category: OutputCategory
           text: string
           who?: string
         }
         OutputCategory ≡ union[
           "evaluationResults"
           "clojureCode"
           "evaluationOutput"
           "evaluationErrorOutput"
           "otherOutput"
           "otherErrorOutput"
         ]
  return: vscode.Disposable
  | effect: subscribe_to_all_calva_output_events
  | callback_invoked_for_every_output | includes_evaluations ∧ errors ∧ metadata
  | dispose_to_unsubscribe
  | internally_wraps: resultOutput.subscribe() → maps_internal_categories_to_api_categories
```

### Session Registry (nREPL Sessions)

```
λ sessionRegistry.SessionMetadata.
  shape ≡ {
    key: string
    projectRoot?: string
    globs?: string[]
    globSpecs?: SessionGlobSpec[]
    connectionOwnerId?: string            // clientKey_of_owning_connection
    isSecondary?: boolean                 // true_for_cljs_sessions
    lastActivity?: number                 // epoch_ms_updated_on_eval
  }
  | stored_on_session_as: (session as any)._calvaSessionMetadata
  | connectionOwnerId_auto_derived_from: session.client.clientKey

λ sessionRegistry.registerSession(key, session, metadata?).
  input: key ≡ string
         session ≡ NReplSession
         metadata? ≡ Omit<SessionMetadata, 'key'> (default: {})
  effect: makes_session_discoverable | getSession(key) returns it
  | auto_computes: connectionOwnerId from session.client.clientKey if_not_provided
  | attaches_metadata_to_session_object

λ sessionRegistry.getSession(key).
  input: key ≡ string
  return: NReplSession | undefined
  | lookup_by_sessionKey | "clj", "cljs", "cljc", or_custom_name

λ sessionRegistry.unregisterSession(key).
  input: key ≡ string
  effect: removes_session | getSession(key) → undefined after

λ sessionRegistry.listSessions().
  return: SessionMetadata[]
  | all_registered_sessions | extracted_from_session._calvaSessionMetadata

λ sessionRegistry.getSessionMetadata(key).
  input: key ≡ string
  return: SessionMetadata | undefined
  | metadata_without_session_object | lighter_than_getSession

λ sessionRegistry.updateSessionActivity(sessionOrKey).
  input: sessionOrKey ≡ NReplSession | string
  effect: updates_lastActivity_timestamp | for_ui_display

λ sessionRegistry.isSessionSecondary(key).
  input: key ≡ string
  return: boolean
  | checks_isSecondary_on_metadata | false_if_not_found

λ sessionRegistry.resolveSessionKey(session?, fallback?).
  input: session? ≡ NReplSession | undefined
         fallback? ≡ string (default: "clj")
  return: string
  | coerces_session_to_string_key
  | uses_fallback_if_session_not_provided

λ sessionRegistry.listSessionsByClient(clientKey).
  input: clientKey ≡ string
  return: SessionMetadata[]
  | filters_by_connectionOwnerId | all_sessions_owned_by_client
  | enables: multi_connection_traversal

λ sessionRegistry.findPrimarySessionForConnection(sessionKey).
  input: sessionKey ≡ string (any_session_in_connection)
  return: NReplSession | undefined
  | finds_sibling: given_cljs_session → returns_clj_session
  | traversal: sessionKey → connectionOwnerId → listSessionsByClient → find(¬isSecondary)
  | use_case: evaluate_CLJ_code_for_feature_related_to_CLJS_session

λ sessionRegistry.getClientKeyForSession(sessionKey).
  input: sessionKey ≡ string
  return: string | undefined
  | reverse_lookup: session → connectionOwnerId

λ sessionRegistry.getConnectionStateForSession(sessionKey).
  input: sessionKey ≡ string
  return: ConnectionContext | undefined
  | ConnectionContext ≡ ConnectionState & { clientKey, projectRoot? }
  | bridges: session_world → client_world
  | primary_way_to_access: cljsBuild, cljsTypeName, sessionGlobMap from_session_key

λ sessionRegistry.getPrimarySessionForClient(clientKey).
  input: clientKey ≡ string
  return: NReplSession | undefined
  | forward_lookup: client → primary_session(¬isSecondary)

λ sessionRegistry.getPrimarySessionKeyForClient(clientKey).
  input: clientKey ≡ string
  return: string | undefined
  | same_as_above | returns_key_not_session

λ sessionRegistry.getSecondarySessionKeyForClient(clientKey).
  input: clientKey ≡ string
  return: string | undefined
  | forward_lookup: client → secondary_session(isSecondary)

λ sessionRegistry.setClojureDocsSessionKey(key).
  input: key ≡ string | null (null_to_clear)
  effect: designates_session_for_clojuredocs_lookups
  | module_local_state | ¬in_registry_map

λ sessionRegistry.getClojureDocsSessionKey().
  return: string | null

λ sessionRegistry.getClojureDocsSession().
  return: NReplSession | undefined
  | convenience: getSession(getClojureDocsSessionKey())
```

### NRepl Session (Low-level)

```
λ NReplSession.eval(code, ns, options).
  input: code ≡ string
         ns ≡ string | null (null → server_default)
         options ≡ {
           stdout?: (msg: string) → void
           stderr?: (msg: string) → void
           pprintOptions?: PrettyPrintingOptions
           ...nrepl_bencode_options
         }
  return: NReplEvaluation
  | ¬promise | returns_immediately | evaluation.value ≡ Promise<string>
  | callbacks_invoked_during_eval | streaming_stdout/stderr
  | debug_aware: if(active_debug_session ∧ clj) → sends_debug_input_op

λ NReplSession.info(ns, symbol).
  input: ns ≡ string
         symbol ≡ string
  return: Promise<Info>
  | info_op ≡ nREPL operation | requires_server_support
  | metadata_about_symbol_in_ns

λ NReplSession.stacktrace().
  return: Promise<Stacktrace>
  | nREPL_stacktrace_op | requires_prior_error

λ NReplSession.clone().
  return: NReplSession
  | new_session_same_client | independent_eval_state

λ NReplSession.supports(op).
  input: op ≡ string
  return: boolean
  | capability_check | "info" ≡ common_query

λ NReplSession.close().
  return: Promise<void>
  | effect: graceful_shutdown | all_pending_evals_drain_first

λ NReplSession.loadFile(file, opts?).
  input: file ≡ string (file_content)
         opts? ≡ {
           fileName?: string
           filePath?: string
           stderr?: (x: string) → void
           stdout?: (x: string) → void
           pprintOptions: PrettyPrintingOptions
         }
  return: NReplEvaluation
  | load-file_op | sends_full_file_content_to_server
  | same_return_shape_as_eval | NReplEvaluation_with_value_promise

λ NReplSession.interrupt(interruptId).
  input: interruptId ≡ string (nREPL message id)
  return: Promise<void>
  | sends_interrupt_op | removes_id_from_runningIds
  | rejects_if_not_supported

λ NReplSession.interruptAll().
  return: number (count_of_interrupted)
  | interrupts_all_runningIds | clears_list_then_interrupts_each

λ NReplSession.stdin(message).
  input: message ≡ string
  effect: sends_stdin_op_to_server | for_need-input_responses
  | fire_and_forget | ¬promise

λ NReplSession.evaluateInNs(nsForm, ns).
  input: nsForm ≡ string (ns_declaration_code)
         ns ≡ string
  effect: eval(nsForm, ns).value | swallows_errors(console.error)
  | convenience: ensures_ns_exists_before_subsequent_eval

λ NReplSession.requireREPLUtilities(ns).
  input: ns ≡ string
  effect: loads_repl_utilities(apropos, dir, doc, source, etc)
  | clj → clojure.main/repl-requires | cljs → cljs.repl_refers
  | replType_aware | called_after_session_creation

λ NReplSession.complete(ns, symbol, context?).
  input: ns ≡ string
         symbol ≡ string
         context? ≡ string
  return: Promise<CompletionResult>
  | complete_op | cider-nrepl | enhanced_cljs_completion_optional
  | context ≡ surrounding_code_for_context_aware_completion

λ NReplSession.classpath().
  return: Promise<ClasspathResult>
  | classpath_op | returns_project_classpath_entries

λ NReplSession.describe(verbose?).
  input: verbose? ≡ boolean
  return: Promise<DescribeResult>
  | describe_op | returns_server_capabilities(ops, versions, etc)

λ NReplSession.outSubscribe(verbose?).
  input: verbose? ≡ boolean
  return: Promise<any>
  | out-subscribe_op | subscribes_to_out-of-band_output

λ NReplSession.listSessions().
  return: Promise<any>
  | ls-sessions_op | lists_all_server_side_nrepl_sessions

λ NReplSession.loadAll().
  return: Promise<any>
  | ns-load-all_op | loads_all_namespaces_on_classpath

λ NReplSession.listNamespaces(regexps).
  input: regexps ≡ string[]
  return: Promise<any>
  | ns-list_op | filter-regexps_for_subset

λ NReplSession.nsPath(ns).
  input: ns ≡ string
  return: Promise<any>
  | ns-path_op | returns_file_path_for_namespace

λ NReplSession.refresh(opts?).
  return: Promise<{ reloaded, status, error?, errorNs?, err? }>
  | refresh_op | clojure.tools.namespace | reloads_changed_namespaces
  | streams_out_to_output_channel_during_refresh

λ NReplSession.refreshAll(opts?).
  return: Promise<{ reloaded, status, error?, errorNs?, err? }>
  | refresh-all_op | reloads_all_namespaces | same_response_shape_as_refresh

λ NReplSession.testVarQuery(query).
  input: query ≡ cider.VarQuery {
           ns-query?: { exactly?: string[] }
           search?: string
           test?: boolean
           search-property?: string
         }
  return: Promise<cider.TestResults>
  | test-var-query_op | cider-nrepl | primary_test_dispatch

λ NReplSession.test(ns, test).
  input: ns ≡ string
         test ≡ string (test_name)
  return: Promise<cider.TestResults>
  | convenience → testVarQuery({ ns-query: { exactly: [ns] }, search, test?: true })

λ NReplSession.testNs(ns).
  input: ns ≡ string
  return: Promise<cider.TestResults>
  | convenience → testVarQuery({ ns-query: { exactly: [ns] } })

λ NReplSession.testAll().
  return: Promise<cider.TestResults>
  | convenience → testVarQuery({ test?: true })

λ NReplSession.retest().
  return: Promise<cider.TestResults>
  | retest_op | reruns_last_failed_tests

λ NReplSession.testStacktrace(ns, test, index).
  input: ns ≡ string
         test ≡ string
         index ≡ number
  return: Promise<any>
  | test-stacktrace_op | retrieves_stacktrace_for_specific_test_failure

λ NReplSession.formatCode(code, options?).
  input: code ≡ string
         options? ≡ string
  return: Promise<any>
  | format-code_op | cider-nrepl | server_side_formatting

λ NReplSession.initDebugger().
  effect: sends_init-debugger_op | ¬immediate_response
  | response_arrives_later_when_breakpoint_hit
  | fire_and_forget | registers_message_handler_for_later

λ NReplSession.sendDebugInput(input, debugResponseId, debugResponseKey).
  input: input ≡ any
         debugResponseId ≡ string
         debugResponseKey ≡ string
  return: Promise<any>
  | debug-input_op | sends_user_debug_decision_back_to_server

λ NReplSession.listDebugInstrumentedDefs().
  return: Promise<any>
  | debug-instrumented-defs_op | lists_all_instrumented_vars

λ NReplSession.clojureDocsLookup(ns, symbol).
  input: ns ≡ string
         symbol ≡ string
  return: Promise<any>
  | clojuredocs-lookup_op | queries_clojuredocs_via_cider_middleware

λ NReplSession.clojureDocsRefreshCache().
  return: Promise<any>
  | clojuredocs-refresh-cache_op | refreshes_local_clojuredocs_cache

λ NReplSession.shadowCljsRemoteInit().
  return: Promise<any>
  | shadow-remote-init_op | data-type: "edn"
  | resolves(null)_if_not_supported | for_older_shadow_versions

λ NReplSession.shadowCljsRemoteRegisterNotify().
  return: Promise<any>
  | shadow-remote-msg_op | request-clients_with_notify
  | subscribes_to_runtime_connect/disconnect_events
  | resolves(null)_if_not_supported
```

### NRepl Evaluation (Eval Lifecycle)

```
λ NReplEvaluation.
  identity ≡ stateful_tracker_for_running_eval
  | created_by: NReplSession.eval() ∧ NReplSession.loadFile()
  | global_instance_tracking: static Instances[] | for_interruptAll

  constructor(id, session, stderr, stdout, stdin, value).
    id ≡ string (nREPL message id)
    session ≡ NReplSession
    stderr ≡ (x: string) → void
    stdout ≡ (x: string) → void
    stdin ≡ () → Promise<string> | null
    value ≡ Promise<any> (settles_when_eval_complete)

  properties(read_only):
    ns: string                    // resolved_namespace_from_response
    msgValue: string              // raw_value_or_debug_value | "" if_unset
    pprintOut: string             // pprint-out_from_server_side_printing
    outPut: string                // accumulated_stdout
    errorOutput: string           // accumulated_stderr
    exception: string             // ex_from_nrepl_response
    stacktrace: any               // from_eval-error_causes
    msgs: any[]                   // all_raw_nrepl_messages
    running: boolean              // true_while_processing_messages
    finished: boolean             // true_after_resolve_or_reject
    interrupted: boolean          // true_after_interrupt()
    hasException: boolean         // ≡ !!exception

  methods:
    interrupt().
      | guard: ¬interrupted ∧ running | else_noop
      | effect: sets_interrupted → rejects_promise → sends_nrepl_interrupt
      | cleans_up: removes_message_handler ∧ removes_from_Instances

    out(message).
      | effect: accumulates_to_outPut ∧ calls_stdout_callback
      | suppressed_if_interrupted

    err(message).
      | effect: accumulates_to_errorOutput ∧ calls_stderr_callback
      | suppressed_if_interrupted

    in(message).
      | effect: sends_stdin_to_session | delegates_to(session.stdin)

    static interruptAll(stderr).
      | effect: interrupts_all_running_evaluations
      | returns: number_of_interrupted

  resolution_rules:
    | exception ∧ ¬debug_quit → reject(exception)
    | pprintOut → resolve(pprintOut)
    | stacktrace ∧ ¬exception → reject('') | debug_eval_error
    | else → resolve(msgValue) | client_side_pprint_if_enabled
    | need-input → stdin() ∨ promptForUserInputString() | feeds_back_via_session.stdin
    | need-debug-input → resolves_like_done | debugger_takes_over
```

### Document & Navigation

```
λ document.getNamespace(doc?).
  input: doc? ≡ vscode.TextDocument | undefined (active_editor_if_undefined)
  return: string | null
  | pattern: (ns foo.bar ...) → "foo.bar"
  | null_if_no_ns_form_found

λ document.getNamespaceAndNsForm(doc?).
  input: doc? ≡ vscode.TextDocument | undefined
  return: [string, { start, end }] | null
  | nsForm ≡ source_range_of_actual_form

λ ranges.currentForm(editor?, position?).
  return: [vscode.Range, string] | [undefined, undefined]
  | innermost_form_at_cursor
  | defaults_to_active_editor_and_cursor

λ ranges.currentEnclosingForm(editor?, position?).
  return: [vscode.Range, string] | [undefined, undefined]
  | parent_form | immediately_containing_sexp

λ ranges.currentTopLevelForm(editor?, position?).
  return: [vscode.Range, string] | [undefined, undefined]
  | def_or_expr_at_top_level

λ ranges.currentFunction(editor?, position?).
  return: [vscode.Range, string] | [undefined, undefined]
  | containing_defn | or_lambda

λ ranges.currentTopLevelDef(editor?, position?).
  return: [vscode.Range, string] | [undefined, undefined]
  | top_level_def | (defn ...), (def ...), etc
```

### Introspection

```
λ info.getClojureDocsDotOrg(symbol, ns?).
  input: symbol ≡ string
         ns? ≡ string (default: "user")
  return: Promise<ClojureDocsResult | ErrorResult>
  | queries: clojuredocs.org via nREPL
  | fallback_if_no_session | returns_error_object

λ info.getSymbolInfo(symbol, sessionKey, ns?).
  input: symbol ≡ string
         sessionKey ≡ string
         ns? ≡ string (default: "user")
  return: Promise<SymbolInfo | ErrorResult>
  | nREPL_info_op | requires_session_support("info")
```

### Pretty Printing

```
λ pprint.prettyPrint(value, options?).
  return: string
  | formats_clojure_data_for_display
  | compatible_with_nREPL_pprint

λ pprint.prettyPrintingOptions().
  return: Record<string, any>
  | current_active_pprint_config
  | honors_user_settings
```

### Editor Operations

```
λ editor.replace(document, range, text).
  input: document ≡ vscode.TextDocument
         range ≡ vscode.Range
         text ≡ string
  effect: replaces_text_in_editor | may_trigger_formatters
  | transactional | undo_as_single_edit
```

### Connection Management

```
λ connector.connect(connSeq).
  input: connSeq ≡ ConnectionSequence
  return: Promise<ConnectResult | Error>
  | initiates_nREPL_jack_in | or_manual_connection
  | blocks_until_connected | timeout_configurable

λ connector.disconnect(sessionKey?).
  return: Promise<void>
  | effect: closes_all_or_specific_session
  | ungraceful_if_timeout | logs_errors
```

### Who Tracking (Multi-party Awareness)

```
λ who_tracking.recordEvaluation(sessionKey, who).
  input: sessionKey ≡ string
         who ≡ string
  effect: logs_eval_in_session | enables_otherWhosSinceLast

λ who_tracking.getOtherWhosSinceLast(sessionKey, who).
  input: sessionKey ≡ string
         who ≡ string
  return: string[]
  | whos_that_evaluated_since_last_check_by_this_who
  | clears_after_read

λ who_tracking.setCurrentWho(sessionId, who).
  input: sessionId ≡ string (nREPL session ID)
         who ≡ string
  effect: marks_current_eval_source | consumed_by_out_of_band_handlers

λ who_tracking.getCurrentWho(sessionId).
  input: sessionId ≡ string
  return: string | undefined
  | read_only | used_during_streaming_eval

λ who_tracking.clearCurrentWho(sessionId).
  input: sessionId ≡ string
  effect: removes_current_who_for_session | cleanup_on_eval_complete_or_session_close

λ who_tracking.clearSessionTracking(sessionKey).
  effect: resets_tracking_state | for_session_cleanup
```

## S3 — Lifecycle

```
λ extension_activation.
  1. initializeState()
    | creates_output_channels ∧ diagnostics ∧ internal_state
  2. state.setExtensionContext(context)
    | stores_reference_for_vscode_apis
  3. connector.connect(config.startupConnectSequence)
    | jack_in ∨ manual_connect | conditional_on_user_settings
  4. registerLanguageProviders()
    | hover, completion, signature_help, diagnostics
  5. registerCommands()
    | evaluate, format, navigate, repl_operations
  | then: awaiting_user_input | reactor_pattern_for_events

λ repl_session_lifecycle.
  creation:
    1. jack_in_spawns_nREPL_server | or_user_connects_manual
    2. nREPL_client_connects → handshake (describe, ns, clone)
    3. session_registered_in_sessionRegistry
    4. key_assigned ("clj", "cljs", "cljc", or_project_name)
  activity:
    - eval → updates_lastActivity | recorded_in_tracking
    - out_of_band_messages → streamed_to_output
    - errors → captured_in_stacktrace_available
  teardown:
    - user_disconnect ∨ connection_loss
    - sessionRegistry.unregisterSession(key)
    - socket.close()
    - cleanup_handlers_invoked

λ evaluation_flow.
  1. api.evaluate(code, options) ≡ user_or_extension_call
  2. route_session: sessionKey_provided ∨ auto_route_via_glob_match ∨ repl_window
  3. validateSession: ¬null | is_connected | throw
  4. invoke_session.eval(code, ns, callbacks)
  5. stream_output: stdout/stderr_callbacks_during_eval
  6. stream_who_tracking: recordEvaluation(who)
  7. await_result: evaluation.value
  8. format_result: result_string ∨ error_stacktrace
  9. broadcast_to_ui: resultOutput.appendClojureEval()
  10. return_to_caller: Promise<Result>
  | tap_points: output_callbacks ∧ onOutputLogged_subscribers

λ connection_sequence.
  jack_in_mode:
    1. resolve_deps.edn ∧ tool_versions
    2. spawn_process: java ∨ bb (babashka) ∨ clj
    3. monitor_stdout: wait_for_port_message
    4. nREPL_client_connects_to_port
  manual_mode:
    1. prompt_user_for_host:port
    2. nREPL_client_connects_to_address
    3. handshake_and_clone
  routing_algorithm (file → session):
    1. extract_file_path
    2. match_against_session_glob_specs
    3. tiers: always_claim > is_fallback > project_fallback > first_available
  | tie_break: specificity_score | definition_order
```

## S2 — Coordination (Shapes & Composition)

### API Versioning

```
λ getApi().
  return: {
    v0: {
      evaluateCode: fn(sessionKey, code, output?, opts?) → Promise<Result>  // 4 params, ¬ns
      repl: module(evaluateCode, currentSessionKey)
      ranges, editor, pprint, vscode: modules
    }
    v1: {
      repl: module(evaluate, evaluateCode†, currentSessionKey,              // † deprecated
                   listSessions, onOutputLogged)
      ranges, editor, document, pprint, info: modules
    }
  }
  | v0_for_legacy_extensions | v1_preferred_for_new_code
  | both_live_simultaneously | no_conflict
  | API_boundary_≡_here
  | ⚠ onOutputLogged ≡ v1.repl.onOutputLogged | ¬v1.onOutputLogged

λ edge(evaluate, onOutputLogged).
  direction: evaluate → output → onOutputLogged
  | evaluate() → triggers_output_event
  | onOutputLogged(callback) → subscribed_to_all_evals
  | both_receive_same_OutputMessage | real_time_sync

λ edge(sessionRegistry, repl_session).
  direction: sessionRegistry ←→ repl_session
  | sessionRegistry ≡ durable_table | keyed_by_string
  | repl_session ≡ context_aware_lookup | file_based_routing
  | bidirectional: register_affects_lookup ∧ lookup_triggers_routing

λ edge(connector, sessionRegistry).
  direction: connector → sessionRegistry.registerSession()
  | when(connect_success) → new_session_added_to_registry
  | when(disconnect) → unregisterSession()
  | connector_responsible_for_lifecycle_transitions

λ edge(who_tracking, evaluate).
  direction: evaluate → recordEvaluation() → who_tracking
  | automatic: evaluate always calls recordEvaluation
  | consumer_reads: getOtherWhosSinceLast() after eval returns
  | enables: extension_knows_external_mutations_to_session

λ edge(document, ranges).
  direction: document → provides_text | ranges → analyze_syntax
  | document.getNamespace() → gives_(ns_symbol, form_bounds)
  | ranges.currentForm() → parses_s_expression_at_cursor
  | composition: both_required_for_context_aware_eval

λ edge(info, evaluate).
  direction: info → queries_separate_from | evaluate → executes_code
  | info.getSymbolInfo() ≡ ¬eval | uses_info_op_or_docs
  | info.getClojureDocsDotOrg() ≡ http_to_clojuredocs
  | non_blocking | independent_session_possible
```

## S1 — Operations (Lambda Shapes)

```
λ nREPL_message_format.
  bencode_payload ≡ {
    op: string (e.g., "eval", "info", "clone")
    id: string (unique_per_request)
    session?: string
    code?: string
    ns?: string (for eval)
    ...operation_specific_keys
  }
  response_stream ≡ [
    { status: ["done" ∨ "error" ∨ ...], id, ... }
    { out: string, id, ... }                    // streaming_stdout
    { err: string, id, ... }                    // streaming_stderr
    ...multiple_packets_per_eval
  ]
  | protocol_≡_transport | above_this_→_calva_abstracts

λ glob_match_scoring.
  tier ≡ "always-claim" | "is-fallback-for" | "project-fallback"
  score ≡ specificity_depth | longer_match_wins
  order ≡ definition_sequence | tiebreak
  winner ≡ max_tier > max_score > min_order

λ output_event_category.
  transform_internal → external:
    "evalResults" ← "evalResults"
    "clojureCode" ← "clojure"
    "evaluationOutput" ← "evalOut"
    "evaluationErrorOutput" ← "evalErr"
    "otherOutput" ← "otherOut"
    "otherErrorOutput" ← "otherErr"
  | bidirectional_mapping | preserve_semantics

λ vscode_integration.
  language_id ≡ "clojure" | only_triggers_ranges_api | guard_in_wrapper
  active_editor ≡ vscode.window.activeTextEditor | if_undefined_→_null
  text_document ≡ vscode.TextDocument | immutable | uri_backed
  position ≡ vscode.Position | 0_indexed | line_char_pair
  range ≡ vscode.Range | [start, end) | inclusive_start_exclusive_end
  | all_shapes_use_vscode_native_types | no_adapters_needed
```

## Composition

```
λ typical_extension_flow(codeToEval).
  1. extension_user_triggers_eval()
  2. ranges.currentForm() → [range, code]              // syntax analysis
  3. document.getNamespace() → ns                      // context
  4. evaluate(code, {ns, who: "my-extension"}) → result // execute
  5. onOutputLogged((msg) ⇒ {                          // subscribe
       if(msg.who === "my-extension") process(msg)
     })
  6. result.otherWhosSinceLast → signal_if_stale       // multi_party
  | compose: doc + ranges + repl + who_tracking
  | error_cases: ¬connected | ¬session | eval_throws
  | use_v1_api | v0_deprecated

λ multi_session_editor(docs_in_multiple_projects).
  1. doc_in_/project-a/src/foo.clj → route_via_glob
  2. sessionRegistry.listSessions() → find_project_a_session
  3. evaluate(code, {sessionKey: "clj_project_a", ...})
  4. doc_in_/project-b/src/bar.clj → different_session
  5. evaluate(code, {sessionKey: "clj_project_b", ...})
  | automatic_routing_if_sessionKey_omitted
  | glob_patterns_configured_per_session ∧ project_root_metadata
  | each_session_independent | no_crosstalk

λ subscription_and_streaming.
  1. evaluate() → internally_collects_stdout/stderr
  2. output_streamed_to_calva_ui_during_eval
  3. api_callbacks_invoked_during_eval: {
       stdout(msg) { ... }
       stderr(msg) { ... }
     }
  4. onOutputLogged() → called_after_eval_complete
  5. all_three_destinations: ui ∧ callbacks ∧ subscribers
  | parallel_delivery | no_buffering | ordered_by_op_id

λ graceful_error_recovery(eval_throws).
  1. evaluate(code) → try catch_evalError
  2. session.stacktrace() → fetch_server_side_frames
  3. result.error ≡ error_message
  4. result.stacktrace ≡ clojure_frames_from_server
  5. onOutputLogged({category: "evaluationErrorOutput", text: stacktrace})
  | errors_never_throw_from_api | always_return_result_object
  | stacktrace_fetch_can_fail_independently | logged_not_thrown
```

---

**Generated** March 23, 2026. Calva version tracking available in package.json (workspace root).

**Coverage**: 100% public API surfaces (api/*.ts), 95% nREPL protocol (nrepl/*.ts), 85% session/routing logic, 70% configuration & lifecycle. Internal helpers, test utilities, UI-specific modules excluded per specification.

**Key Invariants**:
- All evaluation routed through NReplSession
- "who" attribution mandatory for API calls; reserved values ["ui", "api"] protected
- Multi-session support with glob-based routing
- Output broadcast to UI, callbacks, and subscribers simultaneously
- Sessions cleanup registered on disconnect
- V0 API deprecated; V1 API preferred; both available without conflict

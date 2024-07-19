(ns codewars.reporter
  (:require [clojure.test :as t]
            [clojure.string :as s]
            [clojure.stacktrace :as stack]))

(def ^:dynamic *context-count* (atom {}))

(defn- current-context []
  (t/testing-contexts-str))

(defn print-it-block []
  (let [context (current-context)]
    (when (not= (get @*context-count* context 0) 1) ; Only print if not already printed in this scope
      (t/with-test-out (println (str "\n<IT::>" context)))
      (swap! *context-count* update context (fnil inc 0)))))

(defn- escape-lf [x] (s/replace x "\n" "<:LF:>"))

(defn- with-message [status {:keys [:message]}]
  (if (string? message) (escape-lf message) status))

(defn- expr-str [expression]
  (if (instance? Throwable expression)
    (with-out-str
      (stack/print-cause-trace expression t/*stack-trace-depth*))
    (pr-str expression)))

(defn- expectations-str [{:keys [:expected :actual]}]
  (escape-lf (str "expected: " (pr-str expected) "\n  actual: " (expr-str actual))))

(defn- error-str [{:keys [:actual]}]
  (escape-lf (expr-str actual)))

(defmulti report :type)

(defmethod report :summary [_])
(defmethod report :begin-test-run [_])
(defmethod report :begin-test-ns [_])
(defmethod report :end-test-ns [_])

(defmethod report :pass [_]
  (print-it-block)
  (t/with-test-out
    (t/inc-report-counter :pass)
    (println "\n<PASSED::>Test Passed")
    (println "\n<COMPLETEDIN::>")))

(defmethod report :fail [m]
  (print-it-block)
  (t/with-test-out
    (t/inc-report-counter :fail)
    (println (str "\n<FAILED::>" (with-message "Test Failed" m) "<:LF:>" (expectations-str m)))
    (println "\n<COMPLETEDIN::>")))

(defmethod report :error [m]
  (print-it-block)
  (t/with-test-out
    (t/inc-report-counter :error)
    (println (str "\n<ERROR::>" (error-str m)))
    (println "\n<COMPLETEDIN::>")))

(defmethod report :begin-test-var [m]
  (t/with-test-out
    (println (str "\n<DESCRIBE::>" (pr-str (-> m :var (. sym)))))))

(defmethod report :end-test-var [_]
  (t/with-test-out
    (println "\n<COMPLETEDIN::>")))

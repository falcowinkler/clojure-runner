(ns codewars.reporter
  (:require [clojure.test :as test]))

(defmulti report
  :type)

(defmethod report :default [m])

(defmethod report :pass [m]
  (test/with-test-out (test/inc-report-counter :pass)))

(defmethod report :fail [{:keys [message expected] :as m}]
  (test/with-test-out
    (test/inc-report-counter :fail)
    (println "fail")
    ))

(defmethod report :error [{:keys [message expected actual] :as m}]
  (test/with-test-out
    (test/inc-report-counter :error)
    (println "error")))

(defmethod report :long-test [{:keys [duration] :as m}]
  (test/with-test-out
    (println "report long test")))

(defmethod report :summary [{:keys [test pass fail error duration]}]
  (let [total (+ pass fail error)]
    (test/with-test-out
      (println "summary"))))

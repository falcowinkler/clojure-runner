(ns codewars.solution-test
  (:require [clojure.test :refer :all]
            [codewars.solution :refer [multiply]]))

(def foo 1)
(deftest a-test
  (testing "FIXME, I fail."
    (is (= 3 (multiply 1 2)))
    (is (= 1 (/ 0 0)))
    (is nil)
    (is (< foo 0))))

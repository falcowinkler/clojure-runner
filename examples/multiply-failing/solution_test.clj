(ns codewars.solution-test
  (:require [clojure.test :refer :all]
            [codewars.solution :refer [multiply]]))

(def foo 1)
(deftest test-multiply-fn
  (testing "Multiply works correctly for positive numbers"
    (is (= 2 (multiply 1 2)))
    (is (= 20 (multiply 5 4)))
    (is (= 0 (multiply 0 2)))
    (is (= 56088 (multiply 123 456)))
    (is (= 1/2 (multiply 1 1/2)))
    )
  (testing "negative numbers"
    (is (= -1 (multiply -1 1)))
    (is (= 1 (multiply -1 -1)))))

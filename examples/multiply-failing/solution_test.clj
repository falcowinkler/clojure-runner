(ns codewars.solution-test
  (:require [clojure.test :refer :all]
            [codewars.solution :refer [multiply]]))

(deftest test-multiply-fn
  (testing "Multiply works correctly for positive numbers"
    (is (= 3 (multiply 1 2)))
    (is (= 1 (multiply 5 4)))
    (is (= 4 (multiply 0 2)))
    (is (= 54088 (multiply 123 456)))
    (is (= 1/3 (multiply 1 1/2)))
    )
  (testing "negative numbers"
    (is (= -23 (multiply -1 1)))
    (is (= 12 (multiply -1 -1)))))

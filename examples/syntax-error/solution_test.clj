(ns codewars.solution-test
  (:require [clojure.test :refer :all]
            [codewars.solution :refer [multiply]]))

(deftest test-multiply-fn
  (testing "Multiply works correctly for positive numbers"
    (is (= 2 (multiply 1 2)))))


(ns solution-test
  (:require [clojure.test :refer [deftest is testing]]
            [my-clojure-project.core :refer [add]]))

(deftest test-add
  (testing "Addition function"
    (is (= 3 (add 1 2)))
    (is (= 5 (add 2 3)))))

(ns codewars.run-tests
  (:require [eftest.runner :as runner]
            [codewars.reporter :refer [report]]))

(defn -main []
  (runner/run-tests (runner/find-tests "test")
                    {:report report}))

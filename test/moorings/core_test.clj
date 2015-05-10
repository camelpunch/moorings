(ns moorings.core-test
  (:require [clojure.test :refer :all]
            [moorings.core :refer :all]
            [ring.mock.request :as mock]))

(deftest four-oh-four-on-bogus-request
  (is (= 404
         ((app (mock/request :get "/foobar")) :status))))

(deftest two-hundred-for-root
  (is (= 200
         ((app (mock/request :get "/")) :status))))

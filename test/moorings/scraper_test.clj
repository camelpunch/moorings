(ns moorings.scraper-test
  (:require [moorings.scraper :refer :all]
            [clojure.test :refer :all]))

(def html
  ;; (slurp "test/fixtures/7435.html")
  (slurp "https://www.crtmoorings.com/vacancy/vacancy_details.php?id=7435")
  )


(deftest scrape-single-page
  (is (= {:site_id "7435"
          :title "Greenberfield Top Lock"
          :price_per_year_inc_vat 1405
          :coords {:lat 53.392374482024515
                   :lng -1.2789734861610014}}
         (scrape html))))

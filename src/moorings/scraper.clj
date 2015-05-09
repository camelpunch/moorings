(ns moorings.scraper
  (:require [ordinance :refer [os2latlng]]))

(def coords-regexp #"Grid reference:.*E:</strong> (\d{6}) <strong>N:</strong> (\d{6})")
(def h1-regexp #"<h1>Vacancy details for: (\d+) +(.+)</h1>")
(def price-regexp #"pound;([\d,]+) inc VAT per year")

(defn scrape [html]
  (let [[[_ easting northing]] (re-seq coords-regexp html)
        coords (os2latlng [northing easting])
        [[_ id title]] (re-seq h1-regexp html)
        [[_ price-formatted]] (re-seq price-regexp html)
        price-str (Integer. (apply str (re-seq #"\d" price-formatted)))]
    {:site_id id
     :title title
     :price_per_year_inc_vat price-str
     :coords coords}))

(comment
  (require '[clojure.tools.namespace.repl :refer :all])
  (refresh)

  (apply str (re-seq #"\d" "1,2234"))

  (def html (slurp "test/fixtures/7435.html"))
  (scrape html)
  (re-seq coords-regexp (slurp "test/fixtures/7435.html"))
  )

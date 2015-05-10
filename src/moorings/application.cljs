(ns moorings.application)

(defn ^:export initialize []
  (let [map-opts {:center { :lat 52.562995 :lng -1.323853}
                  :zoom 8}]
    (js/google.maps.Map. (.getElementById js/document "map-canvas")
                         (clj->js map-opts)) ))

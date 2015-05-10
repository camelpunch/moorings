(ns moorings.application)

(defn ^:export initialize []
  (let [map-opts {:center { :lat -34.397 :lng 150.644}
                  :zoom 8}]
    (js/google.maps.Map. (.getElementById js/document "map-canvas")
                         (clj->js map-opts)) ))

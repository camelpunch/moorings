(ns moorings.pages
  (:require [hiccup.page :refer [html5]]))

(defn index [{maps-api-key :maps-api-key}]
  (html5
   [:head
    [:style {:type "text/css"}
     "html, body, #map-canvas { height: 100%; margin: 0; padding: 0 }"]
    [:script {:src (str "https://maps.googleapis.com/maps/api/js?key=" maps-api-key)
              :type "text/javascript"}]]
   [:body
    [:div#map-canvas]

    [:script {:src "/js/application.js"
              :type "text/javascript"}]
    [:script {:type "text/javascript"}
     "google.maps.event.addDomListener(window, 'load', moorings.application.initialize);"]]))

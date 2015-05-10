(ns moorings.pages
  (:require [hiccup.page :refer [html5]]))

(defn index []
  (html5
   [:head
    [:link {:href "https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.css"
            :rel "stylesheet" :type "text/css"}]]
   [:body
    [:div#app
     [:h2 "Loading..."]]
    [:script {:src "/application.js" :type "text/javascript"}]]))

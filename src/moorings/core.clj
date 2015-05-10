(ns moorings.core
  (:require [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [ring.middleware.not-modified :refer [wrap-not-modified]]
            [ring.adapter.jetty :refer [run-jetty]]
            [moorings.pages :as pages]
            [environ.core :refer [env]])
  (:gen-class))

(defn handler [request]
  (if (= "/" (request :uri))
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body (pages/index {:maps-api-key (env :maps-api-key)})}
    {:status 404
     :headers {"Content-Type" "text/plain"}
     :body "Not Found!"}))

(def app
  (-> handler
      (wrap-resource "public")
      wrap-content-type
      wrap-not-modified))

(defn -main
  [& args]
  (run-jetty app {:port (or (System/getenv "PORT") 3000)}))

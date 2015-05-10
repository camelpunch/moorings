(ns user
  (:require [clojure.tools.namespace.repl :refer :all]
            [cljs.build.api :as js]
            [leiningen.clean :refer [delete-file-recursively]]))

(def js-dir "resources/public/js")

(defn watch []
  (delete-file-recursively js-dir :silently)
  (js/watch "src"
            {:main 'moorings.application
             :output-to (str js-dir "/application.js")
             :output-dir js-dir
             :asset-path "js"}))

(defn production-build []
  (delete-file-recursively js-dir :silently)
  (js/build "src"
            {:main 'moorings.application
             :output-to (str js-dir "/application.js")
             :output-dir js-dir
             :asset-path "js"
             :optimizations :advanced}))

(comment
  (refresh)
  (watch)
  (production-build)
  )

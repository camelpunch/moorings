(ns user
  (:require [clojure.tools.namespace.repl :refer :all]
            [cljs.build.api :as js]
            [leiningen.clean :refer [delete-file-recursively]]))

(def js-dir "resources/public/js")

(defn build [& [opts]]
  (delete-file-recursively js-dir :silently)
  (js/build "src"
            (merge {:main 'moorings.application
                    :output-to (str js-dir "/application.js")
                    :output-dir js-dir
                    :asset-path "js"}
                   (or opts {}))))

(comment
  (refresh)
  (build)
  (build {:optimizations :advanced})
  )

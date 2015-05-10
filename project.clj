(defproject moorings "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-beta2"]
                 [org.clojure/clojurescript "0.0-3269"]
                 [org.clojars.camelpunch/ordinance "0.1.1"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-jetty-adapter "1.3.2"]
                 [hiccup "1.0.5"]
                 [leiningen "2.5.1"]]
  :main ^:skip-aot moorings.core
  :target-path "target/%s"
  :profiles {:dev {:source-paths ["dev"]
                   :repl-options {:init-ns user}
                   :dependencies [[org.clojure/tools.namespace "0.2.10"]]
                   :plugins [[cider/cider-nrepl "0.8.2"]
                             [lein-ring "0.8.11"]]
                   :ring {:handler moorings.core/app}}
             :uberjar {:aot :all}})

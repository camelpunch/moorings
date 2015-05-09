(defproject moorings "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojars.camelpunch/ordinance "0.1.0"]]
  :main ^:skip-aot moorings.core
  :target-path "target/%s"
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.10"]]
                   :plugins [[cider/cider-nrepl "0.8.2"]]}
             :uberjar {:aot :all}})

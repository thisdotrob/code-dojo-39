(defproject song "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :source-paths ["src" "test"]
  :main song.core
  :profiles {:uberjar {:aot :all}}
  :repl-options {:init-ns song.core}
  :uberjar-name "song.jar"
  :plugins [[lein-auto "0.1.3"]])

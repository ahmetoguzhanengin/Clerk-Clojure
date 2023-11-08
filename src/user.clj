(ns user
  (:require [nextjournal.clerk :as clerk]))


(comment
  ;; start without file watcher, open browser when started
  (clerk/serve! {:browse? true :port 6677}))

(clerk/clear-cache!)

(clerk/show! "notebooks/ex01.clj")



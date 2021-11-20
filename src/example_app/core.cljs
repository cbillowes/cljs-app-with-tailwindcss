(ns example-app.core
  (:require [reagent.dom :as r.dom]
            [axios]
            [moment]))

;; Use mock REST API to get data to output to the browser
(-> (.. axios (get "https://jsonplaceholder.typicode.com/todos/1"))
    (.then #(js/console.log %)))


;; Display the day of the week
;; https://momentjs.com/docs/
(js/console.log (.format (moment) "dddd"))


(defn app []
  [:div
   [:h1 "Example application"]])


(defn mount []
  (r.dom/render [app] (js/document.getElementById "app")))


(defonce start-up (do (mount) true))


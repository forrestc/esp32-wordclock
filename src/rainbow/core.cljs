(ns rainbow.core
  ;; "cljs version of http://www.espruino.com/Reference#t_l_neopixel_write"
  (:require [esprit.repl]))

(def neopixel (js/require "neopixel"))

(def led-pin js/D13)
(def num-leds 11)

(def array-length (* num-leds 3))
(def rgb (js/Uint8ClampedArray. array-length))

(def brightness (atom 10)) ; 0 to 127
(def pos (atom 0))

(defn set-color [rgb brightness pos i coe]
  (aset rgb i
        (-> (js/Math.sin (* (+ i pos) coe)) ; range is -1 to 1
            (+ 1) ; shift range to 0 to 2
            (* brightness) ; multiply by brightness (range 0 to 127) to make output range 0 to 255
            )))

(defn get-pattern [pos brightness]
  (loop [i 0]
    (if (< i array-length)
      (do
        (set-color rgb brightness pos (+ i 0) 0.1324)
        (set-color rgb brightness pos (+ i 1) 0.1654)
        (set-color rgb brightness pos (+ i 2) 0.1)
        (recur (+ i 3)))
      rgb)))

(defn shine []
  (swap! pos inc)
  (.write neopixel led-pin (get-pattern @pos @brightness)))

(def interval (atom nil))

(defn stop []
  (js/clearInterval @interval)
  (reset! interval nil))

(defn start [delay]
  (when @interval (stop))
  (reset! interval (js/setInterval shine delay)))

(defn clear []
  (when @interval (stop))
  (.write neopixel led-pin (js/Uint8ClampedArray. array-length)))

(comment
  (start 100)
  (stop)
  (clear)

  (reset! pos 0)
  (reset! brightness 10)
  )

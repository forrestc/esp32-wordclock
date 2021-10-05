;; cljs version of http://www.espruino.com/Reference#t_l_neopixel_write 

(def neopixel (js/require "neopixel"))
(def brightness 127) ;; an integer between 1 to 127
(defn rainbow [pos]
  (fn [i]
    (let [idx (mod i 3)
          coe (case idx
                0 0.1324 ;; green
                1 0.1654 ;; red
                2 0.1 ;; blue
              )]
    (* brightness
      (+ 1 
        (.sin js/Math
          (* coe (+ i pos))))))))
(defn shine [pos]
  (.write neopixel js/D13
    (->js
      (map (rainbow pos) (range (* 11 3))))))

// ? setInterval with pos++
(doseq [pos (range 0 100 4)] (shine pos))

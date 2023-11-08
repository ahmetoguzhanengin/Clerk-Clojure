(ns ex01)

^{::clerk/visibility {:code :hide}}
(require '[nextjournal.clerk :as clerk])

^{::clerk/visibility {:code :hide}}
(require '[clojure.walk :refer [postwalk]])


;; ### Problem 01: Öğrenci Kayıt Sistemi: Öğrenci Kaydı

;;s01: Öğrenci, uygulamaya girer. "Student Registration" formunu açar.

^{::clerk/visibility {:code :hide}}
(def RegisterationForm
  {:name nil
   :surname nil
   :department nil})
;;s02: Sistem kullanıcıya boş bir "Student Registration" formu sunar. Bu formda şu alanlar bulunur:

^{::clerk/visibility {:code :hide}}
 (clerk/table
   {:name ["<input>"]
    :surname ["<input>"]
    :department ["<input>"]})

;;Department: (mevcut departmanlardan seçilecek)

^{::clerk/visibility {:code :hide}}
(clerk/table
  {:department ["Mimarlık Fakültesi", "Mühendislik Fakültesi", "Hukuk Fakültesi" ,"..."]})

; s02: Öğrenci formu doldurur ve gönderir.

(def form
  {:name "Ahmet Oğuzhan Engin"
   :department "Mühendislik Fakültesi"})

^{::clerk/visibility {:code :hide}}
(defn to-clerk [m]
      (postwalk
        #(if
           (or (string? %) (map? %))
           (vector %)
           %)
        m))

^{::clerk/visibility {:code :hide}}
(clerk/table
  (to-clerk form))





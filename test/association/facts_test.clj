(ns association.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [association.facts :as facts]))

(deftest cbi-has-spec-basis
  (let [sb (facts/spec-basis "cbi")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:association-rule/url %) "https://") sb))
    (is (every? #(= "9411" (:association-rule/isic %)) sb))
    (is (every? #(= "GBR" (:association-rule/country %)) sb))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "iod")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["cbi" "iod"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["iod"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= 2 (count (facts/by-topic "cbi" :governance))))
  (is (empty? (facts/by-topic "cbi" :labor)))
  (is (empty? (facts/by-topic "iod" :governance))))

(ns association.facts-test
  "What the catalog must hold to be worth citing.

  The counts below are deliberately exact rather than `pos?`: this catalog's
  failure mode is not a wrong answer, it is a quiet shrink -- an entry dropped
  in an edit reads the same as an entry that was never there."
  (:require [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is testing]]
            [association.facts :as facts]))

(def ^:private entries (facts/spec-basis "cbi"))

(deftest cbi-has-spec-basis
  (is (= 12 (count entries)))
  (is (every? #(str/starts-with? (:association-rule/url %) "https://") entries))
  (is (every? #(= "9411" (:association-rule/isic %)) entries))
  (is (every? #(= "GBR" (:association-rule/country %)) entries)))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "iod")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["cbi" "iod"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["iod"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= 4 (count (facts/by-topic "cbi" :governance))))
  (is (= 4 (count (facts/by-topic "cbi" :transparency))))
  (is (= 3 (count (facts/by-topic "cbi" :european-representation))))
  (is (= 3 (count (facts/by-topic "cbi" :contact))))
  (is (= 2 (count (facts/by-topic "cbi" :membership))))
  (is (empty? (facts/by-topic "cbi" :labor)))
  (is (empty? (facts/by-topic "iod" :governance))))

(deftest every-entry-carries-the-span-its-claim-rests-on
  ;; A citation without a quote cannot be checked against its own source: the
  ;; URL still resolves long after the page stops saying the thing.
  (doseq [e entries]
    (testing (:association-rule/id e)
      (is (string? (:association-rule/source-quote e)))
      (is (< 20 (count (:association-rule/source-quote e)))
          "a span too short to be distinctive matches by accident")
      (is (string? (:association-rule/source-article e)))
      (is (str/starts-with? (:association-rule/url e) "https://")))))

(deftest a-dated-entry-says-how-precisely-its-source-dates-it
  ;; Precision is a property of the source. Recording it per entry is what
  ;; lets the README's judgement about the two uncorroborated day-level
  ;; founding dates be checked rather than restated.
  (doseq [e entries]
    (testing (:association-rule/id e)
      (let [d (:association-rule/established-date e)
            p (:association-rule/date-precision e)]
        (if d
          (do (is (#{:day :month :year} p))
              (is (= (case p :day 3 :month 2 :year 1)
                     (count (str/split d #"-")))
                  "the precision claimed must match the date written"))
          (do (is (nil? p))
              (is (keyword? (:association-rule/date-unknown-because e))
                  "undated is a fact about the source and is recorded, not hidden")))))))

(deftest the-catalog-does-not-rest-on-a-single-page
  ;; Both entries this catalog started with cited one page. That is one
  ;; redesign away from citing nothing, and nothing in the data said so.
  (let [srcs (facts/sources)]
    (is (= 9 (count srcs)))
    (is (= 12 (reduce + (map count (vals srcs)))))
    (is (some #(str/includes? % "thegazette.co.uk") (keys srcs))
        "the Charter petition is on the UK public record, not only in prose")
    (is (some #(str/includes? % "company-information.service.gov.uk") (keys srcs))
        "and the Royal Charter company is on the UK register")))

(deftest not-one-entry-is-cbi-speaking-about-itself
  ;; cbi.org.uk answers HTTP 403 to the verifier's fetcher, so the catalog is
  ;; entirely third-party. That is a property worth asserting rather than
  ;; describing: an entry that quietly acquired a cbi.org.uk URL would be
  ;; uncheckable by `verify-catalog.cljs --live`, which refuses rather than
  ;; reports when a source cannot be read.
  (is (not-any? #(str/includes? (:association-rule/url %) "cbi.org.uk") entries))
  (is (not-any? #(= :official-cbi-org-uk (:association-rule/url-provenance %)) entries)))

(deftest undated-entries-name-their-reason
  (let [u (facts/undated)]
    (is (= 4 (count u)))
    (is (every? (comp keyword? second) u))))

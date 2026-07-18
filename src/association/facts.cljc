(ns association.facts
  "Industry rule/history catalog for CBI (Confederation of British
  Industry) -- a 77th industry-association-level source (see
  cloud-itonami-assoc-9411-sau-fsc, -9411-aut-wko, -9411-irl-ibec,
  -9411-nzl-businessnz, -9411-cze-spcr, -9411-ind-cii, -9411-zaf-busa,
  -9411-bra-cni, -9411-ken-kam, -9411-can-chamber, -9411-mex-coparmex,
  -9411-ita-confindustria, -9411-nld-vnoncw, -9411-kor-kcci,
  -9411-arg-uia, -9411-bel-feb, -9411-dnk-di, -9411-swe-sn, -9411-fin-ek,
  -9411-tha-fti, -9411-chl-sofofa, -9411-col-andi, -9411-cri-uccaep,
  -9411-ecu-cip, -9411-egy-fei, -9411-pry-uip, -9411-ury-ciu,
  -9411-pol-lewiatan, -9411-prt-cip, -9411-pan-conep, -9411-gtm-cacif,
  -9411-hnd-cohep, -9411-deu-bdi, -9411-fra-medef for the first
  thirty-four) per ADR-2607141700 (cloud-itonami-compliance-fact-
  federation). The THIRTY-FIFTH entry aligned to ISIC 9411 (activities
  of business, employers, and professional membership organizations).
  The THIRD entry in the 16-country major-economy campaign opened at
  tick 173 (ARE/AUS/CHE/ESP/GBR/IDN/JPN/MYS/NGA/NOR/PHL/TUR/USA/VNM,
  after DEU and FRA closed). The United Kingdom now has real,
  individually verified facts across ALL THREE axes (country:
  cloud-itonami-iso3166-gbr statute.facts, pre-existing; municipality:
  cloud-itonami-municipality-gbr-london, pre-existing; association:
  this entry -- the UK already had a niche automotive association,
  cloud-itonami-assoc-2910-gbr-smmt, but lacked a general confederation
  entry until now).

  GENUINE UNRESOLVED SOURCE DISCREPANCY, documented honestly rather
  than silently picked: en.wikipedia.org's own article, directly read,
  confirms only 'formed in 1965' -- year-only precision, no day or
  month. Aggregated web-search summaries surfaced two CONFLICTING
  day-level claims ('3 July 1965' attributed to CBI's own FAQ vs '30
  July 1965' attributed to other unnamed sources), but neither could
  be independently verified by directly reading a source this tick:
  cbi.org.uk's own FAQ PDF, the Warwick Modern Records Centre archive
  catalogue, herinst.org, and oxfordreference.com all either returned
  HTTP 403 or presented a login wall with no usable content. Rather
  than guess between the two conflicting day-level claims, this
  catalog uses ONLY the independently-corroborated year (1965,
  confirmed by both en.wikipedia.org and encyclopedia.com), and
  documents the unresolved day-level discrepancy transparently here
  and in organization.edn/README rather than fabricating a choice.

  A second, distinct, month-precise milestone was directly confirmed
  via en.wikipedia.org: the CBI's headquarters relocated from Centre
  Point to Cannon Place in March 2014.

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"cbi"
   [{:association-rule/id "cbi.founding-1965"
     :association-rule/title "CBI (Confederation of British Industry) formed in 1965 from a merger of the Federation of British Industries, the British Employers' Confederation, and the National Association of British Manufacturers (en.wikipedia.org's own article gives year-only precision; a day-level claim is genuinely disputed across sources and NOT used here -- see docstring)"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://en.wikipedia.org/wiki/Confederation_of_British_Industry"
     :association-rule/url-provenance :wikipedia-corroborated
     :association-rule/established-date "1965"
     :association-rule/retrieved-at "2026-07-18"
     :association-rule/topic #{:governance}}
    {:association-rule/id "cbi.hq-relocation-2014-03"
     :association-rule/title "CBI's headquarters relocated from Centre Point to Cannon Place in March 2014"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://en.wikipedia.org/wiki/Confederation_of_British_Industry"
     :association-rule/url-provenance :wikipedia-corroborated
     :association-rule/established-date "2014-03"
     :association-rule/retrieved-at "2026-07-18"
     :association-rule/topic #{:governance}}]})

(defn spec-basis [association] (get catalog association))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-9411-gbr-cbi Wave 0 (ADR-2607141700): "
                 (count (get catalog "cbi")) " CBI entries seeded "
                 "with en.wikipedia.org corroboration (a genuine, unresolved day-level founding-date "
                 "discrepancy across secondary sources is documented, not fabricated a choice for). "
                 "Extend `association.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))

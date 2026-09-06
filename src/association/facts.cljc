(ns association.facts
  "Industry rule/history catalog for CBI (Confederation of British
  Industry) -- a 77th industry-association-level source per
  ADR-2607141700 (cloud-itonami-compliance-fact-federation). The
  THIRTY-FIFTH entry aligned to ISIC 9411 (activities of business,
  employers, and professional membership organizations), and the THIRD
  in the 16-country major-economy campaign opened at tick 173. The
  United Kingdom has real, individually verified facts across ALL
  THREE axes (country: cloud-itonami-iso3166-gbr statute.facts;
  municipality: cloud-itonami-municipality-gbr-london; association:
  this entry).

  Every entry carries the verbatim span its claim rests on
  (`:association-rule/source-quote`), the page that span was read from,
  and how precisely that page dates the fact
  (`:association-rule/date-precision`). That is what makes the catalog
  checkable rather than merely cited: scripts/verify-catalog.cljs
  --live fetches each source and requires the span to still be there,
  and its structural pass requires the span to actually NAME the date
  the entry claims. A URL that resolves and does not support the claim
  looks exactly like one that does.

  NOT ONE ENTRY HERE IS THE ORGANISATION SPEAKING ABOUT ITSELF, and
  this is a fact about the sourcing, not an oversight. cbi.org.uk
  answers HTTP 403 to this fetcher -- as it did when the catalog was
  first seeded in 2026-07 -- so every span below is a third party: the
  UK public record (thegazette.co.uk), the UK registrar (Companies
  House), three UK government departments' own FOI releases (gov.uk),
  the European peak body CBI belongs to (businesseurope.eu), and
  en.wikipedia.org. The provenance keywords name WHO is speaking
  instead of reaching for the word `official`, which none of these
  sources can carry on CBI's behalf.

  THE FOUNDING-DATE DISCREPANCY, NARROWED BUT NOT CLOSED. The catalog
  used to record only `formed in 1965` and note that two day-level
  claims (`3 July 1965` and `30 July 1965`) circulated in aggregated
  search summaries without either being independently readable. The
  London Gazette entry now added does not settle that: it is the
  PETITION for the Charter, dated 15 April 1965 and published in issue
  43627, not the GRANT. A search of the Gazette across 1965-1967
  surfaced no readable grant notice. So the year stays year-precise,
  the day-level claims stay out, and the record now has a primary
  source for the step that certainly did happen and its date. Note
  also that the Gazette's own OCR renders `11th` as `llth` in that
  span; the quote is stored as the service serves it, because that is
  what `--live` can check.

  Dates are recorded at the precision the source gives and no finer:
  six entries are day-precise, one month-precise, one year-precise
  twice over, and four carry no date at all and say why in
  `:date-unknown-because` rather than being quietly undated.

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"cbi"
   [{:association-rule/id "cbi.charter-petition-1965-04-15"
     :association-rule/title "Federation of British Industries petitioned Her Majesty in Council for a new Charter under the style and title of 'The Confederation of British Industry'; the Privy Council Office notice is dated 15 April 1965 and was published in The London Gazette issue 43627, page 3777"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.thegazette.co.uk/London/issue/43627/page/3777/data.pdf"
     :association-rule/url-provenance :uk-public-record
     :association-rule/source-article "The London Gazette, Issue 43627 (16 April 1965), Page 3777 -- Privy Council Office notice"
     :association-rule/source-quote "Notice is hereby given that a Petition of the Federation of British Industries, praying for the grant of a new Charter under the style and title of \" The Confederation of British Industry\", has been presented to Her Majesty in Council, and, Her Majesty having referred the said Petition to a Committee of the Lords of the Council, Notice is further given that all Petitions for or against such grant should be delivered to the Privy Council Office on or before the llth day of May next. 15th April 1965."
     :association-rule/established-date "1965-04-15"
     :association-rule/date-precision :day
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :public-record}}
    {:association-rule/id "cbi.royal-charter-company-rc000139"
     :association-rule/title "CBI is on the UK company register as a Royal Charter company, company number RC000139"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://find-and-update.company-information.service.gov.uk/company/RC000139"
     :association-rule/url-provenance :uk-registrar
     :association-rule/source-article "Companies House -- Company Overview for CONFEDERATION OF BRITISH INDUSTRY (RC000139)"
     :association-rule/source-quote "CONFEDERATION OF BRITISH INDUSTRY Company number RC000139 Follow this company Company Overview for CONFEDERATION OF BRITISH INDUSTRY (RC000139) Company type Royal Charter company"
     :association-rule/date-unknown-because :registry-overview-carries-no-date
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :registration}}
    {:association-rule/id "cbi.businesseurope-member"
     :association-rule/title "CBI is listed as the United Kingdom member federation of BusinessEurope"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.businesseurope.eu/members"
     :association-rule/url-provenance :peak-body-businesseurope
     :association-rule/source-article "BusinessEurope -- Members"
     :association-rule/source-quote "Confederation of British Industry – CBI United Kingdom"
     :association-rule/date-unknown-because :directory-listing-carries-no-date
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:european-representation :membership}}
    {:association-rule/id "cbi.headquarters-cannon-place"
     :association-rule/title "BusinessEurope's member directory gives CBI's headquarters as Cannon Place, 78 Cannon Place, London EC4N 6HN -- independently corroborating the Cannon Place address that en.wikipedia.org dates to a March 2014 relocation"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.businesseurope.eu/member/confederation-of-british-industry-cbi/"
     :association-rule/url-provenance :peak-body-businesseurope
     :association-rule/source-article "BusinessEurope -- Member: Confederation of British Industry - CBI"
     :association-rule/source-quote "Member – United Kingdom Confederation of British Industry – CBI Headquarters Confederation of British Industry – CBI Cannon Place 78 Cannon Place GB- London EC4N 6HN"
     :association-rule/date-unknown-because :directory-entry-carries-no-date
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:contact :membership}}
    {:association-rule/id "cbi.brussels-office-address"
     :association-rule/title "CBI maintains a Brussels office at Rue de la science 14, 1040 Bruxelles; the same directory entry gives cbi.org.uk as its own site"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.businesseurope.eu/member/confederation-of-british-industry-cbi/"
     :association-rule/url-provenance :peak-body-businesseurope
     :association-rule/source-article "BusinessEurope -- Member: Confederation of British Industry - CBI"
     :association-rule/source-quote "https://www.cbi.org.uk/ Brussels office Rue de la science 14 1040 Bruxelles"
     :association-rule/date-unknown-because :directory-entry-carries-no-date
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:european-representation :contact}}
    {:association-rule/id "cbi.gov-cic-regulator-payments-2014-10-01"
     :association-rule/title "The Office of the Regulator of Community Interest Companies published a Freedom of Information release on payments made to the CBI on 1 October 2014"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.gov.uk/government/publications/payments-made-to-the-confederation-of-british-industry"
     :association-rule/url-provenance :uk-government
     :association-rule/source-article "GOV.UK FOI release -- Payments made to the Confederation of British Industry"
     :association-rule/source-quote "From: Office of the Regulator of Community Interest Companies Published: 1 October 2014 Get emails about this page Documents Payments made to the Confederation of British Industry"
     :association-rule/established-date "2014-10-01"
     :association-rule/date-precision :day
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:transparency}}
    {:association-rule/id "cbi.gov-cprc-fees-2014-09-17"
     :association-rule/title "The Civil Procedure Rule Committee published its CBI and subsidiaries membership fees on 17 September 2014"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.gov.uk/government/publications/confederation-of-british-industry-fees"
     :association-rule/url-provenance :uk-government
     :association-rule/source-article "GOV.UK FOI release -- Confederation of British Industry fees"
     :association-rule/source-quote "Confederation of British Industry (CBI) and subsidiaries membership fees. From: Civil Procedure Rule Committee Published: 17 September 2014"
     :association-rule/established-date "2014-09-17"
     :association-rule/date-precision :day
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:transparency}}
    {:association-rule/id "cbi.gov-defra-expenditure-2014-11-21"
     :association-rule/title "Defra published, on 21 November 2014, the amount paid to the CBI and its regional subsidiaries by each organisation in the Defra family for the financial years 2009-10 to 2013-14"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.gov.uk/government/publications/confederation-of-british-industry-cbi-expenditure-2009-to-2014"
     :association-rule/url-provenance :uk-government
     :association-rule/source-article "GOV.UK FOI release -- Confederation of British Industry (CBI) Expenditure 2009 to 2014"
     :association-rule/source-quote "Confederation of British Industry (CBI) - FOI amount paid to the CBI (and its regional subsidiaries) by each of the organisations within the Defra family in membership fees, fees for one off conferences or other events and fees paid to the CBI for any other services for the financial years from 2009 to 2010 through to 2013 to 2014. Updates to this page Published 21 November 2014"
     :association-rule/established-date "2014-11-21"
     :association-rule/date-precision :day
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:transparency}}
    {:association-rule/id "cbi.gov-companies-house-foi-2016-08-22"
     :association-rule/title "Companies House published, on 22 August 2016, an FOI response on the amount it paid to the CBI and its subsidiaries in membership fees for 2009 to 2014"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.gov.uk/government/publications/request-for-the-amount-paid-by-companies-house-to-the-confederation-of-british-industry-cbi"
     :association-rule/url-provenance :uk-government
     :association-rule/source-article "GOV.UK FOI release -- Request for the amount paid by Companies House to the Confederation of British Industry (CBI)"
     :association-rule/source-quote "Request for the amount paid by Companies House to the CBI. From: Companies House Published: 22 August 2016"
     :association-rule/established-date "2016-08-22"
     :association-rule/date-precision :day
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:transparency}}
    {:association-rule/id "cbi.founding-1965"
     :association-rule/title "CBI was formed in 1965 out of a merger of the Federation of British Industries, the British Employers' Confederation and the National Association of British Manufacturers (year-only precision: this is how the source dates it)"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://en.wikipedia.org/wiki/Confederation_of_British_Industry"
     :association-rule/url-provenance :wikipedia-corroborated
     :association-rule/source-article "Confederation of British Industry -- History"
     :association-rule/source-quote "The organisation was formed in 1965 out of a merger of the Federation of British Industries (known as FBI), the British Employers' Confederation and the National Association of British Manufacturers ."
     :association-rule/established-date "1965"
     :association-rule/date-precision :year
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance}}
    {:association-rule/id "cbi.brussels-office-1971"
     :association-rule/title "CBI opened an office in Brussels in 1971"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://en.wikipedia.org/wiki/Confederation_of_British_Industry"
     :association-rule/url-provenance :wikipedia-corroborated
     :association-rule/source-article "Confederation of British Industry -- History"
     :association-rule/source-quote "The CBI opened an office in Brussels in 1971, to open up opportunities in Europe ."
     :association-rule/established-date "1971"
     :association-rule/date-precision :year
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:european-representation}}
    {:association-rule/id "cbi.hq-relocation-2014-03"
     :association-rule/title "CBI moved its headquarters from Centre Point, London, to Cannon Place in March 2014"
     :association-rule/association "cbi"
     :association-rule/isic "9411"
     :association-rule/country "GBR"
     :association-rule/kind :governance-program
     :association-rule/url "https://en.wikipedia.org/wiki/Confederation_of_British_Industry"
     :association-rule/url-provenance :wikipedia-corroborated
     :association-rule/source-article "Confederation of British Industry -- History"
     :association-rule/source-quote "In March 2014 it moved its headquarters from Centre Point , London, to offices in Cannon Place, located above Cannon Street railway station in the City of London ."
     :association-rule/established-date "2014-03"
     :association-rule/date-precision :month
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :contact}}]})

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
                 (count (get catalog "cbi")) " CBI entries, each citing a source "
                 "with the page and the verbatim span it rests on. None of them "
                 "is CBI speaking about itself -- cbi.org.uk answers 403. "
                 "Extend `association.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))

(defn sources
  "Distinct pages this catalog rests on, with the entries each carries.
   A catalog that cites one page is one redesign away from citing none;
   this is the number that says how exposed it is."
  ([] (sources "cbi"))
  ([association]
   (->> (spec-basis association)
        (group-by :association-rule/url)
        (reduce-kv (fn [m url es] (assoc m url (mapv :association-rule/id es))) {}))))

(defn undated
  "Entries that carry no date, with the reason the source gives none.
   Being undated is a fact about the source and is recorded, not hidden."
  ([] (undated "cbi"))
  ([association]
   (->> (spec-basis association)
        (filterv #(nil? (:association-rule/established-date %)))
        (mapv (juxt :association-rule/id :association-rule/date-unknown-because)))))

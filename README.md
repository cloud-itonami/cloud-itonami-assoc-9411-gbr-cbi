# cloud-itonami-assoc-9411-gbr-cbi

Industry rule/history catalog for **CBI** (Confederation of British
Industry) — the THIRTY-FIFTH entry aligned to **ISIC 9411** (activities
of business, employers, and professional membership organizations),
alongside
[`-9411-fra-medef`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-fra-medef)
(France),
[`-9411-deu-bdi`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-deu-bdi)
(Germany), and 32 other national industry/employers associations.
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

The **third** entry in the 16-country major-economy campaign opened
at tick 173. The UK now has real, individually verified facts across
**all three axes**.

## Every entry carries the span it rests on

Each of the 12 entries records the **verbatim span** its claim rests on
(`:association-rule/source-quote`), the page that span was read from
(`:association-rule/source-article`), and how precisely that page dates
the fact (`:association-rule/date-precision`).

```bash
kbb --backend sci scripts/verify-catalog.cljk          # structural, offline
kbb --backend sci scripts/verify-catalog.cljk --live   # fetch every source, require every span
```

Reachability is not support: a URL that returns 200 and no longer
contains the claim looks exactly like one that does. `--live` does not
ask whether the citation resolves, it asks whether the document still
says the thing the entry says it says. The structural pass additionally
requires the span to **name the date the entry claims** — none of these
sources writes dates in ISO, so a transcription slip would otherwise
leave the quote check green.

Exit is three-valued: `0` checked and clean, `1` findings, `2` **refused**
— it could not read the catalog or could not read a source, which must
not leave the same trace as a pass.

## Sourcing note — nobody here is CBI

**Not one entry is the organisation speaking about itself.** `cbi.org.uk`
answers **HTTP 403** to this fetcher, as it did when the catalog was
first seeded in 2026-07. Every span is therefore a third party, and the
provenance keywords say which:

| provenance | host | entries |
|---|---|---|
| `:uk-public-record` | `thegazette.co.uk` | 1 |
| `:uk-registrar` | Companies House | 1 |
| `:uk-government` | `gov.uk` | 4 |
| `:peak-body-businesseurope` | `businesseurope.eu` | 3 |
| `:wikipedia-corroborated` | `en.wikipedia.org` | 3 |

There is deliberately no `:official-cbi-org-uk` keyword: one that could
not be honoured should not sit in the table waiting to be used.

## The founding-date discrepancy — narrowed, not closed

This catalog used to record only "formed in 1965" and note that two
day-level claims ("3 July 1965" and "30 July 1965") circulated in
aggregated search summaries without either being independently readable.

That is still where it stands, but the record is no longer only prose.
**The London Gazette, issue 43627, page 3777** carries the Privy Council
Office notice that the Federation of British Industries had petitioned
for a new Charter under the style and title of "The Confederation of
British Industry" — dated **15 April 1965**, published 16 April 1965.
This is the UK's official public record and it is now cited directly.

It does **not** settle the founding date. That notice is the
**petition**, not the **grant**; a Gazette search across 1965–1967
surfaced no readable grant notice. So the year stays year-precise, the
two day-level claims stay out, and the catalog gains a primary source
for the step that certainly did happen, on the date the record gives it.

Two smaller notes on that entry, both honest rather than tidy: the
Gazette serves its 1965 pages as **scanned PDF**, so `--live` needs
`pdftotext`; and its OCR renders "11th" as "llth" inside the span. The
quote is stored as the service serves it, because that is what `--live`
can check.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on CBI's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one. Four entries carry no date at all and say why in
`:date-unknown-because` rather than being quietly undated.

## Data

- `src/association/facts.cljc` — the catalog, source of truth.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).
- `src/association_facts.kotoba` — the same catalog as Kotoba, **generated**
  by `scripts/gen-kotoba-port.cljs` (`--check` fails if it was hand-edited).
  `test/association_facts_kotoba_parity_test.clj` compares every field of
  every entry against the `.cljc`.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention).

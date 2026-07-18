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

## Sourcing note — a genuine, unresolved discrepancy

`en.wikipedia.org`'s own article, directly read, confirms only "formed
in 1965" — year-only precision. Aggregated web-search summaries
surfaced two conflicting day-level claims ("3 July 1965" vs "30 July
1965"), but neither could be independently verified: `cbi.org.uk`'s
own FAQ PDF, the Warwick Modern Records Centre archive, and other
reference sites all returned HTTP 403 or a login wall this tick.
Rather than guess between the two, this catalog uses only the
independently-corroborated year and documents the unresolved
discrepancy transparently. A second, distinct fact — the CBI's March
2014 headquarters relocation from Centre Point to Cannon Place — is
directly confirmed by the same Wikipedia article.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on CBI's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, source of truth.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention).

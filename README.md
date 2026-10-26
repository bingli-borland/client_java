# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-26T08:55:24Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V45 96-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 69.86K | ± 241.88 | ops/s | **fastest** |
| prometheusNoLabelsInc | 67.25K | ± 833.72 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 62.87K | ± 200.33 | ops/s | 1.1x slower |
| prometheusAdd | 62.46K | ± 94.28 | ops/s | 1.1x slower |
| simpleclientNoLabelsInc | 11.29K | ± 171.31 | ops/s | 6.2x slower |
| simpleclientInc | 10.79K | ± 155.77 | ops/s | 6.5x slower |
| simpleclientAdd | 10.76K | ± 37.13 | ops/s | 6.5x slower |
| openTelemetryIncNoLabels | 5.96K | ± 848.97 | ops/s | 12x slower |
| openTelemetryAdd | 5.86K | ± 722.82 | ops/s | 12x slower |
| openTelemetryInc | 5.58K | ± 605.59 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 7.17K | ± 84.05 | ops/s | **fastest** |
| prometheusClassic | 6.10K | ± 109.02 | ops/s | 1.2x slower |
| prometheusNative | 5.35K | ± 590.63 | ops/s | 1.3x slower |
| openTelemetryClassic | 961.86 | ± 15.56 | ops/s | 7.5x slower |
| openTelemetryExponential | 788.33 | ± 12.04 | ops/s | 9.1x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 34.10K | ± 346.19 | ops/s | **fastest** |
| openMetricsWriteToNull | 33.82K | ± 358.42 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 742.89K | ± 18.59K | ops/s | **fastest** |
| prometheusWriteToByteArray | 741.29K | ± 39.89K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 708.20K | ± 32.17K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 699.02K | ± 34.28K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      62870.729    ± 200.327  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       5856.699    ± 722.816  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5584.067    ± 605.587  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5964.931    ± 848.966  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      62463.555     ± 94.281  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      69859.318    ± 241.879  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      67245.566    ± 833.719  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15      10755.178     ± 37.131  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15      10786.990    ± 155.765  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15      11294.837    ± 171.313  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        961.858     ± 15.560  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        788.332     ± 12.035  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6102.885    ± 109.021  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       5349.214    ± 590.630  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       7174.045     ± 84.045  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      33823.955    ± 358.416  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      34101.363    ± 346.192  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     699018.813  ± 34275.349  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     708200.184  ± 32165.439  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     741294.123  ± 39888.597  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     742888.840  ± 18591.629  ops/s
```

## Notes

- **Score** = Throughput in operations per second (higher is better)
- **Error** = 99.9% confidence interval

## Benchmark Descriptions

| Benchmark | Description |
|:----------|:------------|
| **CounterBenchmark** | Counter increment performance: Prometheus, OpenTelemetry, simpleclient, Codahale |
| **HistogramBenchmark** | Histogram observation performance (classic vs native/exponential) |
| **TextFormatUtilBenchmark** | Metric exposition format writing speed |

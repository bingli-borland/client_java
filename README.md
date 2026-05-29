# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-05-29T07:38:54Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1015-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.79K | ± 89.90 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.87K | ± 124.61 | ops/s | 1.2x slower |
| prometheusAdd | 48.89K | ± 702.52 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.95K | ± 59.96 | ops/s | 1.4x slower |
| simpleclientInc | 6.17K | ± 49.73 | ops/s | 9.7x slower |
| simpleclientAdd | 6.08K | ± 87.12 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 5.80K | ± 111.64 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 4.98K | ± 1.11K | ops/s | 12x slower |
| openTelemetryInc | 4.57K | ± 965.16 | ops/s | 13x slower |
| openTelemetryAdd | 3.56K | ± 118.80 | ops/s | 17x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.37K | ± 1.82K | ops/s | **fastest** |
| simpleclient | 4.51K | ± 62.89 | ops/s | 1.2x slower |
| prometheusNative | 3.05K | ± 131.23 | ops/s | 1.8x slower |
| openTelemetryClassic | 723.69 | ± 13.78 | ops/s | 7.4x slower |
| openTelemetryExponential | 607.25 | ± 39.87 | ops/s | 8.9x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.57K | ± 219.35 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.14K | ± 112.28 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 566.80K | ± 1.76K | ops/s | **fastest** |
| prometheusWriteToByteArray | 554.21K | ± 4.80K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 522.00K | ± 15.14K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 518.86K | ± 4.40K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43953.104     ± 59.961  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3558.347    ± 118.804  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4574.054    ± 965.161  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4978.058   ± 1109.126  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48891.783    ± 702.520  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59791.634     ± 89.897  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51873.476    ± 124.605  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6078.281     ± 87.122  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6167.500     ± 49.734  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5801.604    ± 111.639  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        723.690     ± 13.781  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        607.246     ± 39.868  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5374.671   ± 1817.524  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3054.408    ± 131.231  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4510.616     ± 62.888  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27141.330    ± 112.276  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27569.764    ± 219.350  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     518861.571   ± 4404.529  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     521998.405  ± 15135.205  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     554213.566   ± 4804.609  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     566799.787   ± 1763.001  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-16T04:23:32Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.49K | ± 1.01K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.59K | ± 435.14 | ops/s | 1.1x slower |
| prometheusAdd | 51.22K | ± 344.66 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.26K | ± 1.58K | ops/s | 1.3x slower |
| simpleclientInc | 6.58K | ± 16.08 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 6.36K | ± 34.59 | ops/s | 10x slower |
| simpleclientAdd | 6.00K | ± 322.54 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 3.49K | ± 266.27 | ops/s | 18x slower |
| openTelemetryAdd | 3.45K | ± 167.22 | ops/s | 19x slower |
| openTelemetryInc | 3.27K | ± 104.66 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.77K | ± 488.90 | ops/s | **fastest** |
| simpleclient | 4.37K | ± 69.81 | ops/s | 1.1x slower |
| prometheusNative | 2.64K | ± 119.83 | ops/s | 1.8x slower |
| openTelemetryClassic | 729.21 | ± 3.55 | ops/s | 6.5x slower |
| openTelemetryExponential | 583.52 | ± 12.31 | ops/s | 8.2x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.11K | ± 164.74 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.69K | ± 717.23 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 502.02K | ± 5.27K | ops/s | **fastest** |
| prometheusWriteToByteArray | 493.06K | ± 5.03K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 484.17K | ± 1.44K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 478.23K | ± 899.56 | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48263.517   ± 1578.534  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3450.467    ± 167.221  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3274.470    ± 104.657  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3486.973    ± 266.272  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51218.188    ± 344.657  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64490.363   ± 1008.849  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56585.211    ± 435.144  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5996.569    ± 322.536  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6576.794     ± 16.084  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6357.431     ± 34.594  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        729.209      ± 3.550  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        583.525     ± 12.306  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4770.290    ± 488.900  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2638.101    ± 119.834  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4365.310     ± 69.813  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23688.169    ± 717.230  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24111.444    ± 164.741  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     478233.754    ± 899.564  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     484169.632   ± 1438.468  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     493062.961   ± 5031.598  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     502022.902   ± 5269.998  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-02T07:23:25Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.48K | ± 1.04K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.17K | ± 941.75 | ops/s | 1.2x slower |
| prometheusAdd | 51.25K | ± 453.43 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.53K | ± 1.67K | ops/s | 1.3x slower |
| simpleclientInc | 6.55K | ± 39.92 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.35K | ± 35.06 | ops/s | 10x slower |
| simpleclientAdd | 6.11K | ± 316.26 | ops/s | 11x slower |
| openTelemetryInc | 3.34K | ± 226.80 | ops/s | 20x slower |
| openTelemetryIncNoLabels | 3.30K | ± 87.30 | ops/s | 20x slower |
| openTelemetryAdd | 3.21K | ± 269.49 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.99K | ± 850.16 | ops/s | **fastest** |
| simpleclient | 4.46K | ± 77.23 | ops/s | 1.3x slower |
| prometheusNative | 2.76K | ± 278.81 | ops/s | 2.2x slower |
| openTelemetryExponential | 723.52 | ± 29.09 | ops/s | 8.3x slower |
| openTelemetryClassic | 715.11 | ± 10.75 | ops/s | 8.4x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 24.20K | ± 667.61 | ops/s | **fastest** |
| prometheusWriteToNull | 24.02K | ± 444.10 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 512.63K | ± 4.79K | ops/s | **fastest** |
| prometheusWriteToByteArray | 501.25K | ± 3.05K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 490.37K | ± 2.99K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 483.33K | ± 6.90K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49532.839   ± 1671.168  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3214.201    ± 269.495  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3339.457    ± 226.804  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3298.048     ± 87.303  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51249.941    ± 453.428  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65481.050   ± 1035.919  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56167.332    ± 941.746  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6111.662    ± 316.256  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6554.752     ± 39.918  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6352.400     ± 35.056  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        715.109     ± 10.752  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        723.521     ± 29.092  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5991.206    ± 850.158  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2759.957    ± 278.814  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4457.706     ± 77.226  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      24203.759    ± 667.608  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24019.307    ± 444.103  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     483327.145   ± 6902.454  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     490368.524   ± 2987.564  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     501249.491   ± 3050.256  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     512632.101   ± 4792.117  ops/s
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

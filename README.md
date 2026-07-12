# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-12T06:52:08Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 57.69K | ± 2.77K | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.35K | ± 1.13K | ops/s | 1.1x slower |
| prometheusAdd | 48.01K | ± 315.48 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.71K | ± 466.83 | ops/s | 1.3x slower |
| simpleclientInc | 6.08K | ± 13.51 | ops/s | 9.5x slower |
| simpleclientNoLabelsInc | 5.92K | ± 17.99 | ops/s | 9.7x slower |
| openTelemetryInc | 5.86K | ± 158.64 | ops/s | 9.9x slower |
| simpleclientAdd | 5.81K | ± 355.35 | ops/s | 9.9x slower |
| openTelemetryIncNoLabels | 5.37K | ± 977.07 | ops/s | 11x slower |
| openTelemetryAdd | 4.40K | ± 821.27 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.91K | ± 1.76K | ops/s | **fastest** |
| simpleclient | 4.52K | ± 97.67 | ops/s | 1.1x slower |
| prometheusNative | 2.91K | ± 247.03 | ops/s | 1.7x slower |
| openTelemetryClassic | 677.64 | ± 16.98 | ops/s | 7.2x slower |
| openTelemetryExponential | 564.18 | ± 26.58 | ops/s | 8.7x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 27.24K | ± 45.73 | ops/s | **fastest** |
| prometheusWriteToNull | 27.04K | ± 438.29 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 563.13K | ± 5.18K | ops/s | **fastest** |
| prometheusWriteToByteArray | 542.13K | ± 8.79K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 532.42K | ± 4.69K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 520.76K | ± 4.22K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43706.427    ± 466.834  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4398.061    ± 821.269  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5855.387    ± 158.644  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5372.600    ± 977.071  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48013.310    ± 315.477  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      57689.502   ± 2768.174  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51353.292   ± 1133.475  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5806.328    ± 355.346  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6083.880     ± 13.513  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5924.357     ± 17.995  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        677.640     ± 16.981  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        564.177     ± 26.582  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4909.653   ± 1758.476  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2907.245    ± 247.030  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4522.678     ± 97.671  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27244.465     ± 45.733  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27040.484    ± 438.290  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     520755.481   ± 4219.013  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     532415.565   ± 4687.664  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     542125.596   ± 8788.630  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     563126.892   ± 5176.072  ops/s
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

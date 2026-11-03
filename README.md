# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-03T10:34:15Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.58K | ± 1.72K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.77K | ± 309.11 | ops/s | 1.2x slower |
| prometheusAdd | 50.90K | ± 301.64 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 47.51K | ± 644.17 | ops/s | 1.4x slower |
| simpleclientInc | 6.38K | ± 191.21 | ops/s | 10x slower |
| simpleclientAdd | 6.23K | ± 314.30 | ops/s | 11x slower |
| simpleclientNoLabelsInc | 6.13K | ± 189.09 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 3.56K | ± 430.33 | ops/s | 18x slower |
| openTelemetryInc | 3.23K | ± 277.93 | ops/s | 20x slower |
| openTelemetryAdd | 3.15K | ± 358.90 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.77K | ± 827.28 | ops/s | **fastest** |
| simpleclient | 4.38K | ± 47.68 | ops/s | 1.1x slower |
| prometheusNative | 2.72K | ± 311.79 | ops/s | 1.8x slower |
| openTelemetryClassic | 804.04 | ± 28.84 | ops/s | 5.9x slower |
| openTelemetryExponential | 599.83 | ± 39.76 | ops/s | 8.0x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.23K | ± 598.76 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.68K | ± 540.35 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 469.60K | ± 2.12K | ops/s | **fastest** |
| prometheusWriteToByteArray | 467.71K | ± 3.59K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 455.02K | ± 5.36K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 443.21K | ± 7.62K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      47511.514    ± 644.169  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3152.891    ± 358.899  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3228.962    ± 277.931  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3561.910    ± 430.326  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50896.495    ± 301.640  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65579.825   ± 1720.716  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56767.873    ± 309.107  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6226.646    ± 314.298  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6379.751    ± 191.205  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6125.989    ± 189.092  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        804.037     ± 28.836  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        599.830     ± 39.756  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4773.084    ± 827.277  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2719.805    ± 311.793  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4383.160     ± 47.683  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23678.925    ± 540.350  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24227.906    ± 598.761  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     443212.449   ± 7618.914  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     455015.353   ± 5360.018  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     467711.202   ± 3594.353  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     469597.670   ± 2124.213  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-04T10:09:40Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) 6975P-C, 4 cores, 15 GB RAM
- **OS:** Linux 7.0.0-1014-aws

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusAdd | 33.95K | ± 782.54 | ops/s | **fastest** |
| prometheusInc | 33.43K | ± 584.53 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 31.99K | ± 187.99 | ops/s | 1.1x slower |
| prometheusNoLabelsInc | 31.82K | ± 222.99 | ops/s | 1.1x slower |
| simpleclientInc | 7.55K | ± 72.33 | ops/s | 4.5x slower |
| simpleclientNoLabelsInc | 7.50K | ± 41.13 | ops/s | 4.5x slower |
| simpleclientAdd | 7.47K | ± 118.50 | ops/s | 4.5x slower |
| openTelemetryInc | 2.77K | ± 267.49 | ops/s | 12x slower |
| openTelemetryIncNoLabels | 2.72K | ± 56.35 | ops/s | 12x slower |
| openTelemetryAdd | 2.56K | ± 391.21 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 5.22K | ± 27.74 | ops/s | **fastest** |
| prometheusClassic | 2.67K | ± 438.38 | ops/s | 2.0x slower |
| prometheusNative | 2.03K | ± 309.47 | ops/s | 2.6x slower |
| openTelemetryClassic | 376.49 | ± 21.87 | ops/s | 14x slower |
| openTelemetryExponential | 322.46 | ± 3.72 | ops/s | 16x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.92K | ± 58.00 | ops/s | **fastest** |
| prometheusWriteToNull | 23.91K | ± 51.31 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 433.78K | ± 8.27K | ops/s | **fastest** |
| prometheusWriteToNull | 433.48K | ± 8.41K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 399.62K | ± 6.98K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 396.60K | ± 2.83K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      31985.728    ± 187.992  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2558.124    ± 391.215  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2772.855    ± 267.489  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2717.403     ± 56.349  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      33948.246    ± 782.535  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      33430.224    ± 584.532  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      31821.328    ± 222.991  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7472.379    ± 118.503  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7551.035     ± 72.334  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7504.834     ± 41.130  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        376.492     ± 21.866  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        322.465      ± 3.717  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2671.734    ± 438.383  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2033.545    ± 309.465  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5216.060     ± 27.737  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23923.159     ± 57.995  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23910.915     ± 51.309  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     396597.934   ± 2825.929  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     399618.273   ± 6982.747  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     433782.830   ± 8274.546  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     433475.741   ± 8409.381  ops/s
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

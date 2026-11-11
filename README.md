# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-11T10:23:32Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V45 96-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.44K | ± 1.69K | ops/s | **fastest** |
| prometheusNoLabelsInc | 65.80K | ± 1.57K | ops/s | 1.0x slower |
| codahaleIncNoLabels | 57.72K | ± 670.21 | ops/s | 1.2x slower |
| prometheusAdd | 53.27K | ± 1.39K | ops/s | 1.2x slower |
| simpleclientInc | 11.03K | ± 271.77 | ops/s | 6.0x slower |
| simpleclientAdd | 10.54K | ± 219.96 | ops/s | 6.3x slower |
| simpleclientNoLabelsInc | 10.47K | ± 211.68 | ops/s | 6.3x slower |
| openTelemetryAdd | 5.50K | ± 734.83 | ops/s | 12x slower |
| openTelemetryInc | 5.41K | ± 560.01 | ops/s | 12x slower |
| openTelemetryIncNoLabels | 5.13K | ± 88.85 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 8.74K | ± 1.87K | ops/s | **fastest** |
| simpleclient | 6.91K | ± 269.98 | ops/s | 1.3x slower |
| prometheusNative | 5.32K | ± 99.71 | ops/s | 1.6x slower |
| openTelemetryClassic | 917.47 | ± 18.53 | ops/s | 9.5x slower |
| openTelemetryExponential | 672.41 | ± 13.63 | ops/s | 13x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 32.75K | ± 825.17 | ops/s | **fastest** |
| openMetricsWriteToNull | 32.15K | ± 453.00 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 749.21K | ± 52.20K | ops/s | **fastest** |
| prometheusWriteToNull | 746.98K | ± 70.75K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 658.13K | ± 20.91K | ops/s | 1.1x slower |
| openMetricsWriteToNull | 656.96K | ± 13.65K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      57723.430    ± 670.215  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       5501.147    ± 734.832  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5409.750    ± 560.012  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5125.375     ± 88.849  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      53269.072   ± 1387.661  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66439.822   ± 1687.010  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      65803.319   ± 1568.357  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15      10544.647    ± 219.963  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15      11029.493    ± 271.767  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15      10474.652    ± 211.682  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        917.472     ± 18.534  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        672.406     ± 13.626  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       8736.899   ± 1870.260  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       5316.202     ± 99.710  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       6910.731    ± 269.980  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      32147.128    ± 452.997  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      32746.010    ± 825.170  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     658125.644  ± 20909.952  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     656961.733  ± 13648.770  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     749209.933  ± 52197.585  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     746984.381  ± 70749.918  ops/s
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

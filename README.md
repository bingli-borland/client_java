# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-06T06:40:16Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.76K | ± 139.70 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.88K | ± 436.76 | ops/s | 1.2x slower |
| prometheusAdd | 51.31K | ± 190.99 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.90K | ± 1.38K | ops/s | 1.3x slower |
| simpleclientInc | 6.57K | ± 26.92 | ops/s | 10x slower |
| simpleclientAdd | 6.46K | ± 29.35 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.34K | ± 18.30 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.41K | ± 236.26 | ops/s | 19x slower |
| openTelemetryInc | 3.19K | ± 182.52 | ops/s | 21x slower |
| openTelemetryAdd | 3.13K | ± 53.35 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.33K | ± 1.03K | ops/s | **fastest** |
| simpleclient | 4.39K | ± 23.66 | ops/s | 1.4x slower |
| prometheusNative | 2.89K | ± 321.88 | ops/s | 2.2x slower |
| openTelemetryClassic | 764.89 | ± 25.90 | ops/s | 8.3x slower |
| openTelemetryExponential | 631.04 | ± 55.80 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.43K | ± 175.72 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.29K | ± 548.53 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 505.36K | ± 6.19K | ops/s | **fastest** |
| prometheusWriteToByteArray | 496.63K | ± 6.03K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 473.61K | ± 11.23K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 469.85K | ± 4.52K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49900.034   ± 1380.622  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3129.037     ± 53.349  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3185.416    ± 182.520  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3408.746    ± 236.258  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51312.165    ± 190.987  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65762.730    ± 139.703  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56877.039    ± 436.765  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6459.158     ± 29.350  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6571.539     ± 26.924  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6343.585     ± 18.297  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        764.892     ± 25.902  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        631.038     ± 55.801  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6330.264   ± 1029.138  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2886.141    ± 321.879  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4392.734     ± 23.658  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23287.534    ± 548.527  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24432.252    ± 175.717  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     469852.999   ± 4515.240  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     473606.615  ± 11230.961  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     496627.830   ± 6034.061  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     505361.563   ± 6194.617  ops/s
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

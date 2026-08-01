# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-01T06:50:43Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 56.21K | ± 9.02K | ops/s | **fastest** |
| prometheusNoLabelsInc | 53.56K | ± 409.69 | ops/s | 1.0x slower |
| prometheusAdd | 47.91K | ± 849.64 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 45.05K | ± 822.00 | ops/s | 1.2x slower |
| simpleclientInc | 6.28K | ± 87.62 | ops/s | 9.0x slower |
| simpleclientAdd | 6.13K | ± 35.77 | ops/s | 9.2x slower |
| simpleclientNoLabelsInc | 6.00K | ± 31.78 | ops/s | 9.4x slower |
| openTelemetryInc | 3.04K | ± 299.36 | ops/s | 19x slower |
| openTelemetryAdd | 2.99K | ± 339.71 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 2.98K | ± 179.33 | ops/s | 19x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.68K | ± 464.80 | ops/s | **fastest** |
| simpleclient | 4.13K | ± 40.50 | ops/s | 1.1x slower |
| prometheusNative | 2.77K | ± 369.11 | ops/s | 1.7x slower |
| openTelemetryClassic | 711.12 | ± 33.05 | ops/s | 6.6x slower |
| openTelemetryExponential | 556.29 | ± 29.94 | ops/s | 8.4x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 21.92K | ± 399.75 | ops/s | **fastest** |
| openMetricsWriteToNull | 21.23K | ± 770.81 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 336.08K | ± 7.96K | ops/s | **fastest** |
| prometheusWriteToNull | 327.60K | ± 11.19K | ops/s | 1.0x slower |
| prometheusWriteToByteArray | 324.20K | ± 6.64K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 320.18K | ± 7.84K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      45051.927    ± 822.000  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2985.674    ± 339.709  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3036.877    ± 299.363  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2980.324    ± 179.329  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      47908.295    ± 849.639  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      56206.229   ± 9022.973  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      53556.558    ± 409.694  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6129.027     ± 35.770  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6277.319     ± 87.624  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5995.425     ± 31.780  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        711.123     ± 33.048  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        556.292     ± 29.937  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4677.441    ± 464.805  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2772.853    ± 369.113  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4128.981     ± 40.499  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      21226.232    ± 770.806  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      21921.988    ± 399.747  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     320182.856   ± 7840.786  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     336083.440   ± 7955.726  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     324197.970   ± 6641.830  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     327595.786  ± 11188.979  ops/s
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

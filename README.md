# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-06T10:24:55Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** INTEL(R) XEON(R) PLATINUM 8573C, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| codahaleIncNoLabels | 29.89K | ± 1.21K | ops/s | **fastest** |
| prometheusNoLabelsInc | 29.23K | ± 175.48 | ops/s | 1.0x slower |
| prometheusInc | 29.22K | ± 920.32 | ops/s | 1.0x slower |
| prometheusAdd | 28.78K | ± 160.97 | ops/s | 1.0x slower |
| simpleclientInc | 7.36K | ± 266.53 | ops/s | 4.1x slower |
| simpleclientNoLabelsInc | 7.31K | ± 130.41 | ops/s | 4.1x slower |
| simpleclientAdd | 7.04K | ± 143.69 | ops/s | 4.2x slower |
| openTelemetryIncNoLabels | 2.38K | ± 164.07 | ops/s | 13x slower |
| openTelemetryInc | 2.28K | ± 45.84 | ops/s | 13x slower |
| openTelemetryAdd | 2.08K | ± 85.69 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.87K | ± 38.08 | ops/s | **fastest** |
| prometheusClassic | 3.43K | ± 502.63 | ops/s | 1.4x slower |
| prometheusNative | 2.21K | ± 388.27 | ops/s | 2.2x slower |
| openTelemetryClassic | 538.99 | ± 11.86 | ops/s | 9.0x slower |
| openTelemetryExponential | 428.30 | ± 3.62 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 20.18K | ± 105.24 | ops/s | **fastest** |
| openMetricsWriteToNull | 20.16K | ± 136.33 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 324.11K | ± 2.34K | ops/s | **fastest** |
| prometheusWriteToByteArray | 320.84K | ± 7.57K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 299.19K | ± 4.38K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 294.26K | ± 2.47K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      29887.830   ± 1208.722  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2083.274     ± 85.693  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2279.070     ± 45.842  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2380.552    ± 164.068  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      28783.689    ± 160.971  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      29221.945    ± 920.318  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      29228.824    ± 175.481  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7040.474    ± 143.687  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7362.366    ± 266.533  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7305.325    ± 130.408  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        538.993     ± 11.856  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        428.304      ± 3.624  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       3433.064    ± 502.630  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2209.740    ± 388.269  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4874.259     ± 38.077  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      20159.864    ± 136.329  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      20180.874    ± 105.238  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     294255.580   ± 2469.429  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     299189.120   ± 4384.849  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     320839.189   ± 7567.992  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     324105.804   ± 2344.021  ops/s
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

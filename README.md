# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-03T08:17:36Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) Platinum 8370C CPU @ 2.80GHz, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1015-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 30.73K | ± 1.23K | ops/s | **fastest** |
| prometheusNoLabelsInc | 30.34K | ± 944.27 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 28.98K | ± 1.29K | ops/s | 1.1x slower |
| prometheusAdd | 28.47K | ± 116.32 | ops/s | 1.1x slower |
| simpleclientInc | 6.54K | ± 71.95 | ops/s | 4.7x slower |
| simpleclientAdd | 6.46K | ± 274.31 | ops/s | 4.8x slower |
| simpleclientNoLabelsInc | 6.44K | ± 246.32 | ops/s | 4.8x slower |
| openTelemetryIncNoLabels | 2.74K | ± 161.60 | ops/s | 11x slower |
| openTelemetryInc | 2.51K | ± 156.82 | ops/s | 12x slower |
| openTelemetryAdd | 2.27K | ± 440.24 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.46K | ± 129.83 | ops/s | **fastest** |
| prometheusClassic | 2.59K | ± 292.64 | ops/s | 1.7x slower |
| prometheusNative | 2.41K | ± 336.23 | ops/s | 1.9x slower |
| openTelemetryClassic | 640.10 | ± 19.21 | ops/s | 7.0x slower |
| openTelemetryExponential | 453.00 | ± 15.09 | ops/s | 9.9x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 18.30K | ± 122.77 | ops/s | **fastest** |
| openMetricsWriteToNull | 18.25K | ± 54.92 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 315.36K | ± 2.10K | ops/s | **fastest** |
| prometheusWriteToByteArray | 313.94K | ± 1.21K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 293.11K | ± 1.68K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 287.94K | ± 2.69K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      28977.297   ± 1294.321  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2268.221    ± 440.235  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2506.836    ± 156.820  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2740.997    ± 161.604  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      28474.447    ± 116.321  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      30734.978   ± 1225.906  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      30335.854    ± 944.266  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6458.526    ± 274.314  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6544.095     ± 71.951  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6438.251    ± 246.316  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        640.099     ± 19.207  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        452.999     ± 15.090  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2594.502    ± 292.640  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2406.853    ± 336.235  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4462.052    ± 129.830  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      18252.572     ± 54.921  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      18299.004    ± 122.768  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     287938.688   ± 2687.778  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     293110.885   ± 1676.539  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     313943.537   ± 1205.499  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     315360.003   ± 2096.213  ops/s
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

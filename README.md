# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-08T08:09:35Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) Platinum 8370C CPU @ 2.80GHz, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1015-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 31.57K | ± 45.32 | ops/s | **fastest** |
| prometheusNoLabelsInc | 31.21K | ± 234.66 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 28.81K | ± 944.31 | ops/s | 1.1x slower |
| prometheusAdd | 28.43K | ± 48.91 | ops/s | 1.1x slower |
| simpleclientInc | 6.79K | ± 180.46 | ops/s | 4.6x slower |
| simpleclientNoLabelsInc | 6.64K | ± 27.95 | ops/s | 4.8x slower |
| simpleclientAdd | 6.38K | ± 145.64 | ops/s | 4.9x slower |
| openTelemetryIncNoLabels | 2.71K | ± 170.96 | ops/s | 12x slower |
| openTelemetryInc | 2.60K | ± 56.46 | ops/s | 12x slower |
| openTelemetryAdd | 2.20K | ± 63.31 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.47K | ± 37.27 | ops/s | **fastest** |
| prometheusClassic | 2.80K | ± 271.78 | ops/s | 1.6x slower |
| prometheusNative | 2.39K | ± 381.99 | ops/s | 1.9x slower |
| openTelemetryClassic | 636.01 | ± 38.22 | ops/s | 7.0x slower |
| openTelemetryExponential | 432.07 | ± 17.67 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 18.28K | ± 56.27 | ops/s | **fastest** |
| prometheusWriteToNull | 18.25K | ± 81.25 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 319.93K | ± 1.37K | ops/s | **fastest** |
| prometheusWriteToByteArray | 317.09K | ± 2.09K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 296.52K | ± 916.08 | ops/s | 1.1x slower |
| openMetricsWriteToNull | 296.35K | ± 2.12K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      28807.848    ± 944.313  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2200.100     ± 63.309  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2599.555     ± 56.456  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2706.817    ± 170.961  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      28425.997     ± 48.912  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      31567.709     ± 45.317  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      31214.049    ± 234.658  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6380.161    ± 145.640  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6792.274    ± 180.465  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6636.430     ± 27.953  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        636.008     ± 38.216  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        432.072     ± 17.672  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2803.926    ± 271.781  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2390.590    ± 381.986  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4474.862     ± 37.268  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      18278.071     ± 56.267  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      18253.152     ± 81.255  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     296523.845    ± 916.077  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     296346.425   ± 2116.009  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     317085.457   ± 2086.241  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     319925.990   ± 1366.226  ops/s
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

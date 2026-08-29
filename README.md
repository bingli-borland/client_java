# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-29T10:08:30Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) Platinum 8370C CPU @ 2.80GHz, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 31.54K | ± 25.31 | ops/s | **fastest** |
| prometheusNoLabelsInc | 31.26K | ± 414.92 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 30.29K | ± 644.68 | ops/s | 1.0x slower |
| prometheusAdd | 28.51K | ± 109.42 | ops/s | 1.1x slower |
| simpleclientInc | 6.94K | ± 58.48 | ops/s | 4.5x slower |
| simpleclientAdd | 6.71K | ± 68.64 | ops/s | 4.7x slower |
| simpleclientNoLabelsInc | 6.59K | ± 21.75 | ops/s | 4.8x slower |
| openTelemetryIncNoLabels | 2.74K | ± 269.15 | ops/s | 11x slower |
| openTelemetryInc | 2.63K | ± 84.35 | ops/s | 12x slower |
| openTelemetryAdd | 2.20K | ± 31.98 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.36K | ± 170.23 | ops/s | **fastest** |
| prometheusClassic | 2.97K | ± 311.60 | ops/s | 1.5x slower |
| prometheusNative | 2.12K | ± 264.77 | ops/s | 2.1x slower |
| openTelemetryClassic | 611.30 | ± 19.39 | ops/s | 7.1x slower |
| openTelemetryExponential | 431.69 | ± 17.81 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 18.24K | ± 108.47 | ops/s | **fastest** |
| openMetricsWriteToNull | 18.21K | ± 78.87 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 318.81K | ± 2.85K | ops/s | **fastest** |
| prometheusWriteToByteArray | 316.63K | ± 2.32K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 296.23K | ± 2.62K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 293.88K | ± 1.79K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      30287.094    ± 644.681  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2200.126     ± 31.985  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2628.276     ± 84.350  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2743.027    ± 269.153  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      28507.413    ± 109.416  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      31537.373     ± 25.307  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      31259.717    ± 414.915  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6708.728     ± 68.639  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6941.812     ± 58.479  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6587.950     ± 21.750  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        611.299     ± 19.385  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        431.689     ± 17.808  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2970.338    ± 311.597  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2120.549    ± 264.770  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4357.178    ± 170.232  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      18211.864     ± 78.869  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      18235.781    ± 108.472  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     293877.821   ± 1787.957  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     296225.079   ± 2623.915  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     316634.425   ± 2322.262  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     318809.878   ± 2849.643  ops/s
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

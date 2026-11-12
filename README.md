# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-12T10:51:42Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** INTEL(R) XEON(R) PLATINUM 8573C, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| codahaleIncNoLabels | 27.47K | ± 33.73 | ops/s | **fastest** |
| prometheusNoLabelsInc | 26.68K | ± 64.56 | ops/s | 1.0x slower |
| prometheusInc | 26.47K | ± 41.38 | ops/s | 1.0x slower |
| prometheusAdd | 25.84K | ± 108.69 | ops/s | 1.1x slower |
| simpleclientInc | 6.61K | ± 20.34 | ops/s | 4.2x slower |
| simpleclientNoLabelsInc | 6.50K | ± 94.37 | ops/s | 4.2x slower |
| simpleclientAdd | 6.32K | ± 69.36 | ops/s | 4.3x slower |
| openTelemetryInc | 2.73K | ± 178.37 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 2.59K | ± 252.42 | ops/s | 11x slower |
| openTelemetryAdd | 2.32K | ± 350.18 | ops/s | 12x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.21K | ± 61.10 | ops/s | **fastest** |
| prometheusClassic | 3.00K | ± 509.02 | ops/s | 1.4x slower |
| prometheusNative | 1.94K | ± 209.15 | ops/s | 2.2x slower |
| openTelemetryClassic | 504.03 | ± 30.69 | ops/s | 8.4x slower |
| openTelemetryExponential | 391.14 | ± 18.18 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 17.86K | ± 84.11 | ops/s | **fastest** |
| openMetricsWriteToNull | 17.79K | ± 83.28 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 300.02K | ± 1.73K | ops/s | **fastest** |
| prometheusWriteToByteArray | 296.01K | ± 2.99K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 280.74K | ± 1.58K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 279.16K | ± 1.83K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      27469.136     ± 33.730  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2321.794    ± 350.184  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2729.752    ± 178.372  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2589.180    ± 252.424  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      25840.066    ± 108.695  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      26470.365     ± 41.380  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      26683.615     ± 64.562  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6315.313     ± 69.357  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6611.147     ± 20.343  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6504.530     ± 94.374  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        504.032     ± 30.689  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        391.135     ± 18.177  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       3000.681    ± 509.024  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       1937.425    ± 209.145  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4211.186     ± 61.101  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      17792.192     ± 83.279  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      17858.838     ± 84.106  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     279157.516   ± 1832.724  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     280737.316   ± 1578.012  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     296006.465   ± 2989.231  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     300018.090   ± 1734.646  ops/s
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

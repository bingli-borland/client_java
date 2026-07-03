# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-03T07:17:30Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) Platinum 8370C CPU @ 2.80GHz, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusNoLabelsInc | 30.19K | ± 1.01K | ops/s | **fastest** |
| codahaleIncNoLabels | 29.75K | ± 852.99 | ops/s | 1.0x slower |
| prometheusInc | 29.27K | ± 1.22K | ops/s | 1.0x slower |
| prometheusAdd | 28.64K | ± 199.77 | ops/s | 1.1x slower |
| simpleclientInc | 6.71K | ± 273.74 | ops/s | 4.5x slower |
| simpleclientNoLabelsInc | 6.60K | ± 12.92 | ops/s | 4.6x slower |
| simpleclientAdd | 6.38K | ± 90.31 | ops/s | 4.7x slower |
| openTelemetryIncNoLabels | 2.67K | ± 489.50 | ops/s | 11x slower |
| openTelemetryInc | 2.49K | ± 132.95 | ops/s | 12x slower |
| openTelemetryAdd | 2.40K | ± 228.46 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.42K | ± 129.16 | ops/s | **fastest** |
| prometheusClassic | 3.20K | ± 167.17 | ops/s | 1.4x slower |
| prometheusNative | 1.99K | ± 71.62 | ops/s | 2.2x slower |
| openTelemetryClassic | 620.82 | ± 71.03 | ops/s | 7.1x slower |
| openTelemetryExponential | 494.17 | ± 57.45 | ops/s | 8.9x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 17.94K | ± 78.93 | ops/s | **fastest** |
| openMetricsWriteToNull | 17.87K | ± 84.49 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 264.18K | ± 1.64K | ops/s | **fastest** |
| prometheusWriteToByteArray | 261.35K | ± 1.79K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 246.88K | ± 932.76 | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 244.78K | ± 912.14 | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      29752.243    ± 852.988  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2397.499    ± 228.465  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2491.418    ± 132.952  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2666.891    ± 489.504  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      28643.134    ± 199.771  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      29265.706   ± 1216.367  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      30192.195   ± 1008.394  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6375.420     ± 90.306  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6705.793    ± 273.739  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6602.488     ± 12.923  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        620.823     ± 71.026  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        494.172     ± 57.455  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       3195.498    ± 167.171  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       1989.326     ± 71.616  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4418.477    ± 129.161  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      17869.525     ± 84.492  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      17937.400     ± 78.930  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     244779.683    ± 912.135  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     246875.158    ± 932.756  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     261352.546   ± 1787.126  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     264183.554   ± 1643.165  ops/s
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

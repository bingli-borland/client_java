# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-22T08:51:19Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.01K | ± 397.40 | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.76K | ± 2.24K | ops/s | 1.2x slower |
| prometheusAdd | 51.49K | ± 195.02 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.62K | ± 1.21K | ops/s | 1.4x slower |
| simpleclientInc | 6.55K | ± 46.89 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.45K | ± 140.16 | ops/s | 10x slower |
| simpleclientAdd | 6.28K | ± 146.93 | ops/s | 11x slower |
| openTelemetryInc | 3.57K | ± 479.01 | ops/s | 19x slower |
| openTelemetryAdd | 3.42K | ± 407.02 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 3.08K | ± 204.86 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.95K | ± 2.27K | ops/s | **fastest** |
| simpleclient | 4.40K | ± 56.43 | ops/s | 1.6x slower |
| prometheusNative | 2.75K | ± 348.44 | ops/s | 2.5x slower |
| openTelemetryClassic | 761.04 | ± 14.68 | ops/s | 9.1x slower |
| openTelemetryExponential | 684.86 | ± 113.61 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.53K | ± 183.66 | ops/s | **fastest** |
| prometheusWriteToNull | 23.41K | ± 1.03K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 493.39K | ± 4.60K | ops/s | **fastest** |
| prometheusWriteToNull | 492.92K | ± 5.98K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 479.34K | ± 5.75K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 463.21K | ± 10.66K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48617.038   ± 1210.645  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3417.964    ± 407.017  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3567.147    ± 479.006  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3076.435    ± 204.856  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51489.512    ± 195.016  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66014.431    ± 397.401  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55757.306   ± 2239.080  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6283.730    ± 146.929  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6550.855     ± 46.886  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6453.528    ± 140.161  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        761.041     ± 14.678  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        684.855    ± 113.612  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6950.398   ± 2274.079  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2747.474    ± 348.441  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4398.346     ± 56.428  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23531.113    ± 183.663  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23409.475   ± 1026.733  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     463212.415  ± 10659.011  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     479343.126   ± 5753.367  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     493385.716   ± 4604.718  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     492919.099   ± 5984.950  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-17T08:05:11Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.26K | ± 741.17 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.46K | ± 536.80 | ops/s | 1.2x slower |
| prometheusAdd | 51.07K | ± 511.89 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.01K | ± 944.15 | ops/s | 1.4x slower |
| simpleclientInc | 6.59K | ± 17.93 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.34K | ± 8.37 | ops/s | 10x slower |
| simpleclientAdd | 6.04K | ± 89.98 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 3.95K | ± 495.02 | ops/s | 17x slower |
| openTelemetryInc | 3.80K | ± 540.68 | ops/s | 17x slower |
| openTelemetryAdd | 3.13K | ± 348.73 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.17K | ± 396.83 | ops/s | **fastest** |
| simpleclient | 4.42K | ± 82.14 | ops/s | 1.2x slower |
| prometheusNative | 2.82K | ± 233.79 | ops/s | 1.8x slower |
| openTelemetryClassic | 743.24 | ± 60.77 | ops/s | 7.0x slower |
| openTelemetryExponential | 635.49 | ± 96.53 | ops/s | 8.1x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.50K | ± 956.40 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.29K | ± 1.29K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 492.49K | ± 6.43K | ops/s | **fastest** |
| prometheusWriteToByteArray | 490.64K | ± 2.27K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 479.47K | ± 8.12K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 471.39K | ± 9.23K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49011.512    ± 944.150  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3129.401    ± 348.726  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3795.075    ± 540.685  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3946.052    ± 495.021  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51072.908    ± 511.887  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66258.103    ± 741.168  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56462.187    ± 536.795  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6038.910     ± 89.981  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6585.435     ± 17.935  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6337.628      ± 8.373  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        743.242     ± 60.774  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        635.485     ± 96.532  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5171.910    ± 396.827  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2824.387    ± 233.790  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4418.508     ± 82.141  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23286.064   ± 1289.302  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23502.781    ± 956.395  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     471394.865   ± 9234.581  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     479472.476   ± 8115.854  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     490643.994   ± 2274.856  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     492486.627   ± 6425.556  ops/s
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

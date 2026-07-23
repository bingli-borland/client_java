# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-23T06:49:24Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.45K | ± 967.53 | ops/s | **fastest** |
| prometheusNoLabelsInc | 57.01K | ± 407.83 | ops/s | 1.1x slower |
| prometheusAdd | 50.58K | ± 1.31K | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.27K | ± 1.96K | ops/s | 1.3x slower |
| simpleclientInc | 6.56K | ± 40.10 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 6.38K | ± 23.05 | ops/s | 10x slower |
| simpleclientAdd | 6.27K | ± 274.79 | ops/s | 10x slower |
| openTelemetryAdd | 3.37K | ± 361.67 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 3.22K | ± 177.03 | ops/s | 20x slower |
| openTelemetryInc | 3.13K | ± 193.26 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.18K | ± 565.17 | ops/s | **fastest** |
| simpleclient | 4.41K | ± 20.61 | ops/s | 1.2x slower |
| prometheusNative | 2.85K | ± 370.77 | ops/s | 1.8x slower |
| openTelemetryClassic | 807.71 | ± 39.81 | ops/s | 6.4x slower |
| openTelemetryExponential | 682.95 | ± 82.62 | ops/s | 7.6x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.59K | ± 216.29 | ops/s | **fastest** |
| openMetricsWriteToNull | 22.10K | ± 422.05 | ops/s | 1.1x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 495.21K | ± 6.30K | ops/s | **fastest** |
| prometheusWriteToByteArray | 493.20K | ± 6.28K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 477.55K | ± 6.29K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 470.91K | ± 7.22K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48270.875   ± 1961.101  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3374.377    ± 361.665  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3130.439    ± 193.265  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3219.691    ± 177.027  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50584.881   ± 1308.335  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64451.838    ± 967.534  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      57011.202    ± 407.829  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6271.461    ± 274.793  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6560.367     ± 40.099  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6380.191     ± 23.055  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        807.709     ± 39.814  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        682.947     ± 82.616  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5177.688    ± 565.172  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2853.018    ± 370.765  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4407.785     ± 20.613  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      22103.380    ± 422.046  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23594.882    ± 216.291  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     470913.195   ± 7222.073  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     477550.323   ± 6292.138  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     493203.930   ± 6275.382  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     495213.304   ± 6295.547  ops/s
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

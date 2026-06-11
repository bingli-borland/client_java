# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-11T08:14:14Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1015-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.15K | ± 572.41 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.48K | ± 418.17 | ops/s | 1.1x slower |
| prometheusAdd | 48.52K | ± 973.24 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.05K | ± 1.08K | ops/s | 1.4x slower |
| simpleclientInc | 6.15K | ± 58.95 | ops/s | 9.6x slower |
| simpleclientNoLabelsInc | 5.90K | ± 10.70 | ops/s | 10x slower |
| simpleclientAdd | 5.69K | ± 344.73 | ops/s | 10x slower |
| openTelemetryInc | 5.31K | ± 1.18K | ops/s | 11x slower |
| openTelemetryIncNoLabels | 5.28K | ± 1.15K | ops/s | 11x slower |
| openTelemetryAdd | 4.22K | ± 1.19K | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.51K | ± 1.53K | ops/s | **fastest** |
| simpleclient | 4.34K | ± 48.44 | ops/s | 1.3x slower |
| prometheusNative | 3.03K | ± 186.07 | ops/s | 1.8x slower |
| openTelemetryClassic | 712.86 | ± 15.30 | ops/s | 7.7x slower |
| openTelemetryExponential | 545.43 | ± 7.40 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.59K | ± 201.34 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.39K | ± 235.16 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 587.91K | ± 6.93K | ops/s | **fastest** |
| prometheusWriteToByteArray | 570.70K | ± 3.87K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 544.11K | ± 5.21K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 538.16K | ± 5.14K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43047.304   ± 1081.302  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4219.008   ± 1185.644  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5310.667   ± 1184.494  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5275.557   ± 1152.777  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48515.091    ± 973.245  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59146.279    ± 572.408  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51476.454    ± 418.171  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5685.486    ± 344.733  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6154.304     ± 58.947  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5904.546     ± 10.700  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        712.864     ± 15.300  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        545.434      ± 7.403  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5510.663   ± 1530.570  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3027.986    ± 186.070  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4336.016     ± 48.443  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27393.465    ± 235.163  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27594.869    ± 201.342  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     538155.888   ± 5135.963  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     544105.779   ± 5205.171  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     570702.817   ± 3870.577  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     587913.051   ± 6925.419  ops/s
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

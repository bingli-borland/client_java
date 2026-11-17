# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-17T11:44:40Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 72.40K | ± 8.10K | ops/s | **fastest** |
| prometheusNoLabelsInc | 65.83K | ± 635.51 | ops/s | 1.1x slower |
| prometheusAdd | 62.94K | ± 1.02K | ops/s | 1.2x slower |
| codahaleIncNoLabels | 57.59K | ± 598.72 | ops/s | 1.3x slower |
| simpleclientInc | 7.80K | ± 67.39 | ops/s | 9.3x slower |
| simpleclientAdd | 7.71K | ± 94.59 | ops/s | 9.4x slower |
| simpleclientNoLabelsInc | 7.66K | ± 269.00 | ops/s | 9.4x slower |
| openTelemetryIncNoLabels | 7.17K | ± 1.52K | ops/s | 10x slower |
| openTelemetryInc | 6.02K | ± 1.28K | ops/s | 12x slower |
| openTelemetryAdd | 4.48K | ± 222.54 | ops/s | 16x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 8.63K | ± 2.50K | ops/s | **fastest** |
| simpleclient | 5.39K | ± 91.29 | ops/s | 1.6x slower |
| prometheusNative | 3.69K | ± 247.27 | ops/s | 2.3x slower |
| openTelemetryClassic | 942.05 | ± 32.71 | ops/s | 9.2x slower |
| openTelemetryExponential | 740.60 | ± 52.28 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 35.00K | ± 468.79 | ops/s | **fastest** |
| openMetricsWriteToNull | 34.44K | ± 197.46 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 684.43K | ± 5.46K | ops/s | **fastest** |
| prometheusWriteToByteArray | 668.41K | ± 9.69K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 643.47K | ± 10.33K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 627.01K | ± 10.06K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      57589.216    ± 598.725  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4476.844    ± 222.537  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       6023.440   ± 1276.797  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       7169.574   ± 1515.257  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      62936.096   ± 1016.928  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      72398.865   ± 8103.333  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      65828.960    ± 635.512  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7706.776     ± 94.593  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7802.492     ± 67.389  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7661.269    ± 268.997  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        942.048     ± 32.712  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        740.598     ± 52.281  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       8628.377   ± 2498.727  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3686.679    ± 247.268  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5385.515     ± 91.291  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      34438.651    ± 197.457  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      35002.563    ± 468.792  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     627013.143  ± 10064.614  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     643474.432  ± 10325.065  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     668411.417   ± 9694.583  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     684430.807   ± 5464.355  ops/s
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

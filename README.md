# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-25T08:45:48Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.51K | ± 1.00K | ops/s | **fastest** |
| prometheusNoLabelsInc | 54.46K | ± 2.04K | ops/s | 1.2x slower |
| prometheusAdd | 51.53K | ± 169.34 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.69K | ± 1.15K | ops/s | 1.3x slower |
| simpleclientInc | 6.54K | ± 35.35 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.46K | ± 102.91 | ops/s | 10x slower |
| simpleclientAdd | 6.44K | ± 47.89 | ops/s | 10x slower |
| openTelemetryAdd | 3.68K | ± 287.31 | ops/s | 18x slower |
| openTelemetryIncNoLabels | 3.40K | ± 182.90 | ops/s | 19x slower |
| openTelemetryInc | 3.14K | ± 129.09 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.70K | ± 1.10K | ops/s | **fastest** |
| simpleclient | 4.36K | ± 105.24 | ops/s | 1.5x slower |
| prometheusNative | 2.87K | ± 67.37 | ops/s | 2.3x slower |
| openTelemetryClassic | 798.59 | ± 33.16 | ops/s | 8.4x slower |
| openTelemetryExponential | 635.67 | ± 72.72 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.77K | ± 436.19 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.67K | ± 618.22 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 504.91K | ± 8.10K | ops/s | **fastest** |
| prometheusWriteToByteArray | 495.18K | ± 4.49K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 484.78K | ± 5.75K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 477.64K | ± 9.70K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48689.440   ± 1145.547  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3683.761    ± 287.314  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3139.506    ± 129.089  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3399.371    ± 182.902  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51528.872    ± 169.336  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65514.757   ± 1001.367  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      54461.493   ± 2038.918  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6439.209     ± 47.888  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6542.191     ± 35.347  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6457.000    ± 102.908  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        798.593     ± 33.162  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        635.667     ± 72.723  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6697.545   ± 1102.024  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2870.407     ± 67.374  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4364.792    ± 105.244  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23667.298    ± 618.223  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23773.787    ± 436.188  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     477639.981   ± 9701.929  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     484777.037   ± 5752.759  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     495177.249   ± 4493.997  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     504913.980   ± 8098.033  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-06T07:17:06Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1015-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.69K | ± 1.10K | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.75K | ± 635.70 | ops/s | 1.2x slower |
| prometheusAdd | 51.38K | ± 195.19 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 50.00K | ± 420.04 | ops/s | 1.3x slower |
| simpleclientInc | 6.56K | ± 39.73 | ops/s | 9.9x slower |
| simpleclientAdd | 6.45K | ± 9.25 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.44K | ± 129.07 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.59K | ± 698.05 | ops/s | 18x slower |
| openTelemetryInc | 3.25K | ± 78.81 | ops/s | 20x slower |
| openTelemetryAdd | 3.22K | ± 258.00 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.90K | ± 1.19K | ops/s | **fastest** |
| simpleclient | 4.44K | ± 64.77 | ops/s | 1.3x slower |
| prometheusNative | 3.15K | ± 71.09 | ops/s | 1.9x slower |
| openTelemetryClassic | 831.39 | ± 44.82 | ops/s | 7.1x slower |
| openTelemetryExponential | 648.47 | ± 65.25 | ops/s | 9.1x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 24.18K | ± 270.44 | ops/s | **fastest** |
| prometheusWriteToNull | 23.81K | ± 522.99 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 513.28K | ± 3.64K | ops/s | **fastest** |
| prometheusWriteToByteArray | 510.30K | ± 6.00K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 494.35K | ± 3.71K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 480.61K | ± 6.92K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49999.074    ± 420.040  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3220.807    ± 257.999  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3251.077     ± 78.810  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3585.663    ± 698.049  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51377.814    ± 195.187  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64689.786   ± 1096.717  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55754.161    ± 635.702  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6448.378      ± 9.254  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6560.236     ± 39.727  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6442.900    ± 129.070  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        831.386     ± 44.823  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        648.472     ± 65.254  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5902.017   ± 1188.767  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3148.503     ± 71.091  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4438.335     ± 64.772  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      24182.283    ± 270.439  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23808.224    ± 522.993  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     480607.510   ± 6916.651  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     494349.642   ± 3711.331  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     510303.344   ± 6004.647  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     513280.940   ± 3643.005  ops/s
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

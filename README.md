# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-18T08:33:40Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 75.09K | ± 2.33K | ops/s | **fastest** |
| prometheusNoLabelsInc | 66.40K | ± 1.07K | ops/s | 1.1x slower |
| prometheusAdd | 61.78K | ± 84.98 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 46.83K | ± 15.37K | ops/s | 1.6x slower |
| simpleclientInc | 7.95K | ± 79.31 | ops/s | 9.4x slower |
| simpleclientNoLabelsInc | 7.60K | ± 13.13 | ops/s | 9.9x slower |
| simpleclientAdd | 7.38K | ± 330.42 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 6.69K | ± 936.93 | ops/s | 11x slower |
| openTelemetryInc | 6.12K | ± 1.40K | ops/s | 12x slower |
| openTelemetryAdd | 4.91K | ± 1.13K | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.67K | ± 2.52K | ops/s | **fastest** |
| simpleclient | 5.35K | ± 29.68 | ops/s | 1.4x slower |
| prometheusNative | 4.12K | ± 55.22 | ops/s | 1.9x slower |
| openTelemetryClassic | 896.93 | ± 27.71 | ops/s | 8.6x slower |
| openTelemetryExponential | 703.65 | ± 40.00 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 35.23K | ± 216.84 | ops/s | **fastest** |
| openMetricsWriteToNull | 34.92K | ± 427.60 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 707.06K | ± 4.60K | ops/s | **fastest** |
| prometheusWriteToByteArray | 687.20K | ± 6.29K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 659.24K | ± 2.70K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 643.24K | ± 5.72K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      46826.512  ± 15370.361  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4910.414   ± 1127.005  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       6115.404   ± 1400.599  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       6693.688    ± 936.929  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      61783.177     ± 84.976  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      75088.288   ± 2331.908  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      66401.355   ± 1074.861  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7378.763    ± 330.424  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7950.144     ± 79.309  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7599.680     ± 13.129  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        896.935     ± 27.709  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        703.652     ± 40.001  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7671.033   ± 2519.726  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       4121.894     ± 55.221  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5345.568     ± 29.675  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      34916.817    ± 427.600  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      35233.060    ± 216.842  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     643236.300   ± 5720.220  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     659242.168   ± 2702.473  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     687203.360   ± 6287.678  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     707059.735   ± 4596.014  ops/s
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

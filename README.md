# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-28T09:47:56Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.30K | ± 419.34 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.86K | ± 830.36 | ops/s | 1.1x slower |
| prometheusAdd | 47.92K | ± 417.34 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 42.60K | ± 1.20K | ops/s | 1.4x slower |
| openTelemetryInc | 6.26K | ± 245.58 | ops/s | 9.5x slower |
| simpleclientInc | 6.15K | ± 42.32 | ops/s | 9.6x slower |
| simpleclientNoLabelsInc | 5.93K | ± 17.55 | ops/s | 10x slower |
| simpleclientAdd | 5.86K | ± 248.71 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 5.57K | ± 955.41 | ops/s | 11x slower |
| openTelemetryAdd | 4.57K | ± 798.60 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.15K | ± 448.17 | ops/s | **fastest** |
| simpleclient | 4.55K | ± 97.28 | ops/s | 1.6x slower |
| prometheusNative | 3.07K | ± 80.07 | ops/s | 2.3x slower |
| openTelemetryClassic | 713.42 | ± 17.98 | ops/s | 10x slower |
| openTelemetryExponential | 583.83 | ± 9.43 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.58K | ± 184.89 | ops/s | **fastest** |
| openMetricsWriteToNull | 26.98K | ± 455.58 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 578.88K | ± 5.36K | ops/s | **fastest** |
| prometheusWriteToByteArray | 556.25K | ± 11.55K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 542.87K | ± 4.96K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 532.14K | ± 3.05K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      42598.155   ± 1197.857  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4569.313    ± 798.603  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       6261.475    ± 245.579  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5567.213    ± 955.413  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      47921.263    ± 417.338  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59302.437    ± 419.342  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51858.908    ± 830.360  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5857.018    ± 248.711  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6149.855     ± 42.317  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5925.598     ± 17.546  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        713.418     ± 17.979  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        583.827      ± 9.427  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7147.137    ± 448.173  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3074.602     ± 80.072  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4547.323     ± 97.281  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      26977.639    ± 455.576  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27584.536    ± 184.891  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     532143.574   ± 3047.390  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     542872.630   ± 4957.831  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     556254.417  ± 11553.410  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     578883.725   ± 5363.208  ops/s
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

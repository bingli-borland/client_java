# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-07T07:32:42Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 60.04K | ± 940.22 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.21K | ± 535.89 | ops/s | 1.2x slower |
| prometheusAdd | 49.14K | ± 1.01K | ops/s | 1.2x slower |
| codahaleIncNoLabels | 39.81K | ± 5.58K | ops/s | 1.5x slower |
| simpleclientInc | 6.16K | ± 58.17 | ops/s | 9.7x slower |
| simpleclientNoLabelsInc | 6.04K | ± 200.01 | ops/s | 9.9x slower |
| openTelemetryIncNoLabels | 5.98K | ± 1.79K | ops/s | 10x slower |
| simpleclientAdd | 5.91K | ± 131.91 | ops/s | 10x slower |
| openTelemetryInc | 4.75K | ± 1.22K | ops/s | 13x slower |
| openTelemetryAdd | 4.54K | ± 895.69 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.49K | ± 1.89K | ops/s | **fastest** |
| simpleclient | 4.49K | ± 24.17 | ops/s | 1.4x slower |
| prometheusNative | 3.16K | ± 165.39 | ops/s | 2.1x slower |
| openTelemetryClassic | 729.94 | ± 15.12 | ops/s | 8.9x slower |
| openTelemetryExponential | 567.77 | ± 21.54 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.57K | ± 168.84 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.53K | ± 134.42 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 567.05K | ± 3.18K | ops/s | **fastest** |
| prometheusWriteToByteArray | 558.13K | ± 3.30K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 532.28K | ± 3.22K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 519.29K | ± 4.95K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      39814.588   ± 5577.575  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4537.880    ± 895.693  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4748.416   ± 1222.876  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5977.169   ± 1792.691  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      49138.697   ± 1009.406  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      60043.962    ± 940.216  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51209.332    ± 535.891  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5906.906    ± 131.906  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6163.148     ± 58.170  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6042.288    ± 200.010  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        729.939     ± 15.116  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        567.767     ± 21.544  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6494.549   ± 1891.859  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3155.766    ± 165.388  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4492.260     ± 24.174  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27529.534    ± 134.424  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27566.067    ± 168.835  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     519290.317   ± 4950.866  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     532277.135   ± 3218.174  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     558125.254   ± 3299.325  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     567049.035   ± 3183.523  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-20T07:54:00Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.69K | ± 807.19 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.53K | ± 379.24 | ops/s | 1.2x slower |
| prometheusAdd | 51.41K | ± 185.75 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.71K | ± 670.58 | ops/s | 1.3x slower |
| simpleclientInc | 6.61K | ± 70.92 | ops/s | 9.9x slower |
| simpleclientAdd | 6.46K | ± 9.08 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.36K | ± 31.95 | ops/s | 10x slower |
| openTelemetryAdd | 3.42K | ± 463.28 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 3.29K | ± 569.71 | ops/s | 20x slower |
| openTelemetryInc | 3.17K | ± 248.04 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.84K | ± 1.04K | ops/s | **fastest** |
| simpleclient | 4.45K | ± 61.55 | ops/s | 1.1x slower |
| prometheusNative | 2.83K | ± 212.34 | ops/s | 1.7x slower |
| openTelemetryClassic | 759.37 | ± 19.88 | ops/s | 6.4x slower |
| openTelemetryExponential | 623.90 | ± 74.50 | ops/s | 7.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.84K | ± 701.16 | ops/s | **fastest** |
| prometheusWriteToNull | 23.75K | ± 537.59 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 500.25K | ± 7.05K | ops/s | **fastest** |
| prometheusWriteToNull | 498.76K | ± 6.65K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 485.24K | ± 5.47K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 479.20K | ± 3.18K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49708.829    ± 670.579  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3421.885    ± 463.280  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3169.254    ± 248.036  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3290.658    ± 569.705  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51411.195    ± 185.747  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65685.386    ± 807.190  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56525.041    ± 379.244  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6461.521      ± 9.082  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6609.832     ± 70.919  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6361.152     ± 31.947  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        759.369     ± 19.882  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        623.897     ± 74.497  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4844.557   ± 1042.207  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2829.110    ± 212.338  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4446.244     ± 61.548  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23837.703    ± 701.158  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23753.386    ± 537.591  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     479197.946   ± 3184.809  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     485238.688   ± 5472.641  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     500248.254   ± 7053.700  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     498764.315   ± 6652.614  ops/s
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

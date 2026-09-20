# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-20T08:55:51Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.89K | ± 1.09K | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.85K | ± 746.81 | ops/s | 1.2x slower |
| prometheusAdd | 50.48K | ± 587.36 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 50.11K | ± 92.60 | ops/s | 1.3x slower |
| simpleclientInc | 6.56K | ± 43.20 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 6.39K | ± 164.52 | ops/s | 10x slower |
| simpleclientAdd | 6.24K | ± 343.36 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.49K | ± 216.21 | ops/s | 19x slower |
| openTelemetryInc | 3.41K | ± 393.79 | ops/s | 19x slower |
| openTelemetryAdd | 3.32K | ± 399.80 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.07K | ± 1.67K | ops/s | **fastest** |
| simpleclient | 4.40K | ± 45.66 | ops/s | 1.2x slower |
| prometheusNative | 2.98K | ± 249.17 | ops/s | 1.7x slower |
| openTelemetryClassic | 766.12 | ± 41.31 | ops/s | 6.6x slower |
| openTelemetryExponential | 589.59 | ± 53.19 | ops/s | 8.6x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.58K | ± 938.85 | ops/s | **fastest** |
| prometheusWriteToNull | 22.98K | ± 529.66 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 511.12K | ± 4.32K | ops/s | **fastest** |
| prometheusWriteToByteArray | 500.63K | ± 3.54K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 484.69K | ± 2.38K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 482.11K | ± 3.47K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      50109.553     ± 92.596  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3322.318    ± 399.803  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3408.910    ± 393.789  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3486.891    ± 216.207  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50479.470    ± 587.363  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64885.085   ± 1089.534  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55848.478    ± 746.810  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6236.298    ± 343.360  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6555.492     ± 43.204  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6392.052    ± 164.517  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        766.117     ± 41.306  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        589.592     ± 53.195  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5067.535   ± 1672.997  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2979.609    ± 249.175  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4399.632     ± 45.658  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23580.743    ± 938.853  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      22976.082    ± 529.657  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     482111.690   ± 3473.393  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     484693.894   ± 2380.484  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     500627.359   ± 3536.843  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     511117.998   ± 4319.162  ops/s
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

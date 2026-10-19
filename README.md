# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-19T08:51:08Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.08K | ± 1.31K | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.81K | ± 1.02K | ops/s | 1.2x slower |
| prometheusAdd | 51.44K | ± 89.60 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.79K | ± 542.84 | ops/s | 1.3x slower |
| simpleclientInc | 6.55K | ± 43.39 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 6.35K | ± 37.23 | ops/s | 10x slower |
| simpleclientAdd | 6.15K | ± 197.57 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 3.38K | ± 286.63 | ops/s | 19x slower |
| openTelemetryInc | 3.23K | ± 272.40 | ops/s | 20x slower |
| openTelemetryAdd | 3.11K | ± 241.69 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.59K | ± 1.10K | ops/s | **fastest** |
| simpleclient | 4.40K | ± 85.64 | ops/s | 1.5x slower |
| prometheusNative | 2.73K | ± 85.89 | ops/s | 2.4x slower |
| openTelemetryClassic | 800.55 | ± 46.98 | ops/s | 8.2x slower |
| openTelemetryExponential | 650.49 | ± 51.65 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.65K | ± 183.66 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.31K | ± 179.42 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 484.43K | ± 5.49K | ops/s | **fastest** |
| prometheusWriteToByteArray | 479.90K | ± 3.95K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 458.63K | ± 3.39K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 455.29K | ± 7.68K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49791.052    ± 542.839  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3112.553    ± 241.685  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3232.886    ± 272.401  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3382.155    ± 286.625  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51436.375     ± 89.603  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65081.818   ± 1308.753  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55814.879   ± 1016.660  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6148.603    ± 197.569  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6550.797     ± 43.393  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6352.998     ± 37.228  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        800.548     ± 46.981  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        650.488     ± 51.653  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6594.389   ± 1095.134  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2728.059     ± 85.892  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4402.062     ± 85.638  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23305.900    ± 179.419  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23652.351    ± 183.655  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     455289.699   ± 7679.914  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     458626.934   ± 3385.397  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     479902.877   ± 3949.286  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     484428.934   ± 5485.209  ops/s
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

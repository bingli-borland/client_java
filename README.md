# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-05T07:29:29Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.29K | ± 279.16 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.37K | ± 161.17 | ops/s | 1.2x slower |
| prometheusAdd | 51.44K | ± 441.61 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.46K | ± 1.34K | ops/s | 1.3x slower |
| simpleclientInc | 6.60K | ± 83.21 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.39K | ± 24.06 | ops/s | 10x slower |
| simpleclientAdd | 6.33K | ± 179.05 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.60K | ± 542.56 | ops/s | 18x slower |
| openTelemetryInc | 3.14K | ± 321.73 | ops/s | 21x slower |
| openTelemetryAdd | 3.11K | ± 351.73 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.12K | ± 1.61K | ops/s | **fastest** |
| simpleclient | 4.38K | ± 109.38 | ops/s | 1.4x slower |
| prometheusNative | 2.83K | ± 130.11 | ops/s | 2.2x slower |
| openTelemetryClassic | 804.49 | ± 19.20 | ops/s | 7.6x slower |
| openTelemetryExponential | 717.06 | ± 72.78 | ops/s | 8.5x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.11K | ± 790.22 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.70K | ± 583.89 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 504.41K | ± 7.82K | ops/s | **fastest** |
| prometheusWriteToByteArray | 498.55K | ± 5.16K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 482.53K | ± 3.51K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 474.84K | ± 7.56K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49459.414   ± 1337.078  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3110.231    ± 351.725  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3138.083    ± 321.725  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3603.911    ± 542.563  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51437.142    ± 441.610  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66292.700    ± 279.163  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56370.239    ± 161.167  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6333.246    ± 179.047  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6601.529     ± 83.210  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6385.117     ± 24.064  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        804.488     ± 19.198  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        717.059     ± 72.783  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6115.330   ± 1607.342  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2825.340    ± 130.109  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4380.606    ± 109.384  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23698.826    ± 583.893  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24110.274    ± 790.216  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     474843.117   ± 7561.696  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     482532.404   ± 3506.394  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     498549.562   ± 5161.733  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     504413.805   ± 7816.034  ops/s
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

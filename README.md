# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-30T07:36:52Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.00K | ± 282.98 | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.11K | ± 1.62K | ops/s | 1.2x slower |
| prometheusAdd | 49.64K | ± 3.01K | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.01K | ± 1.84K | ops/s | 1.3x slower |
| simpleclientInc | 6.59K | ± 75.60 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.35K | ± 10.50 | ops/s | 10x slower |
| simpleclientAdd | 6.18K | ± 226.89 | ops/s | 11x slower |
| openTelemetryInc | 3.97K | ± 340.31 | ops/s | 17x slower |
| openTelemetryAdd | 3.31K | ± 166.85 | ops/s | 20x slower |
| openTelemetryIncNoLabels | 3.16K | ± 132.85 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.29K | ± 1.29K | ops/s | **fastest** |
| simpleclient | 4.49K | ± 63.32 | ops/s | 1.4x slower |
| prometheusNative | 2.79K | ± 356.13 | ops/s | 2.2x slower |
| openTelemetryClassic | 765.59 | ± 29.24 | ops/s | 8.2x slower |
| openTelemetryExponential | 594.64 | ± 21.35 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 25.23K | ± 665.34 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.83K | ± 990.52 | ops/s | 1.1x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 537.62K | ± 8.05K | ops/s | **fastest** |
| prometheusWriteToByteArray | 530.49K | ± 4.02K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 505.67K | ± 7.47K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 503.92K | ± 4.52K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49006.335   ± 1839.484  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3309.102    ± 166.845  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3965.756    ± 340.311  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3160.937    ± 132.845  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      49643.407   ± 3010.662  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65996.203    ± 282.983  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55106.325   ± 1621.147  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6176.528    ± 226.889  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6590.239     ± 75.605  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6348.696     ± 10.500  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        765.589     ± 29.242  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        594.641     ± 21.347  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6287.956   ± 1291.632  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2794.932    ± 356.134  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4494.602     ± 63.321  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23831.880    ± 990.520  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      25234.297    ± 665.339  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     503921.399   ± 4518.316  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     505671.187   ± 7470.139  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     530493.284   ± 4015.229  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     537624.277   ± 8053.426  ops/s
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

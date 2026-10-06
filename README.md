# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-06T10:05:54Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.49K | ± 510.74 | ops/s | **fastest** |
| prometheusNoLabelsInc | 57.16K | ± 59.86 | ops/s | 1.2x slower |
| prometheusAdd | 48.34K | ± 5.08K | ops/s | 1.4x slower |
| codahaleIncNoLabels | 47.36K | ± 400.70 | ops/s | 1.4x slower |
| simpleclientInc | 6.59K | ± 73.83 | ops/s | 10x slower |
| simpleclientAdd | 6.43K | ± 18.14 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.38K | ± 38.76 | ops/s | 10x slower |
| openTelemetryAdd | 3.42K | ± 396.26 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 3.33K | ± 393.30 | ops/s | 20x slower |
| openTelemetryInc | 3.30K | ± 499.26 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.74K | ± 1.57K | ops/s | **fastest** |
| simpleclient | 4.36K | ± 40.61 | ops/s | 1.3x slower |
| prometheusNative | 2.79K | ± 327.32 | ops/s | 2.1x slower |
| openTelemetryClassic | 773.61 | ± 13.29 | ops/s | 7.4x slower |
| openTelemetryExponential | 587.06 | ± 41.93 | ops/s | 9.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.47K | ± 701.25 | ops/s | **fastest** |
| prometheusWriteToNull | 23.26K | ± 780.08 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 497.05K | ± 4.30K | ops/s | **fastest** |
| prometheusWriteToByteArray | 486.42K | ± 6.31K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 475.36K | ± 5.34K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 470.61K | ± 5.07K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      47363.583    ± 400.696  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3420.826    ± 396.262  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3301.190    ± 499.256  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3326.207    ± 393.297  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48336.482   ± 5080.709  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66490.418    ± 510.738  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      57163.597     ± 59.859  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6434.021     ± 18.141  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6593.129     ± 73.827  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6384.600     ± 38.759  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        773.607     ± 13.294  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        587.063     ± 41.932  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5735.428   ± 1567.801  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2787.439    ± 327.317  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4363.066     ± 40.611  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23472.738    ± 701.254  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23256.474    ± 780.082  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     470605.258   ± 5065.179  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     475358.929   ± 5337.197  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     486421.203   ± 6307.307  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     497051.626   ± 4301.074  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-10T09:35:47Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 63.61K | ± 4.06K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.82K | ± 310.79 | ops/s | 1.1x slower |
| prometheusAdd | 51.14K | ± 211.81 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 48.01K | ± 1.64K | ops/s | 1.3x slower |
| simpleclientInc | 6.56K | ± 36.73 | ops/s | 9.7x slower |
| simpleclientNoLabelsInc | 6.34K | ± 13.34 | ops/s | 10x slower |
| simpleclientAdd | 6.25K | ± 365.07 | ops/s | 10x slower |
| openTelemetryInc | 3.81K | ± 548.60 | ops/s | 17x slower |
| openTelemetryAdd | 3.31K | ± 157.99 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 3.15K | ± 66.65 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.54K | ± 1.67K | ops/s | **fastest** |
| simpleclient | 4.36K | ± 15.23 | ops/s | 1.3x slower |
| prometheusNative | 2.61K | ± 98.46 | ops/s | 2.1x slower |
| openTelemetryClassic | 761.15 | ± 17.40 | ops/s | 7.3x slower |
| openTelemetryExponential | 648.10 | ± 49.43 | ops/s | 8.5x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.92K | ± 600.23 | ops/s | **fastest** |
| prometheusWriteToNull | 23.81K | ± 552.30 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 510.85K | ± 1.84K | ops/s | **fastest** |
| prometheusWriteToByteArray | 499.78K | ± 6.11K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 490.20K | ± 2.22K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 480.12K | ± 7.34K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48013.714   ± 1639.909  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3307.173    ± 157.987  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3811.336    ± 548.596  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3150.819     ± 66.654  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51135.938    ± 211.805  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      63610.071   ± 4057.247  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56821.268    ± 310.786  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6245.287    ± 365.070  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6556.631     ± 36.728  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6338.325     ± 13.344  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        761.153     ± 17.400  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        648.103     ± 49.428  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5540.193   ± 1667.813  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2606.632     ± 98.460  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4359.479     ± 15.229  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23922.325    ± 600.227  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23805.233    ± 552.301  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     480120.717   ± 7337.792  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     490197.185   ± 2218.251  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     499782.939   ± 6110.683  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     510854.882   ± 1842.730  ops/s
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

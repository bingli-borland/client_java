# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-01T08:25:10Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1015-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.58K | ± 434.77 | ops/s | **fastest** |
| prometheusNoLabelsInc | 52.07K | ± 923.46 | ops/s | 1.1x slower |
| prometheusAdd | 49.26K | ± 723.95 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.39K | ± 779.59 | ops/s | 1.3x slower |
| simpleclientInc | 6.17K | ± 65.30 | ops/s | 9.7x slower |
| simpleclientAdd | 6.10K | ± 44.31 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 5.86K | ± 63.31 | ops/s | 10x slower |
| openTelemetryInc | 5.40K | ± 1.00K | ops/s | 11x slower |
| openTelemetryIncNoLabels | 4.92K | ± 976.93 | ops/s | 12x slower |
| openTelemetryAdd | 3.94K | ± 789.49 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.39K | ± 1.51K | ops/s | **fastest** |
| simpleclient | 4.31K | ± 140.07 | ops/s | 1.3x slower |
| prometheusNative | 3.10K | ± 54.62 | ops/s | 1.7x slower |
| openTelemetryClassic | 700.16 | ± 13.87 | ops/s | 7.7x slower |
| openTelemetryExponential | 552.64 | ± 4.41 | ops/s | 9.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.54K | ± 326.45 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.14K | ± 178.72 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 577.05K | ± 11.56K | ops/s | **fastest** |
| prometheusWriteToByteArray | 553.47K | ± 20.15K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 546.21K | ± 3.06K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 538.55K | ± 3.60K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44392.360    ± 779.595  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3937.553    ± 789.487  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5397.448   ± 1001.984  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4921.037    ± 976.930  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      49259.373    ± 723.950  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59580.412    ± 434.768  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      52068.656    ± 923.456  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6103.118     ± 44.310  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6165.760     ± 65.301  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5856.085     ± 63.311  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        700.160     ± 13.865  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        552.635      ± 4.415  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5391.155   ± 1509.003  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3102.067     ± 54.617  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4311.859    ± 140.070  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27137.930    ± 178.719  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27543.553    ± 326.447  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     538545.619   ± 3598.612  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     546206.161   ± 3061.143  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     553472.067  ± 20154.030  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     577051.951  ± 11562.887  ops/s
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

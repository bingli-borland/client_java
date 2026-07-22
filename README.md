# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-22T06:42:57Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 56.57K | ± 5.20K | ops/s | **fastest** |
| prometheusNoLabelsInc | 52.36K | ± 584.02 | ops/s | 1.1x slower |
| prometheusAdd | 48.17K | ± 337.79 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.14K | ± 389.90 | ops/s | 1.3x slower |
| simpleclientInc | 6.14K | ± 91.85 | ops/s | 9.2x slower |
| simpleclientAdd | 5.93K | ± 157.44 | ops/s | 9.5x slower |
| simpleclientNoLabelsInc | 5.90K | ± 26.51 | ops/s | 9.6x slower |
| openTelemetryInc | 4.69K | ± 1.14K | ops/s | 12x slower |
| openTelemetryIncNoLabels | 4.13K | ± 635.26 | ops/s | 14x slower |
| openTelemetryAdd | 3.44K | ± 135.22 | ops/s | 16x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.82K | ± 1.05K | ops/s | **fastest** |
| simpleclient | 4.52K | ± 80.54 | ops/s | 1.5x slower |
| prometheusNative | 3.05K | ± 205.35 | ops/s | 2.2x slower |
| openTelemetryClassic | 692.99 | ± 17.43 | ops/s | 9.8x slower |
| openTelemetryExponential | 552.27 | ± 18.31 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 27.27K | ± 231.05 | ops/s | **fastest** |
| prometheusWriteToNull | 27.14K | ± 314.74 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 558.36K | ± 3.44K | ops/s | **fastest** |
| prometheusWriteToByteArray | 549.61K | ± 3.71K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 525.16K | ± 3.94K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 515.94K | ± 3.97K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44139.491    ± 389.896  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3443.797    ± 135.223  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4687.083   ± 1140.637  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4125.865    ± 635.264  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48168.680    ± 337.792  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      56571.976   ± 5204.678  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      52360.581    ± 584.024  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5931.731    ± 157.442  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6140.638     ± 91.853  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5896.570     ± 26.511  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        692.990     ± 17.426  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        552.271     ± 18.312  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6822.903   ± 1052.887  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3050.502    ± 205.354  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4521.040     ± 80.537  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27266.645    ± 231.051  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27143.771    ± 314.741  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     515935.153   ± 3974.806  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     525155.327   ± 3935.974  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     549611.470   ± 3713.632  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     558364.142   ± 3442.182  ops/s
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

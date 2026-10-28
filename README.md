# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-28T09:25:43Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.59K | ± 340.75 | ops/s | **fastest** |
| prometheusNoLabelsInc | 54.81K | ± 2.27K | ops/s | 1.2x slower |
| prometheusAdd | 51.08K | ± 572.90 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 50.02K | ± 2.45K | ops/s | 1.3x slower |
| simpleclientInc | 6.59K | ± 11.31 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.36K | ± 33.39 | ops/s | 10x slower |
| simpleclientAdd | 5.85K | ± 97.41 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 3.30K | ± 455.86 | ops/s | 20x slower |
| openTelemetryInc | 3.28K | ± 381.94 | ops/s | 20x slower |
| openTelemetryAdd | 2.91K | ± 39.63 | ops/s | 23x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.39K | ± 1.18K | ops/s | **fastest** |
| simpleclient | 4.41K | ± 20.97 | ops/s | 1.4x slower |
| prometheusNative | 2.96K | ± 338.37 | ops/s | 2.2x slower |
| openTelemetryClassic | 759.00 | ± 8.40 | ops/s | 8.4x slower |
| openTelemetryExponential | 653.73 | ± 58.91 | ops/s | 9.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.44K | ± 716.98 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.24K | ± 155.31 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 489.02K | ± 4.83K | ops/s | **fastest** |
| prometheusWriteToByteArray | 481.97K | ± 2.84K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 461.43K | ± 5.44K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 454.87K | ± 9.01K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      50015.587   ± 2445.704  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2905.003     ± 39.631  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3284.053    ± 381.935  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3300.107    ± 455.861  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51080.585    ± 572.904  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65591.496    ± 340.750  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      54811.843   ± 2266.031  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5846.819     ± 97.409  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6587.579     ± 11.314  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6364.695     ± 33.393  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        759.005      ± 8.401  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        653.731     ± 58.907  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6385.390   ± 1176.805  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2958.863    ± 338.368  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4406.089     ± 20.968  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23244.162    ± 155.310  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23442.971    ± 716.981  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     454874.548   ± 9010.301  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     461428.407   ± 5439.616  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     481965.759   ± 2844.108  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     489017.701   ± 4832.863  ops/s
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

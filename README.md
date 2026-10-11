# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-11T09:53:05Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 60.88K | ± 4.63K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.87K | ± 408.94 | ops/s | 1.1x slower |
| prometheusAdd | 51.15K | ± 408.02 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.91K | ± 8.55K | ops/s | 1.4x slower |
| simpleclientInc | 6.56K | ± 41.36 | ops/s | 9.3x slower |
| simpleclientNoLabelsInc | 6.34K | ± 13.64 | ops/s | 9.6x slower |
| simpleclientAdd | 6.14K | ± 190.14 | ops/s | 9.9x slower |
| openTelemetryIncNoLabels | 3.39K | ± 307.54 | ops/s | 18x slower |
| openTelemetryInc | 3.27K | ± 414.95 | ops/s | 19x slower |
| openTelemetryAdd | 3.03K | ± 178.00 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.59K | ± 1.46K | ops/s | **fastest** |
| simpleclient | 4.43K | ± 56.65 | ops/s | 1.3x slower |
| prometheusNative | 2.59K | ± 74.55 | ops/s | 2.2x slower |
| openTelemetryClassic | 797.36 | ± 34.75 | ops/s | 7.0x slower |
| openTelemetryExponential | 682.08 | ± 84.79 | ops/s | 8.2x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.81K | ± 789.51 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.68K | ± 270.98 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 498.13K | ± 3.86K | ops/s | **fastest** |
| prometheusWriteToByteArray | 492.14K | ± 3.35K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 478.77K | ± 6.28K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 470.12K | ± 5.35K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43914.956   ± 8547.785  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3028.946    ± 178.001  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3268.203    ± 414.953  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3391.876    ± 307.539  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51151.437    ± 408.021  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      60877.871   ± 4633.543  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56868.567    ± 408.938  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6138.886    ± 190.137  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6561.673     ± 41.358  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6340.885     ± 13.635  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        797.358     ± 34.746  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        682.078     ± 84.792  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5590.266   ± 1456.155  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2589.534     ± 74.554  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4431.936     ± 56.648  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23675.002    ± 270.980  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23810.933    ± 789.511  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     478771.984   ± 6278.559  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     470115.261   ± 5346.480  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     492137.675   ± 3352.786  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     498131.529   ± 3857.033  ops/s
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

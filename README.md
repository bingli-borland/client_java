# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-11T06:36:52Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.86K | ± 1.21K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.84K | ± 455.88 | ops/s | 1.1x slower |
| prometheusAdd | 51.04K | ± 754.13 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.90K | ± 1.55K | ops/s | 1.3x slower |
| simpleclientInc | 6.59K | ± 15.28 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 6.37K | ± 46.83 | ops/s | 10x slower |
| simpleclientAdd | 6.36K | ± 155.45 | ops/s | 10x slower |
| openTelemetryAdd | 3.40K | ± 204.67 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 3.39K | ± 420.80 | ops/s | 19x slower |
| openTelemetryInc | 3.39K | ± 228.99 | ops/s | 19x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.09K | ± 388.07 | ops/s | **fastest** |
| simpleclient | 4.31K | ± 142.38 | ops/s | 1.2x slower |
| prometheusNative | 2.72K | ± 132.17 | ops/s | 1.9x slower |
| openTelemetryClassic | 747.87 | ± 27.28 | ops/s | 6.8x slower |
| openTelemetryExponential | 699.66 | ± 46.04 | ops/s | 7.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.34K | ± 799.37 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.01K | ± 840.99 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 516.93K | ± 8.13K | ops/s | **fastest** |
| prometheusWriteToByteArray | 514.91K | ± 3.03K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 494.22K | ± 1.62K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 492.21K | ± 2.03K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49898.492   ± 1552.552  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3400.275    ± 204.671  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3392.815    ± 228.992  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3394.629    ± 420.801  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51037.282    ± 754.129  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64861.849   ± 1207.275  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56837.037    ± 455.882  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6359.665    ± 155.450  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6585.916     ± 15.276  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6371.309     ± 46.827  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        747.875     ± 27.277  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        699.664     ± 46.044  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5088.901    ± 388.070  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2717.180    ± 132.173  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4312.638    ± 142.383  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23005.388    ± 840.994  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23340.093    ± 799.375  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     492210.810   ± 2029.594  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     494222.485   ± 1616.507  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     514912.055   ± 3033.816  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     516930.179   ± 8134.724  ops/s
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

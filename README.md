# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-24T06:44:05Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.21K | ± 1.52K | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.88K | ± 1.51K | ops/s | 1.2x slower |
| prometheusAdd | 51.11K | ± 255.86 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 46.73K | ± 1.75K | ops/s | 1.4x slower |
| simpleclientInc | 6.55K | ± 142.07 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.34K | ± 7.30 | ops/s | 10x slower |
| simpleclientAdd | 6.33K | ± 180.76 | ops/s | 10x slower |
| openTelemetryInc | 3.79K | ± 432.60 | ops/s | 17x slower |
| openTelemetryAdd | 3.40K | ± 426.60 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 3.33K | ± 280.19 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.50K | ± 1.40K | ops/s | **fastest** |
| simpleclient | 4.41K | ± 66.67 | ops/s | 1.2x slower |
| prometheusNative | 2.77K | ± 347.69 | ops/s | 2.0x slower |
| openTelemetryClassic | 752.84 | ± 24.28 | ops/s | 7.3x slower |
| openTelemetryExponential | 598.00 | ± 74.05 | ops/s | 9.2x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.17K | ± 950.45 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.41K | ± 186.14 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 501.04K | ± 3.81K | ops/s | **fastest** |
| prometheusWriteToByteArray | 492.56K | ± 2.49K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 475.03K | ± 3.09K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 474.41K | ± 1.57K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      46734.113   ± 1752.071  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3400.862    ± 426.598  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3792.743    ± 432.600  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3329.771    ± 280.192  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51109.294    ± 255.865  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65214.191   ± 1515.025  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55883.540   ± 1509.835  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6331.567    ± 180.763  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6550.999    ± 142.068  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6335.212      ± 7.296  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        752.841     ± 24.280  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        597.996     ± 74.048  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5502.433   ± 1399.798  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2772.571    ± 347.687  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4414.915     ± 66.674  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23405.006    ± 186.139  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24172.759    ± 950.445  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     474409.233   ± 1574.161  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     475033.626   ± 3094.425  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     492558.682   ± 2493.087  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     501044.259   ± 3806.210  ops/s
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

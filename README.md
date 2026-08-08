# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-08T04:56:09Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) 6973P-C, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| codahaleIncNoLabels | 36.10K | ± 1.67K | ops/s | **fastest** |
| prometheusAdd | 35.78K | ± 1.54K | ops/s | 1.0x slower |
| prometheusInc | 35.51K | ± 250.18 | ops/s | 1.0x slower |
| prometheusNoLabelsInc | 34.82K | ± 1.18K | ops/s | 1.0x slower |
| simpleclientInc | 9.22K | ± 87.71 | ops/s | 3.9x slower |
| simpleclientNoLabelsInc | 8.99K | ± 88.13 | ops/s | 4.0x slower |
| simpleclientAdd | 8.85K | ± 144.32 | ops/s | 4.1x slower |
| openTelemetryInc | 2.84K | ± 49.36 | ops/s | 13x slower |
| openTelemetryAdd | 2.49K | ± 500.01 | ops/s | 14x slower |
| openTelemetryIncNoLabels | 2.09K | ± 140.43 | ops/s | 17x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 6.13K | ± 57.38 | ops/s | **fastest** |
| prometheusClassic | 3.11K | ± 798.03 | ops/s | 2.0x slower |
| prometheusNative | 2.26K | ± 120.74 | ops/s | 2.7x slower |
| openTelemetryClassic | 488.60 | ± 44.22 | ops/s | 13x slower |
| openTelemetryExponential | 394.79 | ± 38.46 | ops/s | 16x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 25.42K | ± 146.07 | ops/s | **fastest** |
| openMetricsWriteToNull | 25.29K | ± 337.90 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 355.96K | ± 6.06K | ops/s | **fastest** |
| prometheusWriteToByteArray | 354.50K | ± 4.62K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 345.22K | ± 7.60K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 339.69K | ± 6.41K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      36098.366   ± 1665.286  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2490.739    ± 500.008  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2840.100     ± 49.359  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2089.624    ± 140.433  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      35784.990   ± 1542.973  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      35508.815    ± 250.176  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      34815.965   ± 1176.051  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       8845.596    ± 144.318  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       9224.290     ± 87.712  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       8991.827     ± 88.126  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        488.601     ± 44.219  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        394.793     ± 38.463  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       3105.610    ± 798.033  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2261.894    ± 120.739  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       6131.445     ± 57.376  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      25294.932    ± 337.902  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      25417.339    ± 146.072  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     345218.890   ± 7596.133  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     339694.100   ± 6411.563  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     354500.121   ± 4615.515  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     355959.759   ± 6059.283  ops/s
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

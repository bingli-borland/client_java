# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-09T08:33:07Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.54K | ± 1.25K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.19K | ± 1.43K | ops/s | 1.1x slower |
| prometheusAdd | 50.89K | ± 529.43 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.14K | ± 1.73K | ops/s | 1.3x slower |
| simpleclientInc | 6.63K | ± 66.68 | ops/s | 9.7x slower |
| simpleclientNoLabelsInc | 6.52K | ± 134.52 | ops/s | 9.9x slower |
| simpleclientAdd | 6.28K | ± 225.34 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.47K | ± 402.27 | ops/s | 19x slower |
| openTelemetryInc | 3.19K | ± 345.41 | ops/s | 20x slower |
| openTelemetryAdd | 3.15K | ± 364.69 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.98K | ± 1.60K | ops/s | **fastest** |
| simpleclient | 4.44K | ± 62.37 | ops/s | 1.1x slower |
| prometheusNative | 2.98K | ± 369.65 | ops/s | 1.7x slower |
| openTelemetryClassic | 739.11 | ± 11.02 | ops/s | 6.7x slower |
| openTelemetryExponential | 713.91 | ± 11.69 | ops/s | 7.0x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.46K | ± 353.59 | ops/s | **fastest** |
| prometheusWriteToNull | 23.40K | ± 410.57 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 517.49K | ± 6.51K | ops/s | **fastest** |
| prometheusWriteToByteArray | 508.64K | ± 6.16K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 490.85K | ± 3.35K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 489.47K | ± 4.89K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49142.210   ± 1733.135  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3150.832    ± 364.690  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3192.790    ± 345.408  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3469.871    ± 402.265  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50885.948    ± 529.425  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64535.470   ± 1245.401  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56186.915   ± 1428.363  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6282.318    ± 225.341  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6633.820     ± 66.678  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6517.822    ± 134.522  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        739.113     ± 11.025  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        713.913     ± 11.692  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4984.645   ± 1599.454  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2980.050    ± 369.648  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4442.458     ± 62.371  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23457.955    ± 353.595  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23399.208    ± 410.569  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     489466.121   ± 4885.281  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     490852.603   ± 3351.787  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     508641.122   ± 6155.753  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     517490.575   ± 6514.306  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-21T09:08:09Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.47K | ± 112.24 | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.55K | ± 1.35K | ops/s | 1.2x slower |
| prometheusAdd | 51.36K | ± 149.23 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 43.03K | ± 7.04K | ops/s | 1.5x slower |
| simpleclientInc | 6.56K | ± 29.40 | ops/s | 10x slower |
| simpleclientAdd | 6.37K | ± 69.68 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.36K | ± 33.53 | ops/s | 10x slower |
| openTelemetryAdd | 3.46K | ± 398.55 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 3.22K | ± 250.92 | ops/s | 21x slower |
| openTelemetryInc | 3.03K | ± 405.22 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.54K | ± 1.52K | ops/s | **fastest** |
| simpleclient | 4.43K | ± 57.18 | ops/s | 1.7x slower |
| prometheusNative | 3.01K | ± 270.87 | ops/s | 2.5x slower |
| openTelemetryClassic | 718.04 | ± 31.29 | ops/s | 11x slower |
| openTelemetryExponential | 636.13 | ± 61.61 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 24.03K | ± 513.35 | ops/s | **fastest** |
| prometheusWriteToNull | 24.00K | ± 753.00 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 501.88K | ± 8.19K | ops/s | **fastest** |
| prometheusWriteToByteArray | 497.24K | ± 7.67K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 487.67K | ± 3.66K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 483.51K | ± 7.07K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43028.582   ± 7043.846  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3457.052    ± 398.555  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3034.397    ± 405.220  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3221.209    ± 250.920  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51356.821    ± 149.230  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66471.797    ± 112.237  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55554.825   ± 1352.751  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6368.276     ± 69.681  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6562.653     ± 29.396  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6357.576     ± 33.530  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        718.042     ± 31.294  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        636.132     ± 61.611  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7544.133   ± 1524.153  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3008.806    ± 270.866  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4428.658     ± 57.175  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      24029.074    ± 513.350  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24000.134    ± 753.002  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     483508.210   ± 7074.449  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     487665.732   ± 3661.177  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     497243.305   ± 7670.258  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     501881.402   ± 8192.585  ops/s
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

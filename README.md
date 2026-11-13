# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-13T10:37:16Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.84K | ± 1.33K | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.61K | ± 598.51 | ops/s | 1.2x slower |
| prometheusAdd | 51.05K | ± 318.64 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.63K | ± 732.98 | ops/s | 1.3x slower |
| simpleclientInc | 6.52K | ± 55.71 | ops/s | 10.0x slower |
| simpleclientAdd | 6.38K | ± 10.20 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.24K | ± 34.69 | ops/s | 10x slower |
| openTelemetryInc | 3.12K | ± 357.65 | ops/s | 21x slower |
| openTelemetryIncNoLabels | 3.03K | ± 348.39 | ops/s | 21x slower |
| openTelemetryAdd | 2.96K | ± 210.79 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.27K | ± 1.02K | ops/s | **fastest** |
| simpleclient | 4.35K | ± 43.10 | ops/s | 1.4x slower |
| prometheusNative | 2.75K | ± 321.59 | ops/s | 2.3x slower |
| openTelemetryClassic | 821.08 | ± 15.79 | ops/s | 7.6x slower |
| openTelemetryExponential | 726.16 | ± 50.31 | ops/s | 8.6x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.34K | ± 422.26 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.30K | ± 1.13K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 463.78K | ± 4.16K | ops/s | **fastest** |
| prometheusWriteToByteArray | 458.11K | ± 2.01K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 442.70K | ± 7.17K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 440.67K | ± 4.47K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48628.505    ± 732.979  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2963.620    ± 210.788  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3123.332    ± 357.646  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3030.083    ± 348.392  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51045.770    ± 318.643  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64838.650   ± 1325.802  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55612.137    ± 598.509  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6381.818     ± 10.203  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6516.152     ± 55.706  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6236.850     ± 34.687  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        821.078     ± 15.786  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        726.157     ± 50.311  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6270.639   ± 1022.694  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2754.347    ± 321.590  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4348.940     ± 43.105  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23303.773   ± 1132.038  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24336.998    ± 422.263  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     440669.888   ± 4474.045  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     442700.874   ± 7168.159  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     458108.476   ± 2009.896  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     463782.403   ± 4156.700  ops/s
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

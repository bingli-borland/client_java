# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-31T09:31:55Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** INTEL(R) XEON(R) PLATINUM 8573C, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| codahaleIncNoLabels | 31.32K | ± 1.18K | ops/s | **fastest** |
| prometheusNoLabelsInc | 30.87K | ± 264.59 | ops/s | 1.0x slower |
| prometheusInc | 30.80K | ± 77.94 | ops/s | 1.0x slower |
| prometheusAdd | 29.92K | ± 122.76 | ops/s | 1.0x slower |
| simpleclientInc | 7.78K | ± 33.47 | ops/s | 4.0x slower |
| simpleclientNoLabelsInc | 7.53K | ± 117.27 | ops/s | 4.2x slower |
| simpleclientAdd | 7.43K | ± 140.55 | ops/s | 4.2x slower |
| openTelemetryAdd | 2.83K | ± 170.06 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 2.55K | ± 234.49 | ops/s | 12x slower |
| openTelemetryInc | 2.31K | ± 115.88 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.91K | ± 51.27 | ops/s | **fastest** |
| prometheusClassic | 3.08K | ± 1.14K | ops/s | 1.6x slower |
| prometheusNative | 2.07K | ± 430.05 | ops/s | 2.4x slower |
| openTelemetryClassic | 573.01 | ± 24.44 | ops/s | 8.6x slower |
| openTelemetryExponential | 404.93 | ± 29.41 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 20.76K | ± 148.10 | ops/s | **fastest** |
| prometheusWriteToNull | 20.73K | ± 147.12 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 355.94K | ± 8.56K | ops/s | **fastest** |
| prometheusWriteToByteArray | 351.52K | ± 2.83K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 335.02K | ± 7.15K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 324.92K | ± 8.15K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      31322.737   ± 1177.463  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2828.150    ± 170.060  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2314.736    ± 115.879  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2546.807    ± 234.487  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      29917.708    ± 122.762  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      30802.431     ± 77.937  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      30873.444    ± 264.592  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7425.449    ± 140.554  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7776.169     ± 33.469  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7529.960    ± 117.274  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        573.007     ± 24.442  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        404.929     ± 29.413  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       3079.634   ± 1144.178  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2068.216    ± 430.055  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4905.152     ± 51.266  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      20759.680    ± 148.100  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      20730.243    ± 147.124  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     324920.350   ± 8146.436  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     335024.711   ± 7145.146  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     351515.624   ± 2826.397  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     355942.796   ± 8561.204  ops/s
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

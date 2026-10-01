# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-01T09:56:04Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 58.10K | ± 2.11K | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.04K | ± 1.19K | ops/s | 1.1x slower |
| prometheusAdd | 48.28K | ± 424.76 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.18K | ± 353.58 | ops/s | 1.3x slower |
| simpleclientInc | 6.16K | ± 61.58 | ops/s | 9.4x slower |
| simpleclientAdd | 6.03K | ± 249.98 | ops/s | 9.6x slower |
| simpleclientNoLabelsInc | 5.92K | ± 28.99 | ops/s | 9.8x slower |
| openTelemetryInc | 5.15K | ± 1.15K | ops/s | 11x slower |
| openTelemetryIncNoLabels | 5.08K | ± 892.83 | ops/s | 11x slower |
| openTelemetryAdd | 3.29K | ± 171.11 | ops/s | 18x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.64K | ± 814.16 | ops/s | **fastest** |
| simpleclient | 4.45K | ± 102.31 | ops/s | 1.3x slower |
| prometheusNative | 3.00K | ± 274.89 | ops/s | 1.9x slower |
| openTelemetryClassic | 674.93 | ± 23.68 | ops/s | 8.4x slower |
| openTelemetryExponential | 536.76 | ± 4.80 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 27.38K | ± 222.87 | ops/s | **fastest** |
| prometheusWriteToNull | 27.30K | ± 462.32 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 568.78K | ± 2.26K | ops/s | **fastest** |
| prometheusWriteToNull | 562.67K | ± 10.76K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 543.39K | ± 2.42K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 532.35K | ± 3.17K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44178.455    ± 353.579  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3290.801    ± 171.113  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5146.440   ± 1154.327  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5078.377    ± 892.834  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48281.738    ± 424.764  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      58097.771   ± 2109.202  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51035.811   ± 1188.502  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6034.550    ± 249.980  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6156.855     ± 61.579  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5918.871     ± 28.985  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        674.927     ± 23.676  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        536.757      ± 4.805  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5638.537    ± 814.158  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2996.660    ± 274.888  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4451.905    ± 102.310  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27375.296    ± 222.868  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27300.829    ± 462.316  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     532352.065   ± 3172.283  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     543390.673   ± 2415.340  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     568782.689   ± 2259.408  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     562665.266  ± 10763.621  ops/s
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

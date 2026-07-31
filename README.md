# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-31T06:59:08Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 55.95K | ± 15.08K | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.30K | ± 2.55K | ops/s | 1.0x slower |
| prometheusAdd | 51.16K | ± 373.47 | ops/s | 1.1x slower |
| codahaleIncNoLabels | 48.60K | ± 1.35K | ops/s | 1.2x slower |
| simpleclientInc | 6.52K | ± 104.47 | ops/s | 8.6x slower |
| simpleclientAdd | 6.47K | ± 11.67 | ops/s | 8.7x slower |
| simpleclientNoLabelsInc | 6.45K | ± 145.28 | ops/s | 8.7x slower |
| openTelemetryAdd | 3.27K | ± 371.75 | ops/s | 17x slower |
| openTelemetryIncNoLabels | 3.08K | ± 138.99 | ops/s | 18x slower |
| openTelemetryInc | 3.00K | ± 135.20 | ops/s | 19x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.15K | ± 1.47K | ops/s | **fastest** |
| simpleclient | 4.41K | ± 95.93 | ops/s | 1.4x slower |
| prometheusNative | 2.98K | ± 335.44 | ops/s | 2.1x slower |
| openTelemetryClassic | 767.95 | ± 22.61 | ops/s | 8.0x slower |
| openTelemetryExponential | 647.89 | ± 97.73 | ops/s | 9.5x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.91K | ± 190.15 | ops/s | **fastest** |
| prometheusWriteToNull | 23.87K | ± 1.15K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 505.02K | ± 5.76K | ops/s | **fastest** |
| prometheusWriteToByteArray | 499.81K | ± 3.75K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 484.82K | ± 7.11K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 479.10K | ± 2.87K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48598.041   ± 1353.530  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3272.257    ± 371.753  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2997.500    ± 135.199  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3080.133    ± 138.995  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51164.177    ± 373.468  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      55953.359  ± 15078.115  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55301.637   ± 2550.104  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6465.638     ± 11.665  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6517.594    ± 104.471  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6450.373    ± 145.278  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        767.945     ± 22.608  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        647.894     ± 97.726  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6147.663   ± 1472.206  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2975.243    ± 335.444  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4414.054     ± 95.927  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23909.726    ± 190.151  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23867.725   ± 1148.592  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     479096.499   ± 2867.410  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     484817.538   ± 7113.740  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     499805.630   ± 3750.299  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     505015.187   ± 5764.385  ops/s
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

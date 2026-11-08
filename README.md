# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-08T10:05:40Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.15K | ± 2.38K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.21K | ± 474.98 | ops/s | 1.1x slower |
| prometheusAdd | 51.52K | ± 338.56 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 47.18K | ± 2.62K | ops/s | 1.4x slower |
| simpleclientInc | 6.48K | ± 47.98 | ops/s | 9.9x slower |
| simpleclientAdd | 6.38K | ± 61.73 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.23K | ± 7.57 | ops/s | 10x slower |
| openTelemetryInc | 3.56K | ± 359.52 | ops/s | 18x slower |
| openTelemetryIncNoLabels | 3.33K | ± 243.61 | ops/s | 19x slower |
| openTelemetryAdd | 3.31K | ± 222.98 | ops/s | 19x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.28K | ± 1.29K | ops/s | **fastest** |
| simpleclient | 4.37K | ± 77.21 | ops/s | 1.4x slower |
| prometheusNative | 3.05K | ± 290.77 | ops/s | 2.1x slower |
| openTelemetryClassic | 783.01 | ± 2.50 | ops/s | 8.0x slower |
| openTelemetryExponential | 640.45 | ± 86.75 | ops/s | 9.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.66K | ± 636.23 | ops/s | **fastest** |
| openMetricsWriteToNull | 22.85K | ± 353.95 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 465.82K | ± 5.20K | ops/s | **fastest** |
| prometheusWriteToNull | 464.17K | ± 9.64K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 452.96K | ± 6.71K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 446.96K | ± 6.93K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      47179.034   ± 2624.838  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3305.260    ± 222.980  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3562.450    ± 359.521  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3329.431    ± 243.610  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51524.931    ± 338.561  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64153.910   ± 2381.918  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56214.840    ± 474.981  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6383.143     ± 61.728  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6481.257     ± 47.976  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6230.147      ± 7.568  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        783.010      ± 2.499  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        640.455     ± 86.748  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6281.331   ± 1290.411  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3047.170    ± 290.765  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4370.092     ± 77.210  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      22849.725    ± 353.950  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23663.321    ± 636.230  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     446955.337   ± 6933.577  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     452963.993   ± 6706.120  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     465816.914   ± 5195.100  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     464172.733   ± 9637.024  ops/s
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

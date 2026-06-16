# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-16T08:51:49Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.06K | ± 1.05K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.58K | ± 409.70 | ops/s | 1.1x slower |
| prometheusAdd | 51.44K | ± 175.97 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.12K | ± 1.10K | ops/s | 1.4x slower |
| simpleclientInc | 6.59K | ± 9.90 | ops/s | 9.9x slower |
| simpleclientAdd | 6.53K | ± 30.13 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.35K | ± 33.50 | ops/s | 10x slower |
| openTelemetryInc | 3.44K | ± 370.34 | ops/s | 19x slower |
| openTelemetryAdd | 3.42K | ± 133.89 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 2.96K | ± 95.11 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.50K | ± 1.52K | ops/s | **fastest** |
| simpleclient | 4.44K | ± 67.61 | ops/s | 1.5x slower |
| prometheusNative | 2.96K | ± 248.29 | ops/s | 2.2x slower |
| openTelemetryClassic | 740.80 | ± 29.83 | ops/s | 8.8x slower |
| openTelemetryExponential | 697.93 | ± 57.44 | ops/s | 9.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.59K | ± 389.52 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.51K | ± 979.10 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 499.85K | ± 5.30K | ops/s | **fastest** |
| prometheusWriteToByteArray | 497.52K | ± 5.30K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 478.15K | ± 3.10K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 476.85K | ± 6.53K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48120.401   ± 1104.272  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3416.230    ± 133.892  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3443.593    ± 370.341  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2961.429     ± 95.109  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51441.677    ± 175.969  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65061.632   ± 1047.781  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56578.207    ± 409.700  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6530.735     ± 30.130  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6586.567      ± 9.903  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6353.731     ± 33.499  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        740.798     ± 29.831  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        697.933     ± 57.437  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6496.222   ± 1520.727  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2959.443    ± 248.291  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4436.878     ± 67.608  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23514.881    ± 979.096  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23589.027    ± 389.524  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     476847.277   ± 6527.023  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     478150.019   ± 3095.577  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     497520.725   ± 5297.873  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     499845.499   ± 5296.989  ops/s
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

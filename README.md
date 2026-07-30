# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-30T06:32:34Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.80K | ± 1.15K | ops/s | **fastest** |
| prometheusNoLabelsInc | 57.19K | ± 155.23 | ops/s | 1.1x slower |
| prometheusAdd | 51.52K | ± 357.66 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.62K | ± 2.14K | ops/s | 1.3x slower |
| simpleclientInc | 6.51K | ± 55.77 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.44K | ± 125.64 | ops/s | 10x slower |
| simpleclientAdd | 6.23K | ± 347.05 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.46K | ± 534.01 | ops/s | 19x slower |
| openTelemetryAdd | 3.37K | ± 407.37 | ops/s | 19x slower |
| openTelemetryInc | 3.31K | ± 291.91 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.56K | ± 1.31K | ops/s | **fastest** |
| simpleclient | 4.47K | ± 57.20 | ops/s | 1.2x slower |
| prometheusNative | 2.94K | ± 372.74 | ops/s | 1.9x slower |
| openTelemetryClassic | 753.70 | ± 29.23 | ops/s | 7.4x slower |
| openTelemetryExponential | 598.27 | ± 42.86 | ops/s | 9.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.68K | ± 1.05K | ops/s | **fastest** |
| prometheusWriteToNull | 23.58K | ± 319.30 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 505.21K | ± 9.75K | ops/s | **fastest** |
| prometheusWriteToByteArray | 502.82K | ± 6.13K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 486.86K | ± 3.66K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 484.06K | ± 5.21K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48619.596   ± 2139.376  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3370.553    ± 407.373  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3311.079    ± 291.912  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3461.000    ± 534.011  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51517.489    ± 357.657  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64796.857   ± 1149.687  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      57188.591    ± 155.234  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6227.651    ± 347.053  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6509.469     ± 55.773  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6437.598    ± 125.637  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        753.697     ± 29.226  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        598.269     ± 42.864  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5555.693   ± 1312.030  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2937.678    ± 372.744  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4471.050     ± 57.199  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23679.313   ± 1051.665  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23576.448    ± 319.301  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     484057.765   ± 5214.461  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     486864.306   ± 3655.459  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     502822.827   ± 6126.663  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     505209.993   ± 9748.833  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-25T07:32:31Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.57K | ± 1.79K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.24K | ± 1.01K | ops/s | 1.2x slower |
| prometheusAdd | 48.52K | ± 2.10K | ops/s | 1.4x slower |
| codahaleIncNoLabels | 41.61K | ± 10.54K | ops/s | 1.6x slower |
| simpleclientInc | 6.58K | ± 8.06 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.36K | ± 35.00 | ops/s | 10x slower |
| simpleclientAdd | 6.33K | ± 226.67 | ops/s | 10x slower |
| openTelemetryInc | 3.72K | ± 616.19 | ops/s | 18x slower |
| openTelemetryAdd | 3.57K | ± 326.60 | ops/s | 18x slower |
| openTelemetryIncNoLabels | 3.15K | ± 59.17 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.92K | ± 2.74K | ops/s | **fastest** |
| simpleclient | 4.42K | ± 78.71 | ops/s | 1.3x slower |
| prometheusNative | 2.85K | ± 264.74 | ops/s | 2.1x slower |
| openTelemetryClassic | 748.86 | ± 30.76 | ops/s | 7.9x slower |
| openTelemetryExponential | 604.57 | ± 41.11 | ops/s | 9.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 24.06K | ± 1.03K | ops/s | **fastest** |
| prometheusWriteToNull | 23.61K | ± 888.27 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 504.55K | ± 9.39K | ops/s | **fastest** |
| prometheusWriteToByteArray | 492.19K | ± 4.74K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 482.58K | ± 3.01K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 477.22K | ± 3.73K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      41608.596  ± 10535.096  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3574.982    ± 326.597  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3719.837    ± 616.189  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3145.946     ± 59.172  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48522.052   ± 2101.040  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65566.252   ± 1787.609  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56240.617   ± 1007.562  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6325.711    ± 226.671  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6580.365      ± 8.060  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6360.788     ± 34.997  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        748.856     ± 30.765  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        604.567     ± 41.111  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5924.764   ± 2739.639  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2845.764    ± 264.737  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4424.528     ± 78.710  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      24055.993   ± 1034.892  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23609.772    ± 888.266  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     477224.326   ± 3725.348  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     482582.702   ± 3009.890  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     492186.982   ± 4739.360  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     504549.249   ± 9391.259  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-02T06:51:12Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.77K | ± 85.14 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.64K | ± 229.12 | ops/s | 1.2x slower |
| prometheusAdd | 51.43K | ± 216.72 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.42K | ± 1.13K | ops/s | 1.4x slower |
| simpleclientInc | 6.58K | ± 76.90 | ops/s | 10.0x slower |
| simpleclientAdd | 6.32K | ± 165.61 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.32K | ± 85.60 | ops/s | 10x slower |
| openTelemetryInc | 3.71K | ± 290.30 | ops/s | 18x slower |
| openTelemetryIncNoLabels | 3.33K | ± 710.94 | ops/s | 20x slower |
| openTelemetryAdd | 3.17K | ± 143.56 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.56K | ± 954.45 | ops/s | **fastest** |
| simpleclient | 4.37K | ± 78.72 | ops/s | 1.0x slower |
| prometheusNative | 2.78K | ± 338.41 | ops/s | 1.6x slower |
| openTelemetryClassic | 736.98 | ± 31.97 | ops/s | 6.2x slower |
| openTelemetryExponential | 638.63 | ± 73.99 | ops/s | 7.1x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.96K | ± 312.09 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.35K | ± 1.26K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 512.13K | ± 2.03K | ops/s | **fastest** |
| prometheusWriteToByteArray | 504.98K | ± 6.47K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 490.10K | ± 2.13K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 485.89K | ± 4.46K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48423.980   ± 1129.897  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3173.464    ± 143.561  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3711.018    ± 290.299  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3331.679    ± 710.941  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51427.138    ± 216.725  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65770.257     ± 85.138  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56644.728    ± 229.124  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6323.534    ± 165.612  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6584.990     ± 76.904  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6315.936     ± 85.595  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        736.980     ± 31.965  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        638.626     ± 73.986  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4555.918    ± 954.447  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2779.445    ± 338.413  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4366.588     ± 78.721  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23345.925   ± 1256.601  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23963.578    ± 312.092  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     485893.289   ± 4462.352  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     490100.709   ± 2132.683  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     504976.484   ± 6469.270  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     512128.517   ± 2027.698  ops/s
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

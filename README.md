# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-29T09:30:36Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V45 96-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 67.21K | ± 677.56 | ops/s | **fastest** |
| prometheusNoLabelsInc | 66.74K | ± 906.87 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 61.24K | ± 1.11K | ops/s | 1.1x slower |
| prometheusAdd | 57.50K | ± 3.12K | ops/s | 1.2x slower |
| simpleclientInc | 10.87K | ± 150.48 | ops/s | 6.2x slower |
| simpleclientNoLabelsInc | 10.70K | ± 105.99 | ops/s | 6.3x slower |
| simpleclientAdd | 10.57K | ± 370.62 | ops/s | 6.4x slower |
| openTelemetryIncNoLabels | 6.48K | ± 1.89K | ops/s | 10x slower |
| openTelemetryAdd | 5.11K | ± 463.57 | ops/s | 13x slower |
| openTelemetryInc | 4.77K | ± 127.19 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.21K | ± 2.29K | ops/s | **fastest** |
| simpleclient | 6.96K | ± 109.44 | ops/s | 1.0x slower |
| prometheusNative | 4.85K | ± 558.53 | ops/s | 1.5x slower |
| openTelemetryClassic | 891.28 | ± 23.56 | ops/s | 8.1x slower |
| openTelemetryExponential | 693.25 | ± 25.38 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 33.66K | ± 430.08 | ops/s | **fastest** |
| openMetricsWriteToNull | 33.63K | ± 334.38 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 752.82K | ± 26.82K | ops/s | **fastest** |
| prometheusWriteToNull | 737.06K | ± 37.00K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 706.61K | ± 27.32K | ops/s | 1.1x slower |
| openMetricsWriteToNull | 673.03K | ± 54.59K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      61240.681   ± 1112.035  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       5112.431    ± 463.567  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4774.644    ± 127.191  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       6483.808   ± 1890.362  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      57500.067   ± 3121.366  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      67205.286    ± 677.563  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      66739.609    ± 906.875  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15      10565.724    ± 370.624  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15      10873.789    ± 150.480  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15      10698.261    ± 105.994  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        891.280     ± 23.555  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        693.255     ± 25.382  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7214.479   ± 2293.326  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       4848.131    ± 558.526  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       6963.690    ± 109.439  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      33626.259    ± 334.380  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      33663.800    ± 430.076  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     706614.651  ± 27316.401  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     673025.479  ± 54587.585  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     752823.606  ± 26823.329  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     737063.949  ± 36997.310  ops/s
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

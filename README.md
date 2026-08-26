# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-26T04:28:50Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 74.63K | ± 2.19K | ops/s | **fastest** |
| prometheusNoLabelsInc | 66.80K | ± 1.07K | ops/s | 1.1x slower |
| prometheusAdd | 63.53K | ± 1.19K | ops/s | 1.2x slower |
| codahaleIncNoLabels | 56.76K | ± 216.30 | ops/s | 1.3x slower |
| simpleclientInc | 7.93K | ± 117.33 | ops/s | 9.4x slower |
| simpleclientAdd | 7.88K | ± 103.10 | ops/s | 9.5x slower |
| simpleclientNoLabelsInc | 7.62K | ± 25.56 | ops/s | 9.8x slower |
| openTelemetryAdd | 6.45K | ± 39.82 | ops/s | 12x slower |
| openTelemetryIncNoLabels | 6.31K | ± 1.43K | ops/s | 12x slower |
| openTelemetryInc | 5.86K | ± 1.39K | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 8.34K | ± 1.77K | ops/s | **fastest** |
| simpleclient | 5.67K | ± 82.76 | ops/s | 1.5x slower |
| prometheusNative | 3.86K | ± 324.72 | ops/s | 2.2x slower |
| openTelemetryClassic | 913.33 | ± 29.42 | ops/s | 9.1x slower |
| openTelemetryExponential | 686.32 | ± 10.19 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 35.43K | ± 237.79 | ops/s | **fastest** |
| openMetricsWriteToNull | 34.96K | ± 373.22 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 686.79K | ± 2.48K | ops/s | **fastest** |
| prometheusWriteToByteArray | 669.13K | ± 1.79K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 642.39K | ± 4.65K | ops/s | 1.1x slower |
| openMetricsWriteToNull | 641.26K | ± 3.30K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      56761.632    ± 216.299  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       6448.885     ± 39.824  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5864.973   ± 1388.654  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       6310.154   ± 1429.765  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      63525.753   ± 1188.911  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      74630.333   ± 2189.975  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      66799.069   ± 1071.089  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7878.696    ± 103.104  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7932.619    ± 117.325  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7623.680     ± 25.558  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        913.328     ± 29.417  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        686.319     ± 10.190  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       8344.218   ± 1773.331  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3863.032    ± 324.720  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5665.685     ± 82.759  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      34955.810    ± 373.218  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      35429.132    ± 237.793  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     642393.760   ± 4654.271  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     641257.635   ± 3295.161  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     669134.348   ± 1791.062  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     686789.678   ± 2480.863  ops/s
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

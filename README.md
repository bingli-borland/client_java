# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-16T10:36:58Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) 6975P-C, 4 cores, 15 GB RAM
- **OS:** Linux 7.0.0-1014-aws

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusAdd | 33.68K | ± 704.55 | ops/s | **fastest** |
| prometheusInc | 33.06K | ± 81.99 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 32.75K | ± 554.38 | ops/s | 1.0x slower |
| prometheusNoLabelsInc | 32.50K | ± 1.16K | ops/s | 1.0x slower |
| simpleclientNoLabelsInc | 7.53K | ± 90.82 | ops/s | 4.5x slower |
| simpleclientInc | 7.52K | ± 88.76 | ops/s | 4.5x slower |
| simpleclientAdd | 7.52K | ± 116.62 | ops/s | 4.5x slower |
| openTelemetryInc | 2.66K | ± 529.83 | ops/s | 13x slower |
| openTelemetryIncNoLabels | 2.64K | ± 513.21 | ops/s | 13x slower |
| openTelemetryAdd | 2.48K | ± 601.30 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 5.33K | ± 50.04 | ops/s | **fastest** |
| prometheusClassic | 2.61K | ± 359.21 | ops/s | 2.0x slower |
| prometheusNative | 2.10K | ± 255.92 | ops/s | 2.5x slower |
| openTelemetryClassic | 384.31 | ± 31.51 | ops/s | 14x slower |
| openTelemetryExponential | 307.52 | ± 24.48 | ops/s | 17x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 24.21K | ± 133.81 | ops/s | **fastest** |
| prometheusWriteToNull | 24.09K | ± 59.36 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 426.19K | ± 1.84K | ops/s | **fastest** |
| prometheusWriteToNull | 425.33K | ± 2.50K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 405.88K | ± 14.29K | ops/s | 1.1x slower |
| openMetricsWriteToNull | 398.77K | ± 3.24K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      32754.948    ± 554.381  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2478.440    ± 601.303  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2660.179    ± 529.828  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2641.613    ± 513.210  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      33679.757    ± 704.552  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      33061.850     ± 81.992  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      32503.847   ± 1163.943  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7517.715    ± 116.621  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7520.716     ± 88.765  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7525.284     ± 90.820  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        384.308     ± 31.512  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        307.519     ± 24.480  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2613.174    ± 359.205  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2097.968    ± 255.918  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5329.799     ± 50.040  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      24207.366    ± 133.806  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24091.007     ± 59.358  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     405881.963  ± 14286.965  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     398769.987   ± 3236.836  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     426188.472   ± 1840.547  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     425330.265   ± 2495.973  ops/s
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

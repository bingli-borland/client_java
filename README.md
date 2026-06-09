# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-09T07:33:21Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1015-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.99K | ± 1.33K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.65K | ± 449.29 | ops/s | 1.1x slower |
| prometheusAdd | 50.54K | ± 1.20K | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.54K | ± 897.37 | ops/s | 1.3x slower |
| simpleclientInc | 6.53K | ± 40.58 | ops/s | 10.0x slower |
| simpleclientAdd | 6.46K | ± 11.07 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.36K | ± 25.73 | ops/s | 10x slower |
| openTelemetryInc | 3.44K | ± 429.54 | ops/s | 19x slower |
| openTelemetryAdd | 3.25K | ± 185.79 | ops/s | 20x slower |
| openTelemetryIncNoLabels | 3.02K | ± 74.51 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.97K | ± 1.19K | ops/s | **fastest** |
| simpleclient | 4.39K | ± 27.43 | ops/s | 1.4x slower |
| prometheusNative | 2.85K | ± 248.68 | ops/s | 2.1x slower |
| openTelemetryClassic | 798.69 | ± 27.77 | ops/s | 7.5x slower |
| openTelemetryExponential | 647.99 | ± 74.45 | ops/s | 9.2x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.47K | ± 1.21K | ops/s | **fastest** |
| openMetricsWriteToNull | 22.99K | ± 497.74 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 506.14K | ± 5.09K | ops/s | **fastest** |
| prometheusWriteToByteArray | 501.12K | ± 2.87K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 482.01K | ± 2.10K | ops/s | 1.1x slower |
| openMetricsWriteToNull | 476.64K | ± 8.20K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49543.326    ± 897.369  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3250.798    ± 185.793  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3438.876    ± 429.541  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3020.305     ± 74.511  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50543.744   ± 1204.026  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64987.551   ± 1332.168  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56649.353    ± 449.293  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6456.085     ± 11.071  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6527.863     ± 40.583  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6362.980     ± 25.732  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        798.691     ± 27.769  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        647.987     ± 74.451  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5966.564   ± 1186.343  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2846.715    ± 248.677  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4387.254     ± 27.427  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      22985.135    ± 497.737  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23471.656   ± 1214.383  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     482013.092   ± 2096.690  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     476635.128   ± 8200.563  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     501122.218   ± 2868.816  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     506138.764   ± 5091.965  ops/s
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

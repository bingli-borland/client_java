# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-15T06:14:25Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** INTEL(R) XEON(R) PLATINUM 8573C, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| codahaleIncNoLabels | 27.21K | ± 431.28 | ops/s | **fastest** |
| prometheusNoLabelsInc | 26.78K | ± 62.67 | ops/s | 1.0x slower |
| prometheusInc | 26.62K | ± 26.95 | ops/s | 1.0x slower |
| prometheusAdd | 25.62K | ± 785.84 | ops/s | 1.1x slower |
| simpleclientInc | 6.76K | ± 40.81 | ops/s | 4.0x slower |
| simpleclientNoLabelsInc | 6.63K | ± 13.30 | ops/s | 4.1x slower |
| simpleclientAdd | 6.58K | ± 18.53 | ops/s | 4.1x slower |
| openTelemetryIncNoLabels | 2.23K | ± 196.43 | ops/s | 12x slower |
| openTelemetryInc | 2.20K | ± 311.27 | ops/s | 12x slower |
| openTelemetryAdd | 1.81K | ± 211.76 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.37K | ± 19.13 | ops/s | **fastest** |
| prometheusClassic | 2.53K | ± 462.36 | ops/s | 1.7x slower |
| prometheusNative | 2.26K | ± 171.11 | ops/s | 1.9x slower |
| openTelemetryClassic | 452.50 | ± 22.47 | ops/s | 9.6x slower |
| openTelemetryExponential | 339.85 | ± 8.06 | ops/s | 13x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 17.94K | ± 48.37 | ops/s | **fastest** |
| openMetricsWriteToNull | 17.93K | ± 21.78 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 305.02K | ± 1.93K | ops/s | **fastest** |
| prometheusWriteToByteArray | 301.81K | ± 1.99K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 286.42K | ± 1.41K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 283.64K | ± 1.40K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      27213.711    ± 431.282  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       1811.136    ± 211.764  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2201.486    ± 311.269  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2233.586    ± 196.426  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      25623.284    ± 785.843  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      26621.272     ± 26.946  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      26779.803     ± 62.669  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6577.402     ± 18.525  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6761.208     ± 40.815  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6631.849     ± 13.298  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        452.497     ± 22.472  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        339.852      ± 8.059  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2529.724    ± 462.357  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2261.877    ± 171.106  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4365.759     ± 19.133  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      17927.860     ± 21.776  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      17940.127     ± 48.375  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     283636.505   ± 1400.549  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     286420.861   ± 1413.371  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     301814.911   ± 1992.556  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     305018.181   ± 1930.302  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-02T10:27:06Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 76.87K | ± 499.89 | ops/s | **fastest** |
| prometheusNoLabelsInc | 65.00K | ± 2.22K | ops/s | 1.2x slower |
| prometheusAdd | 62.21K | ± 480.63 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 56.92K | ± 405.31 | ops/s | 1.4x slower |
| simpleclientInc | 7.86K | ± 32.70 | ops/s | 9.8x slower |
| simpleclientAdd | 7.65K | ± 270.10 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 7.45K | ± 112.17 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 6.91K | ± 1.51K | ops/s | 11x slower |
| openTelemetryInc | 6.18K | ± 1.41K | ops/s | 12x slower |
| openTelemetryAdd | 4.67K | ± 129.61 | ops/s | 16x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 8.53K | ± 3.71K | ops/s | **fastest** |
| simpleclient | 5.48K | ± 115.02 | ops/s | 1.6x slower |
| prometheusNative | 3.62K | ± 338.42 | ops/s | 2.4x slower |
| openTelemetryClassic | 972.71 | ± 36.19 | ops/s | 8.8x slower |
| openTelemetryExponential | 690.61 | ± 12.47 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 35.20K | ± 192.94 | ops/s | **fastest** |
| openMetricsWriteToNull | 34.29K | ± 340.43 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 681.93K | ± 13.64K | ops/s | **fastest** |
| openMetricsWriteToNull | 638.48K | ± 3.61K | ops/s | 1.1x slower |
| prometheusWriteToByteArray | 636.69K | ± 33.88K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 621.69K | ± 7.38K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      56916.082    ± 405.313  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4670.870    ± 129.607  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       6177.018   ± 1410.997  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       6907.861   ± 1512.948  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      62205.549    ± 480.633  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      76867.814    ± 499.887  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      65004.298   ± 2218.088  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7649.131    ± 270.104  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7860.985     ± 32.697  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7453.846    ± 112.168  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        972.708     ± 36.192  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        690.612     ± 12.467  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       8534.152   ± 3710.499  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3618.007    ± 338.419  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5483.516    ± 115.020  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      34290.000    ± 340.428  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      35200.998    ± 192.938  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     621692.571   ± 7380.587  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     638476.992   ± 3612.786  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     636690.125  ± 33879.244  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     681929.648  ± 13640.169  ops/s
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

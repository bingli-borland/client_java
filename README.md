# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-17T06:36:40Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 77.57K | ± 1.42K | ops/s | **fastest** |
| prometheusNoLabelsInc | 65.06K | ± 3.32K | ops/s | 1.2x slower |
| prometheusAdd | 62.57K | ± 1.38K | ops/s | 1.2x slower |
| codahaleIncNoLabels | 54.52K | ± 1.16K | ops/s | 1.4x slower |
| simpleclientInc | 7.99K | ± 139.11 | ops/s | 9.7x slower |
| simpleclientNoLabelsInc | 7.79K | ± 198.41 | ops/s | 10.0x slower |
| simpleclientAdd | 7.74K | ± 169.36 | ops/s | 10x slower |
| openTelemetryInc | 6.84K | ± 1.40K | ops/s | 11x slower |
| openTelemetryIncNoLabels | 5.93K | ± 1.41K | ops/s | 13x slower |
| openTelemetryAdd | 5.84K | ± 984.18 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 8.36K | ± 3.14K | ops/s | **fastest** |
| simpleclient | 5.64K | ± 91.02 | ops/s | 1.5x slower |
| prometheusNative | 3.56K | ± 174.36 | ops/s | 2.3x slower |
| openTelemetryClassic | 897.19 | ± 19.53 | ops/s | 9.3x slower |
| openTelemetryExponential | 701.79 | ± 11.80 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 35.26K | ± 304.12 | ops/s | **fastest** |
| openMetricsWriteToNull | 33.89K | ± 1.16K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 700.89K | ± 11.59K | ops/s | **fastest** |
| prometheusWriteToByteArray | 685.12K | ± 7.25K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 665.06K | ± 6.04K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 649.51K | ± 6.53K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      54515.713   ± 1160.362  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       5842.098    ± 984.181  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       6838.953   ± 1404.315  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5931.224   ± 1405.930  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      62565.238   ± 1379.620  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      77574.483   ± 1422.253  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      65064.905   ± 3320.776  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7738.808    ± 169.361  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7985.069    ± 139.107  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7791.086    ± 198.414  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        897.191     ± 19.531  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        701.794     ± 11.798  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       8363.571   ± 3137.779  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3560.874    ± 174.361  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5642.068     ± 91.016  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      33892.456   ± 1155.685  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      35256.978    ± 304.120  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     649511.709   ± 6534.865  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     665057.496   ± 6044.840  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     685116.532   ± 7248.048  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     700888.507  ± 11593.028  ops/s
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

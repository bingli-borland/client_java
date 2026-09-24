# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-24T08:46:17Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.19K | ± 289.98 | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.50K | ± 2.62K | ops/s | 1.2x slower |
| prometheusAdd | 51.41K | ± 325.66 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.61K | ± 1.58K | ops/s | 1.3x slower |
| simpleclientInc | 6.53K | ± 49.55 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.45K | ± 135.54 | ops/s | 10x slower |
| simpleclientAdd | 6.39K | ± 57.12 | ops/s | 10x slower |
| openTelemetryAdd | 3.38K | ± 575.05 | ops/s | 20x slower |
| openTelemetryIncNoLabels | 3.25K | ± 605.74 | ops/s | 20x slower |
| openTelemetryInc | 3.21K | ± 418.08 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.37K | ± 1.23K | ops/s | **fastest** |
| simpleclient | 4.38K | ± 21.02 | ops/s | 1.2x slower |
| prometheusNative | 3.05K | ± 198.80 | ops/s | 1.8x slower |
| openTelemetryClassic | 764.80 | ± 66.22 | ops/s | 7.0x slower |
| openTelemetryExponential | 697.89 | ± 60.87 | ops/s | 7.7x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.09K | ± 595.34 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.98K | ± 373.04 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 505.20K | ± 2.86K | ops/s | **fastest** |
| prometheusWriteToByteArray | 494.54K | ± 4.13K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 481.55K | ± 1.21K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 477.52K | ± 2.21K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49612.163   ± 1580.430  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3379.253    ± 575.054  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3208.107    ± 418.083  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3249.184    ± 605.740  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51407.637    ± 325.665  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66194.667    ± 289.978  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55499.697   ± 2622.919  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6391.523     ± 57.119  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6533.629     ± 49.551  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6449.022    ± 135.541  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        764.801     ± 66.224  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        697.885     ± 60.869  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5374.583   ± 1231.041  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3053.016    ± 198.799  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4381.223     ± 21.018  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23982.299    ± 373.044  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24092.134    ± 595.342  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     477516.850   ± 2211.869  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     481549.417   ± 1213.657  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     494540.082   ± 4127.066  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     505199.062   ± 2855.427  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-12T05:30:41Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.31K | ± 334.11 | ops/s | **fastest** |
| prometheusNoLabelsInc | 54.84K | ± 1.39K | ops/s | 1.2x slower |
| prometheusAdd | 51.44K | ± 300.96 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.42K | ± 1.08K | ops/s | 1.3x slower |
| simpleclientInc | 6.56K | ± 36.83 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.36K | ± 38.25 | ops/s | 10x slower |
| simpleclientAdd | 6.22K | ± 173.53 | ops/s | 11x slower |
| openTelemetryAdd | 3.24K | ± 554.22 | ops/s | 20x slower |
| openTelemetryIncNoLabels | 3.19K | ± 337.76 | ops/s | 21x slower |
| openTelemetryInc | 3.04K | ± 275.49 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.03K | ± 1.72K | ops/s | **fastest** |
| simpleclient | 4.43K | ± 73.77 | ops/s | 1.4x slower |
| prometheusNative | 3.09K | ± 105.53 | ops/s | 2.0x slower |
| openTelemetryClassic | 756.70 | ± 24.05 | ops/s | 8.0x slower |
| openTelemetryExponential | 662.57 | ± 69.04 | ops/s | 9.1x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.45K | ± 624.60 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.01K | ± 1.21K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 493.67K | ± 3.79K | ops/s | **fastest** |
| prometheusWriteToByteArray | 487.41K | ± 6.48K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 472.70K | ± 6.59K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 470.51K | ± 7.81K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49422.424   ± 1078.658  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3239.198    ± 554.221  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3040.636    ± 275.490  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3190.904    ± 337.758  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51437.229    ± 300.964  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66305.977    ± 334.114  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      54842.658   ± 1391.466  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6218.900    ± 173.529  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6559.610     ± 36.835  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6358.510     ± 38.247  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        756.697     ± 24.047  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        662.574     ± 69.036  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6028.567   ± 1716.323  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3089.494    ± 105.526  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4426.610     ± 73.775  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23006.294   ± 1213.123  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23452.944    ± 624.596  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     470505.648   ± 7810.637  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     472698.012   ± 6586.063  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     487405.805   ± 6481.941  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     493673.000   ± 3785.385  ops/s
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

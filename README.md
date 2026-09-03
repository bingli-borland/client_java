# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-03T08:21:10Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.24K | ± 469.41 | ops/s | **fastest** |
| prometheusNoLabelsInc | 52.07K | ± 898.48 | ops/s | 1.1x slower |
| prometheusAdd | 46.79K | ± 2.70K | ops/s | 1.3x slower |
| codahaleIncNoLabels | 43.76K | ± 282.48 | ops/s | 1.4x slower |
| simpleclientInc | 6.13K | ± 55.32 | ops/s | 9.7x slower |
| simpleclientAdd | 5.99K | ± 186.25 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 5.88K | ± 23.98 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 4.88K | ± 1.77K | ops/s | 12x slower |
| openTelemetryInc | 4.43K | ± 1.19K | ops/s | 13x slower |
| openTelemetryAdd | 3.30K | ± 159.50 | ops/s | 18x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.09K | ± 1.75K | ops/s | **fastest** |
| simpleclient | 4.44K | ± 149.35 | ops/s | 1.4x slower |
| prometheusNative | 2.97K | ± 282.00 | ops/s | 2.1x slower |
| openTelemetryClassic | 659.57 | ± 19.35 | ops/s | 9.2x slower |
| openTelemetryExponential | 530.33 | ± 10.94 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.64K | ± 197.60 | ops/s | **fastest** |
| openMetricsWriteToNull | 26.89K | ± 597.65 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 578.95K | ± 7.76K | ops/s | **fastest** |
| prometheusWriteToByteArray | 570.36K | ± 11.22K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 539.76K | ± 8.87K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 533.06K | ± 7.40K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43761.255    ± 282.476  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3303.388    ± 159.497  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4431.834   ± 1191.590  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4881.704   ± 1772.868  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      46785.525   ± 2699.813  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59237.313    ± 469.408  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      52069.849    ± 898.477  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5992.269    ± 186.251  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6134.981     ± 55.317  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5881.017     ± 23.981  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        659.571     ± 19.346  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        530.329     ± 10.939  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6094.228   ± 1749.300  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2966.149    ± 281.997  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4441.001    ± 149.354  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      26894.895    ± 597.649  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27639.897    ± 197.599  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     533057.711   ± 7395.680  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     539756.147   ± 8869.490  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     570358.902  ± 11221.640  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     578945.346   ± 7763.185  ops/s
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

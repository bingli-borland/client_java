# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-10T07:55:40Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.24K | ± 1.04K | ops/s | **fastest** |
| prometheusNoLabelsInc | 49.96K | ± 2.37K | ops/s | 1.2x slower |
| prometheusAdd | 47.65K | ± 437.70 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 40.57K | ± 5.70K | ops/s | 1.5x slower |
| simpleclientInc | 6.09K | ± 8.18 | ops/s | 9.7x slower |
| simpleclientAdd | 6.08K | ± 176.65 | ops/s | 9.7x slower |
| simpleclientNoLabelsInc | 6.04K | ± 160.88 | ops/s | 9.8x slower |
| openTelemetryIncNoLabels | 4.93K | ± 885.95 | ops/s | 12x slower |
| openTelemetryInc | 4.64K | ± 1.12K | ops/s | 13x slower |
| openTelemetryAdd | 4.32K | ± 930.36 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.56K | ± 2.00K | ops/s | **fastest** |
| simpleclient | 4.57K | ± 72.86 | ops/s | 1.7x slower |
| prometheusNative | 3.02K | ± 143.10 | ops/s | 2.5x slower |
| openTelemetryClassic | 695.52 | ± 10.10 | ops/s | 11x slower |
| openTelemetryExponential | 536.42 | ± 19.49 | ops/s | 14x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.34K | ± 310.14 | ops/s | **fastest** |
| openMetricsWriteToNull | 26.08K | ± 1.83K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 575.76K | ± 7.40K | ops/s | **fastest** |
| prometheusWriteToByteArray | 566.19K | ± 11.03K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 546.53K | ± 8.55K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 534.62K | ± 1.97K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      40566.097   ± 5704.144  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4324.574    ± 930.362  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4635.926   ± 1117.278  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4932.240    ± 885.948  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      47647.417    ± 437.695  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59239.485   ± 1040.925  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      49964.102   ± 2370.155  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6076.749    ± 176.647  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6085.970      ± 8.185  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6040.129    ± 160.876  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        695.524     ± 10.099  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        536.417     ± 19.494  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7564.560   ± 1996.025  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3023.399    ± 143.099  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4571.461     ± 72.858  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      26080.879   ± 1834.503  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27336.873    ± 310.141  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     534618.298   ± 1968.855  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     546533.228   ± 8551.206  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     566185.403  ± 11028.350  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     575758.327   ± 7403.756  ops/s
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

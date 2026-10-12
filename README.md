# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-12T10:13:12Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.04K | ± 1.43K | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.97K | ± 597.41 | ops/s | 1.1x slower |
| prometheusAdd | 48.29K | ± 1.11K | ops/s | 1.2x slower |
| codahaleIncNoLabels | 42.66K | ± 1.92K | ops/s | 1.4x slower |
| simpleclientAdd | 6.16K | ± 23.78 | ops/s | 9.6x slower |
| simpleclientInc | 6.14K | ± 97.33 | ops/s | 9.6x slower |
| simpleclientNoLabelsInc | 5.90K | ± 14.98 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 4.95K | ± 1.63K | ops/s | 12x slower |
| openTelemetryAdd | 4.61K | ± 922.10 | ops/s | 13x slower |
| openTelemetryInc | 4.17K | ± 541.25 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.31K | ± 1.77K | ops/s | **fastest** |
| simpleclient | 4.58K | ± 54.82 | ops/s | 1.2x slower |
| prometheusNative | 3.07K | ± 283.59 | ops/s | 1.7x slower |
| openTelemetryClassic | 754.90 | ± 27.00 | ops/s | 7.0x slower |
| openTelemetryExponential | 585.25 | ± 31.05 | ops/s | 9.1x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.32K | ± 335.35 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.22K | ± 176.43 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 573.04K | ± 10.76K | ops/s | **fastest** |
| prometheusWriteToByteArray | 556.66K | ± 8.06K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 527.81K | ± 7.99K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 520.28K | ± 5.09K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      42661.481   ± 1921.550  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4610.716    ± 922.104  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4167.259    ± 541.253  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4950.566   ± 1627.218  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48293.570   ± 1112.563  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59035.453   ± 1426.591  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51969.738    ± 597.412  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6163.342     ± 23.784  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6142.501     ± 97.335  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5903.014     ± 14.983  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        754.901     ± 26.998  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        585.249     ± 31.048  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5313.362   ± 1765.332  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3073.990    ± 283.594  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4577.719     ± 54.824  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27219.184    ± 176.434  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27317.669    ± 335.345  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     520275.620   ± 5086.098  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     527805.579   ± 7988.312  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     556662.388   ± 8061.943  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     573040.289  ± 10762.697  ops/s
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

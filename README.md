# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-24T04:26:48Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.25K | ± 389.15 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.42K | ± 1.45K | ops/s | 1.2x slower |
| prometheusAdd | 48.23K | ± 287.53 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.10K | ± 55.80 | ops/s | 1.3x slower |
| simpleclientInc | 6.13K | ± 58.08 | ops/s | 9.7x slower |
| simpleclientNoLabelsInc | 5.90K | ± 5.12 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 5.62K | ± 1.34K | ops/s | 11x slower |
| simpleclientAdd | 5.60K | ± 167.37 | ops/s | 11x slower |
| openTelemetryInc | 4.04K | ± 256.79 | ops/s | 15x slower |
| openTelemetryAdd | 3.96K | ± 787.10 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.60K | ± 787.09 | ops/s | **fastest** |
| simpleclient | 4.40K | ± 43.35 | ops/s | 1.0x slower |
| prometheusNative | 2.95K | ± 242.07 | ops/s | 1.6x slower |
| openTelemetryClassic | 697.52 | ± 8.01 | ops/s | 6.6x slower |
| openTelemetryExponential | 573.42 | ± 21.40 | ops/s | 8.0x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.42K | ± 233.10 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.34K | ± 164.08 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 570.75K | ± 5.13K | ops/s | **fastest** |
| prometheusWriteToNull | 565.41K | ± 6.55K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 545.20K | ± 1.69K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 522.99K | ± 7.19K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44095.242     ± 55.797  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3957.747    ± 787.096  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4044.366    ± 256.794  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5622.588   ± 1337.692  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48233.740    ± 287.531  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59254.477    ± 389.155  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51418.522   ± 1454.978  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5603.032    ± 167.367  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6125.060     ± 58.080  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5897.551      ± 5.118  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        697.524      ± 8.007  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        573.417     ± 21.399  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4600.367    ± 787.087  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2952.600    ± 242.073  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4400.833     ± 43.351  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27336.537    ± 164.076  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27420.016    ± 233.101  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     522988.211   ± 7188.375  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     545197.101   ± 1687.513  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     570749.076   ± 5134.173  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     565410.440   ± 6549.894  ops/s
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

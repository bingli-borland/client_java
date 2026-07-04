# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-04T07:10:09Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.84K | ± 1.33K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.13K | ± 954.02 | ops/s | 1.2x slower |
| prometheusAdd | 51.26K | ± 134.71 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.14K | ± 1.22K | ops/s | 1.3x slower |
| simpleclientInc | 6.50K | ± 74.25 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.34K | ± 55.42 | ops/s | 10x slower |
| simpleclientAdd | 6.25K | ± 170.98 | ops/s | 10x slower |
| openTelemetryAdd | 3.33K | ± 368.37 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 3.25K | ± 179.22 | ops/s | 20x slower |
| openTelemetryInc | 3.06K | ± 62.04 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.20K | ± 2.06K | ops/s | **fastest** |
| simpleclient | 4.44K | ± 66.28 | ops/s | 1.4x slower |
| prometheusNative | 3.04K | ± 238.08 | ops/s | 2.0x slower |
| openTelemetryClassic | 768.38 | ± 15.84 | ops/s | 8.1x slower |
| openTelemetryExponential | 660.41 | ± 140.26 | ops/s | 9.4x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.88K | ± 1.24K | ops/s | **fastest** |
| openMetricsWriteToNull | 22.76K | ± 869.73 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 513.11K | ± 4.16K | ops/s | **fastest** |
| prometheusWriteToByteArray | 504.32K | ± 6.42K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 486.09K | ± 2.69K | ops/s | 1.1x slower |
| openMetricsWriteToNull | 484.64K | ± 3.89K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49144.179   ± 1224.937  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3329.456    ± 368.373  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3055.179     ± 62.039  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3253.284    ± 179.221  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51264.438    ± 134.705  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64835.970   ± 1326.788  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56132.482    ± 954.024  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6246.403    ± 170.983  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6496.185     ± 74.253  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6338.491     ± 55.422  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        768.378     ± 15.841  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        660.413    ± 140.257  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6195.300   ± 2055.576  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3039.198    ± 238.076  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4435.551     ± 66.283  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      22756.939    ± 869.732  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23879.506   ± 1235.187  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     486087.094   ± 2693.191  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     484639.957   ± 3888.465  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     504315.810   ± 6417.521  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     513114.132   ± 4160.394  ops/s
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

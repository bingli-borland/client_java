# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-22T04:17:21Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.84K | ± 443.91 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.96K | ± 175.00 | ops/s | 1.2x slower |
| prometheusAdd | 51.53K | ± 158.22 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 47.37K | ± 3.66K | ops/s | 1.4x slower |
| simpleclientInc | 6.51K | ± 117.19 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.42K | ± 138.42 | ops/s | 10x slower |
| simpleclientAdd | 6.29K | ± 266.36 | ops/s | 11x slower |
| openTelemetryInc | 3.44K | ± 68.52 | ops/s | 19x slower |
| openTelemetryAdd | 3.21K | ± 344.42 | ops/s | 21x slower |
| openTelemetryIncNoLabels | 2.92K | ± 272.74 | ops/s | 23x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.70K | ± 334.82 | ops/s | **fastest** |
| simpleclient | 4.51K | ± 12.64 | ops/s | 1.0x slower |
| prometheusNative | 2.88K | ± 249.54 | ops/s | 1.6x slower |
| openTelemetryClassic | 735.88 | ± 42.36 | ops/s | 6.4x slower |
| openTelemetryExponential | 661.92 | ± 76.65 | ops/s | 7.1x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.94K | ± 773.39 | ops/s | **fastest** |
| prometheusWriteToNull | 23.65K | ± 644.91 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 512.33K | ± 3.27K | ops/s | **fastest** |
| prometheusWriteToByteArray | 501.01K | ± 4.89K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 486.68K | ± 3.04K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 479.42K | ± 9.84K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      47369.884   ± 3661.975  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3213.049    ± 344.420  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3440.068     ± 68.524  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2924.520    ± 272.739  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51525.912    ± 158.220  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66836.116    ± 443.913  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56962.791    ± 175.000  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6286.526    ± 266.356  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6513.548    ± 117.192  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6419.503    ± 138.420  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        735.882     ± 42.362  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        661.923     ± 76.651  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4701.138    ± 334.822  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2878.876    ± 249.539  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4505.529     ± 12.638  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23939.090    ± 773.391  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23650.528    ± 644.910  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     479418.247   ± 9840.253  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     486683.194   ± 3037.218  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     501014.610   ± 4891.019  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     512333.023   ± 3271.115  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-20T08:39:27Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) Platinum 8370C CPU @ 2.80GHz, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 31.47K | ± 42.08 | ops/s | **fastest** |
| prometheusNoLabelsInc | 30.60K | ± 1.03K | ops/s | 1.0x slower |
| codahaleIncNoLabels | 30.03K | ± 1.02K | ops/s | 1.0x slower |
| prometheusAdd | 27.10K | ± 1.57K | ops/s | 1.2x slower |
| simpleclientInc | 6.28K | ± 75.77 | ops/s | 5.0x slower |
| simpleclientNoLabelsInc | 5.93K | ± 152.53 | ops/s | 5.3x slower |
| simpleclientAdd | 5.92K | ± 284.92 | ops/s | 5.3x slower |
| openTelemetryInc | 2.60K | ± 95.64 | ops/s | 12x slower |
| openTelemetryIncNoLabels | 2.58K | ± 125.73 | ops/s | 12x slower |
| openTelemetryAdd | 2.27K | ± 74.74 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.38K | ± 1.82K | ops/s | **fastest** |
| simpleclient | 4.08K | ± 150.38 | ops/s | 1.1x slower |
| prometheusNative | 2.21K | ± 312.90 | ops/s | 2.0x slower |
| openTelemetryClassic | 613.53 | ± 21.75 | ops/s | 7.1x slower |
| openTelemetryExponential | 449.40 | ± 15.56 | ops/s | 9.7x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 18.13K | ± 91.04 | ops/s | **fastest** |
| openMetricsWriteToNull | 18.10K | ± 152.36 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 312.98K | ± 4.61K | ops/s | **fastest** |
| prometheusWriteToByteArray | 305.33K | ± 3.60K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 290.33K | ± 3.23K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 290.22K | ± 2.43K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      30033.619   ± 1020.812  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2266.005     ± 74.740  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2600.685     ± 95.640  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2577.143    ± 125.730  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      27100.753   ± 1569.799  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      31470.483     ± 42.081  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      30600.812   ± 1032.078  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5923.109    ± 284.921  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6284.942     ± 75.768  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5934.590    ± 152.527  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        613.528     ± 21.748  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        449.403     ± 15.560  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4380.273   ± 1822.695  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2206.436    ± 312.900  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4081.277    ± 150.384  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      18099.193    ± 152.364  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      18132.259     ± 91.042  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     290216.328   ± 2428.793  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     290331.221   ± 3226.473  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     305330.026   ± 3601.794  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     312979.501   ± 4608.703  ops/s
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

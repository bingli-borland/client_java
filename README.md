# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-14T10:06:14Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) Platinum 8370C CPU @ 2.80GHz, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 30.66K | ± 1.39K | ops/s | **fastest** |
| prometheusNoLabelsInc | 30.46K | ± 1.06K | ops/s | 1.0x slower |
| codahaleIncNoLabels | 29.58K | ± 725.98 | ops/s | 1.0x slower |
| prometheusAdd | 27.69K | ± 713.52 | ops/s | 1.1x slower |
| simpleclientInc | 6.24K | ± 82.79 | ops/s | 4.9x slower |
| simpleclientNoLabelsInc | 6.11K | ± 224.36 | ops/s | 5.0x slower |
| simpleclientAdd | 5.97K | ± 100.03 | ops/s | 5.1x slower |
| openTelemetryIncNoLabels | 2.85K | ± 201.94 | ops/s | 11x slower |
| openTelemetryInc | 2.64K | ± 193.23 | ops/s | 12x slower |
| openTelemetryAdd | 2.31K | ± 73.65 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 3.94K | ± 103.22 | ops/s | **fastest** |
| prometheusClassic | 2.90K | ± 256.25 | ops/s | 1.4x slower |
| prometheusNative | 1.90K | ± 135.29 | ops/s | 2.1x slower |
| openTelemetryClassic | 609.22 | ± 17.55 | ops/s | 6.5x slower |
| openTelemetryExponential | 441.53 | ± 15.93 | ops/s | 8.9x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 18.06K | ± 129.82 | ops/s | **fastest** |
| openMetricsWriteToNull | 17.93K | ± 130.19 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 290.17K | ± 6.93K | ops/s | **fastest** |
| prometheusWriteToNull | 289.62K | ± 8.44K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 272.26K | ± 4.89K | ops/s | 1.1x slower |
| openMetricsWriteToNull | 271.18K | ± 5.61K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      29579.003    ± 725.980  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2310.077     ± 73.647  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2641.171    ± 193.231  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2848.384    ± 201.940  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      27689.757    ± 713.521  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      30662.245   ± 1388.655  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      30457.318   ± 1059.338  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5970.733    ± 100.026  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6238.237     ± 82.788  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6105.648    ± 224.360  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        609.225     ± 17.551  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        441.528     ± 15.929  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2900.657    ± 256.246  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       1900.624    ± 135.286  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       3941.864    ± 103.225  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      17926.319    ± 130.186  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      18059.989    ± 129.822  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     272255.634   ± 4886.452  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     271176.209   ± 5605.468  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     290170.926   ± 6928.377  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     289624.514   ± 8437.228  ops/s
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

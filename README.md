# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-27T08:53:37Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.08K | ± 1.33K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.09K | ± 909.55 | ops/s | 1.2x slower |
| prometheusAdd | 50.81K | ± 374.62 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.54K | ± 1.47K | ops/s | 1.3x slower |
| simpleclientInc | 6.59K | ± 83.36 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 6.50K | ± 129.88 | ops/s | 10x slower |
| simpleclientAdd | 6.44K | ± 27.72 | ops/s | 10x slower |
| openTelemetryAdd | 3.62K | ± 350.35 | ops/s | 18x slower |
| openTelemetryIncNoLabels | 3.42K | ± 613.63 | ops/s | 19x slower |
| openTelemetryInc | 3.01K | ± 184.07 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.56K | ± 892.74 | ops/s | **fastest** |
| simpleclient | 4.40K | ± 38.67 | ops/s | 1.5x slower |
| prometheusNative | 2.85K | ± 263.46 | ops/s | 2.3x slower |
| openTelemetryClassic | 774.19 | ± 15.74 | ops/s | 8.5x slower |
| openTelemetryExponential | 651.16 | ± 53.79 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.89K | ± 463.00 | ops/s | **fastest** |
| prometheusWriteToNull | 23.39K | ± 800.10 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 512.68K | ± 7.99K | ops/s | **fastest** |
| prometheusWriteToByteArray | 499.44K | ± 7.55K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 485.24K | ± 2.37K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 482.77K | ± 4.24K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48537.992   ± 1466.554  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3615.164    ± 350.355  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3014.050    ± 184.069  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3416.786    ± 613.627  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50813.497    ± 374.618  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65078.038   ± 1325.325  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56088.263    ± 909.550  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6444.185     ± 27.719  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6586.012     ± 83.362  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6501.904    ± 129.877  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        774.187     ± 15.742  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        651.165     ± 53.793  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6561.120    ± 892.741  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2850.511    ± 263.464  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4400.577     ± 38.668  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23893.652    ± 463.001  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23386.346    ± 800.102  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     482768.471   ± 4238.038  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     485239.515   ± 2370.181  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     499441.101   ± 7547.284  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     512678.079   ± 7990.644  ops/s
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

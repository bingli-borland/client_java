# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-24T07:30:41Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) Platinum 8370C CPU @ 2.80GHz, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 30.70K | ± 1.25K | ops/s | **fastest** |
| prometheusNoLabelsInc | 30.69K | ± 1.01K | ops/s | 1.0x slower |
| prometheusAdd | 27.98K | ± 510.67 | ops/s | 1.1x slower |
| codahaleIncNoLabels | 27.06K | ± 3.94K | ops/s | 1.1x slower |
| simpleclientInc | 6.80K | ± 250.05 | ops/s | 4.5x slower |
| simpleclientNoLabelsInc | 6.52K | ± 159.08 | ops/s | 4.7x slower |
| simpleclientAdd | 6.44K | ± 239.20 | ops/s | 4.8x slower |
| openTelemetryIncNoLabels | 2.86K | ± 100.25 | ops/s | 11x slower |
| openTelemetryInc | 2.74K | ± 157.63 | ops/s | 11x slower |
| openTelemetryAdd | 2.51K | ± 211.10 | ops/s | 12x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.49K | ± 47.82 | ops/s | **fastest** |
| prometheusClassic | 3.03K | ± 416.07 | ops/s | 1.5x slower |
| prometheusNative | 1.97K | ± 65.29 | ops/s | 2.3x slower |
| openTelemetryClassic | 605.78 | ± 12.06 | ops/s | 7.4x slower |
| openTelemetryExponential | 420.85 | ± 6.53 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 18.12K | ± 156.62 | ops/s | **fastest** |
| openMetricsWriteToNull | 18.05K | ± 152.95 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 313.09K | ± 4.05K | ops/s | **fastest** |
| prometheusWriteToNull | 312.57K | ± 3.02K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 291.41K | ± 2.05K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 290.05K | ± 2.03K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      27056.411   ± 3940.908  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2508.747    ± 211.097  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2740.518    ± 157.632  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2858.959    ± 100.247  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      27982.560    ± 510.672  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      30696.946   ± 1251.395  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      30685.054   ± 1009.853  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6444.355    ± 239.201  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6800.362    ± 250.046  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6521.432    ± 159.080  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        605.778     ± 12.059  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        420.850      ± 6.527  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       3034.370    ± 416.075  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       1969.199     ± 65.289  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4489.645     ± 47.823  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      18048.524    ± 152.951  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      18115.552    ± 156.619  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     290046.308   ± 2031.832  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     291408.616   ± 2051.382  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     313088.518   ± 4051.765  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     312570.014   ± 3024.496  ops/s
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

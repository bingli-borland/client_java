# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-10T08:29:26Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) Platinum 8370C CPU @ 2.80GHz, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 31.42K | ± 49.19 | ops/s | **fastest** |
| prometheusNoLabelsInc | 31.29K | ± 174.36 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 30.35K | ± 1.07K | ops/s | 1.0x slower |
| prometheusAdd | 27.05K | ± 1.34K | ops/s | 1.2x slower |
| simpleclientInc | 6.80K | ± 118.22 | ops/s | 4.6x slower |
| simpleclientNoLabelsInc | 6.54K | ± 53.50 | ops/s | 4.8x slower |
| simpleclientAdd | 6.37K | ± 317.97 | ops/s | 4.9x slower |
| openTelemetryInc | 2.90K | ± 37.97 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 2.65K | ± 144.25 | ops/s | 12x slower |
| openTelemetryAdd | 2.65K | ± 72.45 | ops/s | 12x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.50K | ± 35.80 | ops/s | **fastest** |
| prometheusClassic | 3.01K | ± 628.17 | ops/s | 1.5x slower |
| prometheusNative | 2.25K | ± 72.82 | ops/s | 2.0x slower |
| openTelemetryClassic | 574.22 | ± 28.81 | ops/s | 7.8x slower |
| openTelemetryExponential | 418.59 | ± 22.95 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 18.28K | ± 78.23 | ops/s | **fastest** |
| openMetricsWriteToNull | 18.17K | ± 166.66 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 314.15K | ± 1.96K | ops/s | **fastest** |
| prometheusWriteToByteArray | 310.06K | ± 4.47K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 291.14K | ± 1.09K | ops/s | 1.1x slower |
| openMetricsWriteToNull | 288.68K | ± 4.73K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      30345.166   ± 1068.052  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2649.953     ± 72.450  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2896.705     ± 37.970  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2651.119    ± 144.253  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      27048.094   ± 1340.224  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      31416.776     ± 49.194  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      31290.073    ± 174.356  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6369.947    ± 317.967  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6801.727    ± 118.223  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6543.918     ± 53.497  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        574.219     ± 28.806  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        418.585     ± 22.947  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       3005.004    ± 628.171  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2246.766     ± 72.819  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4504.963     ± 35.798  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      18166.340    ± 166.659  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      18276.551     ± 78.227  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     291137.011   ± 1089.329  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     288684.661   ± 4725.428  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     310064.388   ± 4472.895  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     314150.068   ± 1959.308  ops/s
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

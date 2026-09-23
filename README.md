# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-23T08:54:17Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** INTEL(R) XEON(R) PLATINUM 8573C, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| codahaleIncNoLabels | 27.17K | ± 788.99 | ops/s | **fastest** |
| prometheusNoLabelsInc | 26.72K | ± 40.50 | ops/s | 1.0x slower |
| prometheusInc | 26.55K | ± 48.68 | ops/s | 1.0x slower |
| prometheusAdd | 25.96K | ± 107.80 | ops/s | 1.0x slower |
| simpleclientInc | 6.78K | ± 21.82 | ops/s | 4.0x slower |
| simpleclientNoLabelsInc | 6.60K | ± 13.66 | ops/s | 4.1x slower |
| simpleclientAdd | 6.56K | ± 206.96 | ops/s | 4.1x slower |
| openTelemetryAdd | 2.29K | ± 406.35 | ops/s | 12x slower |
| openTelemetryInc | 2.20K | ± 350.24 | ops/s | 12x slower |
| openTelemetryIncNoLabels | 2.17K | ± 239.82 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.36K | ± 17.09 | ops/s | **fastest** |
| prometheusClassic | 3.08K | ± 571.65 | ops/s | 1.4x slower |
| prometheusNative | 2.04K | ± 416.50 | ops/s | 2.1x slower |
| openTelemetryClassic | 445.69 | ± 19.58 | ops/s | 9.8x slower |
| openTelemetryExponential | 344.06 | ± 36.72 | ops/s | 13x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 17.89K | ± 75.88 | ops/s | **fastest** |
| openMetricsWriteToNull | 17.85K | ± 66.69 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 300.65K | ± 2.52K | ops/s | **fastest** |
| prometheusWriteToByteArray | 299.19K | ± 1.58K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 282.32K | ± 2.04K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 281.54K | ± 2.21K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      27166.995    ± 788.992  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2287.644    ± 406.348  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2201.193    ± 350.235  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2172.860    ± 239.822  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      25956.405    ± 107.797  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      26554.668     ± 48.676  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      26716.098     ± 40.502  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6558.391    ± 206.958  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6779.628     ± 21.817  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6601.642     ± 13.664  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        445.690     ± 19.578  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        344.064     ± 36.722  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       3081.594    ± 571.652  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2035.697    ± 416.501  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4364.516     ± 17.090  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      17850.962     ± 66.687  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      17887.378     ± 75.885  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     281540.563   ± 2205.447  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     282320.864   ± 2037.005  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     299193.641   ± 1583.859  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     300652.586   ± 2515.260  ops/s
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

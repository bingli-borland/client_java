# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-02T08:06:22Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) Platinum 8370C CPU @ 2.80GHz, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1015-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 31.51K | ± 25.80 | ops/s | **fastest** |
| prometheusNoLabelsInc | 31.14K | ± 314.42 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 29.66K | ± 817.96 | ops/s | 1.1x slower |
| prometheusAdd | 28.45K | ± 89.19 | ops/s | 1.1x slower |
| simpleclientInc | 6.94K | ± 36.60 | ops/s | 4.5x slower |
| simpleclientAdd | 6.62K | ± 49.70 | ops/s | 4.8x slower |
| simpleclientNoLabelsInc | 6.59K | ± 64.90 | ops/s | 4.8x slower |
| openTelemetryIncNoLabels | 2.75K | ± 229.40 | ops/s | 11x slower |
| openTelemetryAdd | 2.59K | ± 92.37 | ops/s | 12x slower |
| openTelemetryInc | 2.57K | ± 216.05 | ops/s | 12x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.40K | ± 164.56 | ops/s | **fastest** |
| prometheusClassic | 2.65K | ± 405.41 | ops/s | 1.7x slower |
| prometheusNative | 2.28K | ± 257.25 | ops/s | 1.9x slower |
| openTelemetryClassic | 604.10 | ± 27.76 | ops/s | 7.3x slower |
| openTelemetryExponential | 433.84 | ± 12.21 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 18.19K | ± 91.28 | ops/s | **fastest** |
| openMetricsWriteToNull | 18.18K | ± 136.43 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 313.08K | ± 1.39K | ops/s | **fastest** |
| prometheusWriteToByteArray | 309.47K | ± 1.61K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 288.44K | ± 2.13K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 286.53K | ± 1.58K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      29656.245    ± 817.961  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2586.641     ± 92.374  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2571.098    ± 216.048  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2748.460    ± 229.399  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      28454.019     ± 89.192  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      31513.950     ± 25.803  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      31139.212    ± 314.419  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6620.093     ± 49.696  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6941.249     ± 36.605  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6591.697     ± 64.896  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        604.104     ± 27.761  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        433.840     ± 12.210  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2652.441    ± 405.412  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2280.734    ± 257.253  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4397.691    ± 164.563  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      18184.996    ± 136.434  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      18189.056     ± 91.279  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     286530.671   ± 1582.254  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     288435.916   ± 2126.202  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     309474.328   ± 1610.837  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     313081.011   ± 1392.140  ops/s
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

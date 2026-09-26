# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-26T08:40:18Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** INTEL(R) XEON(R) PLATINUM 8573C, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| codahaleIncNoLabels | 30.08K | ± 335.09 | ops/s | **fastest** |
| prometheusNoLabelsInc | 29.84K | ± 327.28 | ops/s | 1.0x slower |
| prometheusInc | 29.79K | ± 333.49 | ops/s | 1.0x slower |
| prometheusAdd | 28.82K | ± 994.49 | ops/s | 1.0x slower |
| simpleclientNoLabelsInc | 7.52K | ± 65.58 | ops/s | 4.0x slower |
| simpleclientInc | 7.52K | ± 85.98 | ops/s | 4.0x slower |
| simpleclientAdd | 7.42K | ± 108.61 | ops/s | 4.1x slower |
| openTelemetryAdd | 2.63K | ± 365.61 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 2.55K | ± 252.43 | ops/s | 12x slower |
| openTelemetryInc | 2.41K | ± 275.65 | ops/s | 12x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.88K | ± 77.29 | ops/s | **fastest** |
| prometheusClassic | 4.54K | ± 2.22K | ops/s | 1.1x slower |
| prometheusNative | 1.97K | ± 385.32 | ops/s | 2.5x slower |
| openTelemetryClassic | 481.18 | ± 40.95 | ops/s | 10x slower |
| openTelemetryExponential | 360.51 | ± 6.98 | ops/s | 14x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 20.01K | ± 116.40 | ops/s | **fastest** |
| openMetricsWriteToNull | 19.94K | ± 98.40 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 306.76K | ± 1.39K | ops/s | **fastest** |
| prometheusWriteToByteArray | 305.64K | ± 1.50K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 289.88K | ± 1.64K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 286.68K | ± 2.77K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      30075.655    ± 335.093  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2633.958    ± 365.614  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2408.371    ± 275.648  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2552.087    ± 252.428  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      28823.057    ± 994.487  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      29791.194    ± 333.491  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      29836.960    ± 327.283  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7419.131    ± 108.609  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7516.267     ± 85.982  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7516.556     ± 65.582  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        481.175     ± 40.953  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        360.510      ± 6.976  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4537.958   ± 2224.585  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       1972.079    ± 385.317  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4880.898     ± 77.293  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      19936.257     ± 98.400  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      20014.175    ± 116.400  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     286675.129   ± 2770.382  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     289878.524   ± 1638.185  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     305635.629   ± 1495.005  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     306761.763   ± 1390.839  ops/s
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

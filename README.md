# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-21T10:46:30Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) 6975P-C, 4 cores, 15 GB RAM
- **OS:** Linux 7.0.0-1014-aws

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| codahaleIncNoLabels | 33.95K | ± 2.11K | ops/s | **fastest** |
| prometheusAdd | 33.84K | ± 97.43 | ops/s | 1.0x slower |
| prometheusInc | 33.15K | ± 217.08 | ops/s | 1.0x slower |
| prometheusNoLabelsInc | 32.42K | ± 840.32 | ops/s | 1.0x slower |
| simpleclientInc | 7.62K | ± 20.23 | ops/s | 4.5x slower |
| simpleclientNoLabelsInc | 7.50K | ± 44.03 | ops/s | 4.5x slower |
| simpleclientAdd | 7.42K | ± 48.98 | ops/s | 4.6x slower |
| openTelemetryAdd | 2.97K | ± 373.30 | ops/s | 11x slower |
| openTelemetryInc | 2.44K | ± 214.28 | ops/s | 14x slower |
| openTelemetryIncNoLabels | 2.39K | ± 135.80 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 5.26K | ± 58.39 | ops/s | **fastest** |
| prometheusClassic | 2.88K | ± 533.62 | ops/s | 1.8x slower |
| prometheusNative | 2.06K | ± 322.99 | ops/s | 2.6x slower |
| openTelemetryClassic | 356.14 | ± 24.79 | ops/s | 15x slower |
| openTelemetryExponential | 292.15 | ± 15.36 | ops/s | 18x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.94K | ± 65.04 | ops/s | **fastest** |
| prometheusWriteToNull | 23.77K | ± 100.49 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 432.54K | ± 3.42K | ops/s | **fastest** |
| prometheusWriteToNull | 430.08K | ± 9.24K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 394.13K | ± 4.90K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 393.76K | ± 5.05K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      33954.294   ± 2105.019  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2969.981    ± 373.296  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2437.636    ± 214.283  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2390.944    ± 135.803  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      33838.920     ± 97.431  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      33148.911    ± 217.081  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      32423.257    ± 840.323  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7422.086     ± 48.976  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7621.534     ± 20.230  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7499.563     ± 44.033  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        356.143     ± 24.793  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        292.153     ± 15.362  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2883.664    ± 533.624  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2055.486    ± 322.990  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5262.014     ± 58.389  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23937.043     ± 65.039  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23774.086    ± 100.495  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     393764.716   ± 5053.999  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     394129.015   ± 4902.978  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     432536.241   ± 3422.317  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     430080.354   ± 9238.369  ops/s
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

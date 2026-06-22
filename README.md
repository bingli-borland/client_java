# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-22T08:50:12Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.50K | ± 1.09K | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.14K | ± 2.67K | ops/s | 1.2x slower |
| prometheusAdd | 51.45K | ± 71.36 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.49K | ± 1.53K | ops/s | 1.3x slower |
| simpleclientInc | 6.54K | ± 44.00 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 6.33K | ± 12.07 | ops/s | 10x slower |
| simpleclientAdd | 6.33K | ± 167.01 | ops/s | 10x slower |
| openTelemetryInc | 3.14K | ± 177.64 | ops/s | 21x slower |
| openTelemetryAdd | 3.06K | ± 437.84 | ops/s | 21x slower |
| openTelemetryIncNoLabels | 3.00K | ± 207.47 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.49K | ± 1.55K | ops/s | **fastest** |
| simpleclient | 4.42K | ± 24.84 | ops/s | 1.2x slower |
| prometheusNative | 3.02K | ± 310.55 | ops/s | 1.8x slower |
| openTelemetryClassic | 730.12 | ± 10.19 | ops/s | 7.5x slower |
| openTelemetryExponential | 692.47 | ± 31.94 | ops/s | 7.9x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.91K | ± 400.78 | ops/s | **fastest** |
| prometheusWriteToNull | 23.54K | ± 683.13 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 519.41K | ± 3.93K | ops/s | **fastest** |
| prometheusWriteToByteArray | 495.65K | ± 8.06K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 489.28K | ± 4.04K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 487.48K | ± 5.05K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48493.543   ± 1531.624  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3058.287    ± 437.843  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3135.345    ± 177.644  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2998.112    ± 207.465  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51449.991     ± 71.363  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64502.678   ± 1086.539  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55138.492   ± 2672.894  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6328.898    ± 167.009  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6538.684     ± 44.002  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6334.296     ± 12.071  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        730.117     ± 10.192  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        692.473     ± 31.939  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5488.874   ± 1547.375  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3016.604    ± 310.550  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4416.455     ± 24.840  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23906.577    ± 400.780  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23539.480    ± 683.129  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     487475.290   ± 5049.463  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     489284.061   ± 4035.327  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     495646.590   ± 8056.060  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     519406.917   ± 3932.969  ops/s
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

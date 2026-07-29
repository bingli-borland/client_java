# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-29T06:45:36Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.38K | ± 1.23K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.74K | ± 554.48 | ops/s | 1.1x slower |
| prometheusAdd | 51.64K | ± 55.99 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 46.61K | ± 1.40K | ops/s | 1.4x slower |
| simpleclientInc | 6.58K | ± 8.33 | ops/s | 9.8x slower |
| simpleclientAdd | 6.47K | ± 22.45 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.39K | ± 26.67 | ops/s | 10x slower |
| openTelemetryInc | 3.53K | ± 384.44 | ops/s | 18x slower |
| openTelemetryAdd | 3.33K | ± 459.56 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 3.24K | ± 256.81 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.48K | ± 565.81 | ops/s | **fastest** |
| simpleclient | 4.37K | ± 47.96 | ops/s | 1.0x slower |
| prometheusNative | 2.84K | ± 267.11 | ops/s | 1.6x slower |
| openTelemetryClassic | 749.87 | ± 30.45 | ops/s | 6.0x slower |
| openTelemetryExponential | 630.88 | ± 77.70 | ops/s | 7.1x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.56K | ± 196.22 | ops/s | **fastest** |
| prometheusWriteToNull | 23.46K | ± 790.77 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 491.09K | ± 4.56K | ops/s | **fastest** |
| prometheusWriteToByteArray | 490.27K | ± 3.86K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 467.62K | ± 4.83K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 460.12K | ± 5.75K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      46609.599   ± 1402.702  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3333.378    ± 459.559  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3532.314    ± 384.440  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3235.202    ± 256.809  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51643.927     ± 55.993  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64383.720   ± 1225.074  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56739.084    ± 554.483  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6467.406     ± 22.453  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6582.635      ± 8.330  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6386.740     ± 26.671  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        749.875     ± 30.454  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        630.876     ± 77.697  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4484.304    ± 565.806  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2840.169    ± 267.106  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4370.731     ± 47.964  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23563.984    ± 196.221  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23464.566    ± 790.769  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     460118.918   ± 5749.963  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     467624.090   ± 4827.661  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     490265.992   ± 3863.723  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     491088.469   ± 4563.570  ops/s
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

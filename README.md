# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-01T07:57:20Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.91K | ± 194.40 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.67K | ± 275.37 | ops/s | 1.2x slower |
| prometheusAdd | 51.53K | ± 201.11 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.48K | ± 1.73K | ops/s | 1.3x slower |
| simpleclientInc | 6.52K | ± 53.09 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.36K | ± 28.42 | ops/s | 10x slower |
| simpleclientAdd | 6.31K | ± 279.64 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.27K | ± 415.55 | ops/s | 20x slower |
| openTelemetryAdd | 3.16K | ± 359.14 | ops/s | 21x slower |
| openTelemetryInc | 3.14K | ± 288.52 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.42K | ± 2.31K | ops/s | **fastest** |
| simpleclient | 4.42K | ± 50.96 | ops/s | 1.5x slower |
| prometheusNative | 2.96K | ± 402.39 | ops/s | 2.2x slower |
| openTelemetryClassic | 732.35 | ± 45.56 | ops/s | 8.8x slower |
| openTelemetryExponential | 607.28 | ± 43.19 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.59K | ± 477.72 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.74K | ± 1.20K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 502.68K | ± 6.57K | ops/s | **fastest** |
| prometheusWriteToByteArray | 490.68K | ± 3.37K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 479.09K | ± 4.02K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 477.55K | ± 8.55K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49475.981   ± 1728.631  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3158.880    ± 359.141  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3136.875    ± 288.516  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3271.276    ± 415.545  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51525.712    ± 201.106  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65911.814    ± 194.401  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56670.949    ± 275.373  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6311.179    ± 279.637  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6523.638     ± 53.090  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6357.351     ± 28.419  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        732.346     ± 45.564  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        607.285     ± 43.189  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6415.892   ± 2308.750  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2957.640    ± 402.394  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4417.108     ± 50.959  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23735.928   ± 1204.241  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24586.878    ± 477.721  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     477551.581   ± 8553.949  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     479088.611   ± 4017.447  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     490681.143   ± 3373.813  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     502680.315   ± 6569.668  ops/s
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

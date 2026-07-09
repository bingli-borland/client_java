# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-09T07:29:29Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.92K | ± 1.31K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.85K | ± 351.98 | ops/s | 1.1x slower |
| prometheusAdd | 51.35K | ± 272.44 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.15K | ± 1.48K | ops/s | 1.3x slower |
| simpleclientInc | 6.58K | ± 74.46 | ops/s | 9.9x slower |
| simpleclientAdd | 6.43K | ± 28.89 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.34K | ± 12.63 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.39K | ± 530.59 | ops/s | 19x slower |
| openTelemetryAdd | 3.15K | ± 365.17 | ops/s | 21x slower |
| openTelemetryInc | 2.96K | ± 138.62 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.33K | ± 1.97K | ops/s | **fastest** |
| simpleclient | 4.45K | ± 26.46 | ops/s | 1.4x slower |
| prometheusNative | 2.55K | ± 132.53 | ops/s | 2.5x slower |
| openTelemetryClassic | 755.52 | ± 53.84 | ops/s | 8.4x slower |
| openTelemetryExponential | 625.65 | ± 26.59 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.36K | ± 774.25 | ops/s | **fastest** |
| prometheusWriteToNull | 23.22K | ± 591.86 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 494.59K | ± 7.76K | ops/s | **fastest** |
| prometheusWriteToByteArray | 490.45K | ± 1.52K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 476.00K | ± 4.37K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 469.91K | ± 2.74K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49154.395   ± 1479.821  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3145.189    ± 365.167  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2955.503    ± 138.619  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3386.228    ± 530.588  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51347.505    ± 272.436  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64918.899   ± 1310.102  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56846.713    ± 351.982  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6430.811     ± 28.893  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6584.495     ± 74.458  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6343.889     ± 12.634  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        755.521     ± 53.844  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        625.654     ± 26.594  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6333.094   ± 1968.866  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2551.789    ± 132.529  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4453.753     ± 26.465  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23363.183    ± 774.253  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23224.426    ± 591.859  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     469906.829   ± 2739.352  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     476000.400   ± 4372.269  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     490450.519   ± 1520.651  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     494593.599   ± 7758.770  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-05T07:56:07Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1015-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.63K | ± 1.06K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.76K | ± 454.41 | ops/s | 1.1x slower |
| prometheusAdd | 51.37K | ± 140.74 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.31K | ± 1.52K | ops/s | 1.3x slower |
| simpleclientInc | 6.58K | ± 26.45 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 6.34K | ± 14.02 | ops/s | 10x slower |
| simpleclientAdd | 6.29K | ± 264.65 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.36K | ± 212.55 | ops/s | 19x slower |
| openTelemetryAdd | 3.15K | ± 398.66 | ops/s | 21x slower |
| openTelemetryInc | 2.85K | ± 27.50 | ops/s | 23x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.87K | ± 556.42 | ops/s | **fastest** |
| simpleclient | 4.43K | ± 24.12 | ops/s | 1.1x slower |
| prometheusNative | 2.88K | ± 288.18 | ops/s | 1.7x slower |
| openTelemetryClassic | 773.92 | ± 16.35 | ops/s | 6.3x slower |
| openTelemetryExponential | 650.70 | ± 118.03 | ops/s | 7.5x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.96K | ± 228.49 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.75K | ± 497.68 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 511.55K | ± 5.21K | ops/s | **fastest** |
| prometheusWriteToByteArray | 498.05K | ± 5.64K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 487.59K | ± 2.50K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 479.88K | ± 4.01K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48312.684   ± 1524.863  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3147.914    ± 398.657  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2845.141     ± 27.504  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3364.801    ± 212.545  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51365.726    ± 140.735  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64629.822   ± 1056.443  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56762.933    ± 454.415  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6294.312    ± 264.648  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6575.606     ± 26.450  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6344.799     ± 14.020  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        773.917     ± 16.354  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        650.697    ± 118.025  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4871.854    ± 556.424  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2880.074    ± 288.181  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4431.096     ± 24.117  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23753.321    ± 497.682  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23964.512    ± 228.486  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     479880.085   ± 4010.224  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     487587.062   ± 2503.411  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     498048.524   ± 5636.007  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     511550.959   ± 5207.959  ops/s
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

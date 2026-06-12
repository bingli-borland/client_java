# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-12T08:07:18Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.02K | ± 377.64 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.39K | ± 1.06K | ops/s | 1.2x slower |
| prometheusAdd | 51.25K | ± 482.26 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.07K | ± 1.66K | ops/s | 1.3x slower |
| simpleclientInc | 6.55K | ± 45.67 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.36K | ± 24.00 | ops/s | 10x slower |
| simpleclientAdd | 6.22K | ± 418.55 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 3.40K | ± 462.77 | ops/s | 19x slower |
| openTelemetryInc | 3.22K | ± 145.90 | ops/s | 21x slower |
| openTelemetryAdd | 3.18K | ± 293.96 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.34K | ± 1.21K | ops/s | **fastest** |
| simpleclient | 4.37K | ± 61.12 | ops/s | 1.4x slower |
| prometheusNative | 2.51K | ± 69.97 | ops/s | 2.5x slower |
| openTelemetryClassic | 754.25 | ± 19.62 | ops/s | 8.4x slower |
| openTelemetryExponential | 569.97 | ± 27.69 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.27K | ± 193.13 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.47K | ± 309.25 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 514.59K | ± 5.10K | ops/s | **fastest** |
| prometheusWriteToByteArray | 507.64K | ± 3.50K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 490.29K | ± 2.38K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 487.00K | ± 3.58K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49070.602   ± 1659.477  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3179.202    ± 293.958  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3219.503    ± 145.899  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3400.061    ± 462.769  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51247.270    ± 482.257  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66021.380    ± 377.642  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56386.907   ± 1058.117  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6224.878    ± 418.546  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6554.383     ± 45.670  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6363.611     ± 24.000  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        754.247     ± 19.617  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        569.968     ± 27.691  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6339.567   ± 1208.294  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2514.312     ± 69.969  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4372.332     ± 61.119  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23474.557    ± 309.250  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24265.872    ± 193.128  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     487000.912   ± 3577.751  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     490289.690   ± 2379.798  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     507644.435   ± 3502.439  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     514587.125   ± 5102.115  ops/s
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

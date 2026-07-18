# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-18T06:11:52Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.61K | ± 2.13K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.70K | ± 714.81 | ops/s | 1.1x slower |
| prometheusAdd | 51.02K | ± 621.17 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.88K | ± 1.27K | ops/s | 1.3x slower |
| simpleclientInc | 6.62K | ± 56.12 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 6.36K | ± 38.83 | ops/s | 10x slower |
| simpleclientAdd | 6.32K | ± 221.68 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.58K | ± 192.91 | ops/s | 18x slower |
| openTelemetryInc | 3.08K | ± 182.20 | ops/s | 21x slower |
| openTelemetryAdd | 2.78K | ± 112.01 | ops/s | 23x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.72K | ± 1.38K | ops/s | **fastest** |
| simpleclient | 4.39K | ± 30.66 | ops/s | 1.3x slower |
| prometheusNative | 3.19K | ± 80.39 | ops/s | 1.8x slower |
| openTelemetryClassic | 709.94 | ± 59.12 | ops/s | 8.1x slower |
| openTelemetryExponential | 687.54 | ± 41.80 | ops/s | 8.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.75K | ± 487.19 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.02K | ± 1.12K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 489.49K | ± 6.96K | ops/s | **fastest** |
| prometheusWriteToByteArray | 486.18K | ± 3.11K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 475.93K | ± 6.34K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 469.27K | ± 3.51K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48884.290   ± 1273.684  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2782.565    ± 112.009  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3083.298    ± 182.200  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3575.961    ± 192.911  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51019.598    ± 621.169  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64605.932   ± 2125.616  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56704.769    ± 714.806  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6315.332    ± 221.682  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6624.695     ± 56.123  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6356.893     ± 38.833  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        709.944     ± 59.123  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        687.538     ± 41.801  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5715.355   ± 1381.893  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3193.679     ± 80.394  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4389.414     ± 30.659  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23018.861   ± 1118.013  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23745.803    ± 487.188  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     469274.195   ± 3514.264  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     475927.026   ± 6337.062  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     486183.613   ± 3107.145  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     489491.047   ± 6960.907  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-19T06:46:18Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 77.20K | ± 98.61 | ops/s | **fastest** |
| prometheusNoLabelsInc | 67.23K | ± 1.26K | ops/s | 1.1x slower |
| prometheusAdd | 62.47K | ± 135.69 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 56.98K | ± 2.88K | ops/s | 1.4x slower |
| simpleclientInc | 7.90K | ± 87.18 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 7.62K | ± 24.68 | ops/s | 10x slower |
| simpleclientAdd | 7.29K | ± 559.92 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 7.04K | ± 890.56 | ops/s | 11x slower |
| openTelemetryAdd | 5.70K | ± 1.04K | ops/s | 14x slower |
| openTelemetryInc | 5.03K | ± 195.25 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.59K | ± 1.79K | ops/s | **fastest** |
| simpleclient | 5.63K | ± 35.73 | ops/s | 1.3x slower |
| prometheusNative | 3.84K | ± 358.20 | ops/s | 2.0x slower |
| openTelemetryClassic | 896.66 | ± 9.37 | ops/s | 8.5x slower |
| openTelemetryExponential | 673.53 | ± 13.51 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 35.58K | ± 212.66 | ops/s | **fastest** |
| openMetricsWriteToNull | 34.66K | ± 54.67 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 711.57K | ± 6.96K | ops/s | **fastest** |
| prometheusWriteToByteArray | 687.08K | ± 8.04K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 660.57K | ± 2.82K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 646.22K | ± 3.70K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      56981.693   ± 2880.579  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       5701.336   ± 1040.442  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5028.814    ± 195.248  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       7036.006    ± 890.559  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      62473.083    ± 135.687  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      77198.362     ± 98.614  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      67226.241   ± 1256.359  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7294.923    ± 559.917  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7895.470     ± 87.184  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7624.095     ± 24.684  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        896.659      ± 9.374  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        673.534     ± 13.505  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7589.242   ± 1792.536  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3836.570    ± 358.198  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5632.517     ± 35.733  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      34660.245     ± 54.669  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      35580.136    ± 212.664  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     646215.130   ± 3704.301  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     660571.144   ± 2823.546  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     687076.412   ± 8044.922  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     711572.876   ± 6955.390  ops/s
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

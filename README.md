# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-26T07:34:55Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 58.33K | ± 888.47 | ops/s | **fastest** |
| prometheusNoLabelsInc | 50.81K | ± 1.56K | ops/s | 1.1x slower |
| prometheusAdd | 47.96K | ± 355.33 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.54K | ± 594.55 | ops/s | 1.3x slower |
| simpleclientInc | 6.13K | ± 63.27 | ops/s | 9.5x slower |
| simpleclientNoLabelsInc | 5.89K | ± 6.41 | ops/s | 9.9x slower |
| simpleclientAdd | 5.81K | ± 281.89 | ops/s | 10x slower |
| openTelemetryInc | 5.38K | ± 675.61 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 4.34K | ± 394.52 | ops/s | 13x slower |
| openTelemetryAdd | 3.27K | ± 164.82 | ops/s | 18x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.31K | ± 1.63K | ops/s | **fastest** |
| simpleclient | 4.29K | ± 75.67 | ops/s | 1.2x slower |
| prometheusNative | 3.13K | ± 87.92 | ops/s | 1.7x slower |
| openTelemetryClassic | 556.12 | ± 184.87 | ops/s | 9.5x slower |
| openTelemetryExponential | 537.58 | ± 17.48 | ops/s | 9.9x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.46K | ± 155.18 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.31K | ± 80.91 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 566.09K | ± 2.93K | ops/s | **fastest** |
| prometheusWriteToByteArray | 549.82K | ± 3.91K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 530.47K | ± 4.01K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 516.91K | ± 4.35K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43537.397    ± 594.549  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3269.677    ± 164.821  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5377.458    ± 675.607  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4336.403    ± 394.516  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      47964.528    ± 355.334  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      58328.444    ± 888.473  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      50812.920   ± 1560.103  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5812.274    ± 281.892  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6125.867     ± 63.265  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5891.505      ± 6.406  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        556.119    ± 184.870  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        537.579     ± 17.478  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5306.698   ± 1631.160  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3133.741     ± 87.917  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4293.157     ± 75.673  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27311.623     ± 80.912  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27459.421    ± 155.179  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     516906.318   ± 4347.207  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     530465.823   ± 4009.691  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     549817.301   ± 3907.838  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     566088.732   ± 2927.893  ops/s
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

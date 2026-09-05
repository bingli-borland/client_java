# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-05T08:08:38Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) 6973P-C, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusAdd | 35.74K | ± 499.59 | ops/s | **fastest** |
| prometheusInc | 34.34K | ± 376.26 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 34.29K | ± 691.62 | ops/s | 1.0x slower |
| prometheusNoLabelsInc | 32.94K | ± 776.54 | ops/s | 1.1x slower |
| simpleclientNoLabelsInc | 9.13K | ± 73.23 | ops/s | 3.9x slower |
| simpleclientInc | 9.07K | ± 131.14 | ops/s | 3.9x slower |
| simpleclientAdd | 8.60K | ± 275.39 | ops/s | 4.2x slower |
| openTelemetryAdd | 2.41K | ± 377.42 | ops/s | 15x slower |
| openTelemetryIncNoLabels | 2.28K | ± 348.32 | ops/s | 16x slower |
| openTelemetryInc | 2.17K | ± 280.73 | ops/s | 16x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 6.07K | ± 107.14 | ops/s | **fastest** |
| prometheusClassic | 2.56K | ± 652.95 | ops/s | 2.4x slower |
| prometheusNative | 2.36K | ± 66.48 | ops/s | 2.6x slower |
| openTelemetryClassic | 455.50 | ± 6.04 | ops/s | 13x slower |
| openTelemetryExponential | 385.30 | ± 3.07 | ops/s | 16x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 24.84K | ± 276.10 | ops/s | **fastest** |
| prometheusWriteToNull | 24.66K | ± 285.77 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 336.27K | ± 4.56K | ops/s | **fastest** |
| prometheusWriteToByteArray | 333.58K | ± 3.13K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 321.43K | ± 2.47K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 320.08K | ± 4.56K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      34289.392    ± 691.616  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2408.933    ± 377.420  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2171.269    ± 280.734  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2275.340    ± 348.317  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      35737.132    ± 499.589  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      34335.463    ± 376.263  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      32938.049    ± 776.536  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       8602.692    ± 275.388  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       9071.473    ± 131.136  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       9125.346     ± 73.227  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        455.495      ± 6.045  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        385.303      ± 3.074  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2562.827    ± 652.951  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2359.135     ± 66.477  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       6066.698    ± 107.137  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      24844.485    ± 276.098  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24664.305    ± 285.773  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     320078.745   ± 4555.557  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     321427.459   ± 2471.200  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     333580.359   ± 3127.534  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     336272.178   ± 4555.688  ops/s
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

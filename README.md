# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-01T10:15:57Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.82K | ± 1.32K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.87K | ± 384.84 | ops/s | 1.2x slower |
| prometheusAdd | 51.30K | ± 207.86 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.08K | ± 2.09K | ops/s | 1.3x slower |
| simpleclientInc | 6.57K | ± 41.47 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.14K | ± 189.80 | ops/s | 11x slower |
| simpleclientAdd | 6.08K | ± 189.11 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 3.45K | ± 149.17 | ops/s | 19x slower |
| openTelemetryInc | 3.25K | ± 669.73 | ops/s | 20x slower |
| openTelemetryAdd | 3.22K | ± 154.71 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.63K | ± 1.02K | ops/s | **fastest** |
| simpleclient | 4.40K | ± 56.85 | ops/s | 1.3x slower |
| prometheusNative | 2.81K | ± 319.19 | ops/s | 2.0x slower |
| openTelemetryClassic | 824.27 | ± 15.59 | ops/s | 6.8x slower |
| openTelemetryExponential | 679.86 | ± 89.78 | ops/s | 8.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.67K | ± 376.95 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.02K | ± 790.53 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 454.67K | ± 2.19K | ops/s | **fastest** |
| prometheusWriteToByteArray | 448.46K | ± 7.26K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 441.15K | ± 2.31K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 429.66K | ± 4.68K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49075.776   ± 2087.727  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3222.833    ± 154.707  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3252.691    ± 669.729  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3446.567    ± 149.169  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51298.979    ± 207.859  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65818.695   ± 1321.338  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56867.425    ± 384.838  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6083.420    ± 189.110  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6566.122     ± 41.473  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6143.180    ± 189.798  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        824.272     ± 15.591  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        679.859     ± 89.777  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5631.436   ± 1021.193  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2807.733    ± 319.195  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4396.837     ± 56.852  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23024.699    ± 790.526  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23665.392    ± 376.954  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     429656.080   ± 4681.666  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     441146.864   ± 2311.988  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     448456.883   ± 7263.228  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     454671.695   ± 2187.040  ops/s
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

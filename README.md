# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-06T08:00:48Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 57.15K | ± 4.74K | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.60K | ± 933.02 | ops/s | 1.1x slower |
| prometheusAdd | 48.46K | ± 98.71 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.49K | ± 810.17 | ops/s | 1.3x slower |
| simpleclientInc | 6.17K | ± 45.18 | ops/s | 9.3x slower |
| simpleclientAdd | 5.93K | ± 383.10 | ops/s | 9.6x slower |
| simpleclientNoLabelsInc | 5.89K | ± 9.75 | ops/s | 9.7x slower |
| openTelemetryIncNoLabels | 5.34K | ± 1.09K | ops/s | 11x slower |
| openTelemetryInc | 4.32K | ± 368.54 | ops/s | 13x slower |
| openTelemetryAdd | 3.53K | ± 215.21 | ops/s | 16x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.58K | ± 1.28K | ops/s | **fastest** |
| simpleclient | 4.48K | ± 75.76 | ops/s | 1.2x slower |
| prometheusNative | 2.98K | ± 267.30 | ops/s | 1.9x slower |
| openTelemetryClassic | 688.31 | ± 12.00 | ops/s | 8.1x slower |
| openTelemetryExponential | 550.27 | ± 44.66 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.61K | ± 243.10 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.12K | ± 601.32 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 579.17K | ± 4.61K | ops/s | **fastest** |
| prometheusWriteToByteArray | 572.45K | ± 3.28K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 542.85K | ± 6.75K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 537.16K | ± 9.30K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44489.147    ± 810.169  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3532.093    ± 215.213  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4317.329    ± 368.537  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5340.089   ± 1089.280  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48457.427     ± 98.712  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      57146.909   ± 4738.153  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51602.994    ± 933.021  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5927.654    ± 383.101  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6165.394     ± 45.180  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5892.681      ± 9.753  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        688.309     ± 11.997  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        550.272     ± 44.664  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5582.752   ± 1275.501  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2979.206    ± 267.304  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4476.152     ± 75.757  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27120.433    ± 601.319  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27613.559    ± 243.103  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     537161.338   ± 9300.426  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     542850.987   ± 6745.202  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     572449.525   ± 3275.993  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     579168.351   ± 4612.363  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-15T08:48:27Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.67K | ± 1.53K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.64K | ± 433.89 | ops/s | 1.1x slower |
| prometheusAdd | 51.09K | ± 808.61 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 43.15K | ± 7.17K | ops/s | 1.5x slower |
| simpleclientInc | 6.46K | ± 144.81 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.31K | ± 63.30 | ops/s | 10x slower |
| simpleclientAdd | 6.14K | ± 257.35 | ops/s | 11x slower |
| openTelemetryInc | 3.30K | ± 274.11 | ops/s | 20x slower |
| openTelemetryAdd | 3.29K | ± 147.48 | ops/s | 20x slower |
| openTelemetryIncNoLabels | 3.29K | ± 62.96 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.89K | ± 1.56K | ops/s | **fastest** |
| simpleclient | 4.44K | ± 45.07 | ops/s | 1.1x slower |
| prometheusNative | 2.95K | ± 412.33 | ops/s | 1.7x slower |
| openTelemetryClassic | 739.28 | ± 25.02 | ops/s | 6.6x slower |
| openTelemetryExponential | 553.96 | ± 12.33 | ops/s | 8.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.38K | ± 845.01 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.96K | ± 514.75 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 509.96K | ± 7.27K | ops/s | **fastest** |
| prometheusWriteToNull | 508.77K | ± 5.78K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 494.33K | ± 1.41K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 490.10K | ± 4.25K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43147.776   ± 7173.858  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3291.878    ± 147.485  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3304.897    ± 274.108  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3291.619     ± 62.964  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51089.558    ± 808.610  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64668.361   ± 1526.935  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56640.763    ± 433.888  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6138.714    ± 257.346  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6461.655    ± 144.806  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6306.199     ± 63.298  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        739.277     ± 25.019  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        553.959     ± 12.331  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4891.697   ± 1560.807  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2954.593    ± 412.329  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4439.232     ± 45.067  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23956.763    ± 514.746  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24379.476    ± 845.011  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     490097.975   ± 4248.179  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     494328.436   ± 1410.758  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     509957.976   ± 7271.196  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     508768.043   ± 5779.801  ops/s
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

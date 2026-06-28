# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-28T07:43:25Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 58.56K | ± 2.17K | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.05K | ± 313.11 | ops/s | 1.1x slower |
| prometheusAdd | 48.52K | ± 86.42 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.48K | ± 1.41K | ops/s | 1.3x slower |
| simpleclientInc | 6.17K | ± 38.92 | ops/s | 9.5x slower |
| simpleclientAdd | 6.14K | ± 55.30 | ops/s | 9.5x slower |
| simpleclientNoLabelsInc | 5.89K | ± 3.84 | ops/s | 9.9x slower |
| openTelemetryInc | 5.47K | ± 1.21K | ops/s | 11x slower |
| openTelemetryIncNoLabels | 4.81K | ± 1.11K | ops/s | 12x slower |
| openTelemetryAdd | 3.96K | ± 896.12 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.45K | ± 1.50K | ops/s | **fastest** |
| simpleclient | 4.60K | ± 60.88 | ops/s | 1.2x slower |
| prometheusNative | 2.92K | ± 269.90 | ops/s | 1.9x slower |
| openTelemetryClassic | 737.06 | ± 24.54 | ops/s | 7.4x slower |
| openTelemetryExponential | 564.31 | ± 13.76 | ops/s | 9.7x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.12K | ± 792.76 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.06K | ± 558.56 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 564.29K | ± 4.17K | ops/s | **fastest** |
| prometheusWriteToByteArray | 557.98K | ± 4.76K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 529.82K | ± 10.39K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 518.50K | ± 3.04K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43478.474   ± 1405.357  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3960.922    ± 896.120  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5473.794   ± 1205.022  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4812.307   ± 1107.212  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48520.598     ± 86.424  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      58556.250   ± 2167.370  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51045.331    ± 313.108  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6138.604     ± 55.298  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6170.464     ± 38.917  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5894.410      ± 3.841  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        737.061     ± 24.537  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        564.313     ± 13.763  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5449.631   ± 1497.618  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2916.027    ± 269.903  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4596.259     ± 60.883  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27055.116    ± 558.562  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27120.459    ± 792.763  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     518498.297   ± 3037.048  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     529818.792  ± 10386.393  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     557984.971   ± 4759.677  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     564285.126   ± 4172.415  ops/s
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

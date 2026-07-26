# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-26T06:55:40Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** INTEL(R) XEON(R) PLATINUM 8573C, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| codahaleIncNoLabels | 30.47K | ± 353.77 | ops/s | **fastest** |
| prometheusNoLabelsInc | 29.58K | ± 261.58 | ops/s | 1.0x slower |
| prometheusInc | 29.28K | ± 276.86 | ops/s | 1.0x slower |
| prometheusAdd | 28.46K | ± 199.68 | ops/s | 1.1x slower |
| simpleclientInc | 7.36K | ± 117.20 | ops/s | 4.1x slower |
| simpleclientNoLabelsInc | 7.26K | ± 103.67 | ops/s | 4.2x slower |
| simpleclientAdd | 7.22K | ± 91.91 | ops/s | 4.2x slower |
| openTelemetryIncNoLabels | 2.81K | ± 338.78 | ops/s | 11x slower |
| openTelemetryInc | 2.60K | ± 339.00 | ops/s | 12x slower |
| openTelemetryAdd | 2.45K | ± 381.01 | ops/s | 12x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.83K | ± 85.78 | ops/s | **fastest** |
| prometheusClassic | 2.60K | ± 778.13 | ops/s | 1.9x slower |
| prometheusNative | 2.31K | ± 119.08 | ops/s | 2.1x slower |
| openTelemetryClassic | 478.07 | ± 58.27 | ops/s | 10x slower |
| openTelemetryExponential | 355.66 | ± 5.48 | ops/s | 14x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 19.74K | ± 435.27 | ops/s | **fastest** |
| openMetricsWriteToNull | 19.54K | ± 508.43 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 332.30K | ± 3.22K | ops/s | **fastest** |
| prometheusWriteToByteArray | 329.93K | ± 3.77K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 309.26K | ± 4.23K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 307.22K | ± 4.44K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      30469.774    ± 353.767  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2451.407    ± 381.013  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2602.183    ± 339.003  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2813.807    ± 338.780  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      28462.461    ± 199.682  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      29282.320    ± 276.857  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      29580.543    ± 261.575  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7221.082     ± 91.911  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7360.061    ± 117.195  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7260.402    ± 103.673  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        478.072     ± 58.266  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        355.663      ± 5.480  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2599.600    ± 778.132  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2305.707    ± 119.081  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4825.840     ± 85.778  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      19541.790    ± 508.435  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      19737.760    ± 435.274  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     307223.119   ± 4442.140  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     309262.159   ± 4229.940  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     329932.466   ± 3769.295  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     332303.965   ± 3216.091  ops/s
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

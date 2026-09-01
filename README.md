# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-01T08:53:47Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.86K | ± 75.58 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.18K | ± 898.60 | ops/s | 1.2x slower |
| prometheusAdd | 51.50K | ± 199.67 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.36K | ± 1.22K | ops/s | 1.3x slower |
| simpleclientInc | 6.62K | ± 48.16 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 6.36K | ± 36.41 | ops/s | 10x slower |
| simpleclientAdd | 6.19K | ± 191.09 | ops/s | 11x slower |
| openTelemetryAdd | 3.56K | ± 323.92 | ops/s | 18x slower |
| openTelemetryInc | 3.53K | ± 442.16 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 3.27K | ± 218.04 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.47K | ± 665.43 | ops/s | **fastest** |
| simpleclient | 4.42K | ± 90.26 | ops/s | 1.0x slower |
| prometheusNative | 2.74K | ± 376.09 | ops/s | 1.6x slower |
| openTelemetryClassic | 753.10 | ± 19.62 | ops/s | 5.9x slower |
| openTelemetryExponential | 709.23 | ± 17.65 | ops/s | 6.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.06K | ± 901.49 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.74K | ± 924.14 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 494.41K | ± 3.81K | ops/s | **fastest** |
| prometheusWriteToNull | 492.62K | ± 3.23K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 479.53K | ± 3.05K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 469.64K | ± 6.41K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49363.184   ± 1217.763  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3564.764    ± 323.925  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3534.672    ± 442.156  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3271.354    ± 218.036  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51496.462    ± 199.665  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65861.887     ± 75.580  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56181.633    ± 898.605  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6188.246    ± 191.095  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6622.620     ± 48.155  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6361.778     ± 36.408  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        753.096     ± 19.616  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        709.226     ± 17.646  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4470.135    ± 665.431  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2743.956    ± 376.086  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4421.391     ± 90.259  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23744.525    ± 924.141  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24055.356    ± 901.492  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     469638.571   ± 6405.740  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     479527.287   ± 3050.734  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     494411.334   ± 3809.032  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     492619.969   ± 3231.775  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-15T08:30:33Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.83K | ± 1.66K | ops/s | **fastest** |
| prometheusNoLabelsInc | 57.02K | ± 428.49 | ops/s | 1.2x slower |
| prometheusAdd | 50.35K | ± 1.09K | ops/s | 1.3x slower |
| codahaleIncNoLabels | 47.95K | ± 1.67K | ops/s | 1.4x slower |
| simpleclientInc | 6.56K | ± 94.11 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.34K | ± 14.22 | ops/s | 10x slower |
| simpleclientAdd | 6.24K | ± 349.98 | ops/s | 11x slower |
| openTelemetryAdd | 3.74K | ± 476.22 | ops/s | 18x slower |
| openTelemetryIncNoLabels | 3.59K | ± 302.04 | ops/s | 18x slower |
| openTelemetryInc | 3.04K | ± 267.31 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.81K | ± 1.02K | ops/s | **fastest** |
| simpleclient | 4.40K | ± 37.48 | ops/s | 1.3x slower |
| prometheusNative | 2.86K | ± 251.39 | ops/s | 2.0x slower |
| openTelemetryClassic | 743.36 | ± 9.02 | ops/s | 7.8x slower |
| openTelemetryExponential | 614.33 | ± 45.44 | ops/s | 9.5x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.41K | ± 124.22 | ops/s | **fastest** |
| prometheusWriteToNull | 23.12K | ± 802.08 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 505.06K | ± 7.44K | ops/s | **fastest** |
| prometheusWriteToByteArray | 499.75K | ± 2.91K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 485.53K | ± 4.82K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 482.80K | ± 7.59K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      47946.120   ± 1673.187  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3737.588    ± 476.215  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3043.347    ± 267.315  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3590.200    ± 302.040  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50348.381   ± 1093.238  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65833.471   ± 1664.395  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      57024.164    ± 428.487  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6242.529    ± 349.984  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6559.867     ± 94.109  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6337.722     ± 14.220  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        743.363      ± 9.017  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        614.332     ± 45.437  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5812.673   ± 1024.200  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2855.634    ± 251.387  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4395.854     ± 37.482  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23411.300    ± 124.217  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23115.208    ± 802.079  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     482798.660   ± 7594.527  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     485529.075   ± 4816.224  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     499754.847   ± 2911.975  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     505062.578   ± 7437.932  ops/s
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

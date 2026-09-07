# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-07T08:30:04Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 76.75K | ± 660.43 | ops/s | **fastest** |
| prometheusNoLabelsInc | 67.32K | ± 1.27K | ops/s | 1.1x slower |
| prometheusAdd | 62.05K | ± 569.82 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 55.65K | ± 1.83K | ops/s | 1.4x slower |
| simpleclientAdd | 7.91K | ± 50.04 | ops/s | 9.7x slower |
| simpleclientInc | 7.86K | ± 14.56 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 7.61K | ± 34.55 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 7.29K | ± 846.88 | ops/s | 11x slower |
| openTelemetryAdd | 5.29K | ± 1.10K | ops/s | 15x slower |
| openTelemetryInc | 5.18K | ± 686.56 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.26K | ± 929.02 | ops/s | **fastest** |
| simpleclient | 5.63K | ± 151.54 | ops/s | 1.1x slower |
| prometheusNative | 3.70K | ± 308.28 | ops/s | 1.7x slower |
| openTelemetryClassic | 946.14 | ± 40.36 | ops/s | 6.6x slower |
| openTelemetryExponential | 751.80 | ± 27.47 | ops/s | 8.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 35.21K | ± 238.16 | ops/s | **fastest** |
| openMetricsWriteToNull | 35.08K | ± 281.43 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 706.97K | ± 3.17K | ops/s | **fastest** |
| prometheusWriteToByteArray | 689.49K | ± 6.40K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 664.82K | ± 2.58K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 651.56K | ± 3.91K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      55653.290   ± 1826.953  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       5289.466   ± 1101.235  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5179.320    ± 686.556  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       7290.066    ± 846.884  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      62049.735    ± 569.820  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      76748.028    ± 660.427  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      67318.260   ± 1271.384  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7912.639     ± 50.044  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7864.437     ± 14.563  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7613.497     ± 34.549  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        946.137     ± 40.364  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        751.804     ± 27.467  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6262.153    ± 929.023  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3695.299    ± 308.278  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5632.816    ± 151.544  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      35078.079    ± 281.435  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      35205.710    ± 238.165  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     651559.440   ± 3914.035  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     664819.021   ± 2579.919  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     689491.760   ± 6404.361  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     706968.530   ± 3172.944  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-27T09:12:24Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.08K | ± 1.14K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.18K | ± 1.34K | ops/s | 1.2x slower |
| prometheusAdd | 51.19K | ± 265.09 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 47.79K | ± 686.23 | ops/s | 1.4x slower |
| simpleclientInc | 6.58K | ± 101.65 | ops/s | 10x slower |
| simpleclientAdd | 6.47K | ± 11.65 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.29K | ± 75.49 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 3.20K | ± 36.23 | ops/s | 21x slower |
| openTelemetryInc | 3.17K | ± 44.27 | ops/s | 21x slower |
| openTelemetryAdd | 3.07K | ± 139.83 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.57K | ± 1.50K | ops/s | **fastest** |
| simpleclient | 4.39K | ± 39.94 | ops/s | 1.3x slower |
| prometheusNative | 3.08K | ± 290.49 | ops/s | 1.8x slower |
| openTelemetryClassic | 768.75 | ± 38.29 | ops/s | 7.2x slower |
| openTelemetryExponential | 689.65 | ± 70.06 | ops/s | 8.1x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.48K | ± 498.48 | ops/s | **fastest** |
| prometheusWriteToNull | 23.46K | ± 1.36K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 518.42K | ± 9.99K | ops/s | **fastest** |
| prometheusWriteToByteArray | 509.17K | ± 4.96K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 490.49K | ± 1.93K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 488.86K | ± 2.44K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      47790.980    ± 686.225  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3069.382    ± 139.833  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3170.096     ± 44.269  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3198.064     ± 36.235  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51190.651    ± 265.089  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66080.120   ± 1144.711  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56175.490   ± 1344.289  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6465.567     ± 11.650  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6577.664    ± 101.654  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6290.376     ± 75.493  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        768.751     ± 38.293  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        689.646     ± 70.061  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5573.123   ± 1501.129  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3075.557    ± 290.489  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4390.898     ± 39.940  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23477.229    ± 498.485  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23460.551   ± 1361.034  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     488858.235   ± 2440.762  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     490485.445   ± 1930.911  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     509166.088   ± 4964.778  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     518416.715   ± 9987.432  ops/s
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

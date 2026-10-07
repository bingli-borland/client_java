# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-07T09:43:14Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.93K | ± 261.53 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.37K | ± 571.80 | ops/s | 1.2x slower |
| prometheusAdd | 51.55K | ± 165.35 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.93K | ± 1.86K | ops/s | 1.3x slower |
| simpleclientInc | 6.57K | ± 28.17 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.47K | ± 161.07 | ops/s | 10x slower |
| simpleclientAdd | 6.44K | ± 24.17 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.35K | ± 192.47 | ops/s | 20x slower |
| openTelemetryAdd | 3.24K | ± 409.43 | ops/s | 20x slower |
| openTelemetryInc | 2.99K | ± 323.78 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.48K | ± 1.28K | ops/s | **fastest** |
| simpleclient | 4.44K | ± 61.68 | ops/s | 1.5x slower |
| prometheusNative | 3.07K | ± 322.62 | ops/s | 2.1x slower |
| openTelemetryClassic | 748.70 | ± 29.64 | ops/s | 8.7x slower |
| openTelemetryExponential | 660.75 | ± 136.12 | ops/s | 9.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.00K | ± 333.52 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.44K | ± 598.29 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 517.35K | ± 5.42K | ops/s | **fastest** |
| prometheusWriteToByteArray | 509.22K | ± 4.78K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 489.89K | ± 2.09K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 485.30K | ± 4.61K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48933.362   ± 1864.446  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3241.430    ± 409.433  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2989.292    ± 323.777  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3349.727    ± 192.474  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51549.254    ± 165.348  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65933.272    ± 261.526  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56372.232    ± 571.801  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6441.261     ± 24.174  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6565.668     ± 28.165  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6465.785    ± 161.069  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        748.698     ± 29.641  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        660.747    ± 136.115  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6479.654   ± 1279.257  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3065.076    ± 322.620  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4441.134     ± 61.682  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23437.313    ± 598.286  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23999.234    ± 333.515  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     485295.435   ± 4610.307  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     489888.970   ± 2094.612  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     509218.482   ± 4780.532  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     517354.737   ± 5423.778  ops/s
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

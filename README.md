# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-18T11:14:29Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) 6975P-C, 4 cores, 15 GB RAM
- **OS:** Linux 7.0.0-1014-aws

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusAdd | 34.12K | ± 619.72 | ops/s | **fastest** |
| prometheusInc | 33.05K | ± 60.68 | ops/s | 1.0x slower |
| prometheusNoLabelsInc | 32.57K | ± 713.02 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 32.52K | ± 222.39 | ops/s | 1.0x slower |
| simpleclientInc | 7.60K | ± 110.42 | ops/s | 4.5x slower |
| simpleclientNoLabelsInc | 7.58K | ± 17.47 | ops/s | 4.5x slower |
| simpleclientAdd | 7.52K | ± 60.63 | ops/s | 4.5x slower |
| openTelemetryInc | 2.63K | ± 308.68 | ops/s | 13x slower |
| openTelemetryIncNoLabels | 2.60K | ± 155.09 | ops/s | 13x slower |
| openTelemetryAdd | 2.39K | ± 155.78 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 5.32K | ± 45.47 | ops/s | **fastest** |
| prometheusClassic | 2.58K | ± 709.18 | ops/s | 2.1x slower |
| prometheusNative | 1.99K | ± 249.92 | ops/s | 2.7x slower |
| openTelemetryClassic | 391.83 | ± 15.48 | ops/s | 14x slower |
| openTelemetryExponential | 302.62 | ± 32.29 | ops/s | 18x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.42K | ± 54.81 | ops/s | **fastest** |
| openMetricsWriteToNull | 24.40K | ± 115.43 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 463.23K | ± 10.89K | ops/s | **fastest** |
| prometheusWriteToByteArray | 458.14K | ± 8.82K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 437.22K | ± 4.84K | ops/s | 1.1x slower |
| openMetricsWriteToNull | 414.68K | ± 15.07K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      32517.998    ± 222.388  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2390.854    ± 155.778  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2633.747    ± 308.679  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2604.901    ± 155.092  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      34115.352    ± 619.721  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      33052.510     ± 60.682  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      32569.792    ± 713.015  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7521.868     ± 60.627  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7596.517    ± 110.422  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7577.683     ± 17.467  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        391.833     ± 15.484  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        302.620     ± 32.290  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2584.619    ± 709.178  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       1988.432    ± 249.917  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5316.218     ± 45.473  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      24398.486    ± 115.433  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24421.796     ± 54.813  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     437224.746   ± 4835.279  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     414682.557  ± 15074.861  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     458139.810   ± 8821.685  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     463230.849  ± 10892.597  ops/s
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

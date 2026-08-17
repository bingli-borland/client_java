# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-17T04:23:17Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.56K | ± 563.37 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.86K | ± 791.80 | ops/s | 1.1x slower |
| prometheusAdd | 48.94K | ± 644.20 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.78K | ± 206.05 | ops/s | 1.4x slower |
| simpleclientInc | 6.20K | ± 104.56 | ops/s | 9.6x slower |
| simpleclientAdd | 5.96K | ± 293.86 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 5.84K | ± 80.84 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 4.98K | ± 1.21K | ops/s | 12x slower |
| openTelemetryInc | 4.68K | ± 1.01K | ops/s | 13x slower |
| openTelemetryAdd | 3.37K | ± 150.18 | ops/s | 18x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.93K | ± 2.65K | ops/s | **fastest** |
| simpleclient | 4.52K | ± 35.27 | ops/s | 1.3x slower |
| prometheusNative | 2.99K | ± 236.81 | ops/s | 2.0x slower |
| openTelemetryClassic | 723.58 | ± 21.49 | ops/s | 8.2x slower |
| openTelemetryExponential | 561.22 | ± 26.60 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.54K | ± 182.83 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.37K | ± 228.59 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 574.95K | ± 4.56K | ops/s | **fastest** |
| prometheusWriteToByteArray | 561.68K | ± 5.29K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 545.85K | ± 3.58K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 530.99K | ± 6.31K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43781.182    ± 206.054  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3371.759    ± 150.175  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4675.060   ± 1009.824  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4982.507   ± 1210.548  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48939.891    ± 644.197  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59560.384    ± 563.367  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51864.870    ± 791.800  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5960.865    ± 293.855  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6202.236    ± 104.564  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5839.445     ± 80.843  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        723.583     ± 21.486  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        561.222     ± 26.605  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5932.595   ± 2653.141  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2988.218    ± 236.810  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4519.279     ± 35.270  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27372.260    ± 228.586  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27542.599    ± 182.831  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     530987.314   ± 6307.987  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     545853.191   ± 3579.919  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     561681.390   ± 5291.577  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     574948.390   ± 4562.807  ops/s
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

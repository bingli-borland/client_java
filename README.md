# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-18T08:17:27Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.67K | ± 1.80K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.85K | ± 327.43 | ops/s | 1.1x slower |
| prometheusAdd | 50.90K | ± 311.53 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.63K | ± 2.17K | ops/s | 1.3x slower |
| simpleclientInc | 6.55K | ± 40.50 | ops/s | 9.9x slower |
| simpleclientAdd | 6.40K | ± 127.54 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.35K | ± 25.76 | ops/s | 10x slower |
| openTelemetryInc | 3.45K | ± 365.48 | ops/s | 19x slower |
| openTelemetryAdd | 3.34K | ± 239.49 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 2.97K | ± 288.12 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.96K | ± 1.50K | ops/s | **fastest** |
| simpleclient | 4.39K | ± 118.69 | ops/s | 1.1x slower |
| prometheusNative | 2.99K | ± 286.15 | ops/s | 1.7x slower |
| openTelemetryClassic | 772.99 | ± 34.36 | ops/s | 6.4x slower |
| openTelemetryExponential | 730.96 | ± 13.62 | ops/s | 6.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.58K | ± 1.09K | ops/s | **fastest** |
| prometheusWriteToNull | 22.78K | ± 774.30 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 498.82K | ± 10.87K | ops/s | **fastest** |
| prometheusWriteToByteArray | 496.80K | ± 6.11K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 483.78K | ± 3.62K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 474.15K | ± 7.10K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48633.475   ± 2167.293  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3340.505    ± 239.490  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3453.955    ± 365.475  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2965.769    ± 288.119  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50895.219    ± 311.532  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64670.335   ± 1803.152  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56849.811    ± 327.425  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6395.024    ± 127.545  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6553.893     ± 40.495  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6352.477     ± 25.764  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        772.993     ± 34.364  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        730.963     ± 13.616  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4956.175   ± 1501.455  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2985.602    ± 286.154  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4386.867    ± 118.691  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23579.415   ± 1093.873  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      22781.247    ± 774.299  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     474146.008   ± 7099.935  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     483777.350   ± 3618.293  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     496804.875   ± 6106.061  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     498824.102  ± 10870.768  ops/s
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

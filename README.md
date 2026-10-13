# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-13T10:28:23Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** INTEL(R) XEON(R) PLATINUM 8573C, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusNoLabelsInc | 31.14K | ± 763.35 | ops/s | **fastest** |
| prometheusInc | 30.92K | ± 38.51 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 30.44K | ± 1.44K | ops/s | 1.0x slower |
| prometheusAdd | 30.20K | ± 190.13 | ops/s | 1.0x slower |
| simpleclientInc | 7.83K | ± 57.99 | ops/s | 4.0x slower |
| simpleclientNoLabelsInc | 7.71K | ± 18.38 | ops/s | 4.0x slower |
| simpleclientAdd | 7.69K | ± 147.29 | ops/s | 4.1x slower |
| openTelemetryIncNoLabels | 2.74K | ± 201.22 | ops/s | 11x slower |
| openTelemetryInc | 2.64K | ± 311.38 | ops/s | 12x slower |
| openTelemetryAdd | 2.45K | ± 198.21 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 5.01K | ± 92.03 | ops/s | **fastest** |
| prometheusClassic | 3.05K | ± 561.78 | ops/s | 1.6x slower |
| prometheusNative | 2.48K | ± 240.20 | ops/s | 2.0x slower |
| openTelemetryClassic | 507.61 | ± 8.60 | ops/s | 9.9x slower |
| openTelemetryExponential | 397.54 | ± 26.36 | ops/s | 13x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 20.27K | ± 38.71 | ops/s | **fastest** |
| openMetricsWriteToNull | 20.20K | ± 67.84 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 314.99K | ± 1.98K | ops/s | **fastest** |
| prometheusWriteToByteArray | 314.42K | ± 1.18K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 298.16K | ± 1.80K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 295.31K | ± 1.13K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      30439.322   ± 1444.800  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2449.310    ± 198.208  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2636.416    ± 311.381  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2744.235    ± 201.221  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      30200.238    ± 190.128  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      30923.851     ± 38.506  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      31141.116    ± 763.349  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7686.219    ± 147.292  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7829.254     ± 57.994  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7708.319     ± 18.383  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        507.611      ± 8.602  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        397.538     ± 26.364  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       3047.208    ± 561.784  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2481.405    ± 240.199  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5012.439     ± 92.031  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      20199.951     ± 67.839  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      20269.310     ± 38.707  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     295312.736   ± 1133.523  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     298159.515   ± 1803.512  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     314424.432   ± 1180.469  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     314990.747   ± 1975.242  ops/s
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

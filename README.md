# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-05T10:33:06Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.50K | ± 417.09 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.78K | ± 149.36 | ops/s | 1.1x slower |
| prometheusAdd | 48.05K | ± 1.48K | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.15K | ± 294.89 | ops/s | 1.3x slower |
| simpleclientInc | 6.08K | ± 51.25 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 5.84K | ± 20.42 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 5.59K | ± 1.15K | ops/s | 11x slower |
| simpleclientAdd | 5.57K | ± 414.95 | ops/s | 11x slower |
| openTelemetryInc | 3.83K | ± 313.72 | ops/s | 16x slower |
| openTelemetryAdd | 3.30K | ± 179.16 | ops/s | 18x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.16K | ± 1.70K | ops/s | **fastest** |
| simpleclient | 4.33K | ± 30.20 | ops/s | 1.4x slower |
| prometheusNative | 3.03K | ± 58.83 | ops/s | 2.0x slower |
| openTelemetryClassic | 731.67 | ± 10.79 | ops/s | 8.4x slower |
| openTelemetryExponential | 569.93 | ± 24.74 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.35K | ± 49.82 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.02K | ± 162.20 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 573.14K | ± 8.14K | ops/s | **fastest** |
| prometheusWriteToByteArray | 559.04K | ± 5.16K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 524.00K | ± 15.43K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 510.21K | ± 11.71K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44149.509    ± 294.889  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3296.281    ± 179.161  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3825.288    ± 313.722  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5590.731   ± 1148.322  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48045.655   ± 1478.576  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59499.207    ± 417.085  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51776.915    ± 149.358  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5570.179    ± 414.949  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6076.351     ± 51.254  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5836.576     ± 20.419  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        731.667     ± 10.788  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        569.927     ± 24.736  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6155.559   ± 1699.830  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3027.592     ± 58.832  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4328.595     ± 30.205  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27018.575    ± 162.195  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27346.895     ± 49.822  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     510210.602  ± 11713.419  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     523995.998  ± 15434.384  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     559037.575   ± 5158.133  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     573135.497   ± 8137.232  ops/s
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

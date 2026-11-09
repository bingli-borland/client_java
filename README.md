# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-09T10:47:19Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** INTEL(R) XEON(R) PLATINUM 8573C, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| codahaleIncNoLabels | 31.99K | ± 284.26 | ops/s | **fastest** |
| prometheusInc | 31.55K | ± 987.90 | ops/s | 1.0x slower |
| prometheusNoLabelsInc | 30.84K | ± 360.22 | ops/s | 1.0x slower |
| prometheusAdd | 30.07K | ± 208.42 | ops/s | 1.1x slower |
| simpleclientInc | 7.72K | ± 120.59 | ops/s | 4.1x slower |
| simpleclientNoLabelsInc | 7.55K | ± 106.48 | ops/s | 4.2x slower |
| simpleclientAdd | 7.44K | ± 100.71 | ops/s | 4.3x slower |
| openTelemetryInc | 2.50K | ± 259.08 | ops/s | 13x slower |
| openTelemetryIncNoLabels | 2.45K | ± 259.59 | ops/s | 13x slower |
| openTelemetryAdd | 2.31K | ± 441.70 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.97K | ± 81.84 | ops/s | **fastest** |
| prometheusClassic | 3.37K | ± 2.31K | ops/s | 1.5x slower |
| prometheusNative | 2.37K | ± 208.75 | ops/s | 2.1x slower |
| openTelemetryClassic | 531.37 | ± 8.78 | ops/s | 9.4x slower |
| openTelemetryExponential | 414.61 | ± 16.03 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 21.16K | ± 156.22 | ops/s | **fastest** |
| openMetricsWriteToNull | 21.11K | ± 204.12 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 354.50K | ± 8.96K | ops/s | **fastest** |
| openMetricsWriteToNull | 345.24K | ± 4.31K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 343.45K | ± 4.31K | ops/s | 1.0x slower |
| prometheusWriteToNull | 335.59K | ± 7.25K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      31990.876    ± 284.258  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2309.998    ± 441.702  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2503.297    ± 259.077  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2454.664    ± 259.587  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      30067.960    ± 208.424  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      31548.562    ± 987.897  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      30842.319    ± 360.221  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7440.436    ± 100.708  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7724.880    ± 120.590  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7549.444    ± 106.482  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        531.365      ± 8.777  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        414.609     ± 16.030  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       3373.055   ± 2310.915  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2373.976    ± 208.745  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4971.678     ± 81.839  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      21112.792    ± 204.120  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      21155.576    ± 156.215  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     343446.833   ± 4312.140  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     345242.597   ± 4306.927  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     354498.160   ± 8955.625  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     335585.262   ± 7248.086  ops/s
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

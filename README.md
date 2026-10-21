# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-21T08:39:36Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.00K | ± 247.41 | ops/s | **fastest** |
| prometheusNoLabelsInc | 57.03K | ± 108.28 | ops/s | 1.2x slower |
| prometheusAdd | 51.01K | ± 714.72 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.18K | ± 1.77K | ops/s | 1.3x slower |
| simpleclientInc | 6.48K | ± 7.86 | ops/s | 10x slower |
| simpleclientAdd | 6.40K | ± 59.92 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.35K | ± 110.00 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.59K | ± 174.23 | ops/s | 18x slower |
| openTelemetryInc | 3.47K | ± 222.88 | ops/s | 19x slower |
| openTelemetryAdd | 3.12K | ± 381.10 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.42K | ± 1.14K | ops/s | **fastest** |
| simpleclient | 4.35K | ± 85.08 | ops/s | 1.2x slower |
| prometheusNative | 3.14K | ± 38.01 | ops/s | 1.7x slower |
| openTelemetryClassic | 808.78 | ± 50.51 | ops/s | 6.7x slower |
| openTelemetryExponential | 653.72 | ± 61.59 | ops/s | 8.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.26K | ± 539.85 | ops/s | **fastest** |
| prometheusWriteToNull | 22.97K | ± 1.10K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 464.82K | ± 1.83K | ops/s | **fastest** |
| prometheusWriteToByteArray | 459.33K | ± 3.44K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 439.01K | ± 4.04K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 433.68K | ± 4.11K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49182.175   ± 1769.301  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3122.332    ± 381.102  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3467.762    ± 222.877  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3589.671    ± 174.229  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51013.503    ± 714.719  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66003.669    ± 247.408  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      57031.488    ± 108.281  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6403.192     ± 59.916  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6478.596      ± 7.861  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6348.984    ± 109.996  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        808.782     ± 50.507  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        653.719     ± 61.592  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5421.849   ± 1139.527  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3138.286     ± 38.009  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4347.100     ± 85.076  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23259.890    ± 539.852  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      22972.914   ± 1099.117  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     433681.053   ± 4109.830  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     439006.325   ± 4039.130  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     459327.206   ± 3438.179  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     464823.404   ± 1831.831  ops/s
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

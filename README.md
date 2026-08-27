# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-27T13:57:46Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.50K | ± 368.99 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.22K | ± 514.75 | ops/s | 1.2x slower |
| prometheusAdd | 49.13K | ± 979.84 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.09K | ± 1.67K | ops/s | 1.4x slower |
| simpleclientInc | 6.10K | ± 10.33 | ops/s | 9.8x slower |
| simpleclientAdd | 6.06K | ± 205.15 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 5.90K | ± 69.42 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 4.71K | ± 1.03K | ops/s | 13x slower |
| openTelemetryInc | 4.66K | ± 1.25K | ops/s | 13x slower |
| openTelemetryAdd | 3.49K | ± 113.55 | ops/s | 17x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.23K | ± 1.98K | ops/s | **fastest** |
| simpleclient | 4.41K | ± 45.61 | ops/s | 1.4x slower |
| prometheusNative | 3.06K | ± 119.60 | ops/s | 2.0x slower |
| openTelemetryClassic | 730.67 | ± 29.36 | ops/s | 8.5x slower |
| openTelemetryExponential | 574.58 | ± 15.58 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.47K | ± 260.10 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.34K | ± 115.12 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 577.00K | ± 4.88K | ops/s | **fastest** |
| prometheusWriteToByteArray | 572.37K | ± 7.51K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 541.70K | ± 3.94K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 535.85K | ± 3.24K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43090.903   ± 1669.695  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3488.187    ± 113.547  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4660.168   ± 1245.841  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4705.874   ± 1025.202  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      49126.659    ± 979.841  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59502.521    ± 368.988  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51216.553    ± 514.747  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6058.100    ± 205.151  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6096.216     ± 10.325  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5896.697     ± 69.422  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        730.669     ± 29.355  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        574.582     ± 15.583  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6225.417   ± 1980.553  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3063.783    ± 119.599  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4410.801     ± 45.608  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27341.386    ± 115.122  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27469.984    ± 260.101  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     535853.309   ± 3239.392  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     541698.250   ± 3938.114  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     572369.117   ± 7510.451  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     577001.369   ± 4884.485  ops/s
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

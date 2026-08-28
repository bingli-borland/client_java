# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-28T15:31:10Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.84K | ± 68.24 | ops/s | **fastest** |
| prometheusNoLabelsInc | 50.98K | ± 814.47 | ops/s | 1.2x slower |
| prometheusAdd | 48.42K | ± 78.11 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 42.03K | ± 3.39K | ops/s | 1.4x slower |
| simpleclientInc | 6.09K | ± 9.09 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 6.02K | ± 202.61 | ops/s | 9.9x slower |
| simpleclientAdd | 5.78K | ± 277.65 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 4.08K | ± 566.31 | ops/s | 15x slower |
| openTelemetryInc | 3.59K | ± 461.93 | ops/s | 17x slower |
| openTelemetryAdd | 3.27K | ± 214.76 | ops/s | 18x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.69K | ± 2.56K | ops/s | **fastest** |
| simpleclient | 4.33K | ± 114.36 | ops/s | 1.5x slower |
| prometheusNative | 2.85K | ± 224.45 | ops/s | 2.3x slower |
| openTelemetryClassic | 673.76 | ± 11.36 | ops/s | 9.9x slower |
| openTelemetryExponential | 516.59 | ± 9.06 | ops/s | 13x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.43K | ± 312.96 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.31K | ± 157.81 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 566.21K | ± 3.26K | ops/s | **fastest** |
| prometheusWriteToByteArray | 548.10K | ± 13.60K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 529.75K | ± 4.06K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 519.42K | ± 2.43K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      42031.639   ± 3389.438  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3273.822    ± 214.763  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3590.232    ± 461.926  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4081.725    ± 566.307  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48422.446     ± 78.107  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59837.749     ± 68.240  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      50978.002    ± 814.466  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5779.253    ± 277.653  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6092.829      ± 9.087  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6023.766    ± 202.609  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        673.763     ± 11.363  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        516.590      ± 9.065  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6689.134   ± 2562.432  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2852.586    ± 224.446  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4334.752    ± 114.362  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27313.282    ± 157.812  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27433.474    ± 312.962  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     519416.921   ± 2432.082  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     529749.317   ± 4055.418  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     548096.668  ± 13597.904  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     566209.670   ± 3264.357  ops/s
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

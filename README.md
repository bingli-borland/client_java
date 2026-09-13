# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-13T08:39:23Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 74.47K | ± 4.36K | ops/s | **fastest** |
| prometheusNoLabelsInc | 65.99K | ± 645.14 | ops/s | 1.1x slower |
| prometheusAdd | 62.55K | ± 90.12 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 56.46K | ± 2.46K | ops/s | 1.3x slower |
| simpleclientInc | 7.85K | ± 10.70 | ops/s | 9.5x slower |
| simpleclientNoLabelsInc | 7.64K | ± 15.56 | ops/s | 9.8x slower |
| simpleclientAdd | 7.61K | ± 440.87 | ops/s | 9.8x slower |
| openTelemetryIncNoLabels | 6.48K | ± 1.31K | ops/s | 11x slower |
| openTelemetryInc | 5.34K | ± 343.70 | ops/s | 14x slower |
| openTelemetryAdd | 5.27K | ± 1.03K | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.05K | ± 507.18 | ops/s | **fastest** |
| simpleclient | 5.86K | ± 42.01 | ops/s | 1.0x slower |
| prometheusNative | 3.94K | ± 207.07 | ops/s | 1.5x slower |
| openTelemetryClassic | 945.23 | ± 47.20 | ops/s | 6.4x slower |
| openTelemetryExponential | 706.47 | ± 33.92 | ops/s | 8.6x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 35.37K | ± 208.07 | ops/s | **fastest** |
| openMetricsWriteToNull | 34.27K | ± 483.12 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 698.91K | ± 7.72K | ops/s | **fastest** |
| prometheusWriteToByteArray | 680.24K | ± 7.49K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 646.15K | ± 9.59K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 643.83K | ± 3.84K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      56462.402   ± 2457.718  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       5274.679   ± 1030.899  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5337.298    ± 343.699  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       6483.118   ± 1305.612  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      62554.330     ± 90.122  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      74465.707   ± 4357.731  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      65987.041    ± 645.139  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7607.407    ± 440.866  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7850.005     ± 10.702  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7636.823     ± 15.557  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        945.225     ± 47.196  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        706.473     ± 33.920  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6050.370    ± 507.175  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3942.392    ± 207.066  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5862.445     ± 42.011  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      34267.105    ± 483.124  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      35369.423    ± 208.072  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     643831.370   ± 3837.694  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     646151.498   ± 9587.764  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     680241.345   ± 7490.500  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     698912.382   ± 7721.281  ops/s
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

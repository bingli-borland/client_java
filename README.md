# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-18T04:17:58Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.54K | ± 464.91 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.47K | ± 470.00 | ops/s | 1.2x slower |
| prometheusAdd | 48.42K | ± 164.93 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 42.28K | ± 2.64K | ops/s | 1.4x slower |
| simpleclientInc | 6.23K | ± 74.33 | ops/s | 9.6x slower |
| simpleclientAdd | 6.02K | ± 185.16 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 6.02K | ± 204.70 | ops/s | 9.9x slower |
| openTelemetryIncNoLabels | 5.42K | ± 1.15K | ops/s | 11x slower |
| openTelemetryInc | 4.06K | ± 198.04 | ops/s | 15x slower |
| openTelemetryAdd | 3.56K | ± 179.65 | ops/s | 17x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.73K | ± 833.07 | ops/s | **fastest** |
| simpleclient | 4.20K | ± 25.73 | ops/s | 1.1x slower |
| prometheusNative | 3.11K | ± 201.15 | ops/s | 1.5x slower |
| openTelemetryClassic | 736.52 | ± 28.73 | ops/s | 6.4x slower |
| openTelemetryExponential | 564.67 | ± 8.34 | ops/s | 8.4x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.61K | ± 259.61 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.37K | ± 128.31 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 576.91K | ± 3.10K | ops/s | **fastest** |
| prometheusWriteToByteArray | 575.13K | ± 2.13K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 548.38K | ± 5.18K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 532.70K | ± 2.42K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      42281.950   ± 2637.450  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3557.493    ± 179.645  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4055.911    ± 198.037  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5419.185   ± 1146.054  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48416.524    ± 164.929  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59535.061    ± 464.908  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51467.232    ± 470.003  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6016.705    ± 185.158  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6232.941     ± 74.333  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6015.439    ± 204.702  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        736.516     ± 28.727  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        564.674      ± 8.341  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4725.625    ± 833.066  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3110.423    ± 201.146  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4195.843     ± 25.727  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27369.355    ± 128.309  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27607.638    ± 259.608  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     532699.719   ± 2415.131  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     548379.219   ± 5177.036  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     575125.979   ± 2126.172  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     576906.534   ± 3100.258  ops/s
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

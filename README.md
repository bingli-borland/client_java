# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-11T08:28:46Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 60.05K | ± 1.07K | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.81K | ± 822.98 | ops/s | 1.2x slower |
| prometheusAdd | 48.20K | ± 1.37K | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.18K | ± 608.07 | ops/s | 1.4x slower |
| simpleclientInc | 6.06K | ± 70.39 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 5.93K | ± 24.27 | ops/s | 10x slower |
| simpleclientAdd | 5.83K | ± 361.69 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 4.86K | ± 1.10K | ops/s | 12x slower |
| openTelemetryInc | 3.97K | ± 363.42 | ops/s | 15x slower |
| openTelemetryAdd | 3.95K | ± 838.94 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.51K | ± 1.38K | ops/s | **fastest** |
| simpleclient | 4.24K | ± 34.64 | ops/s | 1.3x slower |
| prometheusNative | 2.73K | ± 125.57 | ops/s | 2.0x slower |
| openTelemetryClassic | 684.83 | ± 6.25 | ops/s | 8.0x slower |
| openTelemetryExponential | 564.83 | ± 16.75 | ops/s | 9.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 27.16K | ± 224.31 | ops/s | **fastest** |
| prometheusWriteToNull | 26.96K | ± 575.43 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 551.90K | ± 10.94K | ops/s | **fastest** |
| prometheusWriteToByteArray | 546.43K | ± 6.39K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 526.32K | ± 4.40K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 508.93K | ± 9.53K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44180.723    ± 608.071  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3945.439    ± 838.945  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3972.023    ± 363.418  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4857.555   ± 1100.699  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48196.448   ± 1367.359  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      60050.734   ± 1065.933  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51812.142    ± 822.983  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5829.387    ± 361.691  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6060.643     ± 70.385  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5928.634     ± 24.268  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        684.827      ± 6.250  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        564.832     ± 16.745  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5512.056   ± 1380.866  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2730.856    ± 125.569  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4238.141     ± 34.636  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27161.767    ± 224.307  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      26955.727    ± 575.425  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     508928.724   ± 9527.977  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     526318.275   ± 4401.372  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     546432.587   ± 6394.399  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     551897.673  ± 10944.476  ops/s
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

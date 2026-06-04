# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-04T08:07:22Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1015-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 58.45K | ± 2.78K | ops/s | **fastest** |
| prometheusNoLabelsInc | 50.88K | ± 1.35K | ops/s | 1.1x slower |
| prometheusAdd | 48.48K | ± 108.14 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.13K | ± 66.73 | ops/s | 1.3x slower |
| simpleclientInc | 6.21K | ± 3.62 | ops/s | 9.4x slower |
| simpleclientNoLabelsInc | 5.90K | ± 54.62 | ops/s | 9.9x slower |
| simpleclientAdd | 5.88K | ± 401.57 | ops/s | 9.9x slower |
| openTelemetryInc | 5.38K | ± 1.16K | ops/s | 11x slower |
| openTelemetryAdd | 4.54K | ± 892.24 | ops/s | 13x slower |
| openTelemetryIncNoLabels | 4.08K | ± 518.11 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.51K | ± 1.66K | ops/s | **fastest** |
| simpleclient | 4.32K | ± 54.33 | ops/s | 1.3x slower |
| prometheusNative | 3.12K | ± 59.77 | ops/s | 1.8x slower |
| openTelemetryClassic | 739.69 | ± 28.12 | ops/s | 7.4x slower |
| openTelemetryExponential | 574.11 | ± 33.22 | ops/s | 9.6x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.65K | ± 156.79 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.28K | ± 288.54 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 560.94K | ± 3.90K | ops/s | **fastest** |
| prometheusWriteToByteArray | 550.81K | ± 5.14K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 533.59K | ± 3.02K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 514.39K | ± 2.98K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44130.301     ± 66.727  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4538.795    ± 892.242  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5380.517   ± 1156.241  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4081.673    ± 518.114  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48475.497    ± 108.136  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      58454.427   ± 2783.451  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      50882.347   ± 1352.912  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5879.056    ± 401.570  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6205.162      ± 3.622  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5902.439     ± 54.621  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        739.685     ± 28.119  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        574.106     ± 33.223  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5508.431   ± 1656.922  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3122.912     ± 59.766  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4323.241     ± 54.328  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27280.062    ± 288.542  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27646.431    ± 156.794  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     514390.608   ± 2982.158  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     533592.085   ± 3017.501  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     550813.103   ± 5139.930  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     560936.895   ± 3898.362  ops/s
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

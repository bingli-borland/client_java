# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-04T09:32:53Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 57.31K | ± 3.13K | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.81K | ± 855.32 | ops/s | 1.1x slower |
| prometheusAdd | 48.49K | ± 144.11 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.61K | ± 420.52 | ops/s | 1.3x slower |
| simpleclientAdd | 6.14K | ± 55.65 | ops/s | 9.3x slower |
| simpleclientInc | 6.09K | ± 9.88 | ops/s | 9.4x slower |
| simpleclientNoLabelsInc | 5.88K | ± 57.99 | ops/s | 9.7x slower |
| openTelemetryIncNoLabels | 4.26K | ± 578.71 | ops/s | 13x slower |
| openTelemetryInc | 3.68K | ± 208.97 | ops/s | 16x slower |
| openTelemetryAdd | 3.44K | ± 149.83 | ops/s | 17x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.78K | ± 1.50K | ops/s | **fastest** |
| simpleclient | 4.19K | ± 16.27 | ops/s | 1.4x slower |
| prometheusNative | 3.06K | ± 151.23 | ops/s | 1.9x slower |
| openTelemetryClassic | 704.74 | ± 34.85 | ops/s | 8.2x slower |
| openTelemetryExponential | 538.77 | ± 19.49 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 27.49K | ± 68.60 | ops/s | **fastest** |
| prometheusWriteToNull | 27.21K | ± 393.72 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 583.81K | ± 1.42K | ops/s | **fastest** |
| prometheusWriteToByteArray | 572.39K | ± 2.37K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 552.57K | ± 4.60K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 536.78K | ± 3.06K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44605.446    ± 420.519  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3442.488    ± 149.827  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3680.208    ± 208.970  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4260.849    ± 578.713  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48491.959    ± 144.107  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      57305.578   ± 3130.247  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51812.020    ± 855.324  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6136.355     ± 55.645  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6091.626      ± 9.885  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5884.486     ± 57.988  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        704.738     ± 34.847  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        538.769     ± 19.488  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5778.853   ± 1498.021  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3061.800    ± 151.230  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4186.221     ± 16.265  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27486.082     ± 68.595  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27209.615    ± 393.716  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     536778.056   ± 3062.370  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     552568.300   ± 4604.714  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     572391.581   ± 2372.126  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     583808.537   ± 1420.794  ops/s
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

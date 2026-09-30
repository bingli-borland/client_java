# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-30T09:33:02Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 60.84K | ± 841.74 | ops/s | **fastest** |
| prometheusNoLabelsInc | 52.13K | ± 919.25 | ops/s | 1.2x slower |
| prometheusAdd | 47.62K | ± 833.02 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 44.23K | ± 199.86 | ops/s | 1.4x slower |
| simpleclientInc | 6.15K | ± 44.07 | ops/s | 9.9x slower |
| simpleclientAdd | 5.74K | ± 270.94 | ops/s | 11x slower |
| simpleclientNoLabelsInc | 5.61K | ± 447.35 | ops/s | 11x slower |
| openTelemetryInc | 4.65K | ± 1.29K | ops/s | 13x slower |
| openTelemetryIncNoLabels | 4.47K | ± 447.02 | ops/s | 14x slower |
| openTelemetryAdd | 4.19K | ± 1.05K | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.94K | ± 494.47 | ops/s | **fastest** |
| simpleclient | 4.36K | ± 30.54 | ops/s | 1.1x slower |
| prometheusNative | 2.97K | ± 257.02 | ops/s | 1.7x slower |
| openTelemetryClassic | 697.12 | ± 27.88 | ops/s | 7.1x slower |
| openTelemetryExponential | 548.52 | ± 9.33 | ops/s | 9.0x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.45K | ± 249.20 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.17K | ± 283.84 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 571.55K | ± 3.21K | ops/s | **fastest** |
| prometheusWriteToByteArray | 551.71K | ± 9.05K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 529.77K | ± 2.76K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 518.93K | ± 3.15K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44229.534    ± 199.860  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4185.974   ± 1047.823  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4652.913   ± 1294.939  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4472.195    ± 447.017  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      47624.034    ± 833.021  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      60836.320    ± 841.736  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      52127.849    ± 919.253  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5739.412    ± 270.936  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6153.685     ± 44.074  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5611.468    ± 447.347  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        697.115     ± 27.880  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        548.517      ± 9.330  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4942.367    ± 494.475  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2969.430    ± 257.023  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4358.278     ± 30.542  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27165.318    ± 283.836  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27454.396    ± 249.202  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     518933.829   ± 3149.888  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     529774.145   ± 2759.912  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     551710.225   ± 9047.140  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     571554.714   ± 3206.003  ops/s
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

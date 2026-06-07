# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-07T07:54:11Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1015-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.82K | ± 69.08 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.43K | ± 1.06K | ops/s | 1.2x slower |
| prometheusAdd | 48.28K | ± 293.82 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.98K | ± 110.84 | ops/s | 1.4x slower |
| simpleclientInc | 6.08K | ± 189.60 | ops/s | 9.8x slower |
| simpleclientAdd | 6.03K | ± 179.06 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 6.03K | ± 201.26 | ops/s | 9.9x slower |
| openTelemetryIncNoLabels | 5.41K | ± 1.20K | ops/s | 11x slower |
| openTelemetryInc | 4.06K | ± 323.85 | ops/s | 15x slower |
| openTelemetryAdd | 4.00K | ± 788.30 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.39K | ± 1.38K | ops/s | **fastest** |
| simpleclient | 4.40K | ± 54.65 | ops/s | 1.7x slower |
| prometheusNative | 2.73K | ± 66.51 | ops/s | 2.7x slower |
| openTelemetryClassic | 723.40 | ± 27.99 | ops/s | 10x slower |
| openTelemetryExponential | 545.94 | ± 10.45 | ops/s | 14x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.53K | ± 208.79 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.32K | ± 255.85 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 561.52K | ± 3.79K | ops/s | **fastest** |
| prometheusWriteToByteArray | 545.83K | ± 6.68K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 526.43K | ± 4.13K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 507.86K | ± 9.89K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43984.723    ± 110.839  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3996.306    ± 788.302  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4056.136    ± 323.854  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5412.986   ± 1198.616  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48283.767    ± 293.818  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59823.305     ± 69.076  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51434.687   ± 1064.264  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6031.358    ± 179.056  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6075.120    ± 189.597  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6027.662    ± 201.259  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        723.396     ± 27.991  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        545.941     ± 10.450  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7393.279   ± 1382.924  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2734.735     ± 66.506  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4396.241     ± 54.647  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27321.620    ± 255.853  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27530.114    ± 208.786  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     507862.969   ± 9887.691  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     526434.258   ± 4130.215  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     545834.067   ± 6680.458  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     561523.883   ± 3790.256  ops/s
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

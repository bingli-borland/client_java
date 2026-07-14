# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-14T06:14:22Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 58.33K | ± 2.46K | ops/s | **fastest** |
| prometheusNoLabelsInc | 50.58K | ± 1.11K | ops/s | 1.2x slower |
| prometheusAdd | 48.21K | ± 646.00 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.95K | ± 204.69 | ops/s | 1.3x slower |
| simpleclientInc | 6.16K | ± 76.46 | ops/s | 9.5x slower |
| simpleclientAdd | 6.00K | ± 134.53 | ops/s | 9.7x slower |
| simpleclientNoLabelsInc | 5.87K | ± 62.11 | ops/s | 9.9x slower |
| openTelemetryInc | 4.83K | ± 1.16K | ops/s | 12x slower |
| openTelemetryIncNoLabels | 4.73K | ± 1.44K | ops/s | 12x slower |
| openTelemetryAdd | 3.86K | ± 806.81 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.50K | ± 1.45K | ops/s | **fastest** |
| simpleclient | 4.52K | ± 85.75 | ops/s | 1.2x slower |
| prometheusNative | 3.04K | ± 128.53 | ops/s | 1.8x slower |
| openTelemetryClassic | 726.36 | ± 27.17 | ops/s | 7.6x slower |
| openTelemetryExponential | 541.44 | ± 35.06 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.46K | ± 386.82 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.34K | ± 261.27 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 580.29K | ± 4.59K | ops/s | **fastest** |
| prometheusWriteToByteArray | 567.41K | ± 5.87K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 545.20K | ± 2.93K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 528.39K | ± 2.14K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43953.308    ± 204.689  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3857.581    ± 806.811  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4827.725   ± 1164.419  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4727.039   ± 1442.321  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48213.342    ± 646.002  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      58326.248   ± 2455.923  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      50579.400   ± 1114.152  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5995.079    ± 134.528  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6155.259     ± 76.462  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5867.661     ± 62.114  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        726.363     ± 27.172  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        541.436     ± 35.056  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5498.422   ± 1445.473  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3039.356    ± 128.533  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4517.310     ± 85.753  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27338.545    ± 261.273  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27462.849    ± 386.824  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     528394.106   ± 2142.269  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     545196.572   ± 2932.797  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     567414.030   ± 5873.182  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     580294.666   ± 4592.405  ops/s
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

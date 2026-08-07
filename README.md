# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-07T05:47:19Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 60.30K | ± 649.17 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.47K | ± 483.83 | ops/s | 1.2x slower |
| prometheusAdd | 48.24K | ± 264.30 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 42.75K | ± 887.62 | ops/s | 1.4x slower |
| simpleclientAdd | 6.15K | ± 70.11 | ops/s | 9.8x slower |
| simpleclientInc | 6.12K | ± 69.17 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 5.91K | ± 31.44 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 5.64K | ± 797.37 | ops/s | 11x slower |
| openTelemetryAdd | 4.91K | ± 26.84 | ops/s | 12x slower |
| openTelemetryInc | 3.86K | ± 239.39 | ops/s | 16x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.83K | ± 824.87 | ops/s | **fastest** |
| simpleclient | 4.28K | ± 61.21 | ops/s | 1.1x slower |
| prometheusNative | 3.05K | ± 154.68 | ops/s | 1.6x slower |
| openTelemetryClassic | 690.91 | ± 10.25 | ops/s | 7.0x slower |
| openTelemetryExponential | 528.52 | ± 12.91 | ops/s | 9.1x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 27.19K | ± 299.62 | ops/s | **fastest** |
| prometheusWriteToNull | 27.07K | ± 1.08K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 585.58K | ± 2.09K | ops/s | **fastest** |
| prometheusWriteToByteArray | 575.08K | ± 4.82K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 555.95K | ± 1.94K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 536.74K | ± 2.51K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      42750.438    ± 887.620  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4909.664     ± 26.839  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3859.445    ± 239.392  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5640.532    ± 797.366  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48239.405    ± 264.303  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      60300.605    ± 649.174  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51474.140    ± 483.826  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6145.536     ± 70.112  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6120.145     ± 69.172  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5913.600     ± 31.438  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        690.914     ± 10.249  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        528.523     ± 12.906  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4829.678    ± 824.873  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3053.773    ± 154.675  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4282.965     ± 61.210  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27191.504    ± 299.621  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27072.302   ± 1079.028  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     536741.107   ± 2510.717  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     555947.422   ± 1940.354  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     575079.812   ± 4815.388  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     585575.726   ± 2093.663  ops/s
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

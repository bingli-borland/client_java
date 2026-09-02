# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-02T08:17:42Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.76K | ± 1.67K | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.37K | ± 1.23K | ops/s | 1.2x slower |
| prometheusAdd | 51.39K | ± 183.02 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.58K | ± 2.10K | ops/s | 1.3x slower |
| simpleclientInc | 6.60K | ± 86.51 | ops/s | 9.8x slower |
| simpleclientAdd | 6.37K | ± 216.92 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.27K | ± 86.00 | ops/s | 10x slower |
| openTelemetryInc | 3.71K | ± 118.46 | ops/s | 17x slower |
| openTelemetryIncNoLabels | 3.29K | ± 414.43 | ops/s | 20x slower |
| openTelemetryAdd | 3.23K | ± 374.07 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.22K | ± 1.41K | ops/s | **fastest** |
| simpleclient | 4.37K | ± 20.73 | ops/s | 1.4x slower |
| prometheusNative | 3.19K | ± 82.35 | ops/s | 1.9x slower |
| openTelemetryClassic | 756.92 | ± 44.58 | ops/s | 8.2x slower |
| openTelemetryExponential | 670.57 | ± 97.36 | ops/s | 9.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.08K | ± 879.19 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.60K | ± 846.85 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 507.16K | ± 7.17K | ops/s | **fastest** |
| prometheusWriteToByteArray | 495.32K | ± 7.55K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 483.44K | ± 6.91K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 479.45K | ± 6.11K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49575.600   ± 2101.837  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3225.598    ± 374.071  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3709.182    ± 118.455  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3291.502    ± 414.428  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51385.969    ± 183.020  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64757.664   ± 1674.160  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55368.345   ± 1234.687  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6367.690    ± 216.924  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6596.874     ± 86.507  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6267.890     ± 86.002  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        756.921     ± 44.578  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        670.573     ± 97.356  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6218.272   ± 1412.407  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3192.655     ± 82.346  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4374.481     ± 20.730  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23597.214    ± 846.853  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24082.373    ± 879.186  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     479446.084   ± 6111.360  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     483438.894   ± 6907.462  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     495322.039   ± 7553.949  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     507161.434   ± 7166.937  ops/s
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

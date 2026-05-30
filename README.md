# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-05-30T07:11:17Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1015-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.75K | ± 147.89 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.01K | ± 966.86 | ops/s | 1.2x slower |
| prometheusAdd | 50.35K | ± 179.43 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.74K | ± 1.14K | ops/s | 1.3x slower |
| simpleclientInc | 6.59K | ± 15.31 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.36K | ± 32.38 | ops/s | 10x slower |
| simpleclientAdd | 6.24K | ± 403.44 | ops/s | 11x slower |
| openTelemetryInc | 3.75K | ± 741.55 | ops/s | 18x slower |
| openTelemetryAdd | 3.68K | ± 388.20 | ops/s | 18x slower |
| openTelemetryIncNoLabels | 2.94K | ± 227.10 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.68K | ± 443.99 | ops/s | **fastest** |
| simpleclient | 4.38K | ± 112.22 | ops/s | 1.5x slower |
| prometheusNative | 3.01K | ± 357.60 | ops/s | 2.2x slower |
| openTelemetryClassic | 751.11 | ± 29.15 | ops/s | 8.9x slower |
| openTelemetryExponential | 624.42 | ± 50.39 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 24.58K | ± 455.64 | ops/s | **fastest** |
| prometheusWriteToNull | 22.52K | ± 933.02 | ops/s | 1.1x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 509.12K | ± 2.76K | ops/s | **fastest** |
| prometheusWriteToByteArray | 497.38K | ± 2.80K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 483.27K | ± 4.88K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 479.26K | ± 5.87K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48735.073   ± 1135.690  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3681.056    ± 388.198  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3752.070    ± 741.553  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2937.923    ± 227.101  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50349.266    ± 179.434  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65745.177    ± 147.885  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56010.926    ± 966.857  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6242.330    ± 403.438  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6594.835     ± 15.312  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6357.790     ± 32.375  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        751.110     ± 29.149  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        624.421     ± 50.387  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6678.183    ± 443.990  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3006.308    ± 357.601  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4378.122    ± 112.218  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      24584.410    ± 455.638  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      22523.923    ± 933.019  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     479257.783   ± 5870.126  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     483268.791   ± 4878.389  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     497378.662   ± 2797.747  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     509116.665   ± 2761.557  ops/s
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

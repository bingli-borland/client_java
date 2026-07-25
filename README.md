# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-25T06:37:46Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.39K | ± 1.68K | ops/s | **fastest** |
| prometheusNoLabelsInc | 57.14K | ± 111.47 | ops/s | 1.1x slower |
| prometheusAdd | 51.09K | ± 712.93 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.09K | ± 1.50K | ops/s | 1.3x slower |
| simpleclientInc | 6.55K | ± 33.81 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.34K | ± 9.88 | ops/s | 10x slower |
| simpleclientAdd | 6.00K | ± 194.62 | ops/s | 11x slower |
| openTelemetryAdd | 3.29K | ± 324.74 | ops/s | 20x slower |
| openTelemetryIncNoLabels | 3.29K | ± 264.25 | ops/s | 20x slower |
| openTelemetryInc | 3.06K | ± 276.83 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.27K | ± 1.03K | ops/s | **fastest** |
| simpleclient | 4.39K | ± 14.00 | ops/s | 1.4x slower |
| prometheusNative | 2.81K | ± 271.87 | ops/s | 2.2x slower |
| openTelemetryClassic | 756.71 | ± 12.41 | ops/s | 8.3x slower |
| openTelemetryExponential | 613.90 | ± 91.40 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.66K | ± 634.78 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.49K | ± 613.33 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 487.82K | ± 4.14K | ops/s | **fastest** |
| prometheusWriteToByteArray | 484.02K | ± 4.51K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 459.07K | ± 6.26K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 456.44K | ± 5.72K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49093.317   ± 1496.539  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3290.750    ± 324.742  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3060.989    ± 276.831  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3290.110    ± 264.248  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51085.127    ± 712.925  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65386.208   ± 1680.426  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      57137.687    ± 111.474  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5995.584    ± 194.623  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6551.921     ± 33.811  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6344.842      ± 9.877  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        756.707     ± 12.409  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        613.900     ± 91.401  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6267.980   ± 1030.369  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2813.935    ± 271.869  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4394.997     ± 14.003  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23491.782    ± 613.326  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23664.858    ± 634.784  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     456441.622   ± 5715.488  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     459071.507   ± 6255.463  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     484020.489   ± 4507.639  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     487821.182   ± 4144.197  ops/s
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

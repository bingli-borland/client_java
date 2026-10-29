# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-29T09:34:28Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** INTEL(R) XEON(R) PLATINUM 8573C, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| codahaleIncNoLabels | 27.04K | ± 185.50 | ops/s | **fastest** |
| prometheusInc | 26.37K | ± 991.47 | ops/s | 1.0x slower |
| prometheusNoLabelsInc | 26.16K | ± 93.52 | ops/s | 1.0x slower |
| prometheusAdd | 25.45K | ± 214.33 | ops/s | 1.1x slower |
| simpleclientInc | 6.53K | ± 42.25 | ops/s | 4.1x slower |
| simpleclientNoLabelsInc | 6.32K | ± 113.99 | ops/s | 4.3x slower |
| simpleclientAdd | 6.31K | ± 38.54 | ops/s | 4.3x slower |
| openTelemetryIncNoLabels | 2.14K | ± 331.60 | ops/s | 13x slower |
| openTelemetryInc | 2.12K | ± 72.71 | ops/s | 13x slower |
| openTelemetryAdd | 2.01K | ± 332.09 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.15K | ± 55.41 | ops/s | **fastest** |
| prometheusClassic | 2.53K | ± 447.80 | ops/s | 1.6x slower |
| prometheusNative | 2.29K | ± 128.48 | ops/s | 1.8x slower |
| openTelemetryClassic | 522.23 | ± 17.54 | ops/s | 8.0x slower |
| openTelemetryExponential | 366.16 | ± 13.59 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 17.48K | ± 72.45 | ops/s | **fastest** |
| prometheusWriteToNull | 17.47K | ± 72.84 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 297.58K | ± 1.60K | ops/s | **fastest** |
| prometheusWriteToByteArray | 295.68K | ± 1.27K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 279.04K | ± 1.02K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 278.91K | ± 1.34K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      27042.604    ± 185.497  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2013.757    ± 332.090  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2119.715     ± 72.714  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2138.271    ± 331.603  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      25450.074    ± 214.334  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      26371.410    ± 991.471  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      26155.834     ± 93.519  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6313.393     ± 38.541  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6531.149     ± 42.249  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6318.819    ± 113.988  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        522.228     ± 17.535  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        366.159     ± 13.589  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2534.321    ± 447.803  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2286.653    ± 128.477  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4153.567     ± 55.415  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      17479.645     ± 72.451  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      17474.521     ± 72.839  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     278909.606   ± 1344.118  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     279042.946   ± 1017.757  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     295678.166   ± 1274.543  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     297575.971   ± 1595.006  ops/s
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

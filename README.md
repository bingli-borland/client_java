# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-28T06:38:11Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.22K | ± 1.43K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.82K | ± 258.59 | ops/s | 1.1x slower |
| prometheusAdd | 50.67K | ± 1.24K | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.95K | ± 1.40K | ops/s | 1.3x slower |
| simpleclientInc | 6.53K | ± 50.56 | ops/s | 10.0x slower |
| simpleclientAdd | 6.36K | ± 208.84 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.34K | ± 17.71 | ops/s | 10x slower |
| openTelemetryAdd | 3.19K | ± 384.11 | ops/s | 20x slower |
| openTelemetryInc | 2.99K | ± 266.80 | ops/s | 22x slower |
| openTelemetryIncNoLabels | 2.92K | ± 77.68 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.33K | ± 1.45K | ops/s | **fastest** |
| simpleclient | 4.36K | ± 174.34 | ops/s | 1.2x slower |
| prometheusNative | 2.69K | ± 115.20 | ops/s | 2.0x slower |
| openTelemetryClassic | 755.20 | ± 7.55 | ops/s | 7.1x slower |
| openTelemetryExponential | 592.49 | ± 55.12 | ops/s | 9.0x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.59K | ± 185.17 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.12K | ± 560.21 | ops/s | 1.1x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 491.01K | ± 4.45K | ops/s | **fastest** |
| prometheusWriteToByteArray | 486.08K | ± 6.43K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 470.77K | ± 3.59K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 457.23K | ± 5.61K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48947.246   ± 1401.110  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3194.152    ± 384.105  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2988.551    ± 266.804  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2918.327     ± 77.681  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50665.249   ± 1242.583  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65223.703   ± 1429.617  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56822.549    ± 258.594  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6363.950    ± 208.836  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6531.609     ± 50.563  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6341.395     ± 17.714  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        755.204      ± 7.546  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        592.486     ± 55.122  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5334.274   ± 1445.963  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2686.361    ± 115.198  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4357.875    ± 174.336  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23122.788    ± 560.209  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24586.322    ± 185.169  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     457225.769   ± 5612.026  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     470765.580   ± 3588.314  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     486084.816   ± 6430.009  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     491014.000   ± 4452.096  ops/s
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

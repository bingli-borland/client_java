# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-10T10:49:39Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.27K | ± 559.95 | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.67K | ± 641.36 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 50.27K | ± 148.44 | ops/s | 1.3x slower |
| prometheusAdd | 48.62K | ± 4.31K | ops/s | 1.4x slower |
| simpleclientInc | 6.49K | ± 48.12 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.27K | ± 29.66 | ops/s | 11x slower |
| simpleclientAdd | 6.20K | ± 160.16 | ops/s | 11x slower |
| openTelemetryInc | 3.27K | ± 341.74 | ops/s | 20x slower |
| openTelemetryAdd | 3.22K | ± 246.44 | ops/s | 21x slower |
| openTelemetryIncNoLabels | 3.11K | ± 74.94 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.32K | ± 2.17K | ops/s | **fastest** |
| simpleclient | 4.38K | ± 57.68 | ops/s | 1.7x slower |
| prometheusNative | 2.78K | ± 352.66 | ops/s | 2.6x slower |
| openTelemetryClassic | 817.94 | ± 49.32 | ops/s | 8.9x slower |
| openTelemetryExponential | 622.45 | ± 11.92 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.47K | ± 1.43K | ops/s | **fastest** |
| openMetricsWriteToNull | 23.06K | ± 475.87 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 471.80K | ± 2.59K | ops/s | **fastest** |
| prometheusWriteToNull | 466.89K | ± 3.18K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 453.95K | ± 4.08K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 444.56K | ± 5.58K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      50273.080    ± 148.445  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3217.941    ± 246.439  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3266.466    ± 341.737  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3111.434     ± 74.943  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48618.068   ± 4313.120  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66271.919    ± 559.954  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55669.354    ± 641.362  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6196.709    ± 160.163  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6491.552     ± 48.124  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6267.171     ± 29.655  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        817.938     ± 49.319  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        622.451     ± 11.925  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7316.139   ± 2174.745  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2777.337    ± 352.664  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4377.256     ± 57.681  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23056.937    ± 475.867  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23473.518   ± 1430.644  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     444563.906   ± 5583.927  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     453947.554   ± 4079.916  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     471798.079   ± 2587.233  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     466886.048   ± 3183.603  ops/s
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

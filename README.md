# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-04T06:37:55Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 77.51K | ± 1.36K | ops/s | **fastest** |
| prometheusNoLabelsInc | 67.14K | ± 606.05 | ops/s | 1.2x slower |
| prometheusAdd | 62.74K | ± 268.78 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 56.95K | ± 417.86 | ops/s | 1.4x slower |
| simpleclientInc | 7.95K | ± 82.19 | ops/s | 9.7x slower |
| openTelemetryInc | 7.91K | ± 43.27 | ops/s | 9.8x slower |
| simpleclientAdd | 7.88K | ± 29.68 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 7.60K | ± 5.73 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 7.51K | ± 1.65K | ops/s | 10x slower |
| openTelemetryAdd | 5.66K | ± 1.37K | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 9.57K | ± 2.90K | ops/s | **fastest** |
| simpleclient | 5.60K | ± 35.19 | ops/s | 1.7x slower |
| prometheusNative | 3.79K | ± 293.53 | ops/s | 2.5x slower |
| openTelemetryClassic | 954.80 | ± 46.99 | ops/s | 10x slower |
| openTelemetryExponential | 720.74 | ± 14.45 | ops/s | 13x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 35.28K | ± 426.36 | ops/s | **fastest** |
| openMetricsWriteToNull | 35.06K | ± 173.35 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 702.00K | ± 4.34K | ops/s | **fastest** |
| prometheusWriteToByteArray | 690.77K | ± 6.96K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 666.61K | ± 4.02K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 648.87K | ± 3.78K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      56953.320    ± 417.862  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       5656.805   ± 1366.148  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       7911.803     ± 43.269  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       7513.679   ± 1651.105  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      62739.692    ± 268.781  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      77511.687   ± 1364.720  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      67137.717    ± 606.048  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7884.269     ± 29.680  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7950.930     ± 82.190  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7601.467      ± 5.732  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        954.803     ± 46.987  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        720.740     ± 14.445  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       9574.800   ± 2895.135  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3791.321    ± 293.529  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5596.379     ± 35.186  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      35059.864    ± 173.347  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      35277.439    ± 426.357  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     648865.345   ± 3775.508  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     666612.003   ± 4017.033  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     690766.644   ± 6958.594  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     702001.961   ± 4339.290  ops/s
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

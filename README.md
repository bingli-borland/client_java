# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-08T09:58:53Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.53K | ± 738.30 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.40K | ± 1.22K | ops/s | 1.2x slower |
| prometheusAdd | 51.38K | ± 69.95 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.04K | ± 578.32 | ops/s | 1.4x slower |
| simpleclientInc | 6.51K | ± 112.45 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.36K | ± 28.68 | ops/s | 10x slower |
| simpleclientAdd | 6.31K | ± 272.37 | ops/s | 11x slower |
| openTelemetryInc | 3.37K | ± 388.70 | ops/s | 20x slower |
| openTelemetryAdd | 3.17K | ± 316.99 | ops/s | 21x slower |
| openTelemetryIncNoLabels | 3.06K | ± 215.11 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.44K | ± 2.78K | ops/s | **fastest** |
| simpleclient | 4.35K | ± 33.92 | ops/s | 1.7x slower |
| prometheusNative | 3.06K | ± 385.69 | ops/s | 2.4x slower |
| openTelemetryClassic | 771.06 | ± 22.02 | ops/s | 9.6x slower |
| openTelemetryExponential | 675.09 | ± 105.85 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.93K | ± 1.30K | ops/s | **fastest** |
| prometheusWriteToNull | 22.81K | ± 530.48 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 508.34K | ± 7.48K | ops/s | **fastest** |
| prometheusWriteToNull | 506.65K | ± 2.79K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 486.37K | ± 3.67K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 481.99K | ± 6.44K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48037.694    ± 578.316  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3168.828    ± 316.985  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3368.545    ± 388.698  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3057.750    ± 215.114  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51375.777     ± 69.953  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66527.576    ± 738.301  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56402.405   ± 1222.910  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6312.843    ± 272.370  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6512.466    ± 112.454  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6359.991     ± 28.684  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        771.056     ± 22.017  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        675.086    ± 105.855  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7440.445   ± 2778.417  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3055.140    ± 385.694  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4347.346     ± 33.916  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23925.898   ± 1303.608  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      22810.956    ± 530.482  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     481985.379   ± 6436.263  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     486368.190   ± 3670.308  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     508340.160   ± 7475.248  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     506649.929   ± 2787.517  ops/s
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

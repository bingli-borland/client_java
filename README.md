# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-14T08:05:46Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 58.80K | ± 2.96K | ops/s | **fastest** |
| prometheusNoLabelsInc | 50.58K | ± 1.16K | ops/s | 1.2x slower |
| prometheusAdd | 48.20K | ± 317.01 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.25K | ± 493.64 | ops/s | 1.3x slower |
| simpleclientInc | 6.09K | ± 90.74 | ops/s | 9.6x slower |
| simpleclientAdd | 6.04K | ± 182.80 | ops/s | 9.7x slower |
| simpleclientNoLabelsInc | 5.89K | ± 5.78 | ops/s | 10.0x slower |
| openTelemetryInc | 5.51K | ± 922.98 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 5.34K | ± 904.95 | ops/s | 11x slower |
| openTelemetryAdd | 4.57K | ± 851.88 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.14K | ± 1.80K | ops/s | **fastest** |
| simpleclient | 4.60K | ± 119.39 | ops/s | 1.1x slower |
| prometheusNative | 2.89K | ± 219.26 | ops/s | 1.8x slower |
| openTelemetryClassic | 721.76 | ± 1.03 | ops/s | 7.1x slower |
| openTelemetryExponential | 551.73 | ± 8.37 | ops/s | 9.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.62K | ± 168.33 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.40K | ± 173.98 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 584.77K | ± 1.91K | ops/s | **fastest** |
| prometheusWriteToByteArray | 569.33K | ± 12.81K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 547.58K | ± 2.95K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 535.50K | ± 6.65K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44247.435    ± 493.635  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4572.107    ± 851.881  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5510.373    ± 922.980  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5337.666    ± 904.952  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48198.354    ± 317.013  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      58802.178   ± 2962.461  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      50584.440   ± 1158.267  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6035.267    ± 182.803  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6093.614     ± 90.744  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5893.661      ± 5.776  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        721.763      ± 1.029  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        551.728      ± 8.372  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5138.002   ± 1795.735  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2887.731    ± 219.262  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4603.149    ± 119.393  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27402.273    ± 173.982  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27621.206    ± 168.326  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     535499.120   ± 6652.535  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     547583.589   ± 2948.380  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     569334.500  ± 12810.320  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     584771.267   ± 1907.347  ops/s
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

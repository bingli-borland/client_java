# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-14T05:31:12Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.30K | ± 1.32K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.93K | ± 393.44 | ops/s | 1.1x slower |
| prometheusAdd | 51.38K | ± 130.73 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.43K | ± 1.43K | ops/s | 1.3x slower |
| simpleclientInc | 6.61K | ± 42.09 | ops/s | 9.7x slower |
| simpleclientNoLabelsInc | 6.43K | ± 131.48 | ops/s | 10.0x slower |
| simpleclientAdd | 6.23K | ± 330.36 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.43K | ± 317.00 | ops/s | 19x slower |
| openTelemetryAdd | 2.99K | ± 242.86 | ops/s | 22x slower |
| openTelemetryInc | 2.98K | ± 176.33 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.35K | ± 1.58K | ops/s | **fastest** |
| simpleclient | 4.45K | ± 63.66 | ops/s | 1.4x slower |
| prometheusNative | 2.76K | ± 337.47 | ops/s | 2.3x slower |
| openTelemetryClassic | 769.85 | ± 23.18 | ops/s | 8.3x slower |
| openTelemetryExponential | 691.94 | ± 63.33 | ops/s | 9.2x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.39K | ± 1.33K | ops/s | **fastest** |
| prometheusWriteToNull | 23.06K | ± 479.33 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 508.80K | ± 6.63K | ops/s | **fastest** |
| prometheusWriteToByteArray | 501.36K | ± 3.92K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 490.73K | ± 2.33K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 484.97K | ± 2.93K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48427.357   ± 1427.276  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2987.597    ± 242.863  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2975.284    ± 176.325  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3427.185    ± 316.998  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51383.611    ± 130.726  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64304.562   ± 1324.480  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56932.757    ± 393.437  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6234.358    ± 330.355  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6614.739     ± 42.093  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6431.241    ± 131.482  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        769.850     ± 23.182  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        691.939     ± 63.326  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6354.217   ± 1582.967  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2763.537    ± 337.466  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4447.882     ± 63.657  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23392.889   ± 1330.007  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23055.657    ± 479.326  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     484968.355   ± 2929.694  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     490734.313   ± 2326.914  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     501358.031   ± 3923.939  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     508796.452   ± 6629.525  ops/s
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

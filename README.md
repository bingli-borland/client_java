# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-21T08:15:30Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.71K | ± 209.98 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.62K | ± 265.27 | ops/s | 1.2x slower |
| prometheusAdd | 51.40K | ± 219.45 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.14K | ± 1.70K | ops/s | 1.3x slower |
| simpleclientInc | 6.56K | ± 34.18 | ops/s | 10x slower |
| simpleclientAdd | 6.50K | ± 48.85 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.34K | ± 9.95 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.38K | ± 531.75 | ops/s | 19x slower |
| openTelemetryAdd | 3.31K | ± 628.21 | ops/s | 20x slower |
| openTelemetryInc | 3.10K | ± 206.99 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.76K | ± 1.26K | ops/s | **fastest** |
| simpleclient | 4.39K | ± 20.46 | ops/s | 1.3x slower |
| prometheusNative | 2.83K | ± 283.64 | ops/s | 2.0x slower |
| openTelemetryClassic | 757.60 | ± 46.55 | ops/s | 7.6x slower |
| openTelemetryExponential | 639.65 | ± 65.58 | ops/s | 9.0x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.82K | ± 533.50 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.10K | ± 930.62 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 497.30K | ± 3.98K | ops/s | **fastest** |
| prometheusWriteToByteArray | 485.60K | ± 5.23K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 476.30K | ± 9.68K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 476.14K | ± 2.22K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49135.695   ± 1696.581  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3305.982    ± 628.211  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3099.106    ± 206.992  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3379.149    ± 531.750  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51403.327    ± 219.452  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65711.998    ± 209.983  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56618.726    ± 265.270  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6501.833     ± 48.852  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6558.018     ± 34.178  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6340.923      ± 9.954  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        757.599     ± 46.550  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        639.651     ± 65.582  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5763.363   ± 1255.882  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2831.667    ± 283.638  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4393.669     ± 20.458  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23100.953    ± 930.620  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23819.214    ± 533.499  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     476138.015   ± 2219.837  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     476300.517   ± 9678.807  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     485601.972   ± 5226.096  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     497298.291   ± 3979.584  ops/s
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

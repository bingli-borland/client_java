# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-23T08:33:40Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.65K | ± 425.75 | ops/s | **fastest** |
| prometheusNoLabelsInc | 57.09K | ± 284.63 | ops/s | 1.2x slower |
| prometheusAdd | 50.61K | ± 463.45 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 46.11K | ± 4.09K | ops/s | 1.4x slower |
| simpleclientInc | 6.57K | ± 23.72 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.38K | ± 35.27 | ops/s | 10x slower |
| simpleclientAdd | 6.15K | ± 221.37 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 3.47K | ± 740.15 | ops/s | 19x slower |
| openTelemetryAdd | 3.42K | ± 66.98 | ops/s | 19x slower |
| openTelemetryInc | 2.99K | ± 280.30 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.59K | ± 2.23K | ops/s | **fastest** |
| simpleclient | 4.38K | ± 16.45 | ops/s | 1.5x slower |
| prometheusNative | 2.79K | ± 254.07 | ops/s | 2.4x slower |
| openTelemetryClassic | 731.72 | ± 41.69 | ops/s | 9.0x slower |
| openTelemetryExponential | 607.12 | ± 88.59 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.38K | ± 292.94 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.24K | ± 190.17 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 500.17K | ± 3.61K | ops/s | **fastest** |
| prometheusWriteToByteArray | 489.94K | ± 6.77K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 472.93K | ± 8.40K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 467.66K | ± 8.15K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      46111.582   ± 4094.244  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3418.210     ± 66.984  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2985.423    ± 280.301  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3470.914    ± 740.146  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50606.171    ± 463.455  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66653.330    ± 425.751  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      57093.071    ± 284.633  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6151.181    ± 221.366  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6569.950     ± 23.717  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6375.256     ± 35.266  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        731.719     ± 41.688  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        607.118     ± 88.586  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6593.771   ± 2232.264  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2793.849    ± 254.069  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4378.675     ± 16.454  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23238.820    ± 190.169  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23378.507    ± 292.936  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     467661.373   ± 8146.718  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     472930.430   ± 8399.305  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     489942.229   ± 6772.909  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     500166.471   ± 3612.250  ops/s
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

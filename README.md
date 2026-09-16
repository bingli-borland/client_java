# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-16T08:47:30Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.23K | ± 660.18 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.43K | ± 1.10K | ops/s | 1.2x slower |
| prometheusAdd | 50.90K | ± 727.57 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.32K | ± 1.32K | ops/s | 1.4x slower |
| simpleclientInc | 6.65K | ± 112.09 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.42K | ± 131.55 | ops/s | 10x slower |
| simpleclientAdd | 6.23K | ± 351.24 | ops/s | 11x slower |
| openTelemetryInc | 3.38K | ± 237.32 | ops/s | 20x slower |
| openTelemetryIncNoLabels | 3.06K | ± 317.57 | ops/s | 22x slower |
| openTelemetryAdd | 2.89K | ± 139.65 | ops/s | 23x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.51K | ± 1.32K | ops/s | **fastest** |
| simpleclient | 4.41K | ± 14.94 | ops/s | 1.2x slower |
| prometheusNative | 2.74K | ± 259.35 | ops/s | 2.0x slower |
| openTelemetryClassic | 727.14 | ± 14.68 | ops/s | 7.6x slower |
| openTelemetryExponential | 652.58 | ± 44.43 | ops/s | 8.4x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.97K | ± 999.56 | ops/s | **fastest** |
| prometheusWriteToNull | 23.54K | ± 695.69 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 509.17K | ± 1.94K | ops/s | **fastest** |
| prometheusWriteToByteArray | 502.26K | ± 1.68K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 491.11K | ± 4.08K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 479.65K | ± 6.64K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48318.187   ± 1323.197  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2888.997    ± 139.654  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3379.562    ± 237.315  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3057.128    ± 317.575  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50895.599    ± 727.571  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66229.444    ± 660.178  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56427.432   ± 1097.769  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6234.328    ± 351.242  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6648.253    ± 112.092  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6415.389    ± 131.547  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        727.144     ± 14.680  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        652.585     ± 44.435  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5509.114   ± 1317.877  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2735.374    ± 259.345  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4409.338     ± 14.943  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23973.671    ± 999.556  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23543.271    ± 695.691  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     479651.234   ± 6638.739  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     491114.541   ± 4076.824  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     502259.752   ± 1680.121  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     509172.594   ± 1935.602  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-23T04:26:13Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.03K | ± 422.79 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.41K | ± 1.07K | ops/s | 1.2x slower |
| prometheusAdd | 51.21K | ± 524.37 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 50.17K | ± 93.98 | ops/s | 1.3x slower |
| simpleclientInc | 6.53K | ± 34.33 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.40K | ± 138.15 | ops/s | 10x slower |
| simpleclientAdd | 6.33K | ± 185.54 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.54K | ± 174.76 | ops/s | 19x slower |
| openTelemetryInc | 3.43K | ± 376.65 | ops/s | 19x slower |
| openTelemetryAdd | 3.09K | ± 74.01 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.15K | ± 1.14K | ops/s | **fastest** |
| simpleclient | 4.38K | ± 45.73 | ops/s | 1.2x slower |
| prometheusNative | 2.85K | ± 307.46 | ops/s | 1.8x slower |
| openTelemetryClassic | 749.02 | ± 23.71 | ops/s | 6.9x slower |
| openTelemetryExponential | 664.71 | ± 82.27 | ops/s | 7.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.75K | ± 409.10 | ops/s | **fastest** |
| openMetricsWriteToNull | 22.98K | ± 514.13 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 503.74K | ± 6.16K | ops/s | **fastest** |
| prometheusWriteToByteArray | 485.48K | ± 8.64K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 475.95K | ± 8.44K | ops/s | 1.1x slower |
| openMetricsWriteToNull | 471.25K | ± 11.30K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      50169.994     ± 93.982  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3088.626     ± 74.006  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3428.473    ± 376.647  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3536.750    ± 174.758  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51213.653    ± 524.371  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66034.882    ± 422.785  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56410.908   ± 1067.043  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6333.383    ± 185.537  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6534.064     ± 34.331  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6404.955    ± 138.150  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        749.016     ± 23.705  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        664.709     ± 82.271  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5153.477   ± 1138.155  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2847.435    ± 307.457  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4375.778     ± 45.727  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      22975.641    ± 514.126  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23750.998    ± 409.102  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     475950.192   ± 8437.653  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     471247.765  ± 11295.274  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     485475.162   ± 8640.850  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     503743.823   ± 6155.506  ops/s
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

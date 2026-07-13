# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-13T07:01:52Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 58.00K | ± 1.56K | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.51K | ± 486.33 | ops/s | 1.1x slower |
| prometheusAdd | 49.23K | ± 843.55 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.55K | ± 1.52K | ops/s | 1.3x slower |
| simpleclientInc | 6.14K | ± 89.31 | ops/s | 9.4x slower |
| simpleclientAdd | 5.93K | ± 366.40 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 5.90K | ± 29.42 | ops/s | 9.8x slower |
| openTelemetryInc | 5.43K | ± 735.12 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 5.26K | ± 1.41K | ops/s | 11x slower |
| openTelemetryAdd | 4.65K | ± 884.22 | ops/s | 12x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.53K | ± 1.26K | ops/s | **fastest** |
| simpleclient | 4.55K | ± 31.26 | ops/s | 1.4x slower |
| prometheusNative | 3.05K | ± 160.78 | ops/s | 2.1x slower |
| openTelemetryClassic | 700.67 | ± 22.19 | ops/s | 9.3x slower |
| openTelemetryExponential | 589.27 | ± 43.97 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 27.21K | ± 170.35 | ops/s | **fastest** |
| prometheusWriteToNull | 27.10K | ± 378.42 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 583.63K | ± 7.63K | ops/s | **fastest** |
| prometheusWriteToByteArray | 567.47K | ± 4.03K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 540.19K | ± 3.06K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 533.22K | ± 3.63K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43552.098   ± 1519.346  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4652.428    ± 884.222  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5431.467    ± 735.116  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5258.888   ± 1405.817  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      49228.044    ± 843.547  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      57997.838   ± 1555.569  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51506.410    ± 486.333  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5926.090    ± 366.398  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6137.406     ± 89.312  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5902.194     ± 29.416  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        700.668     ± 22.188  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        589.267     ± 43.966  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6532.730   ± 1255.999  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3054.032    ± 160.783  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4547.128     ± 31.256  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27212.928    ± 170.351  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27101.101    ± 378.421  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     533221.799   ± 3634.916  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     540189.679   ± 3056.704  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     567471.645   ± 4034.741  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     583628.383   ± 7627.786  ops/s
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

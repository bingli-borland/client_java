# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-06T08:19:07Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.58K | ± 631.85 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.48K | ± 89.18 | ops/s | 1.2x slower |
| prometheusAdd | 51.54K | ± 117.42 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 50.24K | ± 993.22 | ops/s | 1.3x slower |
| simpleclientInc | 6.56K | ± 38.37 | ops/s | 10x slower |
| simpleclientAdd | 6.35K | ± 201.20 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.34K | ± 11.04 | ops/s | 10x slower |
| openTelemetryInc | 4.14K | ± 28.40 | ops/s | 16x slower |
| openTelemetryAdd | 3.57K | ± 584.15 | ops/s | 18x slower |
| openTelemetryIncNoLabels | 3.10K | ± 98.98 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.78K | ± 956.77 | ops/s | **fastest** |
| simpleclient | 4.48K | ± 25.78 | ops/s | 1.1x slower |
| prometheusNative | 2.80K | ± 193.73 | ops/s | 1.7x slower |
| openTelemetryClassic | 750.29 | ± 45.74 | ops/s | 6.4x slower |
| openTelemetryExponential | 593.09 | ± 46.25 | ops/s | 8.1x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.67K | ± 481.55 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.18K | ± 964.02 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 515.52K | ± 4.74K | ops/s | **fastest** |
| prometheusWriteToByteArray | 506.78K | ± 3.62K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 490.59K | ± 2.70K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 440.78K | ± 52.32K | ops/s | 1.2x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      50240.139    ± 993.221  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3569.964    ± 584.155  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4143.806     ± 28.398  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3104.441     ± 98.982  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51538.809    ± 117.419  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65579.289    ± 631.849  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56476.042     ± 89.177  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6347.703    ± 201.196  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6556.122     ± 38.371  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6338.888     ± 11.041  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        750.288     ± 45.740  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        593.089     ± 46.253  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4776.015    ± 956.767  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2802.826    ± 193.731  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4480.259     ± 25.783  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23177.564    ± 964.024  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23672.260    ± 481.554  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     440782.639  ± 52318.631  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     490593.887   ± 2701.905  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     506777.359   ± 3619.634  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     515524.551   ± 4738.111  ops/s
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

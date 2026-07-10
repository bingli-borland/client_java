# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-10T07:28:48Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.31K | ± 1.08K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.93K | ± 328.08 | ops/s | 1.1x slower |
| prometheusAdd | 51.29K | ± 155.07 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.56K | ± 911.83 | ops/s | 1.3x slower |
| simpleclientInc | 6.58K | ± 9.62 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 6.36K | ± 23.52 | ops/s | 10x slower |
| simpleclientAdd | 6.20K | ± 402.15 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.85K | ± 352.96 | ops/s | 17x slower |
| openTelemetryAdd | 3.30K | ± 467.84 | ops/s | 19x slower |
| openTelemetryInc | 3.28K | ± 112.16 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.33K | ± 977.56 | ops/s | **fastest** |
| simpleclient | 4.46K | ± 18.79 | ops/s | 1.4x slower |
| prometheusNative | 2.72K | ± 129.89 | ops/s | 2.3x slower |
| openTelemetryClassic | 769.34 | ± 21.36 | ops/s | 8.2x slower |
| openTelemetryExponential | 618.63 | ± 61.75 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.22K | ± 199.64 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.29K | ± 563.20 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 490.18K | ± 4.46K | ops/s | **fastest** |
| prometheusWriteToByteArray | 487.01K | ± 3.98K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 475.57K | ± 3.94K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 466.29K | ± 6.01K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49564.731    ± 911.825  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3297.923    ± 467.840  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3284.980    ± 112.162  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3853.482    ± 352.960  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51290.535    ± 155.068  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64305.138   ± 1080.419  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56931.656    ± 328.083  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6203.221    ± 402.146  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6576.008      ± 9.619  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6359.828     ± 23.521  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        769.345     ± 21.359  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        618.631     ± 61.752  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6325.836    ± 977.555  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2720.870    ± 129.886  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4456.432     ± 18.792  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23292.771    ± 563.198  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24215.131    ± 199.636  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     466286.811   ± 6010.871  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     475565.674   ± 3942.865  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     487013.510   ± 3981.515  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     490177.189   ± 4459.235  ops/s
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

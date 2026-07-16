# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-16T06:34:15Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.98K | ± 2.24K | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.47K | ± 1.29K | ops/s | 1.2x slower |
| prometheusAdd | 51.01K | ± 674.99 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.15K | ± 1.69K | ops/s | 1.3x slower |
| simpleclientInc | 6.56K | ± 31.71 | ops/s | 9.9x slower |
| simpleclientAdd | 6.48K | ± 14.00 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.36K | ± 39.15 | ops/s | 10x slower |
| openTelemetryInc | 3.28K | ± 209.96 | ops/s | 20x slower |
| openTelemetryIncNoLabels | 3.09K | ± 366.49 | ops/s | 21x slower |
| openTelemetryAdd | 2.95K | ± 267.20 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.98K | ± 1.04K | ops/s | **fastest** |
| simpleclient | 4.47K | ± 70.13 | ops/s | 1.3x slower |
| prometheusNative | 3.20K | ± 67.65 | ops/s | 1.9x slower |
| openTelemetryClassic | 756.82 | ± 4.78 | ops/s | 7.9x slower |
| openTelemetryExponential | 618.79 | ± 14.48 | ops/s | 9.7x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 24.44K | ± 794.44 | ops/s | **fastest** |
| prometheusWriteToNull | 23.60K | ± 457.39 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 495.20K | ± 4.60K | ops/s | **fastest** |
| prometheusWriteToNull | 491.70K | ± 4.53K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 477.72K | ± 7.36K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 463.54K | ± 7.02K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49146.409   ± 1687.992  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2946.006    ± 267.201  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3277.487    ± 209.962  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3085.398    ± 366.493  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51013.222    ± 674.995  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64984.823   ± 2235.863  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55469.053   ± 1293.323  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6475.891     ± 14.003  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6564.135     ± 31.710  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6360.268     ± 39.152  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        756.817      ± 4.778  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        618.792     ± 14.476  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5981.658   ± 1038.861  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3203.548     ± 67.645  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4470.304     ± 70.127  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      24436.485    ± 794.435  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23597.273    ± 457.393  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     463540.240   ± 7019.670  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     477720.900   ± 7362.297  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     495203.274   ± 4603.487  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     491704.658   ± 4525.834  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-02T09:33:29Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.17K | ± 809.77 | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.22K | ± 2.34K | ops/s | 1.2x slower |
| prometheusAdd | 50.91K | ± 480.15 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.41K | ± 1.33K | ops/s | 1.4x slower |
| simpleclientInc | 6.54K | ± 32.78 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.34K | ± 10.06 | ops/s | 10x slower |
| simpleclientAdd | 6.29K | ± 135.57 | ops/s | 11x slower |
| openTelemetryInc | 3.53K | ± 560.16 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 3.14K | ± 234.05 | ops/s | 21x slower |
| openTelemetryAdd | 3.11K | ± 286.73 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.82K | ± 538.07 | ops/s | **fastest** |
| simpleclient | 4.46K | ± 21.73 | ops/s | 1.1x slower |
| prometheusNative | 2.61K | ± 60.87 | ops/s | 1.8x slower |
| openTelemetryClassic | 758.28 | ± 20.29 | ops/s | 6.4x slower |
| openTelemetryExponential | 708.12 | ± 90.23 | ops/s | 6.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.98K | ± 473.28 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.45K | ± 195.44 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 507.31K | ± 2.19K | ops/s | **fastest** |
| prometheusWriteToByteArray | 506.09K | ± 2.88K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 485.78K | ± 3.63K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 482.05K | ± 2.16K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48408.284   ± 1333.600  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3114.185    ± 286.733  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3532.575    ± 560.158  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3136.860    ± 234.047  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50909.641    ± 480.155  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66167.437    ± 809.770  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55215.531   ± 2340.459  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6286.578    ± 135.567  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6544.560     ± 32.784  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6339.895     ± 10.060  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        758.282     ± 20.288  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        708.125     ± 90.230  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4815.904    ± 538.068  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2611.122     ± 60.872  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4458.725     ± 21.732  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23446.619    ± 195.440  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23980.797    ± 473.281  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     482052.171   ± 2157.114  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     485775.313   ± 3625.326  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     506086.261   ± 2882.348  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     507308.141   ± 2193.254  ops/s
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

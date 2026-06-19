# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-19T08:37:16Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.70K | ± 183.72 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.20K | ± 933.49 | ops/s | 1.2x slower |
| prometheusAdd | 51.53K | ± 100.27 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.78K | ± 1.50K | ops/s | 1.3x slower |
| simpleclientInc | 6.60K | ± 77.49 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.31K | ± 136.35 | ops/s | 10x slower |
| simpleclientAdd | 6.22K | ± 369.91 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 3.46K | ± 563.25 | ops/s | 19x slower |
| openTelemetryInc | 3.30K | ± 386.37 | ops/s | 20x slower |
| openTelemetryAdd | 3.10K | ± 163.43 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.85K | ± 1.45K | ops/s | **fastest** |
| simpleclient | 4.40K | ± 12.87 | ops/s | 1.8x slower |
| prometheusNative | 3.03K | ± 250.51 | ops/s | 2.6x slower |
| openTelemetryClassic | 766.24 | ± 11.19 | ops/s | 10x slower |
| openTelemetryExponential | 726.04 | ± 118.78 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.48K | ± 831.45 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.81K | ± 422.42 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 502.24K | ± 4.61K | ops/s | **fastest** |
| prometheusWriteToByteArray | 494.17K | ± 2.93K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 485.20K | ± 3.89K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 477.54K | ± 5.64K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48779.045   ± 1503.692  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3104.158    ± 163.431  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3300.840    ± 386.372  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3457.261    ± 563.254  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51528.170    ± 100.270  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65695.350    ± 183.719  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56201.617    ± 933.490  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6222.194    ± 369.909  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6602.137     ± 77.491  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6306.584    ± 136.352  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        766.239     ± 11.189  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        726.036    ± 118.782  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7845.859   ± 1445.352  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3025.471    ± 250.509  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4401.947     ± 12.865  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23812.076    ± 422.420  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24475.491    ± 831.448  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     477541.163   ± 5642.607  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     485204.039   ± 3888.357  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     494172.174   ± 2929.223  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     502240.646   ± 4613.738  ops/s
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

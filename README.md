# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-30T09:41:16Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 76.00K | ± 1.91K | ops/s | **fastest** |
| prometheusNoLabelsInc | 66.23K | ± 685.15 | ops/s | 1.1x slower |
| prometheusAdd | 61.84K | ± 549.03 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 56.84K | ± 162.98 | ops/s | 1.3x slower |
| simpleclientInc | 7.73K | ± 87.80 | ops/s | 9.8x slower |
| simpleclientAdd | 7.43K | ± 474.25 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 7.43K | ± 82.37 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 6.33K | ± 1.38K | ops/s | 12x slower |
| openTelemetryInc | 6.13K | ± 1.30K | ops/s | 12x slower |
| openTelemetryAdd | 4.37K | ± 165.46 | ops/s | 17x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 8.10K | ± 2.95K | ops/s | **fastest** |
| simpleclient | 5.85K | ± 83.52 | ops/s | 1.4x slower |
| prometheusNative | 4.03K | ± 56.97 | ops/s | 2.0x slower |
| openTelemetryClassic | 944.76 | ± 46.34 | ops/s | 8.6x slower |
| openTelemetryExponential | 686.21 | ± 17.64 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 34.23K | ± 266.81 | ops/s | **fastest** |
| prometheusWriteToNull | 33.94K | ± 792.24 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 664.20K | ± 3.85K | ops/s | **fastest** |
| prometheusWriteToByteArray | 648.46K | ± 8.17K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 615.09K | ± 13.87K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 587.40K | ± 21.10K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      56835.412    ± 162.982  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4366.642    ± 165.462  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       6126.854   ± 1301.216  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       6328.803   ± 1383.392  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      61842.790    ± 549.033  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      75999.772   ± 1913.480  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      66233.220    ± 685.146  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7434.700    ± 474.247  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7732.079     ± 87.801  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7430.515     ± 82.368  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        944.761     ± 46.341  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        686.212     ± 17.639  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       8096.365   ± 2953.690  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       4034.118     ± 56.968  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5852.881     ± 83.515  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      34228.254    ± 266.814  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      33944.052    ± 792.240  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     587401.248  ± 21095.284  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     615089.297  ± 13865.423  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     648460.431   ± 8168.221  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     664197.914   ± 3847.695  ops/s
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

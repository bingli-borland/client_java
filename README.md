# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-30T09:26:09Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 74.70K | ± 2.83K | ops/s | **fastest** |
| prometheusNoLabelsInc | 66.49K | ± 581.06 | ops/s | 1.1x slower |
| prometheusAdd | 61.50K | ± 444.03 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 56.82K | ± 251.53 | ops/s | 1.3x slower |
| simpleclientAdd | 7.89K | ± 65.46 | ops/s | 9.5x slower |
| simpleclientInc | 7.88K | ± 39.79 | ops/s | 9.5x slower |
| simpleclientNoLabelsInc | 7.64K | ± 31.85 | ops/s | 9.8x slower |
| openTelemetryIncNoLabels | 5.95K | ± 62.64 | ops/s | 13x slower |
| openTelemetryInc | 5.90K | ± 1.29K | ops/s | 13x slower |
| openTelemetryAdd | 4.37K | ± 312.95 | ops/s | 17x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.97K | ± 2.61K | ops/s | **fastest** |
| simpleclient | 5.57K | ± 111.20 | ops/s | 1.4x slower |
| prometheusNative | 3.75K | ± 211.25 | ops/s | 2.1x slower |
| openTelemetryClassic | 910.84 | ± 11.18 | ops/s | 8.8x slower |
| openTelemetryExponential | 689.46 | ± 17.21 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 35.33K | ± 281.02 | ops/s | **fastest** |
| openMetricsWriteToNull | 35.00K | ± 38.21 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 713.82K | ± 3.54K | ops/s | **fastest** |
| prometheusWriteToByteArray | 686.57K | ± 10.39K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 669.37K | ± 7.00K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 639.68K | ± 16.11K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      56822.281    ± 251.533  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4368.927    ± 312.951  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5902.405   ± 1287.737  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5952.986     ± 62.639  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      61496.925    ± 444.033  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      74697.338   ± 2828.915  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      66485.934    ± 581.062  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7889.165     ± 65.456  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7883.151     ± 39.787  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7643.741     ± 31.848  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        910.844     ± 11.180  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        689.458     ± 17.210  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7970.561   ± 2608.995  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3746.620    ± 211.254  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5573.000    ± 111.204  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      35001.992     ± 38.211  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      35326.209    ± 281.022  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     639682.201  ± 16111.495  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     669368.054   ± 7002.901  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     686569.884  ± 10390.210  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     713821.778   ± 3536.120  ops/s
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

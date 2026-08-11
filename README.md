# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-11T05:07:35Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.40K | ± 611.01 | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.32K | ± 2.44K | ops/s | 1.2x slower |
| codahaleIncNoLabels | 50.32K | ± 1.02K | ops/s | 1.3x slower |
| prometheusAdd | 50.15K | ± 1.38K | ops/s | 1.3x slower |
| simpleclientInc | 6.57K | ± 14.52 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.52K | ± 147.70 | ops/s | 10x slower |
| simpleclientAdd | 6.44K | ± 7.96 | ops/s | 10x slower |
| openTelemetryInc | 3.18K | ± 161.05 | ops/s | 21x slower |
| openTelemetryAdd | 3.12K | ± 213.23 | ops/s | 21x slower |
| openTelemetryIncNoLabels | 2.91K | ± 99.80 | ops/s | 23x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.17K | ± 1.19K | ops/s | **fastest** |
| simpleclient | 4.40K | ± 75.70 | ops/s | 1.4x slower |
| prometheusNative | 3.12K | ± 274.69 | ops/s | 2.0x slower |
| openTelemetryClassic | 746.79 | ± 16.64 | ops/s | 8.3x slower |
| openTelemetryExponential | 670.52 | ± 36.01 | ops/s | 9.2x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.36K | ± 134.85 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.98K | ± 189.31 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 492.03K | ± 2.74K | ops/s | **fastest** |
| prometheusWriteToNull | 491.35K | ± 4.32K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 470.88K | ± 4.60K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 462.10K | ± 10.98K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      50324.404   ± 1015.441  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3116.943    ± 213.233  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3181.885    ± 161.047  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2910.556     ± 99.801  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50151.387   ± 1384.208  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66395.396    ± 611.006  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55316.259   ± 2436.568  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6443.173      ± 7.964  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6569.080     ± 14.515  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6516.710    ± 147.700  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        746.795     ± 16.640  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        670.515     ± 36.013  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6173.447   ± 1189.528  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3121.962    ± 274.685  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4401.901     ± 75.700  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23983.937    ± 189.306  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24358.169    ± 134.848  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     470883.242   ± 4600.870  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     462099.972  ± 10983.710  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     492031.934   ± 2739.390  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     491348.055   ± 4317.081  ops/s
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

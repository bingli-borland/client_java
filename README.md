# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-20T11:10:25Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) 6975P-C, 4 cores, 15 GB RAM
- **OS:** Linux 7.0.0-1014-aws

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusAdd | 33.85K | ± 160.78 | ops/s | **fastest** |
| prometheusInc | 32.91K | ± 82.32 | ops/s | 1.0x slower |
| prometheusNoLabelsInc | 32.55K | ± 1.19K | ops/s | 1.0x slower |
| codahaleIncNoLabels | 32.31K | ± 1.03K | ops/s | 1.0x slower |
| simpleclientInc | 7.60K | ± 36.85 | ops/s | 4.5x slower |
| simpleclientNoLabelsInc | 7.54K | ± 30.36 | ops/s | 4.5x slower |
| simpleclientAdd | 7.45K | ± 15.79 | ops/s | 4.5x slower |
| openTelemetryIncNoLabels | 2.62K | ± 533.13 | ops/s | 13x slower |
| openTelemetryAdd | 2.35K | ± 193.19 | ops/s | 14x slower |
| openTelemetryInc | 2.13K | ± 33.79 | ops/s | 16x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 5.27K | ± 59.29 | ops/s | **fastest** |
| prometheusClassic | 2.98K | ± 393.14 | ops/s | 1.8x slower |
| prometheusNative | 1.98K | ± 167.73 | ops/s | 2.7x slower |
| openTelemetryClassic | 365.86 | ± 28.89 | ops/s | 14x slower |
| openTelemetryExponential | 306.36 | ± 23.00 | ops/s | 17x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.86K | ± 73.86 | ops/s | **fastest** |
| prometheusWriteToNull | 23.86K | ± 38.52 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 423.72K | ± 5.02K | ops/s | **fastest** |
| prometheusWriteToByteArray | 422.91K | ± 2.70K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 397.73K | ± 8.78K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 389.50K | ± 968.05 | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      32306.222   ± 1025.702  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2351.921    ± 193.189  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2134.757     ± 33.789  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2615.323    ± 533.129  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      33845.138    ± 160.777  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      32914.334     ± 82.324  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      32550.883   ± 1187.904  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7454.812     ± 15.793  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7601.178     ± 36.847  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7537.775     ± 30.364  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        365.858     ± 28.886  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        306.361     ± 23.001  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2980.631    ± 393.136  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       1983.826    ± 167.734  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5270.941     ± 59.291  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23857.441     ± 73.861  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23855.462     ± 38.523  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     389503.576    ± 968.045  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     397727.650   ± 8781.447  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     422909.561   ± 2696.042  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     423717.373   ± 5016.331  ops/s
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

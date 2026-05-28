# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-05-28T07:37:13Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1013-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.07K | ± 1.32K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.20K | ± 530.87 | ops/s | 1.2x slower |
| prometheusAdd | 51.35K | ± 122.68 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.89K | ± 1.50K | ops/s | 1.3x slower |
| simpleclientInc | 6.61K | ± 35.62 | ops/s | 9.8x slower |
| simpleclientAdd | 6.45K | ± 11.54 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.39K | ± 26.11 | ops/s | 10x slower |
| openTelemetryAdd | 3.16K | ± 664.90 | ops/s | 21x slower |
| openTelemetryIncNoLabels | 3.15K | ± 236.70 | ops/s | 21x slower |
| openTelemetryInc | 3.09K | ± 338.55 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.68K | ± 575.40 | ops/s | **fastest** |
| simpleclient | 4.32K | ± 125.34 | ops/s | 1.1x slower |
| prometheusNative | 2.84K | ± 334.02 | ops/s | 1.6x slower |
| openTelemetryClassic | 751.24 | ± 11.37 | ops/s | 6.2x slower |
| openTelemetryExponential | 605.67 | ± 58.54 | ops/s | 7.7x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.96K | ± 938.97 | ops/s | **fastest** |
| prometheusWriteToNull | 23.91K | ± 353.85 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 509.38K | ± 3.39K | ops/s | **fastest** |
| prometheusWriteToByteArray | 503.74K | ± 4.12K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 493.37K | ± 2.99K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 490.05K | ± 2.06K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48887.676   ± 1502.553  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3156.224    ± 664.903  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3090.478    ± 338.552  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3147.924    ± 236.701  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51345.088    ± 122.676  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65068.900   ± 1319.945  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56202.439    ± 530.873  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6445.109     ± 11.535  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6611.478     ± 35.616  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6390.072     ± 26.115  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        751.237     ± 11.368  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        605.667     ± 58.545  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4681.010    ± 575.397  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2839.609    ± 334.024  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4317.170    ± 125.341  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23963.517    ± 938.965  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23913.573    ± 353.852  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     490047.576   ± 2064.998  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     493367.809   ± 2985.548  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     503737.608   ± 4117.199  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     509381.224   ± 3392.957  ops/s
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

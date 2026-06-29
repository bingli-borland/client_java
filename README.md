# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-29T08:14:07Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 60.10K | ± 1.04K | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.15K | ± 489.22 | ops/s | 1.2x slower |
| prometheusAdd | 48.38K | ± 25.50 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.24K | ± 1.20K | ops/s | 1.4x slower |
| simpleclientInc | 6.16K | ± 50.48 | ops/s | 9.8x slower |
| simpleclientAdd | 5.97K | ± 180.73 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 5.91K | ± 18.95 | ops/s | 10x slower |
| openTelemetryInc | 5.47K | ± 1.05K | ops/s | 11x slower |
| openTelemetryIncNoLabels | 4.94K | ± 836.49 | ops/s | 12x slower |
| openTelemetryAdd | 4.54K | ± 840.02 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.36K | ± 1.55K | ops/s | **fastest** |
| simpleclient | 4.37K | ± 55.50 | ops/s | 1.2x slower |
| prometheusNative | 2.92K | ± 218.61 | ops/s | 1.8x slower |
| openTelemetryClassic | 727.38 | ± 11.75 | ops/s | 7.4x slower |
| openTelemetryExponential | 575.02 | ± 28.85 | ops/s | 9.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.53K | ± 236.87 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.48K | ± 78.07 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 579.72K | ± 7.79K | ops/s | **fastest** |
| prometheusWriteToByteArray | 565.15K | ± 8.45K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 540.36K | ± 7.06K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 530.00K | ± 13.44K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43238.180   ± 1196.473  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4544.186    ± 840.022  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5472.019   ± 1051.541  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4942.569    ± 836.487  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48377.909     ± 25.502  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      60097.725   ± 1041.643  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51145.118    ± 489.219  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5967.451    ± 180.727  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6162.944     ± 50.483  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5909.550     ± 18.955  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        727.379     ± 11.746  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        575.020     ± 28.847  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5356.058   ± 1547.363  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2924.710    ± 218.609  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4369.229     ± 55.501  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27479.300     ± 78.071  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27534.327    ± 236.867  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     529996.638  ± 13439.467  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     540356.515   ± 7057.582  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     565147.080   ± 8448.977  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     579720.660   ± 7793.817  ops/s
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

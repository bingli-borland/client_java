# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-27T07:14:31Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.45K | ± 556.35 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.77K | ± 406.72 | ops/s | 1.2x slower |
| prometheusAdd | 51.42K | ± 264.10 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.92K | ± 477.72 | ops/s | 1.3x slower |
| simpleclientInc | 6.55K | ± 39.17 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.36K | ± 218.13 | ops/s | 10x slower |
| simpleclientAdd | 6.24K | ± 225.63 | ops/s | 10x slower |
| openTelemetryAdd | 3.65K | ± 166.11 | ops/s | 18x slower |
| openTelemetryInc | 3.29K | ± 270.58 | ops/s | 20x slower |
| openTelemetryIncNoLabels | 2.92K | ± 81.45 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.79K | ± 1.05K | ops/s | **fastest** |
| simpleclient | 4.39K | ± 32.46 | ops/s | 1.3x slower |
| prometheusNative | 2.83K | ± 444.89 | ops/s | 2.0x slower |
| openTelemetryClassic | 741.23 | ± 1.04 | ops/s | 7.8x slower |
| openTelemetryExponential | 691.72 | ± 2.17 | ops/s | 8.4x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.23K | ± 334.44 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.53K | ± 583.09 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 489.23K | ± 3.26K | ops/s | **fastest** |
| prometheusWriteToByteArray | 484.87K | ± 3.31K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 465.84K | ± 7.02K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 461.44K | ± 5.08K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49920.201    ± 477.716  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3646.037    ± 166.106  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3294.848    ± 270.577  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2921.848     ± 81.452  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51422.998    ± 264.101  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65447.171    ± 556.348  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56771.778    ± 406.724  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6241.436    ± 225.630  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6551.616     ± 39.169  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6355.236    ± 218.128  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        741.233      ± 1.036  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        691.724      ± 2.170  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5791.678   ± 1052.637  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2828.804    ± 444.892  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4386.241     ± 32.457  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23531.524    ± 583.091  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24231.132    ± 334.438  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     461442.081   ± 5083.016  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     465842.965   ± 7024.878  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     484869.088   ± 3314.530  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     489231.227   ± 3258.718  ops/s
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

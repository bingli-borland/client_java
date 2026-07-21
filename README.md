# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-21T06:44:40Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.67K | ± 1.80K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.83K | ± 437.47 | ops/s | 1.1x slower |
| prometheusAdd | 51.30K | ± 467.19 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.49K | ± 1.31K | ops/s | 1.3x slower |
| simpleclientInc | 6.49K | ± 130.08 | ops/s | 10.0x slower |
| simpleclientAdd | 6.43K | ± 59.38 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.36K | ± 32.78 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.57K | ± 346.30 | ops/s | 18x slower |
| openTelemetryAdd | 3.38K | ± 182.04 | ops/s | 19x slower |
| openTelemetryInc | 3.31K | ± 420.37 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.45K | ± 593.96 | ops/s | **fastest** |
| simpleclient | 4.42K | ± 19.51 | ops/s | 1.2x slower |
| prometheusNative | 3.07K | ± 118.72 | ops/s | 1.8x slower |
| openTelemetryClassic | 762.75 | ± 28.59 | ops/s | 7.1x slower |
| openTelemetryExponential | 647.94 | ± 99.23 | ops/s | 8.4x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.75K | ± 430.51 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.63K | ± 215.08 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 502.58K | ± 2.23K | ops/s | **fastest** |
| prometheusWriteToByteArray | 498.68K | ± 7.17K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 487.93K | ± 2.54K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 483.53K | ± 2.27K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48493.835   ± 1306.267  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3378.127    ± 182.045  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3305.710    ± 420.374  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3571.216    ± 346.304  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51303.940    ± 467.185  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64665.866   ± 1799.909  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56833.681    ± 437.470  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6433.636     ± 59.381  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6489.830    ± 130.076  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6361.151     ± 32.780  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        762.752     ± 28.590  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        647.936     ± 99.226  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5450.763    ± 593.962  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3066.208    ± 118.719  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4415.019     ± 19.513  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23626.418    ± 215.077  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23751.456    ± 430.507  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     483528.530   ± 2267.770  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     487927.023   ± 2535.035  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     498676.774   ± 7173.852  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     502581.162   ± 2227.284  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-05T10:02:29Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.22K | ± 260.39 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.95K | ± 534.63 | ops/s | 1.2x slower |
| prometheusAdd | 51.36K | ± 294.65 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.43K | ± 1.50K | ops/s | 1.4x slower |
| simpleclientInc | 6.57K | ± 43.34 | ops/s | 10x slower |
| simpleclientAdd | 6.48K | ± 20.31 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.43K | ± 134.24 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.67K | ± 505.66 | ops/s | 18x slower |
| openTelemetryAdd | 3.36K | ± 239.94 | ops/s | 20x slower |
| openTelemetryInc | 3.30K | ± 69.30 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.49K | ± 1.01K | ops/s | **fastest** |
| simpleclient | 4.43K | ± 51.96 | ops/s | 1.5x slower |
| prometheusNative | 2.90K | ± 324.10 | ops/s | 2.2x slower |
| openTelemetryClassic | 768.50 | ± 7.77 | ops/s | 8.4x slower |
| openTelemetryExponential | 661.13 | ± 71.94 | ops/s | 9.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.17K | ± 911.15 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.48K | ± 203.70 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 500.76K | ± 5.07K | ops/s | **fastest** |
| prometheusWriteToNull | 498.94K | ± 4.81K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 484.42K | ± 2.85K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 475.30K | ± 3.95K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48426.229   ± 1496.718  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3357.771    ± 239.942  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3301.743     ± 69.301  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3670.644    ± 505.655  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51358.763    ± 294.655  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66218.319    ± 260.388  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56945.500    ± 534.625  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6475.585     ± 20.307  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6567.015     ± 43.336  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6429.360    ± 134.240  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        768.504      ± 7.772  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        661.130     ± 71.940  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6486.785   ± 1005.694  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2895.459    ± 324.097  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4431.802     ± 51.957  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23478.151    ± 203.698  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24172.621    ± 911.149  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     475298.346   ± 3945.744  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     484420.688   ± 2848.350  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     500759.431   ± 5072.372  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     498941.558   ± 4812.671  ops/s
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

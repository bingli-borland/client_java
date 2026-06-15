# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-15T08:46:34Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) Platinum 8370C CPU @ 2.80GHz, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 30.74K | ± 1.48K | ops/s | **fastest** |
| prometheusNoLabelsInc | 30.05K | ± 923.08 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 30.05K | ± 982.23 | ops/s | 1.0x slower |
| prometheusAdd | 28.46K | ± 45.85 | ops/s | 1.1x slower |
| simpleclientInc | 6.94K | ± 32.90 | ops/s | 4.4x slower |
| simpleclientNoLabelsInc | 6.60K | ± 60.90 | ops/s | 4.7x slower |
| simpleclientAdd | 6.44K | ± 236.34 | ops/s | 4.8x slower |
| openTelemetryAdd | 2.47K | ± 377.01 | ops/s | 12x slower |
| openTelemetryIncNoLabels | 2.38K | ± 63.09 | ops/s | 13x slower |
| openTelemetryInc | 2.37K | ± 115.64 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.51K | ± 9.02 | ops/s | **fastest** |
| prometheusClassic | 3.03K | ± 332.80 | ops/s | 1.5x slower |
| prometheusNative | 2.06K | ± 226.75 | ops/s | 2.2x slower |
| openTelemetryClassic | 638.82 | ± 14.85 | ops/s | 7.1x slower |
| openTelemetryExponential | 431.46 | ± 23.57 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 18.33K | ± 65.80 | ops/s | **fastest** |
| prometheusWriteToNull | 18.27K | ± 92.15 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 313.83K | ± 2.61K | ops/s | **fastest** |
| prometheusWriteToNull | 311.68K | ± 2.91K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 296.65K | ± 1.83K | ops/s | 1.1x slower |
| openMetricsWriteToNull | 292.98K | ± 4.03K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      30053.044    ± 982.228  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2474.540    ± 377.008  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2369.620    ± 115.643  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2376.240     ± 63.093  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      28463.823     ± 45.854  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      30740.962   ± 1484.534  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      30054.394    ± 923.083  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6438.592    ± 236.336  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6944.215     ± 32.904  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6596.362     ± 60.900  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        638.818     ± 14.849  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        431.462     ± 23.568  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       3032.161    ± 332.797  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2064.426    ± 226.747  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4509.276      ± 9.024  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      18332.466     ± 65.802  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      18272.586     ± 92.146  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     296653.980   ± 1827.609  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     292984.253   ± 4034.271  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     313830.112   ± 2606.783  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     311683.497   ± 2910.197  ops/s
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

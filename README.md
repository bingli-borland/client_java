# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-12T08:20:24Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.68K | ± 737.82 | ops/s | **fastest** |
| prometheusNoLabelsInc | 57.07K | ± 85.65 | ops/s | 1.2x slower |
| prometheusAdd | 51.11K | ± 700.28 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 50.24K | ± 112.47 | ops/s | 1.3x slower |
| simpleclientInc | 6.56K | ± 38.43 | ops/s | 10x slower |
| simpleclientAdd | 6.44K | ± 43.71 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.36K | ± 7.30 | ops/s | 10x slower |
| openTelemetryInc | 3.43K | ± 303.98 | ops/s | 19x slower |
| openTelemetryAdd | 2.98K | ± 318.04 | ops/s | 22x slower |
| openTelemetryIncNoLabels | 2.98K | ± 230.72 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.79K | ± 602.96 | ops/s | **fastest** |
| simpleclient | 4.42K | ± 19.70 | ops/s | 1.5x slower |
| prometheusNative | 2.76K | ± 331.54 | ops/s | 2.5x slower |
| openTelemetryClassic | 735.80 | ± 15.54 | ops/s | 9.2x slower |
| openTelemetryExponential | 628.78 | ± 93.53 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.57K | ± 214.32 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.55K | ± 144.30 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 501.86K | ± 4.51K | ops/s | **fastest** |
| prometheusWriteToByteArray | 498.05K | ± 8.81K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 482.68K | ± 7.81K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 472.93K | ± 6.20K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      50242.570    ± 112.468  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2983.271    ± 318.045  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3434.006    ± 303.981  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2982.829    ± 230.722  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51113.999    ± 700.284  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66684.266    ± 737.818  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      57074.995     ± 85.648  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6440.113     ± 43.711  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6560.462     ± 38.432  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6355.104      ± 7.297  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        735.795     ± 15.542  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        628.779     ± 93.527  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6792.304    ± 602.963  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2760.796    ± 331.542  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4423.863     ± 19.695  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23545.166    ± 144.300  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24566.273    ± 214.325  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     472931.169   ± 6197.674  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     482681.067   ± 7805.119  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     498047.287   ± 8814.958  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     501858.669   ± 4506.419  ops/s
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

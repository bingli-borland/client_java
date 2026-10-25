# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-25T08:46:28Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.34K | ± 1.28K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.17K | ± 994.63 | ops/s | 1.2x slower |
| prometheusAdd | 51.42K | ± 143.07 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.18K | ± 1.82K | ops/s | 1.3x slower |
| simpleclientInc | 6.58K | ± 22.04 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 6.43K | ± 83.98 | ops/s | 10x slower |
| simpleclientAdd | 6.21K | ± 367.13 | ops/s | 11x slower |
| openTelemetryAdd | 3.49K | ± 127.57 | ops/s | 19x slower |
| openTelemetryIncNoLabels | 3.47K | ± 492.77 | ops/s | 19x slower |
| openTelemetryInc | 3.30K | ± 162.21 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.15K | ± 1.51K | ops/s | **fastest** |
| simpleclient | 4.39K | ± 18.10 | ops/s | 1.2x slower |
| prometheusNative | 3.14K | ± 84.04 | ops/s | 1.6x slower |
| openTelemetryClassic | 736.27 | ± 15.28 | ops/s | 7.0x slower |
| openTelemetryExponential | 706.50 | ± 4.99 | ops/s | 7.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.41K | ± 759.51 | ops/s | **fastest** |
| openMetricsWriteToNull | 22.38K | ± 604.37 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 478.51K | ± 5.96K | ops/s | **fastest** |
| prometheusWriteToByteArray | 477.96K | ± 6.64K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 450.16K | ± 5.15K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 445.46K | ± 7.20K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49183.795   ± 1822.449  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3486.990    ± 127.575  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3301.618    ± 162.209  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3465.502    ± 492.768  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51417.054    ± 143.073  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65339.563   ± 1278.956  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56174.726    ± 994.626  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6210.007    ± 367.133  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6575.077     ± 22.039  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6428.108     ± 83.977  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        736.269     ± 15.281  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        706.498      ± 4.993  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5145.155   ± 1514.212  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3141.850     ± 84.043  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4386.970     ± 18.102  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      22381.881    ± 604.370  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23409.058    ± 759.508  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     445460.546   ± 7202.023  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     450156.520   ± 5145.312  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     477962.843   ± 6643.338  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     478511.129   ± 5955.242  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-17T08:44:45Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) 6973P-C, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusAdd | 36.01K | ± 1.09K | ops/s | **fastest** |
| prometheusInc | 35.37K | ± 537.43 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 35.24K | ± 2.02K | ops/s | 1.0x slower |
| prometheusNoLabelsInc | 34.10K | ± 552.17 | ops/s | 1.1x slower |
| simpleclientNoLabelsInc | 9.06K | ± 175.19 | ops/s | 4.0x slower |
| simpleclientInc | 9.03K | ± 271.59 | ops/s | 4.0x slower |
| simpleclientAdd | 8.90K | ± 300.48 | ops/s | 4.0x slower |
| openTelemetryInc | 2.47K | ± 228.84 | ops/s | 15x slower |
| openTelemetryAdd | 2.23K | ± 507.34 | ops/s | 16x slower |
| openTelemetryIncNoLabels | 2.09K | ± 123.67 | ops/s | 17x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 6.02K | ± 189.01 | ops/s | **fastest** |
| prometheusClassic | 3.14K | ± 872.70 | ops/s | 1.9x slower |
| prometheusNative | 2.16K | ± 105.00 | ops/s | 2.8x slower |
| openTelemetryClassic | 529.24 | ± 6.02 | ops/s | 11x slower |
| openTelemetryExponential | 361.27 | ± 21.19 | ops/s | 17x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 24.60K | ± 522.25 | ops/s | **fastest** |
| prometheusWriteToNull | 24.58K | ± 556.66 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 343.02K | ± 6.64K | ops/s | **fastest** |
| prometheusWriteToByteArray | 341.89K | ± 4.82K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 336.18K | ± 7.47K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 322.18K | ± 6.00K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      35237.094   ± 2022.271  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2228.878    ± 507.338  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2471.948    ± 228.835  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2085.243    ± 123.667  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      36006.269   ± 1094.864  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      35372.592    ± 537.434  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      34102.979    ± 552.166  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       8899.690    ± 300.478  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       9033.351    ± 271.594  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       9061.217    ± 175.190  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        529.236      ± 6.021  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        361.267     ± 21.186  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       3136.703    ± 872.704  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2160.230    ± 105.002  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       6017.461    ± 189.007  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      24599.053    ± 522.247  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24580.361    ± 556.661  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     322176.141   ± 6000.173  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     336180.583   ± 7469.443  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     341889.748   ± 4824.632  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     343020.872   ± 6644.429  ops/s
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

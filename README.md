# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-19T11:21:38Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** Intel(R) Xeon(R) 6975P-C, 4 cores, 15 GB RAM
- **OS:** Linux 7.0.0-1014-aws

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusAdd | 34.40K | ± 618.71 | ops/s | **fastest** |
| prometheusInc | 33.10K | ± 356.29 | ops/s | 1.0x slower |
| prometheusNoLabelsInc | 32.47K | ± 683.01 | ops/s | 1.1x slower |
| codahaleIncNoLabels | 32.25K | ± 583.55 | ops/s | 1.1x slower |
| simpleclientNoLabelsInc | 7.54K | ± 18.42 | ops/s | 4.6x slower |
| simpleclientInc | 7.52K | ± 107.76 | ops/s | 4.6x slower |
| simpleclientAdd | 7.45K | ± 64.50 | ops/s | 4.6x slower |
| openTelemetryIncNoLabels | 2.81K | ± 419.98 | ops/s | 12x slower |
| openTelemetryAdd | 2.60K | ± 477.25 | ops/s | 13x slower |
| openTelemetryInc | 2.32K | ± 186.21 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 5.26K | ± 74.96 | ops/s | **fastest** |
| prometheusClassic | 2.62K | ± 596.03 | ops/s | 2.0x slower |
| prometheusNative | 2.39K | ± 19.88 | ops/s | 2.2x slower |
| openTelemetryClassic | 398.65 | ± 11.19 | ops/s | 13x slower |
| openTelemetryExponential | 317.82 | ± 14.67 | ops/s | 17x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.96K | ± 56.93 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.94K | ± 123.22 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 435.75K | ± 14.15K | ops/s | **fastest** |
| prometheusWriteToByteArray | 422.23K | ± 11.36K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 414.41K | ± 6.83K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 412.75K | ± 11.10K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      32252.920    ± 583.549  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2601.195    ± 477.252  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2323.502    ± 186.210  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2810.941    ± 419.976  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      34400.877    ± 618.708  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      33100.670    ± 356.292  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      32466.950    ± 683.011  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7450.622     ± 64.502  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7524.019    ± 107.755  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7540.649     ± 18.418  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        398.652     ± 11.194  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        317.816     ± 14.672  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2619.637    ± 596.027  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2393.117     ± 19.883  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5255.162     ± 74.961  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23940.815    ± 123.224  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23962.104     ± 56.932  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     412750.032  ± 11096.594  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     414408.875   ± 6834.872  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     422226.758  ± 11359.448  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     435752.810  ± 14148.860  ops/s
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

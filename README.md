# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-19T08:30:55Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.28K | ± 432.01 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.23K | ± 564.48 | ops/s | 1.2x slower |
| prometheusAdd | 49.19K | ± 959.52 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.16K | ± 1.20K | ops/s | 1.4x slower |
| simpleclientInc | 6.18K | ± 115.25 | ops/s | 9.6x slower |
| simpleclientAdd | 5.90K | ± 327.14 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 5.84K | ± 70.35 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 5.06K | ± 1.19K | ops/s | 12x slower |
| openTelemetryAdd | 4.58K | ± 817.99 | ops/s | 13x slower |
| openTelemetryInc | 4.02K | ± 481.08 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.29K | ± 1.76K | ops/s | **fastest** |
| simpleclient | 4.54K | ± 37.75 | ops/s | 1.2x slower |
| prometheusNative | 2.84K | ± 152.94 | ops/s | 1.9x slower |
| openTelemetryClassic | 727.53 | ± 27.23 | ops/s | 7.3x slower |
| openTelemetryExponential | 567.28 | ± 6.87 | ops/s | 9.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 27.45K | ± 94.32 | ops/s | **fastest** |
| prometheusWriteToNull | 27.31K | ± 413.44 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 579.86K | ± 12.89K | ops/s | **fastest** |
| prometheusWriteToByteArray | 578.74K | ± 1.94K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 547.12K | ± 8.40K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 533.83K | ± 4.11K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43158.266   ± 1196.465  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4576.799    ± 817.993  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4024.615    ± 481.080  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5062.359   ± 1192.175  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      49189.372    ± 959.517  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59277.382    ± 432.008  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51226.924    ± 564.481  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5895.146    ± 327.135  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6175.492    ± 115.252  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5835.435     ± 70.349  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        727.525     ± 27.235  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        567.284      ± 6.873  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5292.954   ± 1756.453  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2840.644    ± 152.942  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4537.520     ± 37.751  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27447.899     ± 94.320  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27312.286    ± 413.439  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     533832.525   ± 4112.295  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     547124.843   ± 8395.024  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     578744.399   ± 1939.834  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     579856.509  ± 12894.558  ops/s
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

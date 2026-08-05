# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-05T06:37:59Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.29K | ± 1.32K | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.89K | ± 949.89 | ops/s | 1.2x slower |
| prometheusAdd | 51.32K | ± 192.00 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.64K | ± 1.19K | ops/s | 1.3x slower |
| simpleclientInc | 6.65K | ± 62.77 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 6.35K | ± 16.83 | ops/s | 10x slower |
| simpleclientAdd | 6.23K | ± 337.01 | ops/s | 10x slower |
| openTelemetryInc | 3.38K | ± 674.83 | ops/s | 19x slower |
| openTelemetryAdd | 3.17K | ± 333.86 | ops/s | 21x slower |
| openTelemetryIncNoLabels | 3.10K | ± 130.08 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.31K | ± 1.53K | ops/s | **fastest** |
| simpleclient | 4.37K | ± 63.74 | ops/s | 1.4x slower |
| prometheusNative | 2.83K | ± 240.71 | ops/s | 2.2x slower |
| openTelemetryClassic | 769.52 | ± 15.01 | ops/s | 8.2x slower |
| openTelemetryExponential | 636.84 | ± 51.38 | ops/s | 9.9x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.18K | ± 452.48 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.51K | ± 1.10K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 501.62K | ± 7.46K | ops/s | **fastest** |
| prometheusWriteToByteArray | 495.38K | ± 5.67K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 483.36K | ± 2.21K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 480.84K | ± 6.85K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48641.553   ± 1186.748  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3173.722    ± 333.859  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3384.797    ± 674.829  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3101.681    ± 130.082  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51323.216    ± 191.995  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65285.453   ± 1322.454  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55894.050    ± 949.889  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6226.987    ± 337.013  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6652.397     ± 62.768  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6347.680     ± 16.832  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        769.520     ± 15.012  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        636.837     ± 51.376  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6312.791   ± 1525.998  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2825.899    ± 240.714  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4368.254     ± 63.738  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23513.284   ± 1096.215  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24183.514    ± 452.482  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     480839.129   ± 6853.348  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     483361.755   ± 2208.071  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     495378.526   ± 5673.299  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     501623.199   ± 7460.281  ops/s
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

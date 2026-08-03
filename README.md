# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-03T07:06:52Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.49K | ± 703.23 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.23K | ± 974.05 | ops/s | 1.2x slower |
| prometheusAdd | 51.30K | ± 223.78 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.95K | ± 1.25K | ops/s | 1.4x slower |
| simpleclientInc | 6.53K | ± 162.61 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.34K | ± 13.81 | ops/s | 10x slower |
| simpleclientAdd | 6.05K | ± 344.65 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 3.27K | ± 384.05 | ops/s | 20x slower |
| openTelemetryAdd | 3.16K | ± 29.29 | ops/s | 21x slower |
| openTelemetryInc | 2.97K | ± 330.39 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.39K | ± 75.22 | ops/s | **fastest** |
| prometheusClassic | 4.18K | ± 338.69 | ops/s | 1.1x slower |
| prometheusNative | 3.17K | ± 37.22 | ops/s | 1.4x slower |
| openTelemetryClassic | 737.71 | ± 21.10 | ops/s | 6.0x slower |
| openTelemetryExponential | 669.21 | ± 78.49 | ops/s | 6.6x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.17K | ± 1.03K | ops/s | **fastest** |
| openMetricsWriteToNull | 23.83K | ± 922.64 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 490.16K | ± 7.15K | ops/s | **fastest** |
| prometheusWriteToNull | 487.20K | ± 3.32K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 464.94K | ± 9.24K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 460.55K | ± 6.72K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48954.347   ± 1253.920  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3158.462     ± 29.292  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2965.252    ± 330.390  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3269.937    ± 384.055  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51300.322    ± 223.777  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66494.976    ± 703.226  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56227.046    ± 974.050  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6054.756    ± 344.647  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6533.696    ± 162.608  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6337.805     ± 13.809  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        737.712     ± 21.100  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        669.210     ± 78.495  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4176.053    ± 338.694  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3166.861     ± 37.217  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4394.990     ± 75.218  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23832.837    ± 922.636  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24171.357   ± 1032.557  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     460551.200   ± 6720.440  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     464940.034   ± 9236.988  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     490161.338   ± 7151.511  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     487203.264   ± 3317.622  ops/s
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

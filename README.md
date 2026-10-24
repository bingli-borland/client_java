# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-24T08:22:01Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.18K | ± 1.50K | ops/s | **fastest** |
| prometheusNoLabelsInc | 57.07K | ± 152.12 | ops/s | 1.1x slower |
| prometheusAdd | 51.37K | ± 84.62 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 47.87K | ± 992.28 | ops/s | 1.4x slower |
| simpleclientInc | 6.56K | ± 40.13 | ops/s | 9.9x slower |
| simpleclientAdd | 6.45K | ± 35.79 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.11K | ± 324.47 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 3.25K | ± 162.12 | ops/s | 20x slower |
| openTelemetryInc | 2.87K | ± 140.96 | ops/s | 23x slower |
| openTelemetryAdd | 2.85K | ± 161.53 | ops/s | 23x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.18K | ± 1.44K | ops/s | **fastest** |
| simpleclient | 4.37K | ± 50.93 | ops/s | 1.4x slower |
| prometheusNative | 2.67K | ± 99.56 | ops/s | 2.3x slower |
| openTelemetryExponential | 738.49 | ± 24.28 | ops/s | 8.4x slower |
| openTelemetryClassic | 727.46 | ± 10.92 | ops/s | 8.5x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.80K | ± 130.62 | ops/s | **fastest** |
| prometheusWriteToNull | 23.79K | ± 891.13 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 511.79K | ± 3.25K | ops/s | **fastest** |
| prometheusWriteToByteArray | 504.24K | ± 4.94K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 490.68K | ± 3.97K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 482.49K | ± 6.47K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      47869.396    ± 992.277  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2845.541    ± 161.530  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2871.998    ± 140.963  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3253.571    ± 162.116  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51373.636     ± 84.622  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65177.381   ± 1497.622  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      57072.962    ± 152.117  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6453.505     ± 35.785  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6562.954     ± 40.127  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6110.330    ± 324.465  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        727.455     ± 10.924  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        738.489     ± 24.277  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6184.407   ± 1439.378  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2667.810     ± 99.557  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4373.841     ± 50.934  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23804.325    ± 130.620  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23791.710    ± 891.131  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     482489.564   ± 6466.234  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     490677.544   ± 3966.473  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     504243.202   ± 4937.520  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     511790.378   ± 3251.086  ops/s
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

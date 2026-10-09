# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-09T10:03:57Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V45 96-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.64K | ± 769.51 | ops/s | **fastest** |
| prometheusNoLabelsInc | 65.51K | ± 680.59 | ops/s | 1.0x slower |
| codahaleIncNoLabels | 62.32K | ± 3.10K | ops/s | 1.1x slower |
| prometheusAdd | 56.97K | ± 2.61K | ops/s | 1.2x slower |
| simpleclientNoLabelsInc | 10.97K | ± 120.32 | ops/s | 6.1x slower |
| simpleclientInc | 10.56K | ± 338.49 | ops/s | 6.3x slower |
| simpleclientAdd | 10.12K | ± 84.55 | ops/s | 6.6x slower |
| openTelemetryIncNoLabels | 6.97K | ± 1.45K | ops/s | 9.6x slower |
| openTelemetryInc | 5.07K | ± 226.66 | ops/s | 13x slower |
| openTelemetryAdd | 4.59K | ± 32.16 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.42K | ± 1.97K | ops/s | **fastest** |
| simpleclient | 6.88K | ± 185.78 | ops/s | 1.1x slower |
| prometheusNative | 5.11K | ± 435.06 | ops/s | 1.5x slower |
| openTelemetryClassic | 947.59 | ± 34.41 | ops/s | 7.8x slower |
| openTelemetryExponential | 737.07 | ± 9.60 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 32.14K | ± 697.43 | ops/s | **fastest** |
| prometheusWriteToNull | 32.04K | ± 349.15 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 747.94K | ± 44.45K | ops/s | **fastest** |
| prometheusWriteToByteArray | 725.50K | ± 18.31K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 673.69K | ± 45.60K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 660.20K | ± 44.62K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      62318.451   ± 3102.721  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4592.731     ± 32.158  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5065.455    ± 226.660  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       6967.837   ± 1445.900  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      56966.394   ± 2607.755  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66643.680    ± 769.515  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      65505.890    ± 680.589  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15      10117.764     ± 84.546  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15      10560.962    ± 338.485  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15      10971.494    ± 120.316  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        947.591     ± 34.407  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        737.074      ± 9.605  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7417.296   ± 1971.655  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       5110.076    ± 435.062  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       6883.741    ± 185.783  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      32141.603    ± 697.431  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      32035.169    ± 349.149  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     660195.606  ± 44616.494  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     673691.295  ± 45599.141  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     725500.788  ± 18311.928  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     747936.552  ± 44453.535  ops/s
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

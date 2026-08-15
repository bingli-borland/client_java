# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-15T04:14:12Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.94K | ± 1.61K | ops/s | **fastest** |
| prometheusNoLabelsInc | 54.47K | ± 1.87K | ops/s | 1.2x slower |
| prometheusAdd | 51.34K | ± 580.94 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 50.18K | ± 80.34 | ops/s | 1.3x slower |
| simpleclientInc | 6.54K | ± 30.44 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 6.43K | ± 151.49 | ops/s | 10x slower |
| simpleclientAdd | 6.31K | ± 226.45 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.48K | ± 403.43 | ops/s | 19x slower |
| openTelemetryAdd | 3.04K | ± 87.68 | ops/s | 21x slower |
| openTelemetryInc | 3.01K | ± 210.61 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.11K | ± 1.46K | ops/s | **fastest** |
| simpleclient | 4.46K | ± 67.18 | ops/s | 1.1x slower |
| prometheusNative | 2.98K | ± 162.71 | ops/s | 1.7x slower |
| openTelemetryClassic | 757.47 | ± 13.76 | ops/s | 6.7x slower |
| openTelemetryExponential | 723.30 | ± 125.24 | ops/s | 7.1x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.40K | ± 284.08 | ops/s | **fastest** |
| prometheusWriteToNull | 23.19K | ± 689.42 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 500.98K | ± 4.56K | ops/s | **fastest** |
| prometheusWriteToNull | 498.88K | ± 2.23K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 490.42K | ± 2.28K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 480.85K | ± 5.10K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      50182.460     ± 80.339  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3042.843     ± 87.676  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3007.332    ± 210.614  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3483.332    ± 403.431  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51338.030    ± 580.943  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64941.628   ± 1605.954  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      54466.685   ± 1867.396  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6306.484    ± 226.446  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6538.665     ± 30.440  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6431.888    ± 151.488  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        757.472     ± 13.758  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        723.303    ± 125.241  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5112.247   ± 1462.857  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2977.330    ± 162.705  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4461.315     ± 67.180  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23397.453    ± 284.078  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23191.893    ± 689.424  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     480849.016   ± 5099.547  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     490420.652   ± 2280.984  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     500980.679   ± 4557.564  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     498882.636   ± 2234.900  ops/s
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

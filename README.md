# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-07T09:52:40Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 77.48K | ± 1.54K | ops/s | **fastest** |
| prometheusNoLabelsInc | 67.39K | ± 558.45 | ops/s | 1.1x slower |
| prometheusAdd | 62.22K | ± 365.59 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 55.80K | ± 1.23K | ops/s | 1.4x slower |
| simpleclientInc | 7.80K | ± 60.67 | ops/s | 9.9x slower |
| simpleclientAdd | 7.66K | ± 242.82 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 7.48K | ± 60.42 | ops/s | 10x slower |
| openTelemetryInc | 6.87K | ± 1.39K | ops/s | 11x slower |
| openTelemetryAdd | 6.59K | ± 107.90 | ops/s | 12x slower |
| openTelemetryIncNoLabels | 6.25K | ± 1.26K | ops/s | 12x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 8.44K | ± 2.12K | ops/s | **fastest** |
| simpleclient | 5.75K | ± 190.22 | ops/s | 1.5x slower |
| prometheusNative | 3.61K | ± 301.83 | ops/s | 2.3x slower |
| openTelemetryClassic | 976.92 | ± 28.92 | ops/s | 8.6x slower |
| openTelemetryExponential | 676.33 | ± 8.38 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 35.01K | ± 290.58 | ops/s | **fastest** |
| openMetricsWriteToNull | 34.48K | ± 106.29 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 691.89K | ± 14.76K | ops/s | **fastest** |
| prometheusWriteToByteArray | 670.89K | ± 10.60K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 636.28K | ± 9.49K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 612.28K | ± 4.41K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      55799.850   ± 1232.844  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       6590.966    ± 107.896  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       6872.204   ± 1391.376  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       6249.674   ± 1258.483  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      62215.116    ± 365.591  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      77476.288   ± 1543.045  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      67386.113    ± 558.446  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7656.143    ± 242.817  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7801.320     ± 60.667  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7483.314     ± 60.424  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        976.921     ± 28.917  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        676.330      ± 8.382  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       8443.983   ± 2120.552  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3605.894    ± 301.826  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5750.498    ± 190.218  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      34482.556    ± 106.291  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      35005.289    ± 290.575  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     612282.043   ± 4405.582  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     636277.789   ± 9492.621  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     670892.178  ± 10595.995  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     691889.702  ± 14757.686  ops/s
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

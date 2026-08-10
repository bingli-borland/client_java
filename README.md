# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-10T05:19:40Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 60.08K | ± 1.03K | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.83K | ± 160.08 | ops/s | 1.2x slower |
| prometheusAdd | 48.38K | ± 1.12K | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.45K | ± 1.46K | ops/s | 1.4x slower |
| simpleclientInc | 6.18K | ± 123.34 | ops/s | 9.7x slower |
| simpleclientAdd | 6.17K | ± 81.67 | ops/s | 9.7x slower |
| simpleclientNoLabelsInc | 6.02K | ± 202.96 | ops/s | 10.0x slower |
| openTelemetryInc | 5.31K | ± 775.27 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 4.80K | ± 1.25K | ops/s | 13x slower |
| openTelemetryAdd | 4.59K | ± 844.06 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.58K | ± 1.31K | ops/s | **fastest** |
| simpleclient | 4.39K | ± 191.84 | ops/s | 1.5x slower |
| prometheusNative | 2.94K | ± 184.46 | ops/s | 2.2x slower |
| openTelemetryClassic | 705.32 | ± 27.88 | ops/s | 9.3x slower |
| openTelemetryExponential | 567.88 | ± 28.22 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.46K | ± 291.05 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.33K | ± 50.76 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 563.15K | ± 3.87K | ops/s | **fastest** |
| prometheusWriteToByteArray | 551.38K | ± 7.77K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 532.57K | ± 5.59K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 522.15K | ± 2.73K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43449.141   ± 1464.358  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4586.637    ± 844.062  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5309.429    ± 775.275  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4800.219   ± 1249.526  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48375.918   ± 1116.264  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      60080.162   ± 1031.774  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51827.637    ± 160.079  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6173.516     ± 81.670  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6179.713    ± 123.344  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6022.393    ± 202.963  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        705.320     ± 27.880  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        567.882     ± 28.219  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6580.286   ± 1312.405  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2944.611    ± 184.459  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4385.584    ± 191.838  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27327.814     ± 50.763  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27463.187    ± 291.053  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     522149.709   ± 2734.484  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     532566.246   ± 5593.636  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     551382.785   ± 7768.749  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     563153.284   ± 3865.740  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-13T05:34:42Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.48K | ± 418.01 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.23K | ± 494.08 | ops/s | 1.2x slower |
| prometheusAdd | 47.92K | ± 447.88 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.90K | ± 487.41 | ops/s | 1.4x slower |
| simpleclientInc | 6.09K | ± 16.68 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 5.93K | ± 18.92 | ops/s | 10x slower |
| simpleclientAdd | 5.80K | ± 315.75 | ops/s | 10x slower |
| openTelemetryInc | 5.43K | ± 929.97 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 5.34K | ± 1.13K | ops/s | 11x slower |
| openTelemetryAdd | 3.89K | ± 799.84 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.65K | ± 501.36 | ops/s | **fastest** |
| simpleclient | 4.54K | ± 73.33 | ops/s | 1.0x slower |
| prometheusNative | 2.85K | ± 205.90 | ops/s | 1.6x slower |
| openTelemetryClassic | 711.34 | ± 29.98 | ops/s | 6.5x slower |
| openTelemetryExponential | 559.71 | ± 36.87 | ops/s | 8.3x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.59K | ± 161.23 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.49K | ± 80.21 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 583.25K | ± 7.63K | ops/s | **fastest** |
| prometheusWriteToByteArray | 575.18K | ± 3.07K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 550.31K | ± 7.61K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 541.28K | ± 7.25K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43901.719    ± 487.409  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3891.275    ± 799.836  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5427.981    ± 929.968  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5337.246   ± 1126.057  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      47919.326    ± 447.878  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59484.060    ± 418.008  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51229.024    ± 494.079  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5798.918    ± 315.749  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6087.948     ± 16.678  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5931.369     ± 18.922  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        711.337     ± 29.983  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        559.708     ± 36.871  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4652.240    ± 501.358  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2846.503    ± 205.901  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4541.230     ± 73.329  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27485.361     ± 80.208  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27592.800    ± 161.233  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     541279.537   ± 7252.594  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     550306.564   ± 7607.314  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     575182.083   ± 3069.190  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     583246.190   ± 7628.782  ops/s
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

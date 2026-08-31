# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-31T09:46:54Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.34K | ± 1.34K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.40K | ± 969.68 | ops/s | 1.2x slower |
| prometheusAdd | 51.48K | ± 106.26 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.95K | ± 1.41K | ops/s | 1.3x slower |
| simpleclientInc | 6.60K | ± 76.87 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 6.42K | ± 113.75 | ops/s | 10x slower |
| simpleclientAdd | 6.31K | ± 171.92 | ops/s | 10x slower |
| openTelemetryAdd | 3.20K | ± 302.03 | ops/s | 20x slower |
| openTelemetryInc | 3.08K | ± 223.24 | ops/s | 21x slower |
| openTelemetryIncNoLabels | 3.04K | ± 132.38 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.03K | ± 2.98K | ops/s | **fastest** |
| simpleclient | 4.41K | ± 57.90 | ops/s | 1.4x slower |
| prometheusNative | 2.74K | ± 305.36 | ops/s | 2.2x slower |
| openTelemetryClassic | 761.19 | ± 21.63 | ops/s | 7.9x slower |
| openTelemetryExponential | 622.78 | ± 84.76 | ops/s | 9.7x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.59K | ± 550.97 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.39K | ± 1.30K | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 500.67K | ± 3.52K | ops/s | **fastest** |
| prometheusWriteToByteArray | 493.89K | ± 4.25K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 468.40K | ± 6.72K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 462.78K | ± 10.08K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48952.019   ± 1407.599  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3195.704    ± 302.029  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3082.666    ± 223.242  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3042.191    ± 132.380  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51484.999    ± 106.256  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65341.834   ± 1340.264  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56395.103    ± 969.682  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6309.701    ± 171.917  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6597.846     ± 76.874  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6416.879    ± 113.751  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        761.186     ± 21.625  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        622.775     ± 84.759  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6028.649   ± 2984.345  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2735.847    ± 305.363  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4411.672     ± 57.898  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23391.036   ± 1298.230  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23591.410    ± 550.975  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     462779.157  ± 10077.420  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     468401.514   ± 6717.418  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     493888.825   ± 4251.803  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     500669.457   ± 3520.547  ops/s
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

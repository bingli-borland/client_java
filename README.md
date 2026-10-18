# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-18T08:25:18Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** INTEL(R) XEON(R) PLATINUM 8573C, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| codahaleIncNoLabels | 27.73K | ± 98.61 | ops/s | **fastest** |
| prometheusNoLabelsInc | 26.73K | ± 69.77 | ops/s | 1.0x slower |
| prometheusInc | 26.62K | ± 69.67 | ops/s | 1.0x slower |
| prometheusAdd | 25.57K | ± 477.44 | ops/s | 1.1x slower |
| simpleclientInc | 6.74K | ± 72.38 | ops/s | 4.1x slower |
| simpleclientNoLabelsInc | 6.66K | ± 42.13 | ops/s | 4.2x slower |
| simpleclientAdd | 6.51K | ± 135.16 | ops/s | 4.3x slower |
| openTelemetryIncNoLabels | 2.20K | ± 246.41 | ops/s | 13x slower |
| openTelemetryAdd | 2.02K | ± 14.37 | ops/s | 14x slower |
| openTelemetryInc | 1.98K | ± 112.24 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.35K | ± 18.09 | ops/s | **fastest** |
| prometheusClassic | 2.86K | ± 608.48 | ops/s | 1.5x slower |
| prometheusNative | 1.99K | ± 254.17 | ops/s | 2.2x slower |
| openTelemetryClassic | 453.68 | ± 29.50 | ops/s | 9.6x slower |
| openTelemetryExponential | 335.04 | ± 17.88 | ops/s | 13x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 17.92K | ± 64.01 | ops/s | **fastest** |
| openMetricsWriteToNull | 17.91K | ± 27.78 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 309.19K | ± 867.38 | ops/s | **fastest** |
| prometheusWriteToByteArray | 307.26K | ± 1.94K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 285.69K | ± 1.53K | ops/s | 1.1x slower |
| openMetricsWriteToNull | 285.57K | ± 1.80K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      27731.651     ± 98.612  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2018.160     ± 14.368  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       1984.138    ± 112.241  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2198.826    ± 246.409  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      25568.382    ± 477.436  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      26617.222     ± 69.674  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      26731.240     ± 69.768  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6507.009    ± 135.158  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6735.862     ± 72.375  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6656.091     ± 42.128  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        453.685     ± 29.503  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        335.036     ± 17.877  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       2856.578    ± 608.478  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       1987.377    ± 254.171  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4348.736     ± 18.091  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      17908.993     ± 27.777  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      17917.770     ± 64.014  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     285685.136   ± 1533.388  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     285566.720   ± 1795.913  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     307255.361   ± 1939.375  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     309192.346    ± 867.381  ops/s
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

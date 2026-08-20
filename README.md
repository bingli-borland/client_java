# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-20T04:20:06Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 58.97K | ± 69.67 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.51K | ± 1.03K | ops/s | 1.1x slower |
| prometheusAdd | 49.81K | ± 61.26 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.46K | ± 756.58 | ops/s | 1.4x slower |
| simpleclientInc | 6.16K | ± 47.07 | ops/s | 9.6x slower |
| simpleclientNoLabelsInc | 6.02K | ± 219.81 | ops/s | 9.8x slower |
| simpleclientAdd | 5.89K | ± 231.27 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 5.06K | ± 750.56 | ops/s | 12x slower |
| openTelemetryInc | 4.59K | ± 1.13K | ops/s | 13x slower |
| openTelemetryAdd | 3.86K | ± 881.32 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.56K | ± 2.53K | ops/s | **fastest** |
| simpleclient | 4.37K | ± 58.24 | ops/s | 1.5x slower |
| prometheusNative | 2.95K | ± 250.17 | ops/s | 2.2x slower |
| openTelemetryClassic | 695.90 | ± 30.18 | ops/s | 9.4x slower |
| openTelemetryExponential | 560.93 | ± 20.08 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.73K | ± 129.22 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.22K | ± 201.58 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 588.67K | ± 2.11K | ops/s | **fastest** |
| prometheusWriteToByteArray | 573.72K | ± 3.88K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 547.34K | ± 9.72K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 528.59K | ± 6.41K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43461.894    ± 756.584  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3858.523    ± 881.319  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4587.009   ± 1131.091  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5063.305    ± 750.556  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      49808.470     ± 61.256  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      58973.380     ± 69.675  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51510.308   ± 1027.394  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5889.563    ± 231.268  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6160.291     ± 47.067  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6021.695    ± 219.812  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        695.896     ± 30.180  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        560.931     ± 20.082  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6556.314   ± 2526.028  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2947.738    ± 250.172  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4367.460     ± 58.238  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27219.410    ± 201.579  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27727.912    ± 129.221  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     528591.901   ± 6411.631  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     547344.843   ± 9723.380  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     573721.177   ± 3879.335  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     588672.183   ± 2112.884  ops/s
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

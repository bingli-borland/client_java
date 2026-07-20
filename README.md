# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-20T07:05:29Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.30K | ± 516.99 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.79K | ± 773.80 | ops/s | 1.1x slower |
| prometheusAdd | 48.45K | ± 691.49 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.74K | ± 879.07 | ops/s | 1.3x slower |
| simpleclientInc | 6.16K | ± 46.12 | ops/s | 9.6x slower |
| simpleclientAdd | 5.96K | ± 224.92 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 5.92K | ± 22.18 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 5.33K | ± 845.35 | ops/s | 11x slower |
| openTelemetryAdd | 4.55K | ± 813.40 | ops/s | 13x slower |
| openTelemetryInc | 3.98K | ± 374.63 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 4.88K | ± 591.95 | ops/s | **fastest** |
| simpleclient | 4.50K | ± 59.36 | ops/s | 1.1x slower |
| prometheusNative | 3.14K | ± 82.43 | ops/s | 1.6x slower |
| openTelemetryClassic | 706.54 | ± 23.52 | ops/s | 6.9x slower |
| openTelemetryExponential | 563.45 | ± 12.82 | ops/s | 8.7x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.20K | ± 699.33 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.14K | ± 214.36 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 559.16K | ± 9.67K | ops/s | **fastest** |
| prometheusWriteToByteArray | 554.80K | ± 12.52K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 530.92K | ± 2.10K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 518.45K | ± 4.93K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44739.588    ± 879.073  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4546.965    ± 813.400  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3983.900    ± 374.630  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5328.512    ± 845.354  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48454.758    ± 691.486  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59298.046    ± 516.987  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51790.951    ± 773.795  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5964.197    ± 224.917  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6156.840     ± 46.115  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5919.968     ± 22.184  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        706.544     ± 23.525  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        563.454     ± 12.815  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4882.447    ± 591.955  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3140.215     ± 82.428  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4496.687     ± 59.360  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27137.307    ± 214.356  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27195.272    ± 699.326  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     518454.634   ± 4927.176  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     530919.669   ± 2100.471  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     554797.896  ± 12520.040  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     559159.931   ± 9670.573  ops/s
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

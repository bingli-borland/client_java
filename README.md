# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-16T08:13:15Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V45 96-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusNoLabelsInc | 67.24K | ± 962.45 | ops/s | **fastest** |
| codahaleIncNoLabels | 63.96K | ± 2.74K | ops/s | 1.1x slower |
| prometheusInc | 58.31K | ± 14.35K | ops/s | 1.2x slower |
| prometheusAdd | 56.18K | ± 2.50K | ops/s | 1.2x slower |
| simpleclientAdd | 10.74K | ± 385.52 | ops/s | 6.3x slower |
| simpleclientNoLabelsInc | 10.60K | ± 617.84 | ops/s | 6.3x slower |
| simpleclientInc | 10.48K | ± 449.54 | ops/s | 6.4x slower |
| openTelemetryInc | 5.94K | ± 257.62 | ops/s | 11x slower |
| openTelemetryIncNoLabels | 5.59K | ± 1.13K | ops/s | 12x slower |
| openTelemetryAdd | 5.36K | ± 585.12 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.49K | ± 2.24K | ops/s | **fastest** |
| simpleclient | 6.93K | ± 80.57 | ops/s | 1.1x slower |
| prometheusNative | 4.77K | ± 259.42 | ops/s | 1.6x slower |
| openTelemetryClassic | 923.91 | ± 34.23 | ops/s | 8.1x slower |
| openTelemetryExponential | 722.96 | ± 13.09 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 33.20K | ± 772.72 | ops/s | **fastest** |
| openMetricsWriteToNull | 32.44K | ± 680.33 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 765.33K | ± 43.75K | ops/s | **fastest** |
| prometheusWriteToByteArray | 746.86K | ± 42.81K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 703.84K | ± 41.75K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 656.00K | ± 54.51K | ops/s | 1.2x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      63955.774   ± 2739.900  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       5363.991    ± 585.125  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5944.996    ± 257.619  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5587.599   ± 1132.655  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      56180.540   ± 2502.055  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      58305.565  ± 14350.336  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      67238.816    ± 962.454  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15      10736.198    ± 385.522  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15      10476.377    ± 449.541  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15      10602.141    ± 617.840  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        923.911     ± 34.225  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        722.959     ± 13.085  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7490.936   ± 2235.876  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       4770.680    ± 259.422  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       6927.842     ± 80.574  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      32443.952    ± 680.327  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      33203.334    ± 772.722  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     655999.950  ± 54510.190  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     703838.917  ± 41745.461  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     746856.325  ± 42814.210  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     765332.095  ± 43752.879  ops/s
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

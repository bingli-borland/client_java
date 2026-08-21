# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-21T04:26:13Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.75K | ± 652.41 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.50K | ± 740.34 | ops/s | 1.2x slower |
| prometheusAdd | 51.38K | ± 370.63 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 50.10K | ± 208.32 | ops/s | 1.3x slower |
| simpleclientInc | 6.56K | ± 36.70 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.36K | ± 35.30 | ops/s | 10x slower |
| simpleclientAdd | 6.27K | ± 270.84 | ops/s | 11x slower |
| openTelemetryInc | 3.32K | ± 313.50 | ops/s | 20x slower |
| openTelemetryAdd | 3.02K | ± 293.38 | ops/s | 22x slower |
| openTelemetryIncNoLabels | 2.85K | ± 105.00 | ops/s | 23x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.89K | ± 610.12 | ops/s | **fastest** |
| simpleclient | 4.47K | ± 30.36 | ops/s | 1.5x slower |
| prometheusNative | 3.07K | ± 279.87 | ops/s | 2.2x slower |
| openTelemetryClassic | 778.02 | ± 18.83 | ops/s | 8.9x slower |
| openTelemetryExponential | 639.00 | ± 52.80 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.22K | ± 272.15 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.31K | ± 299.92 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 501.36K | ± 6.42K | ops/s | **fastest** |
| prometheusWriteToByteArray | 497.70K | ± 5.55K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 484.63K | ± 5.10K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 480.10K | ± 2.01K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      50103.754    ± 208.317  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3021.911    ± 293.375  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3316.981    ± 313.495  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2848.607    ± 104.998  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51378.384    ± 370.632  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66746.829    ± 652.406  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56499.327    ± 740.339  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6274.010    ± 270.840  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6558.384     ± 36.701  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6359.366     ± 35.297  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        778.017     ± 18.829  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        639.002     ± 52.801  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6886.077    ± 610.116  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3071.941    ± 279.868  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4466.290     ± 30.358  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23308.838    ± 299.917  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24222.078    ± 272.151  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     480101.484   ± 2010.177  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     484627.545   ± 5099.897  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     497703.300   ± 5551.263  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     501363.206   ± 6422.847  ops/s
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

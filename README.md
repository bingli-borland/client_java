# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-08T08:25:28Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 77.68K | ± 1.11K | ops/s | **fastest** |
| prometheusNoLabelsInc | 66.84K | ± 189.50 | ops/s | 1.2x slower |
| prometheusAdd | 62.80K | ± 1.23K | ops/s | 1.2x slower |
| codahaleIncNoLabels | 54.24K | ± 1.91K | ops/s | 1.4x slower |
| simpleclientInc | 7.88K | ± 39.53 | ops/s | 9.9x slower |
| simpleclientAdd | 7.82K | ± 21.00 | ops/s | 9.9x slower |
| simpleclientNoLabelsInc | 7.78K | ± 275.25 | ops/s | 10.0x slower |
| openTelemetryInc | 6.81K | ± 1.41K | ops/s | 11x slower |
| openTelemetryIncNoLabels | 5.80K | ± 1.36K | ops/s | 13x slower |
| openTelemetryAdd | 4.40K | ± 44.79 | ops/s | 18x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.58K | ± 2.16K | ops/s | **fastest** |
| simpleclient | 5.57K | ± 92.44 | ops/s | 1.2x slower |
| prometheusNative | 4.01K | ± 26.70 | ops/s | 1.6x slower |
| openTelemetryClassic | 891.41 | ± 29.22 | ops/s | 7.4x slower |
| openTelemetryExponential | 687.65 | ± 28.34 | ops/s | 9.6x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 34.68K | ± 1.07K | ops/s | **fastest** |
| openMetricsWriteToNull | 34.45K | ± 316.45 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 704.20K | ± 7.06K | ops/s | **fastest** |
| prometheusWriteToByteArray | 684.05K | ± 5.23K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 655.89K | ± 12.20K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 638.28K | ± 6.27K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      54243.244   ± 1914.545  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4395.665     ± 44.786  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       6813.455   ± 1406.780  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5800.356   ± 1356.041  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      62803.946   ± 1232.757  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      77675.759   ± 1107.756  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      66836.842    ± 189.499  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7824.876     ± 20.996  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7879.849     ± 39.528  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7778.747    ± 275.252  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        891.411     ± 29.218  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        687.650     ± 28.343  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6580.058   ± 2164.756  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       4009.280     ± 26.699  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5572.148     ± 92.445  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      34447.298    ± 316.453  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      34680.339   ± 1069.387  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     638282.058   ± 6266.482  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     655890.393  ± 12197.706  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     684045.752   ± 5227.942  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     704202.249   ± 7056.377  ops/s
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

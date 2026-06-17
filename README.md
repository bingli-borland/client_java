# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-17T08:37:56Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 58.48K | ± 2.07K | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.84K | ± 803.20 | ops/s | 1.1x slower |
| prometheusAdd | 48.20K | ± 329.78 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.74K | ± 572.94 | ops/s | 1.3x slower |
| simpleclientInc | 6.09K | ± 9.00 | ops/s | 9.6x slower |
| simpleclientAdd | 6.03K | ± 154.46 | ops/s | 9.7x slower |
| simpleclientNoLabelsInc | 5.91K | ± 31.53 | ops/s | 9.9x slower |
| openTelemetryInc | 4.64K | ± 988.01 | ops/s | 13x slower |
| openTelemetryIncNoLabels | 4.62K | ± 852.04 | ops/s | 13x slower |
| openTelemetryAdd | 4.44K | ± 796.94 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.46K | ± 1.06K | ops/s | **fastest** |
| simpleclient | 4.52K | ± 51.88 | ops/s | 1.7x slower |
| prometheusNative | 3.06K | ± 137.73 | ops/s | 2.4x slower |
| openTelemetryClassic | 728.55 | ± 12.58 | ops/s | 10x slower |
| openTelemetryExponential | 539.76 | ± 4.68 | ops/s | 14x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 27.36K | ± 173.73 | ops/s | **fastest** |
| prometheusWriteToNull | 27.21K | ± 133.34 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 585.71K | ± 1.90K | ops/s | **fastest** |
| prometheusWriteToByteArray | 574.33K | ± 4.49K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 536.49K | ± 10.21K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 535.87K | ± 5.72K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44738.529    ± 572.945  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4441.162    ± 796.942  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4636.812    ± 988.013  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       4622.036    ± 852.039  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48202.586    ± 329.782  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      58476.483   ± 2072.707  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51841.101    ± 803.200  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6033.132    ± 154.464  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6093.287      ± 9.000  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5907.264     ± 31.530  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        728.552     ± 12.582  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        539.764      ± 4.676  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7464.456   ± 1060.283  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3064.557    ± 137.731  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4520.780     ± 51.877  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27362.852    ± 173.727  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27210.968    ± 133.340  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     535867.786   ± 5721.341  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     536485.797  ± 10209.015  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     574328.750   ± 4487.672  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     585707.393   ± 1897.969  ops/s
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

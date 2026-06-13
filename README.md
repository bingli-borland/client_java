# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-13T07:40:58Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.24K | ± 434.57 | ops/s | **fastest** |
| prometheusNoLabelsInc | 52.07K | ± 860.72 | ops/s | 1.1x slower |
| prometheusAdd | 48.19K | ± 284.30 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.05K | ± 81.84 | ops/s | 1.3x slower |
| simpleclientInc | 6.19K | ± 22.87 | ops/s | 9.6x slower |
| simpleclientAdd | 6.04K | ± 163.54 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 5.84K | ± 95.91 | ops/s | 10x slower |
| openTelemetryInc | 5.54K | ± 1.13K | ops/s | 11x slower |
| openTelemetryIncNoLabels | 5.13K | ± 1.11K | ops/s | 12x slower |
| openTelemetryAdd | 4.69K | ± 859.74 | ops/s | 13x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.53K | ± 79.71 | ops/s | **fastest** |
| prometheusClassic | 4.15K | ± 320.30 | ops/s | 1.1x slower |
| prometheusNative | 3.03K | ± 186.13 | ops/s | 1.5x slower |
| openTelemetryClassic | 747.24 | ± 33.29 | ops/s | 6.1x slower |
| openTelemetryExponential | 585.38 | ± 20.26 | ops/s | 7.7x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 27.47K | ± 43.26 | ops/s | **fastest** |
| prometheusWriteToNull | 27.45K | ± 431.02 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 558.61K | ± 9.19K | ops/s | **fastest** |
| prometheusWriteToByteArray | 550.92K | ± 6.41K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 525.37K | ± 7.98K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 521.23K | ± 3.51K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44051.278     ± 81.835  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4687.170    ± 859.738  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5539.257   ± 1129.217  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5127.154   ± 1113.531  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48185.387    ± 284.302  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59238.672    ± 434.566  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      52066.684    ± 860.720  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6037.814    ± 163.535  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6194.323     ± 22.867  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5844.548     ± 95.906  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        747.244     ± 33.290  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        585.382     ± 20.260  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4153.662    ± 320.296  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3033.052    ± 186.129  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4527.427     ± 79.706  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27474.518     ± 43.264  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27448.203    ± 431.023  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     521225.456   ± 3510.713  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     525367.746   ± 7978.508  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     550922.879   ± 6407.261  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     558605.281   ± 9188.166  ops/s
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

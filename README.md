# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-09T05:06:02Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1020-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 63.35K | ± 3.71K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.73K | ± 635.30 | ops/s | 1.1x slower |
| prometheusAdd | 51.24K | ± 487.99 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 48.94K | ± 1.75K | ops/s | 1.3x slower |
| simpleclientInc | 6.58K | ± 9.30 | ops/s | 9.6x slower |
| simpleclientNoLabelsInc | 6.37K | ± 26.95 | ops/s | 9.9x slower |
| simpleclientAdd | 6.18K | ± 220.34 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.56K | ± 515.06 | ops/s | 18x slower |
| openTelemetryInc | 3.23K | ± 760.72 | ops/s | 20x slower |
| openTelemetryAdd | 2.87K | ± 186.69 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.89K | ± 1.03K | ops/s | **fastest** |
| simpleclient | 4.44K | ± 87.19 | ops/s | 1.3x slower |
| prometheusNative | 3.17K | ± 129.47 | ops/s | 1.9x slower |
| openTelemetryClassic | 767.36 | ± 11.93 | ops/s | 7.7x slower |
| openTelemetryExponential | 673.29 | ± 113.10 | ops/s | 8.7x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 23.96K | ± 685.57 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.77K | ± 168.09 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 511.73K | ± 7.89K | ops/s | **fastest** |
| prometheusWriteToByteArray | 501.46K | ± 4.81K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 493.94K | ± 1.25K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 489.91K | ± 3.70K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48943.814   ± 1748.293  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2873.032    ± 186.688  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3233.908    ± 760.720  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3559.644    ± 515.065  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51242.094    ± 487.987  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      63353.064   ± 3706.904  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56732.867    ± 635.301  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6175.309    ± 220.337  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6581.409      ± 9.301  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6371.090     ± 26.948  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        767.358     ± 11.931  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        673.292    ± 113.098  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5888.321   ± 1027.810  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3173.144    ± 129.471  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4440.069     ± 87.193  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23774.165    ± 168.094  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23960.014    ± 685.568  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     489908.352   ± 3704.498  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     493941.539   ± 1247.713  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     501455.141   ± 4810.721  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     511733.744   ± 7893.987  ops/s
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

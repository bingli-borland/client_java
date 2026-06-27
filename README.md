# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-27T07:16:06Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 75.30K | ± 1.12K | ops/s | **fastest** |
| prometheusNoLabelsInc | 66.43K | ± 633.63 | ops/s | 1.1x slower |
| prometheusAdd | 58.17K | ± 5.83K | ops/s | 1.3x slower |
| codahaleIncNoLabels | 56.08K | ± 1.84K | ops/s | 1.3x slower |
| simpleclientInc | 8.00K | ± 15.57 | ops/s | 9.4x slower |
| simpleclientAdd | 7.87K | ± 44.63 | ops/s | 9.6x slower |
| simpleclientNoLabelsInc | 7.58K | ± 91.14 | ops/s | 9.9x slower |
| openTelemetryIncNoLabels | 6.33K | ± 1.21K | ops/s | 12x slower |
| openTelemetryInc | 6.22K | ± 1.19K | ops/s | 12x slower |
| openTelemetryAdd | 4.88K | ± 1.17K | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.00K | ± 2.03K | ops/s | **fastest** |
| simpleclient | 5.85K | ± 69.57 | ops/s | 1.2x slower |
| prometheusNative | 3.69K | ± 299.73 | ops/s | 1.9x slower |
| openTelemetryClassic | 936.14 | ± 6.77 | ops/s | 7.5x slower |
| openTelemetryExponential | 713.30 | ± 51.22 | ops/s | 9.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 35.18K | ± 409.10 | ops/s | **fastest** |
| openMetricsWriteToNull | 34.70K | ± 574.84 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 705.14K | ± 3.62K | ops/s | **fastest** |
| prometheusWriteToByteArray | 687.32K | ± 4.46K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 658.73K | ± 5.27K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 648.08K | ± 4.00K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      56082.452   ± 1836.047  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4878.583   ± 1166.959  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       6215.777   ± 1191.135  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       6330.620   ± 1209.712  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      58173.544   ± 5825.829  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      75299.129   ± 1116.734  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      66430.551    ± 633.628  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7868.054     ± 44.626  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7995.358     ± 15.573  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7580.613     ± 91.143  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        936.139      ± 6.769  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        713.303     ± 51.223  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7001.835   ± 2030.669  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3694.908    ± 299.732  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5845.918     ± 69.571  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      34697.195    ± 574.840  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      35182.704    ± 409.101  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     648080.827   ± 3998.960  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     658728.709   ± 5271.516  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     687322.900   ± 4458.348  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     705141.998   ± 3617.423  ops/s
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

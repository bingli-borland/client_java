# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-04T08:25:34Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.49K | ± 1.86K | ops/s | **fastest** |
| prometheusNoLabelsInc | 52.82K | ± 5.17K | ops/s | 1.2x slower |
| prometheusAdd | 51.60K | ± 152.05 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 47.78K | ± 1.04K | ops/s | 1.4x slower |
| simpleclientInc | 6.58K | ± 8.92 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 6.41K | ± 184.79 | ops/s | 10x slower |
| simpleclientAdd | 6.33K | ± 271.81 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 3.64K | ± 530.00 | ops/s | 18x slower |
| openTelemetryAdd | 3.46K | ± 256.98 | ops/s | 19x slower |
| openTelemetryInc | 3.19K | ± 266.19 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.15K | ± 1.37K | ops/s | **fastest** |
| simpleclient | 4.44K | ± 45.16 | ops/s | 1.2x slower |
| prometheusNative | 2.80K | ± 266.65 | ops/s | 1.8x slower |
| openTelemetryClassic | 772.19 | ± 27.30 | ops/s | 6.7x slower |
| openTelemetryExponential | 586.79 | ± 6.01 | ops/s | 8.8x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.04K | ± 1.15K | ops/s | **fastest** |
| openMetricsWriteToNull | 23.52K | ± 659.76 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 493.31K | ± 3.24K | ops/s | **fastest** |
| prometheusWriteToByteArray | 475.51K | ± 3.68K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 466.64K | ± 6.08K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 460.52K | ± 4.80K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      47781.898   ± 1037.378  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3460.202    ± 256.980  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3194.647    ± 266.190  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3636.039    ± 529.998  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51599.179    ± 152.045  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65490.624   ± 1856.407  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      52821.693   ± 5172.980  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6330.195    ± 271.815  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6577.932      ± 8.923  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6406.480    ± 184.790  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        772.192     ± 27.302  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        586.788      ± 6.007  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5150.807   ± 1370.020  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2796.359    ± 266.650  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4435.648     ± 45.159  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23518.860    ± 659.763  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24035.042   ± 1145.963  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     460517.001   ± 4802.439  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     466635.237   ± 6078.120  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     475509.855   ± 3684.969  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     493305.586   ± 3238.862  ops/s
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

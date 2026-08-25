# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-25T04:22:03Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.39K | ± 619.40 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.60K | ± 258.86 | ops/s | 1.2x slower |
| prometheusAdd | 51.60K | ± 180.10 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 49.18K | ± 1.56K | ops/s | 1.4x slower |
| simpleclientInc | 6.58K | ± 10.42 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.36K | ± 36.42 | ops/s | 10x slower |
| simpleclientAdd | 6.32K | ± 163.26 | ops/s | 11x slower |
| openTelemetryAdd | 3.31K | ± 386.05 | ops/s | 20x slower |
| openTelemetryIncNoLabels | 3.30K | ± 123.43 | ops/s | 20x slower |
| openTelemetryInc | 3.06K | ± 202.53 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.85K | ± 1.41K | ops/s | **fastest** |
| simpleclient | 4.38K | ± 27.96 | ops/s | 1.3x slower |
| prometheusNative | 2.86K | ± 242.56 | ops/s | 2.0x slower |
| openTelemetryClassic | 772.63 | ± 26.81 | ops/s | 7.6x slower |
| openTelemetryExponential | 681.50 | ± 96.01 | ops/s | 8.6x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.38K | ± 658.60 | ops/s | **fastest** |
| openMetricsWriteToNull | 22.96K | ± 943.96 | ops/s | 1.1x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 487.61K | ± 2.87K | ops/s | **fastest** |
| prometheusWriteToByteArray | 472.73K | ± 5.64K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 463.64K | ± 5.54K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 461.49K | ± 3.03K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      49177.897   ± 1557.564  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3308.502    ± 386.047  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3060.998    ± 202.526  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3296.810    ± 123.432  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51597.910    ± 180.101  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66394.247    ± 619.400  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56595.410    ± 258.861  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6317.618    ± 163.264  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6580.382     ± 10.423  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6357.132     ± 36.422  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        772.630     ± 26.812  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        681.496     ± 96.014  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5847.291   ± 1410.236  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2860.444    ± 242.564  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4381.069     ± 27.957  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      22957.659    ± 943.964  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24383.137    ± 658.596  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     461487.820   ± 3031.195  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     463642.039   ± 5541.592  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     472725.466   ± 5640.577  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     487608.315   ± 2873.059  ops/s
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

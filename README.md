# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-09-14T09:04:40Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.83K | ± 196.16 | ops/s | **fastest** |
| prometheusNoLabelsInc | 55.95K | ± 776.90 | ops/s | 1.2x slower |
| prometheusAdd | 50.44K | ± 388.12 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 47.60K | ± 687.21 | ops/s | 1.4x slower |
| simpleclientInc | 6.58K | ± 8.50 | ops/s | 10x slower |
| simpleclientAdd | 6.47K | ± 65.21 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.44K | ± 137.46 | ops/s | 10x slower |
| openTelemetryAdd | 3.43K | ± 114.67 | ops/s | 19x slower |
| openTelemetryInc | 3.21K | ± 301.43 | ops/s | 21x slower |
| openTelemetryIncNoLabels | 2.94K | ± 219.19 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.93K | ± 868.66 | ops/s | **fastest** |
| simpleclient | 4.41K | ± 42.38 | ops/s | 1.3x slower |
| prometheusNative | 2.85K | ± 311.12 | ops/s | 2.1x slower |
| openTelemetryClassic | 762.18 | ± 26.31 | ops/s | 7.8x slower |
| openTelemetryExponential | 709.38 | ± 52.53 | ops/s | 8.4x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.77K | ± 419.45 | ops/s | **fastest** |
| prometheusWriteToNull | 22.88K | ± 313.62 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 501.46K | ± 2.95K | ops/s | **fastest** |
| prometheusWriteToByteArray | 496.48K | ± 9.37K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 485.56K | ± 4.78K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 480.64K | ± 4.11K | ops/s | 1.0x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      47597.132    ± 687.206  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3425.344    ± 114.670  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3205.176    ± 301.433  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2936.347    ± 219.189  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      50444.778    ± 388.118  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65830.704    ± 196.157  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      55953.100    ± 776.898  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6473.405     ± 65.210  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6581.592      ± 8.502  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6435.311    ± 137.458  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        762.179     ± 26.312  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        709.385     ± 52.526  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5934.842    ± 868.659  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2852.011    ± 311.117  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4413.974     ± 42.379  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23771.471    ± 419.446  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      22884.828    ± 313.624  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     480639.689   ± 4111.817  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     485560.747   ± 4781.121  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     496480.974   ± 9367.385  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     501463.381   ± 2953.998  ops/s
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

# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-06-23T07:32:04Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.88K | ± 55.30 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.57K | ± 729.27 | ops/s | 1.2x slower |
| prometheusAdd | 51.51K | ± 136.21 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 50.11K | ± 986.29 | ops/s | 1.3x slower |
| simpleclientInc | 6.52K | ± 58.48 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.36K | ± 42.09 | ops/s | 10x slower |
| simpleclientAdd | 6.28K | ± 345.89 | ops/s | 10x slower |
| openTelemetryInc | 3.21K | ± 336.97 | ops/s | 21x slower |
| openTelemetryAdd | 3.14K | ± 435.69 | ops/s | 21x slower |
| openTelemetryIncNoLabels | 3.02K | ± 148.79 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 7.29K | ± 1.16K | ops/s | **fastest** |
| simpleclient | 4.41K | ± 31.13 | ops/s | 1.7x slower |
| prometheusNative | 2.87K | ± 267.56 | ops/s | 2.5x slower |
| openTelemetryClassic | 756.22 | ± 12.73 | ops/s | 9.6x slower |
| openTelemetryExponential | 632.19 | ± 51.04 | ops/s | 12x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.42K | ± 372.03 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.94K | ± 466.39 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 511.51K | ± 3.36K | ops/s | **fastest** |
| prometheusWriteToByteArray | 508.04K | ± 3.41K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 488.51K | ± 2.69K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 478.38K | ± 5.81K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      50109.059    ± 986.292  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3136.080    ± 435.689  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3207.832    ± 336.970  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3018.286    ± 148.791  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51511.196    ± 136.211  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65875.369     ± 55.303  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56566.063    ± 729.266  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6283.301    ± 345.888  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6518.558     ± 58.485  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6356.220     ± 42.091  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        756.221     ± 12.735  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        632.192     ± 51.045  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       7287.797   ± 1160.831  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2870.421    ± 267.564  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4410.745     ± 31.129  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23942.826    ± 466.386  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24420.354    ± 372.032  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     478376.196   ± 5812.561  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     488508.029   ± 2687.471  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     508041.199   ± 3405.032  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     511514.776   ± 3357.316  ops/s
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

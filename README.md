# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-08-19T04:20:57Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 65.16K | ± 1.51K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.54K | ± 705.87 | ops/s | 1.2x slower |
| prometheusAdd | 51.43K | ± 131.94 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 47.30K | ± 376.09 | ops/s | 1.4x slower |
| simpleclientInc | 6.44K | ± 70.68 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.40K | ± 202.33 | ops/s | 10x slower |
| simpleclientAdd | 6.32K | ± 192.89 | ops/s | 10x slower |
| openTelemetryAdd | 3.17K | ± 440.91 | ops/s | 21x slower |
| openTelemetryInc | 3.14K | ± 269.08 | ops/s | 21x slower |
| openTelemetryIncNoLabels | 3.12K | ± 185.83 | ops/s | 21x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.33K | ± 1.26K | ops/s | **fastest** |
| simpleclient | 4.40K | ± 92.37 | ops/s | 1.2x slower |
| prometheusNative | 3.00K | ± 274.36 | ops/s | 1.8x slower |
| openTelemetryClassic | 736.83 | ± 17.58 | ops/s | 7.2x slower |
| openTelemetryExponential | 653.22 | ± 50.11 | ops/s | 8.2x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 24.20K | ± 605.41 | ops/s | **fastest** |
| openMetricsWriteToNull | 23.94K | ± 536.35 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToByteArray | 497.71K | ± 3.75K | ops/s | **fastest** |
| prometheusWriteToNull | 494.34K | ± 7.16K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 473.79K | ± 7.43K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 470.29K | ± 5.27K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      47296.803    ± 376.094  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3165.275    ± 440.908  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3135.515    ± 269.080  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3121.469    ± 185.829  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51431.605    ± 131.940  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      65162.226   ± 1509.660  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56539.390    ± 705.871  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6319.609    ± 192.888  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6439.627     ± 70.682  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6400.860    ± 202.333  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        736.830     ± 17.577  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        653.219     ± 50.109  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5331.327   ± 1255.051  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3003.366    ± 274.361  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4396.134     ± 92.369  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23935.246    ± 536.348  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      24201.025    ± 605.413  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     470287.660   ± 5271.180  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     473786.615   ± 7432.816  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     497707.323   ± 3753.733  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     494338.529   ± 7158.555  ops/s
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

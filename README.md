# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-07-08T06:45:51Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1018-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 55.63K | ± 2.73K | ops/s | **fastest** |
| prometheusAdd | 48.56K | ± 864.60 | ops/s | 1.1x slower |
| prometheusNoLabelsInc | 44.56K | ± 9.03K | ops/s | 1.2x slower |
| codahaleIncNoLabels | 44.52K | ± 363.12 | ops/s | 1.2x slower |
| simpleclientInc | 6.26K | ± 39.88 | ops/s | 8.9x slower |
| simpleclientNoLabelsInc | 5.90K | ± 13.00 | ops/s | 9.4x slower |
| simpleclientAdd | 5.82K | ± 205.32 | ops/s | 9.6x slower |
| openTelemetryInc | 4.18K | ± 273.49 | ops/s | 13x slower |
| openTelemetryAdd | 4.07K | ± 788.61 | ops/s | 14x slower |
| openTelemetryIncNoLabels | 3.88K | ± 264.71 | ops/s | 14x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 6.02K | ± 1.24K | ops/s | **fastest** |
| simpleclient | 4.35K | ± 53.26 | ops/s | 1.4x slower |
| prometheusNative | 2.82K | ± 258.68 | ops/s | 2.1x slower |
| openTelemetryClassic | 740.20 | ± 35.90 | ops/s | 8.1x slower |
| openTelemetryExponential | 548.89 | ± 4.31 | ops/s | 11x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.32K | ± 255.55 | ops/s | **fastest** |
| openMetricsWriteToNull | 27.26K | ± 342.90 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 560.16K | ± 3.05K | ops/s | **fastest** |
| prometheusWriteToByteArray | 549.18K | ± 9.36K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 530.99K | ± 2.08K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 513.20K | ± 9.66K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      44521.261    ± 363.121  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4072.078    ± 788.611  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       4184.850    ± 273.489  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3876.253    ± 264.714  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48558.493    ± 864.601  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      55633.265   ± 2728.396  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      44564.417   ± 9034.897  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5820.833    ± 205.322  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6258.891     ± 39.881  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5898.626     ± 13.000  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        740.204     ± 35.897  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        548.886      ± 4.310  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       6016.098   ± 1242.634  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2820.826    ± 258.677  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4347.499     ± 53.255  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      27255.349    ± 342.901  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27318.605    ± 255.553  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     513198.123   ± 9664.602  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     530985.929   ± 2079.660  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     549184.714   ± 9361.084  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     560157.146   ± 3045.021  ops/s
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

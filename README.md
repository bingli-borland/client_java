# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-03T09:09:27Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 66.02K | ± 423.52 | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.51K | ± 668.00 | ops/s | 1.2x slower |
| prometheusAdd | 51.49K | ± 347.57 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 45.18K | ± 8.01K | ops/s | 1.5x slower |
| simpleclientInc | 6.51K | ± 114.28 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 6.38K | ± 22.93 | ops/s | 10x slower |
| simpleclientAdd | 6.13K | ± 242.90 | ops/s | 11x slower |
| openTelemetryInc | 3.59K | ± 579.84 | ops/s | 18x slower |
| openTelemetryAdd | 3.34K | ± 220.32 | ops/s | 20x slower |
| openTelemetryIncNoLabels | 3.05K | ± 332.11 | ops/s | 22x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.91K | ± 1.74K | ops/s | **fastest** |
| simpleclient | 4.42K | ± 86.08 | ops/s | 1.3x slower |
| prometheusNative | 2.98K | ± 226.89 | ops/s | 2.0x slower |
| openTelemetryClassic | 758.59 | ± 33.63 | ops/s | 7.8x slower |
| openTelemetryExponential | 722.26 | ± 12.59 | ops/s | 8.2x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.93K | ± 283.30 | ops/s | **fastest** |
| prometheusWriteToNull | 23.82K | ± 896.05 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 498.08K | ± 10.95K | ops/s | **fastest** |
| prometheusWriteToByteArray | 497.95K | ± 6.51K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 473.94K | ± 3.68K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 463.96K | ± 3.70K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      45177.808   ± 8013.021  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3342.710    ± 220.324  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3585.570    ± 579.837  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3053.376    ± 332.115  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51487.808    ± 347.566  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      66022.862    ± 423.519  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56509.635    ± 667.996  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6132.082    ± 242.901  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6507.760    ± 114.285  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6377.976     ± 22.930  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        758.586     ± 33.630  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        722.261     ± 12.592  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5908.297   ± 1741.759  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2975.501    ± 226.890  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4420.159     ± 86.081  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23929.006    ± 283.299  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23816.077    ± 896.049  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     463959.161   ± 3703.026  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     473944.264   ± 3677.962  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     497953.984   ± 6506.902  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     498079.876  ± 10953.225  ops/s
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

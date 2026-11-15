# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-11-15T10:19:24Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** INTEL(R) XEON(R) PLATINUM 8573C, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| codahaleIncNoLabels | 32.18K | ± 88.59 | ops/s | **fastest** |
| prometheusNoLabelsInc | 31.35K | ± 725.00 | ops/s | 1.0x slower |
| prometheusInc | 30.57K | ± 106.34 | ops/s | 1.1x slower |
| prometheusAdd | 30.26K | ± 161.11 | ops/s | 1.1x slower |
| simpleclientInc | 7.72K | ± 33.16 | ops/s | 4.2x slower |
| simpleclientNoLabelsInc | 7.57K | ± 98.05 | ops/s | 4.3x slower |
| simpleclientAdd | 7.32K | ± 171.44 | ops/s | 4.4x slower |
| openTelemetryIncNoLabels | 2.76K | ± 241.14 | ops/s | 12x slower |
| openTelemetryInc | 2.41K | ± 312.89 | ops/s | 13x slower |
| openTelemetryAdd | 2.13K | ± 74.60 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 4.88K | ± 142.57 | ops/s | **fastest** |
| prometheusClassic | 4.04K | ± 2.35K | ops/s | 1.2x slower |
| prometheusNative | 2.43K | ± 170.06 | ops/s | 2.0x slower |
| openTelemetryClassic | 594.58 | ± 46.83 | ops/s | 8.2x slower |
| openTelemetryExponential | 465.10 | ± 45.71 | ops/s | 10x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 20.60K | ± 79.17 | ops/s | **fastest** |
| openMetricsWriteToNull | 20.54K | ± 142.04 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 332.78K | ± 5.24K | ops/s | **fastest** |
| prometheusWriteToByteArray | 323.64K | ± 3.91K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 317.97K | ± 6.57K | ops/s | 1.0x slower |
| openMetricsWriteToByteArray | 306.84K | ± 3.47K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      32180.289     ± 88.591  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       2130.248     ± 74.604  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       2412.648    ± 312.890  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       2757.572    ± 241.139  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      30263.131    ± 161.105  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      30567.892    ± 106.345  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      31354.981    ± 725.004  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7324.587    ± 171.436  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7721.743     ± 33.156  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7569.336     ± 98.045  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        594.581     ± 46.834  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        465.098     ± 45.707  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       4035.408   ± 2351.434  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2429.425    ± 170.057  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4877.853    ± 142.571  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      20536.410    ± 142.040  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      20597.483     ± 79.170  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     306840.835   ± 3465.649  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     317973.699   ± 6565.390  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     323641.799   ± 3914.982  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     332781.491   ± 5238.178  ops/s
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

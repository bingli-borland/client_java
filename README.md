# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-05-31T07:43:46Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 7763 64-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1015-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 64.24K | ± 1.10K | ops/s | **fastest** |
| prometheusNoLabelsInc | 56.41K | ± 1.03K | ops/s | 1.1x slower |
| prometheusAdd | 51.25K | ± 540.97 | ops/s | 1.3x slower |
| codahaleIncNoLabels | 48.30K | ± 2.03K | ops/s | 1.3x slower |
| simpleclientInc | 6.53K | ± 148.14 | ops/s | 9.8x slower |
| simpleclientNoLabelsInc | 6.36K | ± 37.86 | ops/s | 10x slower |
| simpleclientAdd | 6.23K | ± 198.71 | ops/s | 10x slower |
| openTelemetryAdd | 3.74K | ± 190.63 | ops/s | 17x slower |
| openTelemetryIncNoLabels | 3.61K | ± 594.62 | ops/s | 18x slower |
| openTelemetryInc | 3.16K | ± 152.96 | ops/s | 20x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.55K | ± 1.46K | ops/s | **fastest** |
| simpleclient | 4.39K | ± 9.57 | ops/s | 1.3x slower |
| prometheusNative | 2.63K | ± 127.33 | ops/s | 2.1x slower |
| openTelemetryClassic | 765.59 | ± 35.88 | ops/s | 7.2x slower |
| openTelemetryExponential | 604.49 | ± 54.22 | ops/s | 9.2x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| openMetricsWriteToNull | 23.52K | ± 1.12K | ops/s | **fastest** |
| prometheusWriteToNull | 23.50K | ± 586.66 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 531.23K | ± 5.20K | ops/s | **fastest** |
| prometheusWriteToByteArray | 518.29K | ± 4.94K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 496.15K | ± 4.40K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 490.47K | ± 3.38K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      48301.217   ± 2026.626  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       3736.945    ± 190.629  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3158.852    ± 152.957  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       3611.399    ± 594.620  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      51254.233    ± 540.967  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      64239.243   ± 1097.068  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      56412.523   ± 1034.577  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       6234.828    ± 198.715  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6529.936    ± 148.145  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       6358.699     ± 37.859  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        765.588     ± 35.880  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        604.486     ± 54.225  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5546.929   ± 1464.482  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2626.198    ± 127.328  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4393.126      ± 9.574  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      23517.248   ± 1121.137  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      23496.283    ± 586.660  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     490472.324   ± 3382.942  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     496152.657   ± 4400.066  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     518291.243   ± 4944.073  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     531228.110   ± 5198.056  ops/s
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

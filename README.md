# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-22T08:40:23Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 7.0.0-1017-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 59.76K | ± 929.37 | ops/s | **fastest** |
| prometheusNoLabelsInc | 51.49K | ± 857.29 | ops/s | 1.2x slower |
| prometheusAdd | 48.71K | ± 990.25 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 43.84K | ± 24.55 | ops/s | 1.4x slower |
| simpleclientInc | 6.08K | ± 47.28 | ops/s | 9.8x slower |
| simpleclientAdd | 5.93K | ± 181.81 | ops/s | 10x slower |
| simpleclientNoLabelsInc | 5.84K | ± 103.21 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 5.02K | ± 1.05K | ops/s | 12x slower |
| openTelemetryAdd | 4.54K | ± 827.37 | ops/s | 13x slower |
| openTelemetryInc | 3.86K | ± 212.38 | ops/s | 15x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusClassic | 5.09K | ± 1.82K | ops/s | **fastest** |
| simpleclient | 4.56K | ± 124.33 | ops/s | 1.1x slower |
| prometheusNative | 2.69K | ± 110.72 | ops/s | 1.9x slower |
| openTelemetryClassic | 740.22 | ± 32.26 | ops/s | 6.9x slower |
| openTelemetryExponential | 566.89 | ± 20.06 | ops/s | 9.0x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 27.23K | ± 417.66 | ops/s | **fastest** |
| openMetricsWriteToNull | 26.67K | ± 751.74 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 575.60K | ± 3.89K | ops/s | **fastest** |
| prometheusWriteToByteArray | 563.23K | ± 8.44K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 537.41K | ± 3.36K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 514.66K | ± 5.58K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      43835.018     ± 24.551  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4539.002    ± 827.373  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       3858.267    ± 212.376  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5023.070   ± 1053.309  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      48707.546    ± 990.254  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      59755.030    ± 929.371  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      51489.446    ± 857.287  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       5934.868    ± 181.806  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       6080.464     ± 47.284  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       5843.951    ± 103.214  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        740.222     ± 32.264  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        566.893     ± 20.063  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5093.815   ± 1819.516  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       2690.918    ± 110.718  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       4564.165    ± 124.328  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      26674.228    ± 751.735  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      27231.398    ± 417.659  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     514658.551   ± 5579.804  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     537409.657   ± 3362.786  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     563228.005   ± 8435.412  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     575599.055   ± 3887.420  ops/s
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

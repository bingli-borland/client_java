# Prometheus Java Client Benchmarks

## Run Information

- **Date:** 2026-10-14T08:39:09Z
- **Commit:** [`ba6b0b5`](https://github.com/bingli-borland/client_java/commit/ba6b0b5a95b98ad40d2b513f3e446fdfbf94d0ab)
- **JDK:** 25.0.3 (OpenJDK 64-Bit Server VM)
- **Benchmark config:** 3 fork(s), 3 warmup, 5 measurement, 4 threads
- **Hardware:** AMD EPYC 9V74 80-Core Processor, 4 cores, 16 GB RAM
- **OS:** Linux 6.17.0-1022-azure

## Results

### CounterBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusInc | 76.86K | ± 552.34 | ops/s | **fastest** |
| prometheusNoLabelsInc | 66.19K | ± 468.28 | ops/s | 1.2x slower |
| prometheusAdd | 62.56K | ± 70.46 | ops/s | 1.2x slower |
| codahaleIncNoLabels | 56.42K | ± 2.19K | ops/s | 1.4x slower |
| simpleclientInc | 7.96K | ± 66.63 | ops/s | 9.7x slower |
| simpleclientAdd | 7.72K | ± 195.46 | ops/s | 10.0x slower |
| simpleclientNoLabelsInc | 7.62K | ± 21.76 | ops/s | 10x slower |
| openTelemetryIncNoLabels | 5.85K | ± 476.29 | ops/s | 13x slower |
| openTelemetryInc | 5.07K | ± 451.66 | ops/s | 15x slower |
| openTelemetryAdd | 4.80K | ± 251.72 | ops/s | 16x slower |

### HistogramBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| simpleclient | 5.78K | ± 162.74 | ops/s | **fastest** |
| prometheusClassic | 5.71K | ± 138.66 | ops/s | 1.0x slower |
| prometheusNative | 3.98K | ± 370.47 | ops/s | 1.5x slower |
| openTelemetryClassic | 942.52 | ± 63.33 | ops/s | 6.1x slower |
| openTelemetryExponential | 716.24 | ± 24.40 | ops/s | 8.1x slower |

### HistogramTextFormatBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 35.48K | ± 521.80 | ops/s | **fastest** |
| openMetricsWriteToNull | 34.73K | ± 504.54 | ops/s | 1.0x slower |

### TextFormatUtilBenchmark

| Benchmark | Score | Error | Units | |
|:----------|------:|------:|:------|:---|
| prometheusWriteToNull | 696.45K | ± 6.69K | ops/s | **fastest** |
| prometheusWriteToByteArray | 686.43K | ± 5.63K | ops/s | 1.0x slower |
| openMetricsWriteToNull | 661.14K | ± 4.08K | ops/s | 1.1x slower |
| openMetricsWriteToByteArray | 646.74K | ± 7.10K | ops/s | 1.1x slower |

### Raw Results

```
Benchmark                                            Mode  Cnt          Score        Error  Units
CounterBenchmark.codahaleIncNoLabels                thrpt   15      56421.617   ± 2187.805  ops/s
CounterBenchmark.openTelemetryAdd                   thrpt   15       4804.669    ± 251.723  ops/s
CounterBenchmark.openTelemetryInc                   thrpt   15       5066.742    ± 451.658  ops/s
CounterBenchmark.openTelemetryIncNoLabels           thrpt   15       5849.383    ± 476.291  ops/s
CounterBenchmark.prometheusAdd                      thrpt   15      62558.458     ± 70.455  ops/s
CounterBenchmark.prometheusInc                      thrpt   15      76856.687    ± 552.339  ops/s
CounterBenchmark.prometheusNoLabelsInc              thrpt   15      66188.184    ± 468.281  ops/s
CounterBenchmark.simpleclientAdd                    thrpt   15       7717.999    ± 195.457  ops/s
CounterBenchmark.simpleclientInc                    thrpt   15       7962.514     ± 66.635  ops/s
CounterBenchmark.simpleclientNoLabelsInc            thrpt   15       7622.290     ± 21.756  ops/s
HistogramBenchmark.openTelemetryClassic             thrpt   15        942.520     ± 63.330  ops/s
HistogramBenchmark.openTelemetryExponential         thrpt   15        716.243     ± 24.396  ops/s
HistogramBenchmark.prometheusClassic                thrpt   15       5713.517    ± 138.656  ops/s
HistogramBenchmark.prometheusNative                 thrpt   15       3975.917    ± 370.472  ops/s
HistogramBenchmark.simpleclient                     thrpt   15       5784.118    ± 162.739  ops/s
HistogramTextFormatBenchmark.openMetricsWriteToNull  thrpt   15      34728.574    ± 504.540  ops/s
HistogramTextFormatBenchmark.prometheusWriteToNull  thrpt   15      35479.087    ± 521.797  ops/s
TextFormatUtilBenchmark.openMetricsWriteToByteArray  thrpt   15     646737.736   ± 7096.461  ops/s
TextFormatUtilBenchmark.openMetricsWriteToNull      thrpt   15     661144.800   ± 4076.357  ops/s
TextFormatUtilBenchmark.prometheusWriteToByteArray  thrpt   15     686429.781   ± 5628.555  ops/s
TextFormatUtilBenchmark.prometheusWriteToNull       thrpt   15     696453.125   ± 6691.233  ops/s
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

package com.tt.concurrent.callable;

import java.util.concurrent.Callable;

public class ComplexMathCallable implements Callable<Double> {
    private ComplexMath cm;
    private int threadNumber;
    private int numberOfThreads;

    public ComplexMathCallable(ComplexMath cm, int threadNumber, int numberOfThreads) {
        this.cm = cm;
        this.threadNumber = threadNumber;
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public Double call() throws Exception {
        double result = 0.;
        int columns = cm.getNoColumns();
        int current = columns / numberOfThreads;
        for (int i = current * threadNumber; i < (threadNumber + 1) * current; i++) {
            result += cm.doComplexMathForColumn(i);
        }
        return result;
    }
}
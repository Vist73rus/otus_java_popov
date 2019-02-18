package ru.otus.popovab.l011;

import java.util.*;
import java.util.concurrent.Callable;

import com.google.common.collect.Collections2;

public class Main {
    private static final int MEASURE_COUNT = 1;

    public static void main(String[] args) throws Exception {
        Collection<Integer> example = new ArrayList<>();
        int min = 0;
        int max = 999;
        for (int i = min; i < max + 1; i++) {
            example.add(i);
        }

        calcTimeRun(() -> Collections2.permutations((List<Integer>)example));
        calcTimeCall(() -> Collections2.permutations((List<Integer>)example));
    }

    private static void calcTimeRun(Runnable runnable) {
        long startTime = System.nanoTime();
        for (int i = 0; i < MEASURE_COUNT; i++)
            runnable.run();
        long finishTime = System.nanoTime();
        long timeNs = (finishTime - startTime) / MEASURE_COUNT;
        System.out.println("Run time spent: " + timeNs + "ns (" + timeNs / 1_000_000 + "ms)");
    }

    private static void calcTimeCall(Callable callable) throws Exception {
        long startTime = System.nanoTime();
        for (int i = 0; i < MEASURE_COUNT; i++) {
            callable.call();
        }
        long finishTime = System.nanoTime();
        long timeNs = (finishTime - startTime) / MEASURE_COUNT;
        System.out.println("Call time spent: " + timeNs + "ns (" + timeNs / 1_000_000 + "ms)");
    }
}

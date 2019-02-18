package ru.otus.popovab.l021;

import java.util.function.Supplier;

public class MemoryCalc {
    private long timeWaitMills = 10;
    private int timeWaitNanos = 100;
    private long memoryBefore;
    private long memoryAfter;
    private long arraySize = 10000;
    Object[] arrayObj;

    void memoryCalc(Supplier<Object> supplier) throws Exception {
        String className = supplier.get().getClass().getSimpleName();
        System.out.printf("class name: %s\n", className);

        this.arrayObj = new Object[(int) this.arraySize];
        this.memoryBefore = getUsedMemory();

        for (int i = 0; i < this.arrayObj.length; i++) {
            this.arrayObj[i] = supplier.get();
        }

        this.memoryAfter = getUsedMemory();
        this.arrayObj = null;

        PrintMemoryStat();
    }

    private long getUsedMemory() throws Exception {
        System.gc();
        Thread.sleep(this.timeWaitMills, this.timeWaitNanos);
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private void PrintMemoryStat() throws Exception {
        long allSize = Math.round((double) (this.memoryAfter - this.memoryBefore));
        long allMbSize = Math.round((double) (allSize / 1048576)); //byte -> Mb
        long elementSize = Math.round((double) (allSize) / arraySize);
        System.out.printf("allSize: " + allSize + " byte = " + allMbSize + " mb\n");
        System.out.printf("elementSize: " + elementSize + " byte\n");
        System.out.println("== == ==");
    }
}

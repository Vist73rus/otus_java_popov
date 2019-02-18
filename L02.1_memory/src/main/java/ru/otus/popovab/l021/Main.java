package ru.otus.popovab.l021;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.List;

import static ru.otus.popovab.l021.MemoryCalc.*;

public class Main {
    private static Instrumentation instrumentation;

    public static void main(String[] args) throws Exception {
        MemoryCalc mc = new MemoryCalc();
        mc.memoryCalc(() -> new Short("0"));
        mc.memoryCalc(() -> new Long("0"));
        mc.memoryCalc(() -> new Integer("0"));
        mc.memoryCalc(() -> new Byte("0"));
        mc.memoryCalc(() -> new String());
        mc.memoryCalc(() -> new Float("0"));

        mc.memoryCalc(()-> integerArrayList(100));

        mc.memoryCalc(() -> new Payment());
    }

    private static List<Integer> integerArrayList(int size) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }
        return list;
    }
}

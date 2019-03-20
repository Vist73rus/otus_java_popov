package ru.otus.popovab.l031;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rn = new Random();
        MyArrayList<String> stringMyArrayList = new MyArrayList<>();
        int iRemove1 = Math.round(rn.nextInt(args.length));
        int iRemove2 = Math.round(rn.nextInt(args.length));
        String stringRemove = "";

        for(int i = 0; i < args.length; i++) {
            String str = args[i];
            stringMyArrayList.add(str);
            if (iRemove2 == i) {
                stringRemove = str;
            }
        }
        System.out.println("Array: " + stringMyArrayList);

        System.out.printf("Sublist (2, 8): %s%n", stringMyArrayList.subList(2, 8));

        stringMyArrayList.remove(iRemove1);
        System.out.printf("Removed element by index %d: %s%n", iRemove1, stringMyArrayList);

        stringMyArrayList.remove(stringRemove);
        System.out.printf("Removed element by name \"%s\": %s%n", stringRemove, stringMyArrayList);

        Collections.addAll(stringMyArrayList, "11", "22");
        System.out.printf("0) Added collection lasted: %s%n", stringMyArrayList);

        stringMyArrayList.addAll(2, Arrays.asList(new String[]{"Z", "X", "Y", "A", "C", "D"}));
        System.out.printf("1) Added collection to position 2: %s%n", stringMyArrayList);

        stringMyArrayList.clear();
        System.out.printf("Cleared array: %s%n", stringMyArrayList);

        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();
        for(int i = 0; i < 10; i++) {
            integerMyArrayList.add(rn.nextInt(1000));
        }
        System.out.printf("%nBefore sorted: %s%n", integerMyArrayList);
        Collections.sort(integerMyArrayList);
        System.out.printf("After sorted: %s%n", integerMyArrayList);

        MyArrayList<Integer> integerMyArrayList1 = new MyArrayList<>();
        integerMyArrayList1.addAll(Arrays.asList(new String[5]));

        stringMyArrayList.copy(integerMyArrayList1, integerMyArrayList);
        System.out.printf("Copied small array: %s%n", integerMyArrayList1);

    }
}
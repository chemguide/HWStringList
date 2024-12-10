package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("Start");
        Random random = new Random();
        int arrayLength = 1_000;
        IntegerList integerList = new IntegerListImpl(arrayLength);
        IntegerList integerList1 = new IntegerListImpl(arrayLength);
        IntegerList integerList2 = new IntegerListImpl(arrayLength);
        for (int i = 0; i < arrayLength; i++) {
            integerList.add(random.nextInt(0, 100));
            integerList1.add(random.nextInt(0, 100));
            integerList2.add(random.nextInt(0, 100));
        }
        System.out.println(Arrays.toString(integerList.toArray()));
        long start = System.currentTimeMillis();
        integerList.bubbleSort();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(Arrays.toString(integerList.toArray()));
        System.out.println();

        System.out.println(Arrays.toString(integerList1.toArray()));
        long start1 = System.currentTimeMillis();
        integerList1.bubbleSort();
        System.out.println(System.currentTimeMillis() - start1);
        System.out.println(Arrays.toString(integerList1.toArray()));
        System.out.println();

        System.out.println(Arrays.toString(integerList2.toArray()));
        long start2 = System.currentTimeMillis();
        integerList2.bubbleSort();
        System.out.println(System.currentTimeMillis() - start2);
        System.out.println(Arrays.toString(integerList2.toArray()));
    }
}
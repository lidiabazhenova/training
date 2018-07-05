package com.lidiabazhenova.task18;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.*;

public class Task18Test {


    private static final int ALL_EL_COUNT = 1000000;
    private static final int EL_COUNT = 5000;
    private static final Map<String, Integer> hashMap = new HashMap<>();
    private static final Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
    private static final Map<String, Integer> treeMap = new TreeMap<>();

    @BeforeClass
    public static void createMap() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(generateString());
        }
        System.out.print("first keys: ");

        for (int j = 0; j < 10; j++) {
            System.out.print(list.get(j) + "\t");;
        }
        System.out.println();

        System.out.print("HashMap: ");
        createMap(hashMap, list);
        System.out.println("*********************************************");
        System.out.print("LinkedHashMap: ");
        createMap(linkedHashMap, list);
        System.out.println("*********************************************");
        System.out.print("TreeMap: ");
        createMap(treeMap, list);
        System.out.println("*********************************************");
    }

    @Test
    public void task17InTheMidleListTest() {
//        System.out.println("\tFor " + EL_COUNT + " elements: ");
//        System.out.println("\tget in the middle of the map:");
//        System.out.print("HashMap: ");
//        System.out.print(estimateGetInTheMiddle(hashMap));
//        System.out.print("\tLinkedHashMap: ");
//        System.out.println(estimateGetInTheMiddle(linkedHashMap));
//        System.out.print("\tTreeMap: ");
//        System.out.println(estimateGetInTheMiddle(treeMap));

//        System.out.println("\tadd in the middle of the map:");
//        System.out.print("HashMap: ");
//        System.out.print(estimateAddInTheMiddle(hashMap));
//        System.out.print("\tLinkedHashMap: ");
//        System.out.println(estimateAddInTheMiddle(linkedHashMap));
//
//        System.out.println("\tadd Iterator in the middle of the map:");
//        System.out.print("HashMap: ");
//        System.out.print(estimateIteratorAddInTheMiddle(hashMap));
//        System.out.print("\tLinkedHashMap: ");
//        System.out.println(estimateIteratorAddInTheMiddle(linkedHashMap));
//
//        System.out.println("\tremove in the middle of the map:");
//        System.out.print("HashMap: ");
//        System.out.print(estimateRemoveInTheMiddle(hashMap));
//        System.out.print("\tLinkedHashMap: ");
//        System.out.println(estimateRemoveInTheMiddle(linkedHashMap));
//
//        System.out.println("\tremove Iterator in the middle of the map:");
//        System.out.print("HashMap: ");
//        System.out.print(estimateIteratorRemoveInTheMiddle(hashMap));
//        System.out.print("\tLinkedHashMap: ");
//        System.out.println(estimateIteratorRemoveInTheMiddle(linkedHashMap));
//
        System.out.println("HashMap size = " + hashMap.size());
        printPairsValue(hashMap, 10);
        System.out.println("*********************************************");
        System.out.println("LinkedHashMap size = " + linkedHashMap.size());
        printPairsValue(linkedHashMap, 10);
        System.out.println("*********************************************");
        System.out.println("TreeMap size = " + treeMap.size());
        printPairsValue(treeMap, 10);
        System.out.println("-//-//-//-//-//-//--//-//-//-//-//-//-//-//-//-");
    }

    public static String generateString() {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);

        return generatedString;
    }

    public static Map<String, Integer> createMap(final Map<String, Integer> map, final List<String> list) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i);
            int value = i;
            map.put(key, value);
        }

        final long finish = System.currentTimeMillis();
        System.out.print("add 1000000 elements: ");
        System.out.println(finish - start);

        return map;
    }

    public void printPairsValue(final Map<String, Integer> map, final int max) {
        final long start = System.currentTimeMillis();
        int count = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (count >= max) break;
            System.out.print(entry.getKey()+ "->" + entry.getValue() + " \t");
            count++;
        }
        System.out.println();

        final long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}

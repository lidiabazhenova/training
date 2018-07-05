package com.lidiabazhenova.task18;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

public class Task18Test {


    private static final int ALL_EL_COUNT = 1000000;
    private static final int EL_COUNT = 500;

    private static Map<String, Integer> hashMap = new HashMap<>();
    private static final Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
    private static final Map<String, Integer> treeMap = new TreeMap<>();
    private static final ArrayList<String> list = new ArrayList<>();

    @BeforeClass
    public static void fillInTheValuesInToMap() {

        for (int i = 0; i < ALL_EL_COUNT; i++) {
            list.add(generateString());
        }
        System.out.print("first keys: ");

        for (int j = 0; j < 10; j++) {
            System.out.print(list.get(j) + "\t");
        }
        System.out.println();
        System.out.println("put 1000000 elements: ");
        System.out.print("HashMap: ");
        fillInTheValuesInToMap(hashMap, list);
        System.out.print("\tLinkedHashMap: ");
        fillInTheValuesInToMap(linkedHashMap, list);
        System.out.print("\tTreeMap: ");
        fillInTheValuesInToMap(treeMap, list);
        System.out.println();
    }

    @Test
    public void task18InTheMidleListTest() {
        System.out.println("\tFor " + EL_COUNT + " elements: ");
        System.out.println("\tget in the middle of the map:");
        System.out.print("HashMap: ");
        System.out.print(estimateGetInTheMiddle(hashMap, new HashMap<>(), EL_COUNT));
        System.out.print("\tLinkedHashMap: ");
        System.out.print(estimateGetInTheMiddle(linkedHashMap, new LinkedHashMap<>(), EL_COUNT));
        System.out.print("\tTreeMap: ");
        System.out.println(estimateGetInTheMiddle(treeMap, new TreeMap<>(), EL_COUNT));

        System.out.println("\tset in the middle of the map:");
        System.out.print("HashMap: ");
        System.out.print(estimateSetInTheMiddle(hashMap, EL_COUNT));
        System.out.print("\tLinkedHashMap: ");
        System.out.print(estimateSetInTheMiddle(linkedHashMap, EL_COUNT));
        System.out.print("\tTreeMap: ");
        System.out.println(estimateSetInTheMiddle(treeMap, EL_COUNT));

        System.out.println("\tremove in the middle of the map:");
        System.out.print("HashMap: ");
        System.out.print(estimateRemoveInTheMiddle(hashMap, EL_COUNT));
        System.out.print("\tLinkedHashMap: ");
        System.out.print(estimateRemoveInTheMiddle(linkedHashMap, EL_COUNT));
        System.out.print("\tTreeMap: ");
        System.out.println(estimateRemoveInTheMiddle(treeMap, EL_COUNT));
    }

    @Test
    public void task18AtTheEndListTest() {
        System.out.println("\tFor " + EL_COUNT + " elements: ");
        System.out.println("\tget at the end of the map:");
        System.out.print("HashMap: ");
        System.out.print(estimatGetAtTheEnd(hashMap, new HashMap<>(), EL_COUNT));
        System.out.print("\tLinkedHashMap: ");
        System.out.print(estimatGetAtTheEnd(linkedHashMap, new LinkedHashMap<>(), EL_COUNT));
        System.out.print("\tTreeMap: ");
        System.out.println(estimatGetAtTheEnd(treeMap, new TreeMap<>(), EL_COUNT));

//        System.out.println("\tset in the middle of the map:");
//        System.out.print("HashMap: ");
//        System.out.print(estimateSetInTheMiddle(hashMap, EL_COUNT));
//        System.out.print("\tLinkedHashMap: ");
//        System.out.print(estimateSetInTheMiddle(linkedHashMap, EL_COUNT));
//        System.out.print("\tTreeMap: ");
//        System.out.println(estimateSetInTheMiddle(treeMap, EL_COUNT));
//
        System.out.println("\tremove at the end of the map:");
        System.out.print("HashMap: ");
        System.out.print(estimateRemoveAtTheEnd(hashMap, EL_COUNT));
        System.out.print("\tLinkedHashMap: ");
        System.out.print(estimateRemoveAtTheEnd(linkedHashMap, EL_COUNT));
        System.out.print("\tTreeMap: ");
        System.out.println(estimateRemoveAtTheEnd(treeMap, EL_COUNT));
    }

    public static String generateString() {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);

        return generatedString;
    }

    public static Map<String, Integer> fillInTheValuesInToMap(final Map<String, Integer> map, final List<String> list) {
        final long start = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i);
            int value = i;
            map.put(key, value);
        }
        final long finish = System.currentTimeMillis();


        System.out.print(finish - start);

        return map;
    }

    public void printPairsValue(final Map<String, Integer> map, final int max) {
        int count = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (count >= max) break;
            System.out.print(entry.getKey() + "->" + entry.getValue() + " \t");
            count++;
        }
    }

    public long estimateGetInTheMiddle(final Map<String, Integer> map,
                                       final Map<String, Integer> target, final int targetSize) {
        Map.Entry<String, Integer> entry;
        Iterator<Map.Entry<String, Integer>> it;
        final long start = System.currentTimeMillis();
        int count = 0;
        int startCount = map.size() / 2;

        it = map.entrySet().iterator();
        while (count < startCount + targetSize) {
            entry = it.next();
            count++;
            if (count > startCount) {
                target.put(entry.getKey(), entry.getValue());
            }
        }

        final long finish = System.currentTimeMillis();

        Assert.assertEquals(targetSize, target.size());

        return finish - start;
    }


    public long estimateSetInTheMiddle(final Map<String, Integer> map, final int targetSize) {
        final long start = System.currentTimeMillis();
        int count = 0;
        int startCount = map.size() / 2;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (count >= startCount) {

                if (count >= startCount + targetSize) break;
                entry.setValue(-1);
            }
            count++;
        }
        final long finish = System.currentTimeMillis();

        return finish - start;
    }

    public long estimateRemoveInTheMiddle(final Map<String, Integer> map, final int targetSize) {
        final List<String> target = new ArrayList<>();
        Map.Entry<String, Integer> entry;
        Iterator<Map.Entry<String, Integer>> it;
        final long start = System.currentTimeMillis();
        int count = 0;
        int startCount = map.size() / 2;
        final int mapSizeBeforeRemove = map.size();

        it = map.entrySet().iterator();
        while (count < startCount + targetSize) {
            entry = it.next();
            count++;
            if (count > startCount) {
                target.add(entry.getKey());
            }
        }

        target.forEach(key -> {
            map.remove(key);
        });
        final long finish = System.currentTimeMillis();

        Assert.assertEquals(mapSizeBeforeRemove - targetSize, map.size());

        return finish - start;
    }

    public long estimatGetAtTheEnd(final Map<String, Integer> map,
                                   final Map<String, Integer> target, final int targetSize) {
        Map.Entry<String, Integer> entry;
        Iterator<Map.Entry<String, Integer>> it;
        final long start = System.currentTimeMillis();
        int count = 0;
        int startCount = map.size()-targetSize;

        it = map.entrySet().iterator();
        while (count < map.size()) {
            entry = it.next();
            count++;
            if (count > startCount) {
                target.put(entry.getKey(), entry.getValue());
            }
        }

        final long finish = System.currentTimeMillis();

        Assert.assertEquals(targetSize, target.size());

        return finish - start;
    }

    public long estimateRemoveAtTheEnd(final Map<String, Integer> map, final int targetSize) {
        final List<String> target = new ArrayList<>();
        Map.Entry<String, Integer> entry;
        Iterator<Map.Entry<String, Integer>> it;
        final long start = System.currentTimeMillis();
        int count = 0;
        int startCount = map.size() - targetSize;
        final int mapSizeBeforeRemove = map.size();

        it = map.entrySet().iterator();
        while (count < mapSizeBeforeRemove) {
            entry = it.next();
            count++;
            if (count > startCount) {
                target.add(entry.getKey());
            }
        }

        target.forEach(key -> {
            map.remove(key);
        });
        final long finish = System.currentTimeMillis();

        Assert.assertEquals(mapSizeBeforeRemove - targetSize, map.size());

        return finish - start;
    }

    @After
    public void task17AfterTest() {
//        System.out.println("*********************************************");
//        System.out.println("HashMap size = " + hashMap.size());
//        System.out.print("first keys: ");
//        printPairsValue(hashMap, 10000);
//        System.out.println("*********************************************");
//        System.out.println("LinkedHashMap size = " + linkedHashMap.size());
//        System.out.print("first keys: ");
//        printPairsValue(linkedHashMap, 10000);
//        System.out.println("*********************************************");
//        System.out.println("TreeMap size = " + treeMap.size());
//        System.out.print("first keys: ");
//        printPairsValue(treeMap, 10000);
//        System.out.println("-//-//-//-//-//-//--//-//-//-//-//-//-//-//-//-");
    }
}

package com.lidiabazhenova.task17;

import org.junit.Test;

import java.util.*;

public class Task17Test {

    private static final int ELCOUNT = 5000;

    @Test
    public void task17InTheMidleListTest() {
        List<Integer> arrayList = new ArrayList();
        System.out.print("ArrayList: ");
        createList(arrayList);

        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.print("LinkedList: ");
        createList(linkedList);

        System.out.println("\tadd in the middle of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateAddInTheMiddle(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateAddInTheMiddle(linkedList));

        System.out.println("\tremove in the middle of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateRemoveInTheMiddle(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateRemoveInTheMiddle(linkedList));

        System.out.println("\tget in the middle of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateGetInTheMiddle(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateGetInTheMiddle(linkedList));

        System.out.println("ArrayList size = " + arrayList.size());
        System.out.println("LinkedList size = " + linkedList.size());
        System.out.println("-//-//-//-//-//-//--//-//-//-//-//-//-//-//-//-");
    }

    @Test
    public void task17AtTheEndListTest() {
        List<Integer> arrayList = new ArrayList();
        createList(arrayList);

        LinkedList<Integer> linkedList = new LinkedList<>();
        createList(linkedList);

        System.out.println("\tadd at the end of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateAddToEnd(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateAddToEnd(linkedList));

        System.out.println("\tremove at the end of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateRemoveFromEnd(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateRemoveFromEnd(linkedList));

        System.out.println("\tget at the end of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateGetFromEnd(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateGetFromEnd(linkedList));

        System.out.println("ArrayList size = " + arrayList.size());
        System.out.println("LinkedList size = " + linkedList.size());
        System.out.println("-//-//-//-//-//-//--//-//-//-//-//-//-//-//-//-");
    }

    private List<Integer> createList(final List<Integer> list) {
        final long start = System.currentTimeMillis();
        for (int i = 1; i <= 1000000; i++) {
            list.add(i);
        }

        final long finish = System.currentTimeMillis();
        System.out.print("add 1000000 elements: ");
        System.out.println(finish-start);

        return list;
    }

    private long estimateGetInTheMiddle(final List<Integer> list) {
        final long start = System.currentTimeMillis();
        final int startIndex = list.size() / 2;

        for (int i = 0; i < ELCOUNT; i++) {
            list.get(startIndex + i);
        }
        final long finish = System.currentTimeMillis();

        return finish - start;
    }

    private long estimateAddInTheMiddle(final List<Integer> list) {
        final long startList = System.currentTimeMillis();
        final int startIndex = list.size() / 2;

        for (int i = 0; i < ELCOUNT; i++) {
            list.add(startIndex, i);
        }
        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }

    private long estimateRemoveInTheMiddle(final List<Integer> list) {
        final long startList = System.currentTimeMillis();
        final int startIndex = list.size() / 2;

        for (int i = 0; i < ELCOUNT; i++) {
            list.remove(startIndex + i);
        }
        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }

    private long estimateGetFromEnd(final List<Integer> list) {
        final long startList = System.currentTimeMillis();
        final int startIndex = list.size() - 1;

        for (int i = startIndex; i >= list.size() - 10; i--) {
            list.get(i);
        }
        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }

    private long estimateAddToEnd(final List<Integer> list) {
        final long startList = System.currentTimeMillis();

        for (int i = 0; i < ELCOUNT; i++) {
            list.add(i);
        }
        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }

    private long estimateRemoveFromEnd(final List<Integer> list) {
        final long startList = System.currentTimeMillis();

        for (int i = 0; i < ELCOUNT; i++) {
            list.remove(list.size() - 1);
        }
        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }
}

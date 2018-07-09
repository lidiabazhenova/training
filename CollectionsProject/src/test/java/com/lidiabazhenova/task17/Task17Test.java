package com.lidiabazhenova.task17;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

/**
 * Сгенерировать миллион данных в коллекцию. Найти оптимальные коллекции, чтобы:
 * получать элемент из середины, конца
 * удалять элемент из середны, конца
 * добавлять элемент
 */
public class Task17Test {

    private static final int ALL_EL_COUNT = 1000000;
    private static final int EL_COUNT = 5000;

    private static final List<Integer> arrayList = new ArrayList();
    private static final List<Integer> linkedList = new LinkedList<>();

    @BeforeClass
    public static void createList() {
        System.out.print("ArrayList: ");
        createList(arrayList);
        System.out.print("LinkedList: ");
        createList(linkedList);
    }

    @Test
    public void task17InTheMidleListTest() {
        System.out.println("\tFor " + EL_COUNT + " elements: ");
        System.out.println("\tget in the middle of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateGetInTheMiddle(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateGetInTheMiddle(linkedList));

        System.out.println("\tadd in the middle of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateAddInTheMiddle(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateAddInTheMiddle(linkedList));

        System.out.println("\tadd Iterator in the middle of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateIteratorAddInTheMiddle(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateIteratorAddInTheMiddle(linkedList));

        System.out.println("\tremove in the middle of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateRemoveInTheMiddle(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateRemoveInTheMiddle(linkedList));

        System.out.println("\tremove Iterator in the middle of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateIteratorRemoveInTheMiddle(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateIteratorRemoveInTheMiddle(linkedList));

        System.out.println("ArrayList size = " + arrayList.size());
        System.out.println(arrayList.get(ALL_EL_COUNT / 2 - 1));
        System.out.println("LinkedList size = " + linkedList.size());
        System.out.println(linkedList.get(ALL_EL_COUNT / 2));
        System.out.println(linkedList.get(ALL_EL_COUNT / 2 + 1));
        System.out.println("-//-//-//-//-//-//--//-//-//-//-//-//-//-//-//-");
    }

    @Test
    public void task17AtTheEndListTest() {
        System.out.println("\tFor " + EL_COUNT + " elements: ");
        System.out.println("\tget at the end of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateGetFromEnd(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateGetFromEnd(linkedList));

        System.out.println("\tadd at the end of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateAddAtTheEnd(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateAddAtTheEnd(linkedList));

        System.out.println("\tadd Iterator at the end of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateIteratorAddAtTheEnd(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateIteratorAddAtTheEnd(linkedList));

        System.out.println("\tremove at the end of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateRemoveFromEnd(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateRemoveFromEnd(linkedList));

        System.out.println("\tremove Iterator at the end of the list:");
        System.out.print("ArrayList: ");
        System.out.print(estimateIteratorRemoveFromEnd(arrayList));
        System.out.print("\tLinkedList: ");
        System.out.println(estimateIteratorRemoveFromEnd(linkedList));

        System.out.print("ArrayList lastElem = ");
        System.out.println(arrayList.get(arrayList.size() - 2));
        System.out.print("LinkedList lastElem = ");
        System.out.println(linkedList.get(linkedList.size() - 1));
        System.out.println("-//-//-//-//-//-//--//-//-//-//-//-//-//-//-//-");

        System.out.println("ArrayList size = " + arrayList.size());
        System.out.println("LinkedList size = " + linkedList.size());
        System.out.println("-//-//-//-//-//-//--//-//-//-//-//-//-//-//-//-");
    }

    private static List<Integer> createList(final List<Integer> list) {
        final long start = System.currentTimeMillis();
        for (int i = 1; i <= ALL_EL_COUNT; i++) {
            list.add(i);
        }

        final long finish = System.currentTimeMillis();
        System.out.print("add 1000000 elements: ");
        System.out.println(finish - start);

        return list;
    }

    private long estimateGetInTheMiddle(final List<Integer> list) {
        final long start = System.currentTimeMillis();
        final int startIndex = list.size() / 2;

        for (int i = 0; i < EL_COUNT; i++) {
            list.get(startIndex + i);
        }
        final long finish = System.currentTimeMillis();

        return finish - start;
    }

    private long estimateAddInTheMiddle(final List<Integer> list) {
        final long startList = System.currentTimeMillis();
        final int startIndex = list.size() / 2;
        int i = 0;

        while (i < EL_COUNT) {
            list.add(startIndex + i, i++);
        }
        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }

    private long estimateIteratorAddInTheMiddle(final List<Integer> list) {
        final long startList = System.currentTimeMillis();
        int count = 0;
        int i = 0;
        int index = 0;

        ListIterator<Integer> listIterator = list.listIterator();
        while (index <= (ALL_EL_COUNT / 2 + EL_COUNT)) {
            listIterator.next();
            index++;
            if ((index > ALL_EL_COUNT / 2) & (count < EL_COUNT)) {
                listIterator.previous();
                listIterator.add(++i);
                count++;
            }
        }

        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }

    private long estimateRemoveInTheMiddle(final List<Integer> list) {
        final long startList = System.currentTimeMillis();
        final int startIndex = ALL_EL_COUNT / 2;

        for (int i = 0; i < EL_COUNT; i++) {
            list.remove(startIndex);
        }
        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }

    private long estimateIteratorRemoveInTheMiddle(final List<Integer> list) {
        final long startList = System.currentTimeMillis();
        int count = 0;
        int index = 0;
        Iterator<Integer> iterator = list.iterator();

        while (index <= (ALL_EL_COUNT / 2 + EL_COUNT)) {
            iterator.next();
            index++;

            if ((index > (ALL_EL_COUNT / 2) & (count < EL_COUNT))) {
                iterator.remove();
                count++;
            }

        }
        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }

    private long estimateGetFromEnd(final List<Integer> list) {
        final long startList = System.currentTimeMillis();
        final int startIndex = list.size() - 1;

        for (int i = startIndex; i >= list.size() - EL_COUNT; i--) {
            list.get(i);
        }
        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }

    private long estimateAddAtTheEnd(final List<Integer> list) {
        final long startList = System.currentTimeMillis();

        for (int i = 1; i <= EL_COUNT; i++) {
            list.add(i);
        }
        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }

    private long estimateIteratorAddAtTheEnd(final List<Integer> list) {
        final long startList = System.currentTimeMillis();
        int count = 0;
        int i = 0;

        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (count < EL_COUNT) {
            listIterator.previous();
            listIterator.next();
            listIterator.add(++i);
            count++;
        }

        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }

    private long estimateRemoveFromEnd(final List<Integer> list) {
        final long startList = System.currentTimeMillis();

        for (int i = 0; i < EL_COUNT; i++) {
            list.remove(list.size() - 1);
        }
        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }

    private long estimateIteratorRemoveFromEnd(final List<Integer> list) {
        final long startList = System.currentTimeMillis();
        int count = 0;

        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (count < EL_COUNT) {
            listIterator.previous();
            listIterator.remove();
            count++;
        }

        final long finishList = System.currentTimeMillis();

        return finishList - startList;
    }
}

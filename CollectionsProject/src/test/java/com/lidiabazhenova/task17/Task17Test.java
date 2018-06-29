package com.lidiabazhenova.task17;

import org.junit.Test;

import java.util.*;

public class Task17Test {

    @Test
    public void task17Test() {
        ArrayList<Integer> arrayList = new ArrayList();

        for (int i = 0; i < 1000000; i++) { // Заполнение коллекции последовательностью чисел от 0 до 1000000
            arrayList.add(i);
        }

        Collections.shuffle(arrayList); // организация произвольного порядка

        long arrayListTime = checkTime(arrayList);
        System.out.println(arrayListTime);

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 1000000; i++) { // Заполнение коллекции последовательностью чисел от 0 до 1000000
            linkedList.add(i);
        }

        Collections.shuffle(linkedList); // организация произвольного порядка

        long linkedListTime = checkTime(linkedList);
        System.out.println(linkedListTime);

    }

    private long checkTime(List list) {
        Date startMap = new Date();
        for (int i = 0; i < list.size() / 50; i++) {
            //операция .add .insert. remove. get .set с начала середины, и конца списка
            //k - кол-во операций
            list.get(i);
        }
        Date finishMap = new Date();
        return finishMap.getTime() - startMap.getTime();
    }

}

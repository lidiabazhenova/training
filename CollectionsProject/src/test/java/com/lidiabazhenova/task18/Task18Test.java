package com.lidiabazhenova.task18;

import org.junit.Test;

import java.util.*;

public class Task18Test {

    @Test
    public void task18Test() {
        ArrayList<Integer> list = new ArrayList(); // Создание коллекции

        for (int i = 0; i < 1000000; i++) { // Заполнение коллекции последовательностью чисел от 0 до 1000000
            list.add(i);
        }

        Collections.shuffle(list); // организация произвольного порядка

        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i) + " "); // Показываем что порядок произвольный, выводя первые 10 чисел к примеру
        }

        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), true); // Map всегда содержит только уникальные ключи
        }

        System.out.println(list.size() == map.size()); // Если размеры равны то это значит что в исходной коллекции элементы были уникальны
        long mapTime = checkTime(map);
        System.out.println(mapTime);
    }

    private long checkTime(Map map) {
        Date startMap = new Date();
        for (int i = 0; i < map.size() / 3; i++) {
            //операция .add .insert. remove. get .set с начала середины, и конца списка
            //k - кол-во операций
            map.get(i);
        }
        Date finishMap = new Date();
        return finishMap.getTime() - startMap.getTime();
    }

}

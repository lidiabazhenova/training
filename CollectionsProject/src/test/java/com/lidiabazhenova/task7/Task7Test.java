package com.lidiabazhenova.task7;

import com.lidiabazhenova.Man;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Создать объект Man, с полями id, name, age, sex. Создать список этих объектов.
 * Преобразовать в коллекцию, которая будет содержать строковое представление со значениями id и name.
 */
public class Task7Test {

    @Test
    public void task7Test() throws IOException {
        Man Ivan = new Man(11110000, "Ivan", 22, "male");
        Man Alex = new Man(11110001, "Alex", 34, "male");
        Man Valeria = new Man(11110002, "Valeria", 29, "female");

        Map<Long, Man> manList = new TreeMap<>();
        manList.put(Ivan.getId(), Ivan);
        manList.put(Alex.getId(), Alex);
        manList.put(Valeria.getId(), Valeria);

        final List<Map<String, String>> newManList = manList.entrySet().stream().map((entry) -> {
            Map<String, String> newPerson = new HashMap<>();
            newPerson.put(String.valueOf(entry.getKey()), entry.getValue().getName());
            return newPerson;
        }).collect(Collectors.toList());

        Assert.assertEquals("Ivan", newManList.get(0).get("11110000"));
        Assert.assertEquals("Alex", newManList.get(1).get("11110001"));
        Assert.assertEquals("Valeria", newManList.get(2).get("11110002"));
    }
}

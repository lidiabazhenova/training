package com.lidiabazhenova.task7;

import com.lidiabazhenova.Man;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Создать объект Man, с полями id, name, age, sex. Создать список этих объектов. Преобразовать в коллекцию, которая будет содержать строковое представление со значениями id и name.
 8. Есть две коллекции List<Map<String, List<String>>> с разным содержанием. Сравните их
 */
public class Task7Test {

    @Test
    public void task7Test() throws IOException {
        List<Man> manList = new ArrayList<>();
        manList.add(new Man(11110000, "Ivan", 22, "male"));
        manList.add(new Man(11110001, "Alex", 34, "male"));
        manList.add(new Man(11110002, "Valeria", 29, "female"));

        final List<Map<String, String>> newManList = manList.stream().map((man) -> {
            Map<String, String> newPerson = new HashMap<>();
            newPerson.put("id", String.valueOf(man.getId()));
            newPerson.put("name", man.getName());
            return newPerson;
        }).collect(Collectors.toList());

        Assert.assertEquals("11110000", newManList.get(0).get("id"));
        Assert.assertEquals("Ivan", newManList.get(0).get("name"));
        Assert.assertEquals("11110001", newManList.get(1).get("id"));
        Assert.assertEquals("Alex", newManList.get(1).get("name"));
        Assert.assertEquals("11110002", newManList.get(2).get("id"));
        Assert.assertEquals("Valeria", newManList.get(2).get("name"));
    }
}

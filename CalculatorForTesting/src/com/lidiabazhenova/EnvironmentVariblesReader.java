package com.lidiabazhenova;

import java.util.Map;

public class EnvironmentVariblesReader {
    void readEnvironmentVariables() { // Вариант 1
        System.out.println("Path = " + System.getenv("Path"));
        System.out.println("MyVar = " + System.getenv("MyVar"));
        // Вариант 2
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName));
        }
    }
}
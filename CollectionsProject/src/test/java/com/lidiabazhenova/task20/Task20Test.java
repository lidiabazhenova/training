package com.lidiabazhenova.task20;

import org.junit.Test;

import java.util.Stack;

/**
 * Создать множество с числами. Суммировать соседние числа попарно, пока не останется одно число
 */
public class Task20Test {

    @Test
    public void task20Test() {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> newStack = new Stack<>();

        for (int i = 1; i <= 50; i++) {
            stack.push(i * i);
        }

        while (stack.size() > 1) {
            while (!stack.empty()) {
                int newItem = stack.pop();
                if (!stack.empty()) {
                    newItem = newItem + stack.pop();
                }
                newStack.push(newItem);
            }
            stack.addAll(newStack);
            newStack.clear();
            System.out.println(stack);
        }
    }
}

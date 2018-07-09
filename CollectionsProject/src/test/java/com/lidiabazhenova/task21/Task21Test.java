package com.lidiabazhenova.task21;

import org.junit.Test;

import java.util.Stack;

/**
 * Задать два стека, поменять информацию местами
 */
public class Task21Test {

    @Test
    public void task21Test() {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        stack1.push("Ivanov");
        stack1.push("Ivanova");
        stack1.push("Vasiliev");
        stack1.push("Novikava");

        stack2.push("Ivan");
        stack2.push("Olga");
        stack2.push("Sergey");
        stack2.push("Katja");
        stack2.push("444");

        System.out.println("Before:\n");
        System.out.println(stack1);
        System.out.println(stack2);

        swap(stack1, stack2, stack1.size(), stack2.size());

        System.out.println("After:\n");
        System.out.println(stack1);
        System.out.println(stack2);
    }

    private void swap(Stack<String> stack1, Stack<String> stack2, int size1, int size2) {
        if (stack1.isEmpty() && stack2.isEmpty()) return;

        String stack1Elem = null;
        String stack2Elem = null;

        if (!stack1.isEmpty()) {
            stack1Elem = stack1.pop();
        }
        if (!stack2.isEmpty()) {
            stack2Elem = stack2.pop();
        }

        swap(stack1, stack2, stack1.size(), stack2.size());
        if (stack1.size() < size2) {
            stack1.add(stack2Elem);
        }
        if (stack2.size() < size1) {
            stack2.add(stack1Elem);
        }
    }
}


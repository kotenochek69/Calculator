package org.example.model;

import java.util.Map;
import java.util.Stack;

public class Print implements Calculation {
    @Override
    public void Calculate(Stack<Double> stack, Map<String, Double> map, String data) {
        System.out.println(stack.get(stack.size() - 1));
    }
}

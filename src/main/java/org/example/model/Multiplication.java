package org.example.model;

import java.util.Map;
import java.util.Stack;

public class Multiplication implements Calculation {
    @Override
    public void Calculate(Stack<Double> stack, Map<String, Double> map, String data) {
        Double a = stack.pop();
        Double b = stack.pop();
        stack.push(a * b);
    }
}

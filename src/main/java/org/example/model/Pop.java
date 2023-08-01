package org.example.model;

import java.util.Map;
import java.util.Stack;

public class Pop implements Calculation {
    @Override
    public void Calculate(Stack<Double> stack, Map<String, Double> map, String data) {
        stack.pop();
    }
}

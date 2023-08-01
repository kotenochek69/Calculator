package org.example.model;

import java.util.Map;
import java.util.Stack;

import static java.lang.Math.sqrt;

public class Sqrt implements Calculation {
    @Override
    public void Calculate(Stack<Double> stack, Map<String, Double> map, String data) {
        Double a = stack.pop();
        stack.push(sqrt(a));
    }
}

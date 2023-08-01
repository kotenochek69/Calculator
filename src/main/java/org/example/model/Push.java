package org.example.model;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Push implements Calculation {
    @Override
    public void Calculate(Stack<Double> stack, Map<String, Double> map, String data) {

        Scanner scan = new Scanner(data);
        scan.useDelimiter(" ");

        while (scan.hasNext()) {
            String cur = scan.next();
            for (String s : map.keySet()) {
                if (s.equals(cur)) {
                    stack.push(map.get(s));
                }
            }
        }
    }
}

package org.example.model;

import java.util.*;


public class Define implements Calculation {

    @Override
    public void Calculate(Stack<Double> stack, Map<String, Double> map, String data) {

        Scanner scan = new Scanner(data);
        scan.useDelimiter(" ");

        while (scan.hasNext()) {
            map.put(scan.next(), scan.nextDouble());
        }
    }
}

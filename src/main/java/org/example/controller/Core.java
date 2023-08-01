package org.example.controller;

import org.example.model.Calculation;
import org.example.service.OperationFabric;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class Core {
    public static Stack<Double> stack = new Stack<>();
    public static Map<String, Double> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        InputStream file = Core.class.getClassLoader().getResourceAsStream("example.txt");
        Scanner scanner = new Scanner(Objects.requireNonNull(file), StandardCharsets.UTF_8);
        scanner.useDelimiter(System.getProperty("line.separator"));

        OperationFabric fabric = new OperationFabric();


        while(scanner.hasNext()) {
            scanner.useDelimiter("[\\n\\r]");
            String line = scanner.next();
            Scanner myLine = new Scanner(line);
            String command = "";

            myLine.useDelimiter(" ");
            try {
                command = myLine.next();
            } catch (Exception e) {};

            String data = "";

            while (myLine.hasNext()) {
                String cur = myLine.next();
                data += cur;
                data += " ";
            }


            if (command.length() != 0) {
                Calculation operation = fabric.Create(command);
                operation.Calculate(stack, map, data);
            }
        }
        scanner.close();
    }
}
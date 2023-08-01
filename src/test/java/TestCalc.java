import org.example.model.Calculation;
import org.example.service.OperationFabric;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

import static org.testng.AssertJUnit.assertEquals;

public class TestCalc {
    HashMap<String, Double> map = new HashMap<String, Double>();
    Stack<Double> stack = new Stack<Double>();

    @Test
    private void defineTest() throws IOException {
        OperationFabric fabric = new OperationFabric();
        Calculation defineOp = fabric.Create("DEFINE");
        defineOp.Calculate(stack, map, "a 50 b 711");

        assertEquals(50, map.get("a"), 1e-4);
        assertEquals(711, map.get("b"), 1e-4);
    }

    @Test
    private void pushTest() throws IOException {
        OperationFabric fabric = new OperationFabric();
        Calculation defineOp = fabric.Create("DEFINE");
        defineOp.Calculate(stack, map, "a 50 b 711 c 689");
        Calculation pushOp = fabric.Create("PUSH");
        pushOp.Calculate(stack, map, "a b c");

        assertEquals(689, stack.pop(), 1e-4);
        assertEquals(711, stack.pop(), 1e-4);
        assertEquals(50, stack.pop(), 1e-4);
    }

    @Test
    private void popTest() throws IOException {
        OperationFabric fabric = new OperationFabric();
        Calculation popOp = fabric.Create("POP");
        stack.push(78.0);
        stack.push(554.0);
        popOp.Calculate(stack, map, "");

        assertEquals(78, stack.pop(), 1e-4);
    }

    @Test
    private void sumTest() throws IOException {
        OperationFabric fabric = new OperationFabric();
        Calculation sumOp = fabric.Create("+");
        stack.push(78.0);
        stack.push(554.0);
        sumOp.Calculate(stack, map, "");

        assertEquals(632, stack.pop(), 1e-4);
    }

    @Test
    private void subTest() throws IOException {
        OperationFabric fabric = new OperationFabric();
        Calculation subOp = fabric.Create("-");
        stack.push(78.0);
        stack.push(554.0);
        subOp.Calculate(stack, map, "");

        assertEquals(476, stack.pop(), 1e-4);
    }

    @Test
    private void mulTest() throws IOException {
        OperationFabric fabric = new OperationFabric();
        Calculation mulOp = fabric.Create("*");
        stack.push(78.0);
        stack.push(54.0);
        mulOp.Calculate(stack, map, "");

        assertEquals(4212, stack.pop(), 1e-4);
    }

    @Test
    private void divTest() throws IOException {
        OperationFabric fabric = new OperationFabric();
        Calculation divOp = fabric.Create("/");
        stack.push(5.0);
        stack.push(1000.0);
        divOp.Calculate(stack, map, "");

        assertEquals(200, stack.pop(), 1e-4);
    }

    @Test
    private void sqrtTest() throws IOException {
        OperationFabric fabric = new OperationFabric();
        Calculation sqrtOp = fabric.Create("SQRT");
        stack.push(121.0);
        sqrtOp.Calculate(stack, map, "");

        assertEquals(11, stack.pop(), 1e-4);
    }
}

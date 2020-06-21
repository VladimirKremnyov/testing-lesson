package org.example.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAdd2And2As4() {
        Calculator calculator = new Calculator();
        int sum = calculator.add(2, 2);
        assertEquals(4, sum);
    }

    @Test
    public void shouldAdd2And3As5() {
        Calculator calculator = new Calculator();
        int sum = calculator.add(2, 3);
        assertEquals(5, sum);
    }

    @Test
    public void shouldDivide4And2As2() {
        Calculator calculator = new Calculator();
        double divisionResult = calculator.divide(4, 2);
        assertEquals(2, divisionResult, 0);
    }

    @Test
    public void shouldDivide5And2AsTwoAndHalf() {
        Calculator calculator = new Calculator();
        double divisionResult = calculator.divide(5, 2);
        assertEquals(2.5, divisionResult, 0);
    }

}

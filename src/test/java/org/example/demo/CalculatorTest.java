package org.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Class Test")
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test

    @DisplayName("checking add method of calculator class")
    void addTest() {
        assertEquals(2, calculator.add(1, 1));


    }

    @Test
    void standardAssertions() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(4, calculator.multiply(2, 2),"test message");
        assertTrue(calculator.testPositive(10) < 0, () -> "negative");

    }
    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator.devide(10,0));
        assertEquals("/ by zero", exception.getMessage());
    }
}

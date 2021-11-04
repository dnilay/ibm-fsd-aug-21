package org.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Calculator Class Test")
public class CalculatorTest {
    private Calculator calculator=new Calculator();

    @Test

    @DisplayName("checking add method of calculator class")
    void addTest() {
        assertEquals(2,calculator.add(1,1));


    }
}

package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CalculatorTest {

    @Test
    void testResult() {
        Assertions.assertEquals(19, Calculator.calculate("(1+2*9)"));
    }

    @Test
    void testErrorMessage() {
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> Calculator.checkBrackets("(1+2*9"),
                "Number of open-closed brackets should be equals"
        );
        Assertions.assertTrue(thrown.getMessage().contains("Number of open-closed brackets should be equals"));
    }
}


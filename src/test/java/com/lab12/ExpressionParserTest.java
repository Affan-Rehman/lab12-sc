package com.lab12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ExpressionParserTest {

  @Test
  void testBasicOperations() {
    assertEquals(8.0, ExpressionParser.evaluateExpression("3 + 5"), 0.0001);
    assertEquals(
      10.0,
      ExpressionParser.evaluateExpression("3 * 2 + 4"),
      0.0001
    );
    assertEquals(
      14.0,
      ExpressionParser.evaluateExpression("2 + 3 * 4"),
      0.0001
    );
    assertEquals(2.5, ExpressionParser.evaluateExpression("5 / 2"), 0.0001);
  }

  @Test
  void testParentheses() {
    assertEquals(
      20.0,
      ExpressionParser.evaluateExpression("(2 + 3) * 4"),
      0.0001
    );
    assertEquals(
      14.0,
      ExpressionParser.evaluateExpression("2 + (3 * 4)"),
      0.0001
    );
    assertEquals(10.0, ExpressionParser.evaluateExpression("(5 + 5)"), 0.0001);
  }

  @Test
  void testFloatingPointNumbers() {
    assertEquals(5.5, ExpressionParser.evaluateExpression("2.5 + 3"), 0.0001);
    assertEquals(3.75, ExpressionParser.evaluateExpression("7.5 / 2"), 0.0001);
    assertEquals(0.3, ExpressionParser.evaluateExpression("0.1 + 0.2"), 0.0001);
  }

  @Test
  void testInvalidExpressions() {
    assertThrows(
      IllegalArgumentException.class,
      () -> ExpressionParser.evaluateExpression("2 + + 3")
    );
    assertThrows(
      IllegalArgumentException.class,
      () -> ExpressionParser.evaluateExpression("2 + (3")
    );
    assertThrows(
      IllegalArgumentException.class,
      () -> ExpressionParser.evaluateExpression("")
    );
    assertThrows(
      ArithmeticException.class,
      () -> ExpressionParser.evaluateExpression("5 / 0")
    );
  }

  @Test
  void testComplexExpressions() {
    assertEquals(
      18.5,
      ExpressionParser.evaluateExpression("2.5 * (3 + 4) + 1"),
      0.0001
    );
    assertEquals(
      -5.0,
      ExpressionParser.evaluateExpression("10 - 3 * 5"),
      0.0001
    );
    assertEquals(
      0.0,
      ExpressionParser.evaluateExpression("2 * (3 - 3)"),
      0.0001
    );
  }
}

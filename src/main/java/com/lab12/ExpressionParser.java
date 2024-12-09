package com.lab12;

public class ExpressionParser {

  private int pos = 0;
  private String expression;

  public ExpressionParser(String expression) {
    this.expression = expression.replaceAll("\\s+", "");
  }

  /**
   * @param expr The expression to evaluate
   * @return The result of the evaluation
   * @throws IllegalArgumentException if the expression is invalid
   */
  public static double evaluateExpression(String expr) {
    if (expr == null || expr.trim().isEmpty()) {
      throw new IllegalArgumentException("Expression cannot be null or empty");
    }
    return new ExpressionParser(expr).parse();
  }

  private double parse() {
    double left = parseTerm();

    while (pos < expression.length()) {
      char operator = expression.charAt(pos);
      if (operator != '+' && operator != '-') {
        break;
      }
      pos++;
      double right = parseTerm();

      if (operator == '+') {
        left += right;
      } else {
        left -= right;
      }
    }
    return left;
  }

  private double parseTerm() {
    double left = parseNumber();

    while (pos < expression.length()) {
      char operator = expression.charAt(pos);
      if (operator != '*' && operator != '/') {
        break;
      }
      pos++;
      double right = parseNumber();

      if (operator == '*') {
        left *= right;
      } else {
        if (right == 0) {
          throw new ArithmeticException("Division by zero");
        }
        left /= right;
      }
    }
    return left;
  }

  private double parseNumber() {
    if (pos >= expression.length()) {
      throw new IllegalArgumentException("Unexpected end of expression");
    }

    char ch = expression.charAt(pos);

    if (ch == '(') {
      pos++;
      double result = parse();
      if (pos >= expression.length() || expression.charAt(pos) != ')') {
        throw new IllegalArgumentException("Missing closing parenthesis");
      }
      pos++;
      return result;
    }

    StringBuilder sb = new StringBuilder();
    boolean hasDecimalPoint = false;

    if (ch == '-') {
      sb.append(ch);
      pos++;
    }

    while (pos < expression.length()) {
      ch = expression.charAt(pos);
      if (Character.isDigit(ch)) {
        sb.append(ch);
      } else if (ch == '.' && !hasDecimalPoint) {
        sb.append(ch);
        hasDecimalPoint = true;
      } else {
        break;
      }
      pos++;
    }

    if (sb.length() == 0) {
      throw new IllegalArgumentException("Invalid number format");
    }

    try {
      return Double.parseDouble(sb.toString());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(
        "Invalid number format: " + sb.toString()
      );
    }
  }
}

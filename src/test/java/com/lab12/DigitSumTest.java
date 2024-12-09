package com.lab12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DigitSumTest {

  @Test
  void testPositiveNumbers() {
    assertEquals(6, DigitSum.sumOfDigits(123));
    assertEquals(10, DigitSum.sumOfDigits(1234));
    assertEquals(15, DigitSum.sumOfDigits(12345));
  }

  @Test
  void testNegativeNumbers() {
    assertEquals(6, DigitSum.sumOfDigits(-123));
    assertEquals(10, DigitSum.sumOfDigits(-1234));
    assertEquals(15, DigitSum.sumOfDigits(-12345));
  }

  @Test
  void testZeroAndSingleDigit() {
    assertEquals(0, DigitSum.sumOfDigits(0));
    assertEquals(5, DigitSum.sumOfDigits(5));
    assertEquals(9, DigitSum.sumOfDigits(-9));
  }

  @Test
  void testLargeNumbers() {
    assertEquals(45, DigitSum.sumOfDigits(123456789));
    assertEquals(45, DigitSum.sumOfDigits(-123456789));
  }
}

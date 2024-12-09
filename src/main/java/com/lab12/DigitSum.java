package com.lab12;
public class DigitSum {

  /**
   * @param number The number to sum digits of
   * @return The sum of all digits in the number
   */
  public static int sumOfDigits(int number) {
    if (number < 0) {
      number = Math.abs(number);
    }

    if (number == 0) {
      return 0;
    }

    return (number % 10) + sumOfDigits(number / 10);
  }
}

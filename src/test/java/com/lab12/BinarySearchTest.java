package com.lab12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

  @Test
  void testBinarySearchRecursive() {
    int[] arr = { 1, 3, 5, 7, 9, 11, 13 };

    assertEquals(
      3,
      BinarySearch.binarySearchRecursive(arr, 7, 0, arr.length - 1)
    );
    assertEquals(
      -1,
      BinarySearch.binarySearchRecursive(arr, 4, 0, arr.length - 1)
    );
    assertEquals(
      0,
      BinarySearch.binarySearchRecursive(arr, 1, 0, arr.length - 1)
    );
    assertEquals(
      6,
      BinarySearch.binarySearchRecursive(arr, 13, 0, arr.length - 1)
    );
  }

  @Test
  void testBinarySearchRecursiveString() {
    String[] arr = { "apple", "banana", "cherry", "date", "elderberry" };

    assertEquals(
      2,
      BinarySearch.binarySearchRecursiveString(arr, "cherry", 0, arr.length - 1)
    );
    assertEquals(
      -1,
      BinarySearch.binarySearchRecursiveString(arr, "fig", 0, arr.length - 1)
    );
    assertEquals(
      0,
      BinarySearch.binarySearchRecursiveString(arr, "apple", 0, arr.length - 1)
    );
  }

  @Test
  void testFindAllOccurrences() {
    int[] arr = { 1, 3, 3, 3, 5, 7, 7, 9 };

    List<Integer> result2 = BinarySearch.findAllOccurrences(arr, 7);
    assertEquals(Arrays.asList(5, 6), result2);

    List<Integer> result3 = BinarySearch.findAllOccurrences(arr, 4);
    assertTrue(result3.isEmpty());
  }

  @Test
  void testExceptionHandling() {
    assertThrows(
      IllegalArgumentException.class,
      () -> {
        BinarySearch.binarySearchRecursive(null, 5, 0, 0);
      }
    );

    assertThrows(
      IllegalArgumentException.class,
      () -> {
        BinarySearch.binarySearchRecursiveString(null, "test", 0, 0);
      }
    );

    assertThrows(
      IllegalArgumentException.class,
      () -> {
        BinarySearch.binarySearchRecursiveString(
          new String[] { "test" },
          null,
          0,
          0
        );
      }
    );
  }
}

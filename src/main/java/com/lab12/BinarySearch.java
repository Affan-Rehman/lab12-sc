package com.lab12;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

  /**
   * @param arr The sorted array to search in
   * @param target The value to search for
   * @param left The left boundary of the search range
   * @param right The right boundary of the search range
   * @return The index of the target if found, -1 otherwise
   * @throws IllegalArgumentException if the array is null
   */
  public static int binarySearchRecursive(
    int[] arr,
    int target,
    int left,
    int right
  ) {
    if (arr == null) {
      throw new IllegalArgumentException("Array cannot be null");
    }

    if (left > right) {
      return -1;
    }

    int mid = left + (right - left) / 2;

    if (arr[mid] == target) {
      return mid;
    }

    if (arr[mid] > target) {
      return binarySearchRecursive(arr, target, left, mid - 1);
    } else {
      return binarySearchRecursive(arr, target, mid + 1, right);
    }
  }

  /**
   * @param arr The sorted array of strings to search in
   * @param target The string to search for
   * @param left The left boundary of the search range
   * @param right The right boundary of the search range
   * @return The index of the target if found, -1 otherwise
   * @throws IllegalArgumentException if the array is null or target is null
   */
  public static int binarySearchRecursiveString(
    String[] arr,
    String target,
    int left,
    int right
  ) {
    if (arr == null || target == null) {
      throw new IllegalArgumentException("Array and target cannot be null");
    }

    if (left > right) {
      return -1;
    }

    int mid = left + (right - left) / 2;

    int comparison = arr[mid].compareTo(target);
    if (comparison == 0) {
      return mid;
    }

    if (comparison > 0) {
      return binarySearchRecursiveString(arr, target, left, mid - 1);
    } else {
      return binarySearchRecursiveString(arr, target, mid + 1, right);
    }
  }

  /**
   * @param arr The sorted array to search in
   * @param target The value to search for
   * @return List of indices where the target appears
   * @throws IllegalArgumentException if the array is null
   */
  public static List<Integer> findAllOccurrences(int[] arr, int target) {
    if (arr == null) {
      throw new IllegalArgumentException("Array cannot be null");
    }

    List<Integer> occurrences = new ArrayList<>();
    findAllOccurrencesHelper(arr, target, 0, arr.length - 1, occurrences);
    return occurrences;
  }

  private static void findAllOccurrencesHelper(
    int[] arr,
    int target,
    int left,
    int right,
    List<Integer> occurrences
  ) {
    if (left > right) {
      return;
    }

    int mid = left + (right - left) / 2;

    if (arr[mid] == target) {
      occurrences.add(mid);
      findAllOccurrencesHelper(arr, target, left, mid - 1, occurrences);
      findAllOccurrencesHelper(arr, target, mid + 1, right, occurrences);
    } else if (arr[mid] > target) {
      findAllOccurrencesHelper(arr, target, left, mid - 1, occurrences);
    } else {
      findAllOccurrencesHelper(arr, target, mid + 1, right, occurrences);
    }
  }
}

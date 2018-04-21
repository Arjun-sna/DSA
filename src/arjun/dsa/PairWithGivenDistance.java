/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.Arrays;

/**
 * Given an unsorted array and a number n, find if there exists a pair of elements in the array whose difference is n.
 *
 * @author arjun
 */
public class PairWithGivenDistance {
  public static void main(String[] args) {
    int arr[] = {1, 8, 30, 40, 10};
    int n = 10;
    findPair(arr, n);
  }

  private static void findPair(int[] arr, int n) {
    Arrays.sort(arr);
    for (int i = 0, j = 1; i < arr.length && j < arr.length; ) {
      if (arr[j] - arr[i] == n) {
        System.out.println("True");
        return;
      } else if (arr[j] - arr[i] < n) {
        j++;
      } else {
        i++;
      }
    }
    System.out.println("False");
  }
}

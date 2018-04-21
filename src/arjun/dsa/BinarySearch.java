/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.Scanner;

/**
 * @author arjun
 */
public class BinarySearch {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int v = in.nextInt();
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    System.out.println(binarySearch(arr, v, n));
    ;
  }

  public static int binarySearch(int[] arr, int v, int n) {
    int mid = n / 2, start = 0, end = n - 1;
    while (start <= end) {
      System.out.println(start + " mid " + end + " mid " + mid);
      if (arr[mid] == v) {
        return mid;
      }
      if (arr[mid] < v) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
      mid = start + (end - start) / 2;
    }
    return -1;
  }
}

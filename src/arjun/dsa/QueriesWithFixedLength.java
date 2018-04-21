/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author arjun
 */
public class QueriesWithFixedLength {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), q = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    for (int i = 0; i < q; i++) {
      Deque<Integer> qu = new ArrayDeque<>();
      int wSize = in.nextInt();
      int max = 0, min = Integer.MAX_VALUE;
      int j = 0;
      for (; j < wSize; j++) {
        if (max < arr[j]) {
          max = arr[j];
        }
        qu.add(arr[j]);
      }
      while (j < arr.length) {

      }
    }
  }
}

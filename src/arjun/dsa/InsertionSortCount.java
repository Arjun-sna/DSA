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
public class InsertionSortCount {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      int[] ar = new int[n];
      for (int j = 0; j < n; j++) {
        ar[j] = in.nextInt();
        //System.err.println(ar[j]);
      }
      long c = insertSort(ar);
      System.out.println(c);
    }
  }

  public static long insertSort(int[] ar) {
    long count = 0;
    int index = 0;
    for (int i = 1; i < ar.length; i++) {
      int val = ar[i];
      index = i;
      while (index > 0 && ar[index - 1] > val) {
        ar[index] = ar[index - 1];
        count++;
        index--;
      }
      ar[index] = val;
    }
    return count;
  }
}

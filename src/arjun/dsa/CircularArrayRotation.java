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
public class CircularArrayRotation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), r = in.nextInt(), q = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      int ele = in.nextInt();
      if (i + r >= n) {
        arr[(i + r) % n] = ele;
      } else {
        arr[i + r] = ele;
      }
    }
    //       for (int k = 0; k < n; k++) {
    //        System.out.println(arr[k]);
    //       }

    for (int k = 0; k < q; k++) {
      System.out.println(arr[in.nextInt()]);
    }
  }
}

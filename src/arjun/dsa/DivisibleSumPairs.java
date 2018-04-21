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
public class DivisibleSumPairs {
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int div = in.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int pairCount = 0;
    for (int j = 0; j < n; j++) {
      for (int k = j + 1; k < n; k++) {
        if ((a[j] + a[k]) % div == 0) {
          pairCount++;
        }
      }
    }
    System.out.println(pairCount);
  }
}

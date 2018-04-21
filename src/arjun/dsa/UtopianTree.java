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
public class UtopianTree {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      int h = 1;
      int cycles = in.nextInt();
      for (int j = 1; j <= cycles; j++) {
        if (j % 2 == 0) {
          h += 1;
        } else {
          h *= 2;
        }
      }
      System.out.println(h);
    }
  }
}

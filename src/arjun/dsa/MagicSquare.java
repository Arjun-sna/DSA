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
public class MagicSquare {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[][] ms = new int[3][3];
    int i, j;
    for (i = 0; i < 3; i++) {
      int sum = 0;
      for (j = 0; i < 3; i++) {
        ms[i][j] = in.nextInt();
        sum += ms[i][j];
      }
      int diff = 15 - sum;
      if (diff < 15) {

      }
    }
  }
}

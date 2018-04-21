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
public class Staircase {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int size = in.nextInt();
    for (int i = 1; i <= size; i++) {
      for (int j = 1; j <= size; j++) {
        if (j <= size - i) {
          System.out.print(" ");
        } else {
          System.out.print("#");
        }
      }
      System.out.println();
    }
  }
}

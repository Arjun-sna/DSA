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
public class CountingValleys {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int steps = in.nextInt();
    in.nextLine();
    String s = in.nextLine();
    int height = 0, prev = 0, vally = 0;
    for (int i = 0; i < steps; i++) {
      char c = s.charAt(i);
      if (c == 'D') {
        height--;
      } else {
        height++;
      }
      if (height == 0 && prev < 0) {
        vally++;
      }
      prev = height;
    }
    System.out.println(vally);
  }
}

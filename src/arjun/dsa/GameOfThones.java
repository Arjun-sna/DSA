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
public class GameOfThones {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      boolean valid = false;
      String a = in.nextLine(), b = in.nextLine();
      for (int j = 0; j < a.length(); j++) {
        System.out.println("dfds " + b.contains(new StringBuilder().append(a.charAt(j))));
        if (b.contains(new StringBuilder().append(a.charAt(j)))) {
          valid = true;
          break;
        }
      }
      System.out.println(valid ? "YES" : "NO");
    }
  }
}

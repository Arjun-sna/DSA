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
public class FunnyString {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    for (int i = 0; i < n; i++) {
      String s = in.nextLine();
      boolean isFunny = true;
      for (int j = 1, k = s.length() - 2; j < s.length(); j++, k--) {
        if (Math.abs(s.charAt(j) - s.charAt(j - 1)) != Math.abs(s.charAt(k) - s.charAt(k + 1))) {
          isFunny = false;
          break;
        }
      }
      System.out.println(isFunny ? "Funny" : "Not Funny");
    }
  }
}

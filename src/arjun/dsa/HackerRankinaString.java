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
public class HackerRankinaString {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String base = "hackerrank";
    int baseLength = base.length();
    in.nextLine();
    for (int i = 0; i < n; i++) {
      String ip = in.nextLine();
      if (baseLength > ip.length()) {
        System.out.println("NO");
      } else {
        int baseIndex = 0;
        for (int j = 0; j < ip.length() && baseIndex < baseLength; j++) {
          if (ip.charAt(j) == base.charAt(baseIndex)) {
            baseIndex++;
          }
        }
        System.out.println(baseIndex >= baseLength ? "YES" : "NO");
      }
    }
  }
}

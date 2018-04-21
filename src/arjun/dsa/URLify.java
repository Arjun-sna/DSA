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
public class URLify {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s1 = in.nextLine();
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) == ' ') {
        result.append("%20");
      } else {
        result.append(s1.charAt(i));
      }
    }
    System.out.println(result.toString());
  }
}

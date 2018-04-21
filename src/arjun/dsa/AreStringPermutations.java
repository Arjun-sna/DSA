/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.Scanner;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 *
 * @author arjun
 */
public class AreStringPermutations {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s1 = in.nextLine(), s2 = in.nextLine();
    if (s1.length() != s2.length()) {
      System.out.println("false");
      return;
    }
    int[] frequency = new int[256];
    for (int i = 0; i < s1.length(); i++) {
      frequency[s1.charAt(i)]++;
    }
    for (int i = 0; i < s2.length(); i++) {
      frequency[s2.charAt(i)]--;
      if (frequency[s2.charAt(i)] < 0) {
        System.out.println("false");
        return;
      }
    }
    System.out.println("true");
  }
}

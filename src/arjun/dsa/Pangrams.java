/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author arjun
 */
public class Pangrams {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine().toLowerCase().replace(" ", "");
    Set<Integer> alphaset = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      alphaset.add((int) s.charAt(i));
    }
    System.out.println(alphaset.size() == 26 ? "pangram" : "not pangram");
  }
}

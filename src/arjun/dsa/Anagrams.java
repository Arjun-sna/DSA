/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author arjun
 */
public class Anagrams {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s1 = in.nextLine();
    String s2 = in.nextLine();
    Map<Character, Integer> freq1 = new HashMap<>();
    Map<Character, Integer> freq2 = new HashMap<>();
    int index = 0;
    while (index < s1.length()) {
      char c = s1.charAt(index);
      if (freq1.containsKey(c)) {
        freq1.put(c, freq1.get(c) + 1);
      } else {
        freq1.put(c, 1);
      }
      index++;
    }
    index = 0;
    while (index < s2.length()) {
      char c = s2.charAt(index);
      if (freq2.containsKey(c)) {
        freq2.put(c, Math.abs(freq2.get(c) + 1));
        //                System.out.println("dfa " + Math.abs(freq.get(c) - 1));
      } else {
        freq2.put(c, 1);
      }
      index++;
    }
    for (Character c : freq2.keySet()) {
      if (freq1.containsKey(c)) {
        freq1.put(c, Math.abs(freq1.get(c) - freq2.get(c)));
      } else {
        freq1.put(c, freq2.get(c));
      }
    }
    int count = 0;
    for (Integer i : freq1.values()) {
      count += i;
    }
    System.out.println(count);
  }
}

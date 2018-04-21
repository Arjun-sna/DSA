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
public class Anagram {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    Map<Character, Integer> string1freq = new HashMap<>();
    Map<Character, Integer> string2freq = new HashMap<>();
    for (int i = 0; i < n; i++) {
      string1freq.clear();
      string2freq.clear();
      String s = in.nextLine();
      if (s.length() % 2 != 0) {
        System.out.println("-1");
        continue;
      }
      int mid = s.length() / 2;
      for (int j = 0; j < s.length(); j++) {
        if (j < mid) {
          addToMap(string1freq, s.charAt(j));
        } else {
          addToMap(string2freq, s.charAt(j));
        }
      }
      int numofChange = 0;
      for (Character c : string1freq.keySet()) {
        if (!string2freq.containsKey(c)) {
          numofChange += string1freq.get(c);
        } else if (string2freq.containsKey(c) && string2freq.get(c) < string1freq.get(c)) {
          numofChange += Math.abs(string2freq.get(c) - string1freq.get(c));
        }
      }
      System.out.println(numofChange);
    }
  }

  public static void addToMap(Map<Character, Integer> map, Character c) {
    if (map.containsKey(c)) {
      map.put(c, map.get(c) + 1);
    } else {
      map.put(c, 1);
    }
  }
}

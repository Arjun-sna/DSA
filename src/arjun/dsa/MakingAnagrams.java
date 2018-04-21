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
public class MakingAnagrams {

  public static void main(String[] args) {
    Map<Character, Integer> string1freq = new HashMap<>();
    Map<Character, Integer> string2freq = new HashMap<>();

    Scanner in = new Scanner(System.in);
    String a = in.nextLine(), b = in.nextLine();
    for (int i = 0; i < a.length(); i++) {
      addToMap(string1freq, a.charAt(i));
    }
    for (int i = 0; i < b.length(); i++) {
      addToMap(string2freq, b.charAt(i));
    }
    for (Character c : string1freq.keySet()) {
      if (string2freq.containsKey(c)) {
        int min = string1freq.get(c) < string2freq.get(c) ? string1freq.get(c) : string2freq.get(c);
        string1freq.put(c, string1freq.get(c) - min);
        string2freq.put(c, string2freq.get(c) - min);
      }
    }
    int deletionCount = 0;
    for (Map.Entry<Character, Integer> entry : string1freq.entrySet()) {
      deletionCount += entry.getValue();
    }
    for (Map.Entry<Character, Integer> entry : string2freq.entrySet()) {
      deletionCount += entry.getValue();
    }
    System.out.println(deletionCount);
  }

  public static void addToMap(Map<Character, Integer> map, Character c) {
    if (map.containsKey(c)) {
      map.put(c, map.get(c) + 1);
    } else {
      map.put(c, 1);
    }
  }
}

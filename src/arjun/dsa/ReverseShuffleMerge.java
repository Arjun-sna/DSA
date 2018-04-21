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
public class ReverseShuffleMerge {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    int mainLen = s.length() / 2;
    int[] freq = new int[200];
    int[] freqInMain = new int[200];
    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i)] = freq[s.charAt(i)] + 1;
    }
    for (int i = 0; i < s.length(); i++) {
      freqInMain[s.charAt(i)] = freq[s.charAt(i)] / 2;
    }
    int min = Integer.MAX_VALUE;
    char[] mainArray = new char[mainLen];
    int index = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) < min) {
        mainArray[index] = s.charAt(i);
        min = s.charAt(i);
      } else if (freq[s.charAt(i)] <= freqInMain[s.charAt(i)]) {
        freqInMain[mainArray[index]]--;
        mainArray[++index] = s.charAt(i);
        freqInMain[s.charAt(i)]--;
      }
      freq[s.charAt(i)]--;
    }
    for (char i : mainArray) {
      System.out.print(i);
    }
  }
}

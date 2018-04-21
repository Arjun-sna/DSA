/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.BitSet;
import java.util.Scanner;

/**
 * @author arjun
 */

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of
 a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
 permutation is a rearrangement of letters. The palindrome does not need to be limited to just
 dictionary words.
 * @author arjun
 */
public class PalindromePermutation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    BitSet charSet = new BitSet(256);
    for (int i = 0; i < input.length(); i++) {
      charSet.flip(input.charAt(i));
    }
    if (charSet.cardinality() > 1) {
      System.out.println("false" + charSet.cardinality());
      return;
    }
    System.out.println("true");
  }
}

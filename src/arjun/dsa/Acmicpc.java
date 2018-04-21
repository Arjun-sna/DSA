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
public class Acmicpc {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int people = in.nextInt(), topics = in.nextInt();
    in.nextLine();
    BitSet[] bitSet = new BitSet[people];
    for (int i = 0; i < people; i++) {
      bitSet[i] = new BitSet(topics);
      String s = in.nextLine();
      for (int j = 0; j < s.length(); j++) {
        bitSet[i].set(j, s.charAt(j) == '1');
      }
    }
    int maxSet = 0, maxCount = 0;
    for (int i = 0; i < people; i++) {
      for (int j = i + 1; j < people; j++) {
        BitSet temp = (BitSet) bitSet[i].clone();
        temp.or(bitSet[j]);
        if (temp.cardinality() == maxSet) {
          maxCount++;
        } else if (temp.cardinality() > maxSet) {
          maxSet = temp.cardinality();
          maxCount = 1;
        }
      }
    }

    System.out.println(maxSet);
    System.out.println(maxCount);
  }
}

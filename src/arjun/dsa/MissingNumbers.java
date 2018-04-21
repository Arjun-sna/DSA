/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author arjun
 */
public class MissingNumbers {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int an = in.nextInt();
    int[] arrA = new int[an];
    for (int i = 0; i < an; i++) {
      arrA[i] = in.nextInt();
    }
    int bn = in.nextInt();
    int[] arrB = new int[bn];
    Map<Integer, Integer> freq = new TreeMap<>();
    for (int i = 0; i < bn; i++) {
      arrB[i] = in.nextInt();
      if (freq.containsKey(arrB[i])) {
        freq.put(arrB[i], freq.get(arrB[i]) + 1);
      } else {
        freq.put(arrB[i], 1);
      }
    }

    int[] res = new int[bn - an];
    for (int i = 0; i < an; i++) {
      freq.put(arrA[i], freq.get(arrA[i]) - 1);
    }
    int index = 0;
    for (Integer key : freq.keySet()) {
      if (freq.get(key) > 0) {
        res[index++] = key;
      }
    }
    for (int i = 0; i < index; i++) {
      System.out.print(res[i] + " ");
    }
  }
}

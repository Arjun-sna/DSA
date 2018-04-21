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
public class FlatlandSpceStation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int sp = in.nextInt();
    BitSet map = new BitSet(n);
    for (int i = 0; i < sp; i++) {
      map.set(in.nextInt());
    }
    int index = map.nextSetBit(0);
    int max = index;
    System.out.println(max);
    while (index < n - 1) {
      int temp = map.nextSetBit(index + 1);
      //            System.out.println("Next set n " + temp);
      int curDis;
      if (temp < 0) {
        curDis = n - index - 1;
        temp = n;
      } else {
        curDis = (temp - index) / 2;
      }
      //            System.out.println("Next set " + temp + " " + curDis);
      if (max < curDis) {
        max = curDis;
      }
      index = temp;
    }
    System.out.println(max);
  }
}

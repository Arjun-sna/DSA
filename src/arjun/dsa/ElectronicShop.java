/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author arjun
 */
public class ElectronicShop {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int d = in.nextInt(), i;
    int kc = in.nextInt(), uk = in.nextInt();
    ArrayList<Integer> s1 = new ArrayList<>();
    ArrayList<Integer> s2 = new ArrayList<>();
    for (i = 0; i < kc; i++) {
      s1.add(in.nextInt());
    }
    int max = 0;
    for (i = 0; i < uk; i++) {
      int k = in.nextInt();
      int index = d - k;
      if (index < 1) {
        continue;
      }
      while (index > 0) {
        if (index + k < max) {
          break;
        }
        int ind = s1.indexOf(index);
        if (ind != -1) {
          if (max < s1.get(ind) + k) {
            max = s1.get(ind) + k;
          }
        }
        index--;
      }
    }
    System.out.println(max > 0 ? max : -1);
  }
}

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
public class Kangaroo {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int x1 = in.nextInt();
    int v1 = in.nextInt();
    int x2 = in.nextInt();
    int v2 = in.nextInt(), max, min;
    if (x1 < x2 && v1 < v2) {
      System.out.println("NO");
      return;
    }
    int maxV = v1 > v2 ? v1 : v2, highest = v1 * v2;
    for (int i = maxV; i <= highest; i++) {
      System.out.println(i);
      if (i % v1 == 0 && i % v2 == 0) {

        if (i % x1 == 0 && i % x2 == 0) {
          if ((i - x1) / v1 == (i - x2) / v2) {
            System.out.println("YES");
          }
        } else {
          System.out.println("NO");
          return;
        }
      }
    }
    System.out.println("NO");
  }
}
//if (v1 > v2) {
//            max = v1;
//            min = v2;
//        } else {
//            max = v2;min = v1;
//        }
//        int highest = v1 * v2;
//        int maxStart = x1 > x2 ? x1 : x2;
//        for (int i = max; i < highest ; i ++) {
//            if (i % v1 == 0 && i % v2 == 0) {
//                if ((i - x1) % v1 == 0 && (i - x2) % v2 == 0) {
//                    System.out.println("YES");
//                    return;
//                }
//            }
//        }
//        System.out.println("NO");

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int x1 = in.nextInt();
//        int v1 = in.nextInt();
//        int x2 = in.nextInt();
//        int v2 = in.nextInt(), max, min;
//            boolean matched = false;
//    boolean matchPossible = true;
//    while (!matched && matchPossible) {
//
//        x1 += v1;
//        x2 += v2;
//
//        if ((x1 > x2) && (v1 >= v2)) {
//            matchPossible = false;
//        }
//
//        if ((x2 > x1) && (v2 >= v1)) {
//            matchPossible = false;
//        }
//
//        if (x1 == x2) {
//            matched = true;
//        }
//    }
//
//    System.out.println(matched == true ? "YES" : "NO");
//    }
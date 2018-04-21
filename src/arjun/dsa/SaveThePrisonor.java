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
public class SaveThePrisonor {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      int m = in.nextInt();
      int s = in.nextInt() - 1;
      if (n >= m) {
        System.out.println(s + m);
      } else {
        int next = s + (m % n);
        System.out.println(next > n ? next % n : next);
      }
    }
  }
}

//Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = in.nextInt();
//            int m = in.nextInt();
//            int s = in.nextInt() - 1;
//            if (n > m) {
//                System.out.println(s + m);
//            } else {
//                System.out.println((s + (m % n)) % n);
//            }
//        }
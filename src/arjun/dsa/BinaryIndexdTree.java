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
public class BinaryIndexdTree {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] bit = new int[n + 1];
    for (int i = 0; i < n; i++) {
      int ele = in.nextInt();
      update(bit, i, ele, n);
      for (int k : bit) {
        System.out.print(k + " ");
      }
    }
    printSum(bit, 1);
    printSum(bit, 2);
    printSum(bit, 3);
    printSum(bit, 4);
    printSum(bit, 5);
  }

  public static void update(int[] bit, int x, int val, int n) {
    for (; x <= n; x += x & (-x)) {
      bit[x] = bit[x] + val;
    }
  }

  public static void printSum(int[] bit, int index) {
    int sum = 0, x = index;
    for (; x > 0; x -= x & (-x)) {
      sum += bit[x];
    }
    System.out.println("Sum of " + index + " - " + sum);
  }
}

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
public class SquareRoot {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(sqrt(n, 1, n / 2));
  }

  public static int sqrt(int n, int min, int max) {
    if (max < min) {
      return -1;
    }
    int mid = (max + min) / 2;
    int sq = mid * mid;
    if (sq == n) {
      return mid;
    } else if (sq < n) {
      return sqrt(n, mid + 1, max);
    } else {
      return sqrt(n, min, mid - 1);
    }
  }
}

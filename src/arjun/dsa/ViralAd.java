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
public class ViralAd {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int sum = 0, cur = 5;
    while (n > 0) {
      sum += cur / 2;
      cur = (cur / 2) * 3;
      n--;
    }
    System.out.println(sum);
  }
}

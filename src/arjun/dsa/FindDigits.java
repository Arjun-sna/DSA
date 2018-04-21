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
public class FindDigits {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    for (int i = 0; i < n; i++) {
      System.out.println(getCount(s.nextInt()));
    }
  }

  public static int getCount(int n) {
    int temp = n, count = 0;
    while (temp > 0) {
      int dig = temp % 10;
      if (dig != 0 && n % dig == 0) {
        count++;
      }
      temp = temp / 10;
    }
    return count;
  }
}

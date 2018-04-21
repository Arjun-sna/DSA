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
public class BeautifylDays {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int i = in.nextInt(), j = in.nextInt(), k = in.nextInt(), bCount = 0;
    while (i <= j) {
      //            System.out.println(i + " rev " + reverseOf(i));
      if (Math.abs(i - reverseOf(i)) % k == 0) {
        bCount++;
      }
      i++;
    }
    System.out.println(bCount);
  }

  public static int reverseOf(int num) {
    int reverse = 0;
    while (num > 0) {
      reverse = reverse * 10 + (num % 10);
      num = num / 10;
    }
    return reverse;
  }
}

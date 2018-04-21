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
public class PlusMinus {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    float arrSize = in.nextFloat();
    float plussum = 0, minussum = 0, zerosum = 0;
    for (int i = 0; i < arrSize; i++) {
      int ele = in.nextInt();
      if (ele < 0) {
        minussum++;
      } else if (ele > 0) {
        plussum++;
      } else {
        zerosum++;
      }
    }
    System.out.println(plussum / arrSize);
    System.out.println(minussum / arrSize);
    System.out.println(zerosum / arrSize);
  }
}

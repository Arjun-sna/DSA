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
public class AppleOrange {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int hStart = in.nextInt();
    int hEnd = in.nextInt();
    int apple = in.nextInt();
    int orange = in.nextInt();
    int m = in.nextInt();
    int n = in.nextInt();
    //int[] apple = new int[m];
    int appleCount = 0, orangeCount = 0;
    for (int apple_i = 0; apple_i < m; apple_i++) {
      int currentApple = in.nextInt() + apple;
      if (currentApple >= hStart && currentApple <= hEnd) {
        appleCount++;
      }
    }
    //int[] orange = new int[n];
    for (int orange_i = 0; orange_i < n; orange_i++) {
      int currentOrange = in.nextInt() + orange;
      if (currentOrange >= hStart && currentOrange <= hEnd) {
        orangeCount++;
      }
    }
    System.out.println(appleCount);
    System.out.println(orangeCount);
  }
}

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
public class LeftRotation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int rot = in.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {

      if (i - rot + 1 > 0) {
        arr[i - rot] = in.nextInt();
      } else {
        arr[n + i - rot] = in.nextInt();
      }
    }

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}


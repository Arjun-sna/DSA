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
public class JumpingOnTheClouds {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int c = in.nextInt(), k = in.nextInt();
    int[] cls = new int[c];
    for (int i = 0; i < c; i++) {
      cls[i] = in.nextInt();
    }
    int cur = 0, energy = 100;
    do {
      cur = (cur + k) % c;
      energy = cls[cur] == 1 ? energy - 3 : energy - 1;
    } while (cur != 0);
    System.out.println(energy);
  }
}

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
public class JailBreak {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int output = 0;
    int ip1 = Integer.parseInt(in.nextLine().trim());
    int ip2 = Integer.parseInt(in.nextLine().trim());
    int ip3_size = 0;
    ip3_size = Integer.parseInt(in.nextLine().trim());
    int[] ip3 = new int[ip3_size];
    int ip3_item;
    for (int ip3_i = 0; ip3_i < ip3_size; ip3_i++) {
      ip3_item = Integer.parseInt(in.nextLine().trim());
      ip3[ip3_i] = ip3_item;
    }
    output = GetJumpCount(ip1, ip2, ip3);
    System.out.println(String.valueOf(output));
  }

  public static int GetJumpCount(int input1, int input2, int[] input3) {
    int totalJumps = 0;
    for (int i = 0; i < input3.length; i++) {
      int height = 0;
      while (height < input3[i]) {
        if (height != 0) {
          height -= input2;
        }
        height += input1;
        totalJumps++;
      }
    }
    return totalJumps;
  }
}


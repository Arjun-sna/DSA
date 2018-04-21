/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author arjun
 */
public class EqualStacks {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int n3 = in.nextInt(), sum1 = 0, sum2 = 0, sum3 = 0;
    Stack<Integer> stack1 = new Stack<>();
    int minsum = 0;
    for (int h1_i = 0; h1_i < n1; h1_i++) {
      int h = in.nextInt();
      stack1.push(h);
      sum1 += h;
    }
    minsum = sum1;
    Stack<Integer> stack2 = new Stack<>();
    for (int h2_i = 0; h2_i < n2; h2_i++) {
      int h = in.nextInt();
      stack2.push(h);
      sum2 += h;
    }
    if (sum2 < minsum) {
      minsum = sum2;
    }
    Stack<Integer> stack3 = new Stack<>();
    for (int h3_i = 0; h3_i < n3; h3_i++) {
      int h = in.nextInt();
      stack3.push(h);
      sum3 += h;
    }
    if (sum3 < minsum) {
      minsum = sum3;
    }
    int maxH = minsum;
    if (sum1 == sum2 && sum2 == sum3) {
      System.out.println(maxH);
      return;
    }

    System.out.println(maxH);
  }
}

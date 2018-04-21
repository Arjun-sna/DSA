/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author arjun
 */
public class StackMax {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int max = Integer.MIN_VALUE;
    Deque<Integer> stack = new LinkedList<>();
    for (int i = 0; i < n; i++) {

      switch (sc.nextInt()) {
        case 1:
          int val = sc.nextInt();
          stack.push(val);
          if (val > max) max = val;
          break;
        case 2:
          stack.pop();
          if (stack.isEmpty()) max = Integer.MIN_VALUE;
          break;
        case 3:
          System.out.println(max);
          break;
      }
    }
  }
}

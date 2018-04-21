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
public class QueueUsingStacks {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    for (int i = 0; i < q; i++) {
      int ops = in.nextInt();
      switch (ops) {
        case 1:
          s1.push(in.nextInt());
          break;
        case 2:
          if (s2.empty()) {
            while (!s1.empty()) {
              s2.push(s1.pop());
            }
          }
          s2.pop();
          break;
        case 3:
          if (s2.empty()) {
            while (!s1.empty()) {
              s2.push(s1.pop());
            }
          }
          System.out.println(s2.peek());
      }
    }
  }
}

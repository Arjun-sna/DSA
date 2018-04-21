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
public class AndXorOr {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    int max = 0;
    Stack<Integer> pair = new Stack<>();
    for (int k : arr) {
      while (!pair.isEmpty()) {
        int top = pair.peek();
        int res = k ^ top;
        if (res > max) {
          max = res;
        }
        if (k < top) {
          pair.pop();
        } else {
          break;
        }
      }
      pair.push(k);
    }

    System.out.println(max);
  }
}
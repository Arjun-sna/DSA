/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author arjun
 */
public class GameOfTwoStacks {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int g = in.nextInt();
    for (int a0 = 0; a0 < g; a0++) {
      int n = in.nextInt();
      int m = in.nextInt();
      int x = in.nextInt();
      Deque<Integer> a = new ArrayDeque<>();
      for (int a_i = 0; a_i < n; a_i++) {
        a.push(in.nextInt());
      }
      Deque<Integer> b = new ArrayDeque<>();
      for (int b_i = 0; b_i < m; b_i++) {
        b.push(in.nextInt());
      }
      int indexa = 0, indexb = 0, sum = 0, itemcount = 0;
      while (sum < x) {
        int nextVal = 0;
        if (a.size() == b.size()) {
          nextVal = a.peekLast() > b.peekLast() ? b.removeLast() : a.removeLast();
        } else {
          nextVal = a.size() > b.size() ? a.removeLast() : b.removeLast();
        }
        sum += nextVal;
        System.out.println(sum);
        itemcount++;
      }
      System.out.println(sum > x ? itemcount - 1 : itemcount);
    }
  }
}

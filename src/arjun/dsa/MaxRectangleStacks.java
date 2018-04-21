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
public class MaxRectangleStacks {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    System.out.println(getMaxRect(arr));
  }

  static int getMaxRect(int[] arr) {
    Deque<Integer> stack = new LinkedList<>();
    int maxArea = -1, area = 0, i;
    for (i = 0; i < arr.length; ) {
      if (stack.isEmpty() || arr[stack.peekFirst()] <= arr[i]) {
        stack.push(i++);
      } else {
        int top = stack.pop();
        if (stack.isEmpty()) {
          area = arr[top] * i;
        } else {
          area = arr[top] * (i - stack.peekFirst() - 1);
        }
        if (area > maxArea) {
          maxArea = area;
        }
      }
    }

    while (!stack.isEmpty()) {
      int top = stack.pop();
      if (stack.isEmpty()) {
        area = arr[top] * i;
      } else {
        area = arr[top] * (i - stack.peekFirst() - 1);
      }
      if (area > maxArea) {
        maxArea = area;
      }
    }
    return maxArea;
  }
}

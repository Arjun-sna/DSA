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

/**
 * Given an array, print the Next Greater Element (NGE) for every element. 
 * The Next greater Element for an element x is the first greater element on the right side of x in array. 
 * Elements for which no greater element exist, consider next greater element as -1.
 * @author arjun
 */
public class NextGreaterElement {
  static class stack {
    int top;
    int items[] = new int[100];

    // Stack functions to be used by printNGE
    void push(int x) {
      if (top == 99) {
        System.out.println("Stack full");
      } else {
        items[++top] = x;
      }
    }

    int pop() {
      if (top == -1) {
        System.out.println("Underflow error");
        return -1;
      } else {
        int element = items[top];
        top--;
        return element;
      }
    }

    boolean isEmpty() {
      return (top == -1) ? true : false;
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }
    stack s1 = new stack();
    s1.push(arr[0]);
    for (int i = 1; i < n; i++) {
      int nle = arr[i];
      if (!s1.isEmpty()) {
        int ele = s1.pop();
        while (ele < nle) {
          System.out.println(ele + " --> " + nle);
          if (s1.isEmpty()) {
            break;
          }
          ele = s1.pop();
        }

        if (ele > nle) {
          s1.push(ele);
        }
      }
      s1.push(nle);
    }

    while (!s1.isEmpty()) {
      System.out.println(s1.pop() + " --> " + -1);
    }
  }
}

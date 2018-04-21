/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author arjun
 */
public class RunningMedian {
  static PriorityQueue<Integer> lower = new PriorityQueue<Integer>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      return -1 * o1.compareTo(o2);
    }
  });
  static PriorityQueue<Integer> higher = new PriorityQueue<>();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      addNumber(in.nextInt());
      balanceHeaps();
      System.out.println(getMedian());
    }
  }

  public static void addNumber(int num) {

    if (lower.isEmpty() || num < lower.peek()) {
      lower.add(num);
    } else {
      higher.add(num);
    }
  }

  public static void balanceHeaps() {
    PriorityQueue<Integer> bigger = lower.size() > higher.size() ? lower : higher;
    PriorityQueue<Integer> smaller = lower.size() > higher.size() ? higher : lower;
    if (bigger.size() - smaller.size() >= 2) {
      smaller.add(bigger.poll());
    }
  }

  public static double getMedian() {
    PriorityQueue<Integer> bigger = lower.size() > higher.size() ? lower : higher;
    PriorityQueue<Integer> smaller = lower.size() > higher.size() ? higher : lower;
    if (bigger.size() == smaller.size()) {
      return ((double) bigger.peek() + lower.peek()) / 2;
    } else {
      return bigger.peek();
    }
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author arjun
 */
public class MedianUpdates {
  static PriorityQueue<Integer> lower = new PriorityQueue<Integer>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      return -1 * o1.compareTo(o2);
    }
  });
  static PriorityQueue<Integer> higher = new PriorityQueue<>();
  static DecimalFormat format = new DecimalFormat();

  public static void main(String[] args) {
    format.setDecimalSeparatorAlwaysShown(false);
    format.setGroupingUsed(false);
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      char ch = in.next().charAt(0);
      if (ch == 'a') {
        addNumber(in.nextInt());
        balanceHeaps();
        getMedian();
      } else {
        if (removeNumber(in.nextInt())) {
          balanceHeaps();
          getMedian();
        } else {
          System.out.println("Wrong!");
        }
      }
    }
  }

  public static boolean removeNumber(int num) {
    //        System.out.println("com " + num);
    if (lower.contains(num)) {
      lower.remove(num);
    } else if (higher.contains(num)) {
      higher.remove(num);
    } else {
      return false;
    }
    return true;
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

  public static void getMedian() {
    PriorityQueue<Integer> bigger = lower.size() > higher.size() ? lower : higher;
    PriorityQueue<Integer> smaller = lower.size() > higher.size() ? higher : lower;
    if (bigger.isEmpty()) {
      System.out.println("Wrong!");
      ;
    }
    if (bigger.size() == smaller.size()) {
      System.out.println(format.format(((double) bigger.peek() + smaller.peek()) / 2));
    } else {
      System.out.println(format.format(bigger.peek()));
    }
  }
}

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
public class JesseAndCookies {
  static int[] heap;
  static int last;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int c = in.nextInt(), min = in.nextInt();
    heap = new int[c];
    for (int i = 0; i < c; i++) {
      add(in.nextInt());
    }
    last = c;
    int count = 0;
    while (heap[0] < min) {
      count++;
      if (last < 2) {
        System.out.println(-1);
        return;
      }
      int firstMin = extractMin();
      int secondMin = extractMin();
      int newEle = 1 * firstMin + 2 * secondMin;
      add(newEle);
      System.out.println("count " + count);
    }
    System.out.println(count);
  }

  public static void add(int n) {
    heap[last++] = n;
    sinkUp();
  }

  public static void sinkUp() {
    int index = last - 1;
    while (hasParent(index) && heap[index] < getParent(index)) {
      swap(index, getParentIndex(index));
      index = getParentIndex(index);
    }
  }

  public static boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  public static int extractMin() {
    if (last == 0) {
      return -1;
    }
    int item = heap[0];
    heap[0] = heap[last - 1];
    last--;
    sinkDown();
    return item;
  }

  public static void sinkDown() {
    int index = 0;
    while (hasLeftChild(index)) {
      int smallerIndex = getLeftChildIndexOf(index);
      if (hasRightChild(index) && rightChildOf(index) < leftChildOf(index)) {
        smallerIndex = getRightChildIndexOf(index);
      }
      if (heap[index] < heap[smallerIndex]) {
        break;
      } else {
        swap(index, smallerIndex);
      }
      index = smallerIndex;
    }
  }

  public static void swap(int from, int to) {
    int temp = heap[from];
    heap[from] = heap[to];
    heap[to] = temp;
  }

  public static int leftChildOf(int index) {
    return heap[2 * index + 1];
  }

  public static int rightChildOf(int index) {
    return heap[2 * index + 2];
  }

  public static int getLeftChildIndexOf(int index) {
    return 2 * index + 1;
  }

  public static int getRightChildIndexOf(int index) {
    return 2 * index + 2;
  }

  public static boolean hasLeftChild(int index) {
    return 2 * index + 1 < last;
  }

  public static boolean hasRightChild(int index) {
    return 2 * index + 2 < last;
  }

  public static int getParentIndex(int index) {
    return (index - 1) / 2;
  }

  public static int getParent(int index) {
    return heap[getParentIndex(index)];
  }
}

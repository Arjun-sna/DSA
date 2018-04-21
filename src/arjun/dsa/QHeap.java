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
public class QHeap {
  public static void main(String[] args) {
    int[] heap = new int[16];
    int last = 1;
    Scanner in = new Scanner(System.in);
    int queries = in.nextInt();
    for (int q = 0; q < queries; q++) {
      int op = in.nextInt();
      switch (op) {
        case 1:
          int value = in.nextInt();
          if (last == heap.length) {
            heap = doubleSizeOf(heap);
          }
          heap[last] = value;
          swim(heap, last);
          last++;
          break;
        case 2:
          value = in.nextInt();
          int posToDelete = findInHeap(heap, value, last);
          last--;
          swap(heap, posToDelete, last);
          sink(heap, posToDelete, last);
          break;
        case 3:
          if (last > 1) {
            System.out.println(heap[1]);
          }
          break;
        default:
          ;
      }
    }
    in.close();
  }

  private static int[] doubleSizeOf(int[] heap) {
    int[] doubleHeap = new int[heap.length * 2];
    for (int i = 0; i < heap.length; i++) {
      doubleHeap[i] = heap[i];
    }
    return doubleHeap;
  }

  private static void swim(int[] heap, int pos) {
    int parent = pos / 2;
    while (parent > 0 && heap[pos] < heap[parent]) {
      swap(heap, parent, pos);
      pos = parent;
      parent = pos / 2;
    }
  }

  private static void swap(int[] heap, int from, int to) {
    int temp = heap[from];
    heap[from] = heap[to];
    heap[to] = temp;
  }

  private static int findInHeap(int[] heap, int key, int last) {
    return findInHeapStartingFrom(heap, key, last, 1);
  }

  private static int findInHeapStartingFrom(int[] heap, int key, int last, int pos) {
    if (last <= pos) {
      return -1;
    }
    if (heap[pos] == key) {
      return pos;
    }
    int foundInLeft = findInHeapStartingFrom(heap, key, last, pos * 2);
    if (foundInLeft > -1) {
      return foundInLeft;
    }
    return findInHeapStartingFrom(heap, key, last, pos * 2 + 1);
  }

  private static void sink(int[] heap, int pos, int last) {
    int left = pos * 2;
    int right = pos * 2 + 1;
    int posToSwap = pos;
    if (left < last && heap[left] < heap[posToSwap]) {
      posToSwap = left;
    }
    if (right < last && heap[right] < heap[posToSwap]) {
      posToSwap = right;
    }
    if (pos == posToSwap) {
      return;
    }
    swap(heap, pos, posToSwap);
    sink(heap, posToSwap, last);
  }
}

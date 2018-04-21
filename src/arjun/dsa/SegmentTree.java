/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

/**
 * @author arjun
 */
public class SegmentTree {
  public static void main(String[] args) {
    int[] input = {-1, 2, 4, 0};
    int[] segTree = new int[7];
    constructTree(input, segTree, 0, input.length - 1, 0);
    System.out.println(rangeMin(segTree, 1, 3, 0, input.length - 1, 0));
    System.out.println(rangeMin(segTree, 0, 0, 0, input.length - 1, 0));
  }

  public static void constructTree(int[] input, int[] segTree, int low, int high, int root) {
    if (low == high) {
      segTree[root] = input[low];
      return;
    }
    int mid = (low + high) >> 1;
    constructTree(input, segTree, low, mid, 2 * root + 1);
    constructTree(input, segTree, mid + 1, high, 2 * root + 2);
    segTree[root] = Math.min(segTree[2 * root + 1], segTree[(2 * root + 2)]);
    for (int i : segTree) {
      System.out.print(i + " ");
    }
    System.out.println("");
  }

  public static int rangeMin(int[] segTree, int qLow, int qHigh, int low, int high, int root) {
    if (qLow <= low && qHigh >= high) {
      return segTree[root];
    }
    if (qLow > high || qHigh < low) {
      return Integer.MAX_VALUE;
    }
    int mid = (low + high) / 2;
    return Math.min(rangeMin(segTree, qLow, qHigh, low, mid, 2 * root + 1),
        rangeMin(segTree, qLow, qHigh, mid + 1, high, 2 * root + 2));
  }

  public static void updateRangeLazy(int[] segTree, int[] lazy, int qlow,
      int delta, int qhigh, int low, int high, int pos) {
    if (low > high) {
      return;
    }

    if (lazy[pos] != 0) {
      segTree[pos] += lazy[pos];
      if (low != high) {
        lazy[2 * pos + 1] += lazy[pos];
        lazy[2 * pos + 2] += lazy[pos];
      }
      lazy[pos] = 0;
    }

    if (qlow > high || qhigh < low) {
      return;
    }

    if (qlow <= low && qhigh >= high) {
      segTree[pos] += delta;
      if (low != high) {
        lazy[2 * pos + 1] += delta;
        lazy[2 * pos + 2] += delta;
      }
      return;
    }

    int mid = (low + high) / 2;
    updateRangeLazy(segTree, lazy, qlow, delta, qhigh, low, mid, 2 * pos + 1);
    updateRangeLazy(segTree, lazy, qlow, delta, qhigh, mid + 1, high, 2 * pos + 2);
    segTree[pos] = Math.max(segTree[2 * pos + 1], segTree[2 * pos + 2]);
  }

  public static int rangeMaxLazy(int[] segTree, int[] lazy, int qlow, int qhigh, int low, int high,
      int pos) {
    if (low > high) {
      return Integer.MIN_VALUE;
    }

    if (lazy[pos] != 0) {
      segTree[pos] += lazy[pos];
      if (low != high) {
        lazy[2 * pos + 1] += lazy[pos];
        lazy[2 * pos + 2] += lazy[pos];
      }
      lazy[pos] = 0;
    }

    if (qlow > high || qhigh < low) {
      return Integer.MIN_VALUE;
    }

    if (qlow <= low && qhigh >= high) {
      return segTree[pos];
    }

    int mid = (low + high) / 2;
    return Math.max(rangeMaxLazy(segTree, lazy, qlow, qhigh, low, mid, 2 * pos + 1),
        rangeMaxLazy(segTree, lazy, qlow, qhigh, mid + 1, high, 2 * pos + 2));
  }
}

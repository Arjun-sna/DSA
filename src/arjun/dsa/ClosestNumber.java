/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.ArrayList;
import java.util.Scanner;

import static arjun.dsa.QuickSort.r;

/**
 * @author arjun
 */
public class ClosestNumber {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), i;
    int[] arr = new int[n];
    for (i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    int min = Integer.MAX_VALUE;
    ArrayList<Integer> minIndex = new ArrayList<>();
    quickSort(arr, 0, n - 1);
    for (i = 0; i < n - 1; i++) {
      int diff = arr[i + 1] - arr[i];
      if (diff < min) {
        minIndex.clear();
        minIndex.add(i);
        min = diff;
      } else if (diff == min) {
        minIndex.add(i);
        min = diff;
      }
    }

    for (Integer k : minIndex) {
      System.out.print(arr[k] + " " + arr[k + 1] + " ");
    }
  }

  public static void quickSort(int[] arr, int start, int end) {
    if (start < end) {
      int partition = randomisedPartition(arr, start, end);
      quickSort(arr, start, partition - 1);
      quickSort(arr, partition + 1, end);
    }
  }

  public static int randomisedPartition(int[] arr, int start, int end) {
    int pivot = getRandomBetn(start, end);
    int pivotVal = arr[pivot], pIndex = start;
    swap(arr, pivot, end);
    for (int i = start; i < end; i++) {
      if (arr[i] <= pivotVal) {
        swap(arr, i, pIndex);
        pIndex++;
      }
    }
    swap(arr, pIndex, end);
    return pIndex;
  }

  public static int getRandomBetn(int start, int end) {
    return r.nextInt((end - start) + 1) + start;
  }

  public static void swap(int[] arr, int pos1, int pos2) {
    if (pos1 == pos2) return;
    int temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
  }
}

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
public class ArrayMedian {
  static int midx;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    midx = n / 2;
    quickSort(arr, 0, arr.length - 1);
    System.out.println(arr[midx]);
  }

  public static void quickSort(int[] arr, int start, int end) {
    if (start < end) {
      int partition = randomisedPartition(arr, start, end);
      if (midx <= partition - 1) {
        quickSort(arr, start, partition - 1);
      } else if (midx >= partition + 1) {
        quickSort(arr, partition + 1, end);
      }
    }
  }

  public static int randomisedPartition(int[] arr, int start, int end) {
    int pivot = end;
    int pivotVal = arr[pivot], pIndex = start;
    for (int i = start; i < end; i++) {
      if (arr[i] <= pivotVal) {
        swap(arr, i, pIndex);
        pIndex++;
      }
    }
    swap(arr, pIndex, end);
    return pIndex;
  }

  public static void swap(int[] arr, int pos1, int pos2) {
    if (pos1 == pos2) return;
    int temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
  }
}

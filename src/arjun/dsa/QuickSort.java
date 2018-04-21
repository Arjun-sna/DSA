/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.Random;

/**
 * @author arjun
 */
public class QuickSort {
  public static Random r = new Random();

  public static void main(String[] args) {
    int[] arr = {5, 8, 1, 3, 7, 9, 2};
    quickSort(arr, 0, arr.length - 1);
    for (int i : arr) {
      System.out.print(i + " ");
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
    //        if (pos1 == pos2) return;
    int temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
  }
}

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
public class Runtime {
  static int qCount = 0;
  static int iCount = 0;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    int[] arr2 = new int[n];
    for (int i = 0; i < n; i++) {
      int e = in.nextInt();
      ;
      arr[i] = e;
      arr2[i] = e;
    }
    quickSort(arr, 0, arr.length - 1);
    insertionSort(arr2);
    System.out.println(qCount - iCount);
  }

  static void printArray(int[] ar) {
    for (int n : ar) {
      System.out.print(n + " ");
    }
    System.out.println();
  }

  public static void quickSort(int[] arr, int start, int end) {
    if (start < end) {
      int partition = randomisedPartition(arr, start, end);
      quickSort(arr, start, partition - 1);
      quickSort(arr, partition + 1, end);
    }
  }

  public static int randomisedPartition(int[] arr, int start, int end) {
    int pivot = end;
    int pivotVal = arr[pivot], pIndex = start;
    //swap(arr, pivot, end);
    for (int i = start; i < end; i++) {
      if (arr[i] <= pivotVal) {
        swap(arr, i, pIndex);
        qCount++;
        pIndex++;
      }
    }
    swap(arr, pIndex, end);
    qCount++;
    return pIndex;
  }

  public static void swap(int[] arr, int pos1, int pos2) {
    //        if (pos1 == pos2) return;
    int temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
  }

  public static void insertionSort(int[] A) {
    int count = 0;
    for (int i = 1; i < A.length; i++) {
      int value = A[i];
      int j = i - 1;
      while (j >= 0 && A[j] > value) {
        A[j + 1] = A[j];
        j = j - 1;
        iCount++;
      }
      A[j + 1] = value;
    }
  }
}

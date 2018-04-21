/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author arjun
 */
public class LillysHomework {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int arr[] = new int[n];
    int arrrev[] = new int[n];
    int sorted[] = new int[n];
    Map<Integer, Integer> posMap = new HashMap<>();
    Map<Integer, Integer> posMapRev = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int ele = in.nextInt();
      arr[i] = ele;
      arrrev[n - i - 1] = ele;
      sorted[i] = ele;
      posMap.put(ele, i);
      posMapRev.put(ele, n - i - 1);
    }
    Arrays.sort(sorted);
    int swapCount1 = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != sorted[i]) {
        swapCount1++;
        int swapidx = posMap.get(sorted[i]);
        posMap.put(arr[i], swapidx);
        swap(arr, i, swapidx);
      }
    }
    System.out.println("sw1 " + swapCount1);
    int swapCount2 = 0;
    for (int i = 0; i < arrrev.length; i++) {
      if (arrrev[i] != sorted[i]) {
        swapCount2++;
        int swapidx = posMapRev.get(sorted[i]);
        posMapRev.put(arrrev[i], swapidx);
        swap(arrrev, i, swapidx);
      }
    }
    System.out.println("sw2 " + swapCount2);
    System.out.println(swapCount1 > swapCount2 ? swapCount2 : swapCount1);
  }

  public static void swap(int[] arr, int from, int to) {
    int temp = arr[from];
    arr[from] = arr[to];
    arr[to] = temp;
  }
}

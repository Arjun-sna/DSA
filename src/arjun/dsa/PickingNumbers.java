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
public class PickingNumbers {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    Map<Integer, Integer> weightMap = new HashMap<>();
    Arrays.sort(a);
    int maxCount = 0, maxEle = 0;
    for (int i = 0; i < a.length; ) {
      int countOfi = 1;
      int j = i + 1;
      while (j < a.length && a[j] == a[i]) {
        countOfi++;
        j++;
      }
      weightMap.put(a[i], countOfi);
      if (countOfi > maxCount) {
        maxCount = countOfi;
        maxEle = a[i];
      }
      i = j;
    }
    int maxKey, maxSum = 0;
    for (Integer key : weightMap.keySet()) {
      int currsum = 0;
      currsum += weightMap.get(key);
      maxSum = currsum > maxSum ? currsum : maxSum;
      if (weightMap.containsKey(key - 1)) {
        maxSum = (currsum + weightMap.get(key - 1)) > maxSum ? (currsum + weightMap.get(key - 1))
            : maxSum;
      }
      if (weightMap.containsKey(key + 1)) {
        maxSum = (currsum + weightMap.get(key + 1)) > maxSum ? (currsum + weightMap.get(key + 1))
            : maxSum;
      }
    }
    System.out.println(maxSum);
  }

  //**********************************optimal solution******************************************//
  //    public static void main(String[] args) {
  //        Scanner in = new Scanner(System.in);
  //        int n = in.nextInt();
  //
  //        // An array of zeroes
  //        int[] frequency = new int[100];
  //
  //        // Fill array so that the value at each index corresponds to the number of occurrences of that integer
  //        for (int i = 0; i < n; i++){
  //            frequency[in.nextInt()]++;
  //        }
  //        in.close();
  //
  //        // Determine which pair of adjacent integers has the highest number of occurrences
  //        int max = 0;
  //        for (int i = 1; i < n; i++) {
  //            int count = frequency[i] + frequency[i - 1];
  //            if (count > max) {
  //                max = count;
  //            }
  //        }
  //
  //        System.out.println(max);
  //    }
  //
  //**********************************optimal solution******************************************//

  public static int binarySearch(int[] arr, int start, int end, int key) {
    //        System.out.println("key " + key);
    int mid = start + (end - start) / 2;
    //        System.out.println("mid " + mid);
    while (start <= end) {
      if (arr[mid] == key) {
        return mid;
      }
      if (arr[mid] > key) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
      mid = start + (end - start) / 2;
    }
    return -1;
  }
}

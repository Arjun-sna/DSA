/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa.SortingAndSearching;

/**
 * @author arjun
 */
public class RotatedSearch {
  public static void main(String[] args) {
    int[] arr = new int[] {2, 2, 2, 3, 4, 2};
    System.out.println(" " + searchRotated(arr, 0, arr.length - 1, 3));
  }

  static int searchRotated(int[] arr, int left, int right, int x) {
    int mid = (left + right) / 2;
    if (arr[mid] == x) {
      return mid;
    }
    if (right < left) {
      return -1;
    }
    if (arr[left] < arr[mid]) {
      if (x >= arr[left] && x < arr[mid]) {
        return searchRotated(arr, left, mid - 1, x);
      } else {
        return searchRotated(arr, mid + 1, right, x);
      }
    } else if (arr[left] > arr[mid]) {
      if (x > arr[mid] && x <= arr[right]) {
        return searchRotated(arr, mid + 1, right, x);
      } else {
        return searchRotated(arr, left, mid - 1, x);
      }
    } else if (arr[left] == arr[mid]) {
      if (arr[mid] != arr[right]) {
        return searchRotated(arr, mid + 1, right, x);
      } else {
        int result = searchRotated(arr, left, mid - 1, x);
        if (result == -1) {
          result = searchRotated(arr, mid + 1, right, x);
        }
        return result;
      }
    }
    return -1;
  }
}

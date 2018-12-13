package arjun.dsa.DP;

import java.util.Scanner;

/**
 * Magic Index: A magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[ i]
 * i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
 * array A.
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class MagicIndex {
  public static void main(String[] args) {
    //int[] ipArray = new int[] { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};

    Scanner in = new Scanner(System.in);
    int arrayLength = in.nextInt();
    int[] ipArray = new int[arrayLength];
    for (int i = 0; i < arrayLength; i++) {
      ipArray[i] = in.nextInt();
    }
    int magicIndex = findMagicIndex(ipArray);
    System.out.println("Magic Index " + magicIndex);

    //int[] ipArrayDup = new int[] { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
    //System.out.println("Magic Index with duplicated " + findMagicIndexWithDuplicates(ipArrayDup, 0, ipArray.length));
  }

  //private static int findMagicIndexWithDuplicates(int[] ipArray, int start, int end) {
  //  if (end < start) {
  //    return -1;
  //  }
  //
  //  int mid = (start + end) / 2;
  //  if (mid == ipArray[mid]) {
  //    return mid;
  //  }
  //  int left = findMagicIndexWithDuplicates(ipArray, start, Math.min(mid - 1, ipArray[mid]));
  //  if (left > 0) {
  //    return left;
  //  }
  //  int right = findMagicIndexWithDuplicates(ipArray, Math.max(mid + 1, ipArray[mid]), end);
  //  return right;
  //}

  private static int findMagicIndexInE(int[] ipArray) {
    for (int i = 0; i < ipArray.length; i++) {
      if (ipArray[i] == i) {
        return i;
      }
    }
    return -1;
  }

  private static int findMagicIndex(int[] ipArray) {
    int start = 0, end = ipArray.length - 1;
    int mid;
    while(start <= end) {
      mid = (start + end) / 2;
      if (mid == ipArray[mid]) {
        return mid;
      } else if (mid > ipArray[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }
}

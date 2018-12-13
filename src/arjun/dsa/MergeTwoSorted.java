package arjun.dsa;

// Java program to merge two sorted arrays
import java.util.*;
import java.lang.*;

class MergeTwoSorted
{
  public static void mergeArrays(int[] arr1, int[] arr2, int n1,
      int n2, int[] arr3)
  {
    int i = 0, j = 0, k = 0;

    while (i<n1 && j <n2)
    {
      if (arr1[i] < arr2[j])
        arr3[k++] = arr1[i++];
      else
        arr3[k++] = arr2[j++];
    }

    while (i < n1)
      arr3[k++] = arr1[i++];

    while (j < n2)
      arr3[k++] = arr2[j++];
  }

  public static void main (String[] args)
  {
    Scanner in = new Scanner(System.in);
    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int[] arr1 = new int[n1];
    int[] arr2 = new int[n2];
    int[] res = new int[n1 + n2];
    for (int i = 0; i < n1; i++) {
      arr1[i] = in.nextInt();
    }
    for (int i = 0; i < n2; i++) {
      arr2[i] = in.nextInt();
    }


    mergeArrays(arr1, arr2, n1, n2, res);

    System.out.println("Array after merging");
    for (int i=0; i < n1+n2; i++)
      System.out.print(res[i] + " ");
  }
}

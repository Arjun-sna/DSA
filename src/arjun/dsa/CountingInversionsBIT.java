/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author arjun
 */
public class CountingInversionsBIT {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    for (int i = 0; i < t; i++) {
      int n = in.nextInt(), ele;
      ArrayList<Integer> ar = new ArrayList<>(Collections.nCopies(n + 1, 0));
      ArrayList<Integer> temp = new ArrayList<>(Collections.nCopies(n + 1, 0));
      for (int j = 1; j <= n; j++) {
        ele = in.nextInt();
        System.out.println(j + " insert " + ele);
        ar.add(j, ele);
        temp.add(j, ele);
      }
      long c = countInversions(ar, temp, n);
      System.out.println(c);
    }
  }

  public static int countInversions(ArrayList<Integer> arr, ArrayList<Integer> temp, int n) {
    int invCount = 0;

    convert(arr, temp, n);

    ArrayList<Integer> BIT = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      BIT.add(0);
    }

    for (int k = n - 1; k >= 0; k--) {
      invCount += getSum(BIT, arr.get(k) - 1);
      System.out.println("dd " + invCount);
      updateBIT(BIT, n, arr.get(k), 1);
    }
    return invCount;
  }

  public static int getSum(ArrayList<Integer> BIT, int index) {
    int sum = 0;

    while (index > 0) {
      sum += BIT.get(index);

      index -= index & (-index);
    }
    return sum;
  }

  public static void updateBIT(ArrayList<Integer> BIT, int n, int index, int val) {
    while (index <= n) {
      System.out.println("update " + index);
      BIT.set(index, BIT.get(index) + val);
      index += index & (-index);
    }
  }

  public static void convert(ArrayList<Integer> arr, ArrayList<Integer> temp, int n) {
    //        for (int l : temp) {
    //            System.out.print(l + " ");
    //        }
    //        for (int l : arr) {
    //            System.out.print(l + " ");
    //        }

    temp.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });
    for (int l : temp) {
      System.out.print(l + " ");
    }
    for (int i = 1; i <= n; i++) {
      arr.set(i, temp.indexOf(arr.get(i)));
    }
  }
}

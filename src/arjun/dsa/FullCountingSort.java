/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author arjun
 */
public class FullCountingSort {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(in.readLine());
    int[] arr = new int[n];
    int[] freq = new int[100];
    int[] helper = new int[100];
    StringBuilder[] sorted = new StringBuilder[n];
    StringBuilder[] data = new StringBuilder[n];
    for (int i = 0; i < n; i++) {
      String[] tmp = in.readLine().split(" ");
      int e = Integer.parseInt(tmp[0]);
      String s = tmp[1];
      arr[i] = e;
      data[i] = new StringBuilder(s.trim());
      freq[e] = freq[e] + 1;
    }
    int count = 0;
    for (int k = 0; k < 100; k++) {
      helper[k] = count;
      count += freq[k];
    }
    for (int val = 0; val < n; val++) {
      int k = arr[val];
      StringBuilder s;
      if (val < n / 2) {
        s = new StringBuilder("-");
      } else {
        s = data[val];
      }
      sorted[helper[k]] = s;
      helper[k] += 1;
    }

    for (StringBuilder s : sorted) {
      System.out.print(s + " ");
    }
  }
}

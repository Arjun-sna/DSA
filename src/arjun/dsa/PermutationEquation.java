/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author arjun
 */
public class PermutationEquation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), i;
    ArrayList<Integer> arr = new ArrayList<>();
    for (i = 1; i <= n; i++) {
      arr.add(in.nextInt());
    }
    for (i = 1; i <= n; i++) {
      int ind = arr.indexOf(i) + 1;
      //            System.out.println("ind " + ind + " i " + arr.indexOf(ind));
      System.out.println(arr.indexOf(ind) + 1);
    }
  }
}

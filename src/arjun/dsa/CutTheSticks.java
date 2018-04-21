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
public class CutTheSticks {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    ArrayList<Integer> sticks = new ArrayList<>();
    int currMin = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int ele = in.nextInt();
      sticks.add(ele);
      if (currMin > ele) {
        currMin = ele;
      }
    }
    int currentSize = sticks.size();
    int loopmin = currMin;
    while (currentSize > 0) {
      System.out.println(currentSize);
      for (int i = 0; i < sticks.size(); i++) {
        if (sticks.get(i) == 0) continue;
        int newval = sticks.get(i) - currMin;
        if (newval == 0) {
          currentSize--;
        } else if (newval < loopmin) {
          loopmin = newval;
        }
      }
      System.out.println("min " + loopmin);
      currMin = loopmin;
    }
  }
}

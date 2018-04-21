/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa.DP;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author arjun
 */
public class TripleSteps {
  static HashMap<Integer, Integer> memization = new HashMap<>();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int totalStep = in.nextInt();
    int totalCount = findAllPossibleWays(totalStep);
    System.out.println("Total " + totalCount);
  }

  private static int findAllPossibleWays(int steps) {
    if (memization.containsKey(steps)) {
      return memization.get(steps);
    }
    if (steps < 0) {
      return 0;
    } else if (steps == 0) {
      return 1;
    } else {
      int result =
          findAllPossibleWays(steps - 1) + findAllPossibleWays(steps - 2) + findAllPossibleWays(
              steps - 3);
      memization.put(steps, result);
      return result;
    }
  }
}

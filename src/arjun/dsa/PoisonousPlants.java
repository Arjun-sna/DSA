/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author arjun
 */
public class PoisonousPlants {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] plants = new int[n];
    for (int i = 0; i < n; i++) {
      plants[i] = in.nextInt();
    }
    Stack<Plant> ps = new Stack<>();
    ps.push(new Plant(0, -1));
    int maxDaysToDie = -1;

    for (int i = 1; i < n; i++) {
      int dayToDie = 1;
      while (!ps.isEmpty()) {
        if (plants[ps.peek().plantId] >= plants[i]) {
          dayToDie = Math.max(dayToDie, ps.peek().daysToDie + 1);
          ps.pop();
        } else {
          break;
        }
      }
      if (ps.isEmpty()) {
        dayToDie = -1;
      }
      maxDaysToDie = Math.max(maxDaysToDie, dayToDie);
      ps.push(new Plant(i, dayToDie));
    }

    System.out.println(maxDaysToDie < 0 ? 0 : maxDaysToDie);
  }

  public static class Plant {
    int plantId;
    int daysToDie;

    public Plant(int i, int j) {
      plantId = i;
      daysToDie = j;
    }
  }
}

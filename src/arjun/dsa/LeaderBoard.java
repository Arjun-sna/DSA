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
public class LeaderBoard {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    ArrayList<Integer> scores = new ArrayList<>();
    ArrayList<Integer> ranks = new ArrayList<>();
    int prev = 0, rank = 1;
    for (int scores_i = 0; scores_i < n; scores_i++) {
      int score = in.nextInt();
      if (prev != score) {
        prev = score;
        scores.add(score);
        ranks.add(rank);
        rank++;
      }
    }
    int m = in.nextInt();
    int[] alice = new int[m];
    int k = scores.size() - 1;
    for (int alice_i = 0; alice_i < m; alice_i++) {
      int currentScore = in.nextInt();
      int index = 0, curRank = 0;
      if (currentScore < prev) {
        System.out.println(rank);
        continue;
      }
      if (k < 0) {
        System.out.println(1);
        continue;
      }
      for (; k >= 0; k--) {
        if (scores.get(k) <= currentScore) {
          curRank = ranks.get(scores.indexOf(scores.get(k)));
        } else {
          break;
        }
      }
      System.out.println(curRank);
    }
  }
}

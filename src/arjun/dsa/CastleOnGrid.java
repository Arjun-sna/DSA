/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author arjun
 */
public class CastleOnGrid {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int grid = in.nextInt();
    Node[][] matrix = new Node[grid][grid];
    Deque<Node> q = new ArrayDeque<Node>();
    for (int i = 0; i < grid; i++) {
      for (int j = 0; j < grid; j++) {
        Node n = new Node();
        char c = in.nextLine().charAt(0);
        n.turnVal = 0;
        n.isAvailable = c == '.';
        matrix[i][j] = n;
      }
    }
    Node start = matrix[in.nextInt()][in.nextInt()];
    Node end = matrix[in.nextInt()][in.nextInt()];
    q.addFirst(start);
    while (!q.isEmpty()) {
      Node current = q.getFirst();
    }
  }

  static class Node {
    int turnVal;
    boolean isAvailable;
    int x, y;
  }
}

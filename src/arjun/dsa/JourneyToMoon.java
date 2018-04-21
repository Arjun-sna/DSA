/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author arjun
 */
public class JourneyToMoon {
  static Map<Integer, Node> sets = new HashMap<>();

  static class Node {
    int data;
    int rank;
    int memberCount;
    Node parent;

    public Node() {

    }

    public Node(int data, int rank, int memberCount) {
      this.data = data;
      this.rank = rank;
      this.memberCount = memberCount;
    }
  }

  public static Node findSet(Node n) {
    Node temp = n;
    while (n.parent != n) {
      n = n.parent;
    }
    temp.parent = n;
    return n;
  }

  public static void merge(int n1, int n2) {
    Node p1 = findSet(sets.get(n1));
    Node p2 = findSet(sets.get(n2));
    if (p1 == p2) {
      return;
    }
    if (p1.rank >= p2.rank) {
      p2.parent = p1;
      p1.memberCount += p2.memberCount;
      p1.rank = p1.rank == p2.rank ? p1.rank + 1 : p1.rank;
    } else {
      p1.parent = p2;
      p2.memberCount += p1.memberCount;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int nodes = in.nextInt();
    int pairs = in.nextInt();
    for (int i = 0; i < nodes; i++) {
      Node n = new Node(i, 0, 1);
      n.parent = n;
      sets.put(i, n);
    }

    for (int i = 0; i < pairs; i++) {
      merge(in.nextInt(), in.nextInt());
    }

    long sum = 0, allparis = 0;
    for (Node node : sets.values()) {
      if (node.parent == node) {
        if (sum == 0) {
          sum += node.memberCount;
          continue;
        }
        allparis += sum * node.memberCount;
        sum += node.memberCount;
      }
    }
    System.out.println(allparis);
  }
}

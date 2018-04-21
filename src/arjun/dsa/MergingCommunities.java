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
public class MergingCommunities {

  static Map<Integer, Node> memberMap = new HashMap<>();

  private static int findSize(int k) {
    Node n = memberMap.get(k);
    Node set = findSet(n);
    return set.memberCount;
  }

  private static Node findSet(Node n) {
    Node temp = n;
    Node parent = n.parent;
    while (n != parent) {
      n = parent;
      parent = n.parent;
    }
    temp.parent = n;
    return n;
  }

  private static void merge(int c1, int c2) {
    Node n1 = findSet(memberMap.get(c1));
    Node n2 = findSet(memberMap.get(c2));
    if (n1 == n2) {
      return;
    }
    if (n1.rank >= n2.rank) {
      n2.parent = n1;
      n1.memberCount += n2.memberCount;
      n1.rank = n1.rank == n2.rank ? n1.rank + 1 : n1.rank;
    } else {
      n1.parent = n2;
      n2.memberCount += n1.memberCount;
    }
  }

  static class Node {
    int data;
    Node parent;
    int rank;
    int memberCount;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int totalMembers = in.nextInt();
    int q = in.nextInt();
    for (int i = 1; i <= totalMembers; i++) {
      Node n = new Node();
      n.data = 1;
      n.parent = n;
      n.memberCount = 1;
      n.rank = 0;
      memberMap.put(i, n);
    }
    for (int i = 0; i < q; i++) {
      char qtype = in.next().charAt(0);
      switch (qtype) {
        case 'Q':
          int k = in.nextInt();
          System.out.println(findSize(k));
          break;
        case 'M':
          int c1 = in.nextInt(), c2 = in.nextInt();
          merge(c1, c2);
      }
    }
  }
}

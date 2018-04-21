/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author arjun
 */
public class ComponentsInGraph {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int total = n * 2;
    for (int i = 1; i <= total; i++) {
      Node node = new Node();
      node.data = i;
      node.parent = node;
      node.memberCount = 1;
      node.rank = 0;
      memberMap.put(i, node);
    }
    int min = Integer.MAX_VALUE, max = 1;
    Set<Integer> al = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int v1 = in.nextInt(), v2 = in.nextInt();
      Node set = merge(v1, v2);
      al.add(set.data);
    }
    for (Integer p : al) {
      if (memberMap.get(p).parent != memberMap.get(p)) {
        continue;
      }
      if (memberMap.get(p).memberCount > max) {
        max = memberMap.get(p).memberCount;
      }
      if (memberMap.get(p).memberCount < min) {
        min = memberMap.get(p).memberCount;
      }
    }
    System.out.println(min + " " + max);
  }

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

  private static Node merge(int c1, int c2) {
    Node n1 = findSet(memberMap.get(c1));
    Node n2 = findSet(memberMap.get(c2));
    if (n1 == n2) {
      return n1;
    }
    if (n1.rank >= n2.rank) {
      n2.parent = n1;
      n1.memberCount += n2.memberCount;
      n1.rank = n1.rank == n2.rank ? n1.rank + 1 : n1.rank;
      return n1;
    } else {
      n1.parent = n2;
      n2.memberCount += n1.memberCount;
      return n2;
    }
  }

  static class Node {
    int data;
    Node parent;
    int rank;
    int memberCount;
  }
}

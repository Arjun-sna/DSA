/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa.linkedlist;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author arjun
 */
public class ReturnKth {
  private static class Node {
    int val;
    Node next;
  }

  public static void main(String[] args) {
    ArrayList<Integer> inp = new ArrayList<>();
    Random r = new Random();
    for (int i = 1; i <= 100; i++) {
      inp.add(r.nextInt(100));
    }
    Node prev = null, head = null;
    for (int i = 0; i < inp.size() - 1; i++) {
      Node n = new Node();
      n.val = inp.get(i);
      if (prev == null) {
        head = n;
      } else {
        prev.next = n;
      }
      prev = n;
    }
    Node kth = returnKthElement(head, 4);
    Node kth2 = returnKthElement(head, new Index(), 4);
    System.out.println(kth.val + " " + kth2.val);
  }

  public static Node returnKthElement(Node n, int k) {
    Node p1 = n, p2 = n;
    for (int i = 1; i < k; i++) {
      p2 = p2.next;
    }
    while (p2.next != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    return p1;
  }

  static class Index {
    int val = 0;
  }

  public static Node returnKthElement(Node n, Index idx, int k) {
    if (n == null) {
      return n;
    }
    Node node = returnKthElement(n.next, idx, k);
    idx.val += 1;
    if (idx.val == k) {
      return n;
    }
    return node;
  }
}

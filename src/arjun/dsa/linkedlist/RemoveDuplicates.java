/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * @author arjun
 */
public class RemoveDuplicates {
  private static class Node {
    int val;
    Node next;
  }

  public static void main(String[] args) {
    int[] array = new int[] {1, 5, 6, 6, 8, 1, 4, 3, 7, 2};
    ArrayList<Integer> inp = new ArrayList<>();
    Random r = new Random();
    for (int i = 0; i < 10000000; i++) {
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
    System.out.println(System.currentTimeMillis());
    //        removeDuplicates(head);
    removeDuplicatesNoExtraSpace(head);
    System.out.println(System.currentTimeMillis());
    Node n = head;
    while (n != null) {
      System.out.print(n.val + " ");
      n = n.next;
    }
  }

  private static void removeDuplicates(Node n) {
    HashSet<Integer> duplicateTestSet = new HashSet<>();
    Node prev = n;
    while (n != null) {
      if (duplicateTestSet.contains(n.val)) {
        prev.next = n.next;
      } else {
        duplicateTestSet.add(n.val);
        prev = n;
      }
      n = n.next;
    }
  }

  private static void removeDuplicatesNoExtraSpace(Node n) {
    Node p1 = n, p2;
    while (p1 != null) {
      p2 = p1.next;
      Node prev = p1;
      while (p2 != null) {
        if (p1.val == p2.val) {
          prev.next = p2.next;
        } else {
          prev = p2;
        }
        p2 = p2.next;
      }
      p1 = p1.next;
    }
  }
}

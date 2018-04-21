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
public class DeleteMiddleElement {
  private static class Node {
    int val;
    Node next;
  }

  public static void main(String[] args) {
    ArrayList<Integer> inp = new ArrayList<>();
    Random r = new Random();
    for (int i = 1; i <= 10; i++) {
      inp.add(r.nextInt(100));
    }
    Node prev = null, head = null, middle = null;
    for (int i = 0; i < inp.size() - 1; i++) {
      Node n = new Node();
      n.val = inp.get(i);
      if (prev == null) {
        head = n;
      } else {
        prev.next = n;
      }
      if (i == inp.size() / 2) {
        middle = n;
      }
      prev = n;
    }
    Node nb = head;
    while (nb != null) {
      System.out.print(nb.val + " ");
      nb = nb.next;
    }
    deleteThisNode(middle);
    Node n = head;
    System.out.println("");
    while (n != null) {
      System.out.print(n.val + " ");
      n = n.next;
    }
  }

  private static void deleteThisNode(Node n) {
    n.val = n.next.val;
    n.next = n.next.next;
  }
}

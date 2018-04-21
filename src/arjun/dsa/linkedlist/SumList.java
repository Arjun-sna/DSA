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
public class SumList {
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
    Node prev = null, head1 = null;
    for (int i = 0; i < inp.size() - 1; i++) {
      Node n = new Node();
      n.val = inp.get(i);
      if (prev == null) {
        head1 = n;
      } else {
        prev.next = n;
      }
      prev = n;
    }
    prev = null;
    Node head2 = null;
    for (int i = 0; i < inp.size() - 1; i++) {
      Node n = new Node();
      n.val = inp.get(i);
      if (prev == null) {
        head2 = n;
      } else {
        prev.next = n;
      }
      prev = n;
    }
    Node result, n1 = head1, n2 = head2;
    int carry = 0;
    while (n1 != null || n2 != null) {

    }
  }
}

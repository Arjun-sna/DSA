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
public class Contacts {
  static class Node {
    Map<Character, Node> charMap;
    boolean isEnd;
    int count;

    public Node() {
      charMap = new HashMap<>();
      isEnd = false;
      count = 0;
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    s.nextLine();
    Node root = new Node();
    for (int i = 0; i < n; i++) {
      String op[] = s.nextLine().split(" ");

      if (op[0].equals("add")) {
        insertWord(root, op[1]);
      } else {
        System.out.println(find(root, op[1]));
      }
    }
  }

  public static void insertWord(Node root, String word) {
    Node current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      Node n = current.charMap.get(ch);
      if (n == null) {
        n = new Node();
        current.charMap.put(ch, n);
      }
      n.count++;
      current = n;
    }
    current.isEnd = true;
  }

  public static int find(Node root, String word) {
    Node currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      Node n = currNode.charMap.get(ch);
      if (n == null) {
        return 0;
      }
      currNode = n;
    }
    return currNode == null ? 0 : currNode.count;
  }

  //    public static int find(Node root, String word) {
  //        Node current = root;
  //        for (int i = 0; i < word.length(); i++) {
  //            char ch = word.charAt(i);
  //            Node n = current.charMap.get(ch);
  //            if (n == null) {
  //                return 0;
  //            }
  //            current = n;
  //        }
  //        return findStringEnds(current);
  //    }
  //
  //    public static int findStringEnds(Node current) {
  //        int count = 0;
  //        if (current.isEnd) count++;
  //        for (Node n : current.charMap.values()) {
  //            count += findStringEnds(n);
  //        }
  //        return count;
  //    }
}

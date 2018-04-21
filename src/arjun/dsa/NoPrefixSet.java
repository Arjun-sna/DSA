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
public class NoPrefixSet {
  static class Node {
    Map<Character, Node> charMap;
    boolean isEnd;

    public Node() {
      charMap = new HashMap<>();
      isEnd = false;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    Node root = new Node();
    for (int i = 0; i < n; i++) {
      String word = in.nextLine();
      if (!insertWord(root, word)) {
        System.out.println("BAD SET");
        System.out.println(word);
        return;
      }
    }
    System.out.println("GOOD SET");
  }

  public static boolean insertWord(Node root, String word) {
    Node current = root;
    boolean isSubset = false;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      Node n = current.charMap.get(ch);
      if (n == null) {
        isSubset = true;
        n = new Node();
        current.charMap.put(ch, n);
      } else if (n.isEnd) {
        return false;
      }
      current = n;
    }
    current.isEnd = true;
    return isSubset;
  }
}

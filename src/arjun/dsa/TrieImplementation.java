package arjun.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrieImplementation {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String[] dict = new String[n];

    String[] dictItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      String genesItem = dictItems[i];
      dict[i] = genesItem;
    }

    String wordToSearch = scanner.nextLine();

    Trie trie = new Trie();
    for (String word : dict) {
      trie.insertWord(word);
    }

    System.out.println(trie.isAWord(wordToSearch));

    scanner.close();
  }

  public static class Trie {
    public TrieNode root;
    private class TrieNode {
      //Map<Character, TrieNode> children;
      TrieNode[] children;
      boolean isEndOfWord = false;

      public TrieNode() {
        //children = new HashMap<>();
        children = new TrieNode[26];
      }
    }

    public Trie() {
      root = new TrieNode();
    }

    public void insertWord(String word) {
      TrieNode currentNode = root;
      for (int i = 0; i < word.length(); i++) {
        char currentChar = word.charAt(i);
        int index = currentChar - 'a';
        TrieNode node = currentNode.children[index];
        if (node == null) {
          node = new TrieNode();
          currentNode.children[index] = node;
        }
        currentNode = node;
      }
      currentNode.isEndOfWord = true;
    }

    public boolean isAWord(String word) {
      TrieNode currentNode = root;
      for (char c : word.toCharArray()) {
        int index = c - 'a';
        TrieNode node = currentNode.children[index];
        if (node == null) {
          return false;
        }
        currentNode = node;
      }
      return currentNode.isEndOfWord;
    }
  }
}


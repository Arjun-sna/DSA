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
public class RansomNote {
  Map<String, Integer> magazineMap;
  Map<String, Integer> noteMap;

  public RansomNote(String magazine, String note) {
    magazineMap = new HashMap<>();
    for (String word : magazine.split(" ")) {
      if (magazineMap.containsKey(word)) {
        magazineMap.put(word, magazineMap.get(word) + 1);
      } else {
        magazineMap.put(word, 1);
      }
    }

    noteMap = new HashMap<>();
    for (String word : note.split(" ")) {
      if (noteMap.containsKey(word)) {
        noteMap.put(word, noteMap.get(word) + 1);
      } else {
        noteMap.put(word, 1);
      }
    }
  }

  public boolean solve() {
    for (String word : noteMap.keySet()) {
      System.out.print("Wo " + word);
      if (magazineMap.containsKey(word)) {
        System.out.println(" con " + word);
        if (!(noteMap.get(word) <= magazineMap.get(word))) {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();

    // Eat whitespace to beginning of next line
    scanner.nextLine();

    RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
    scanner.close();

    boolean answer = s.solve();
    if (answer) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}

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
public class SparseArray {
  public static void main(String[] arg) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    Map<String, Integer> stringsMap = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      String s = in.nextLine();
      Integer value = stringsMap.get(s);
      stringsMap.put(s, value == null ? 1 : ++value);
    }
    int q = in.nextInt();
    in.nextLine();
    for (int j = 0; j < q; j++) {
      String query = in.nextLine();
      int count = stringsMap.containsKey(query) ? stringsMap.get(query) : 0;
      System.out.println(count);
    }
  }
}

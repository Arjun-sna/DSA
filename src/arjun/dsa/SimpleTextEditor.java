/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author arjun
 */
public class SimpleTextEditor {
  public static void main(String[] args) {
    String s = "";
    Scanner in = new Scanner(System.in);
    int ops = in.nextInt();
    ArrayList<String> lastopss = new ArrayList<>();
    for (int i = 0; i < ops; i++) {
      switch (in.nextInt()) {
        case 1:
          String append = in.next();
          lastopss.add(s);
          s = s + append;
          break;
        case 2:
          int k = in.nextInt();
          lastopss.add(s);
          s = s.substring(0, s.length() - k);
          break;
        case 3:
          System.out.println(s.charAt(in.nextInt() - 1));
          break;
        case 4:
          String lastOpString = lastopss.get(lastopss.size() - 1);
          s = lastOpString;
          lastopss.remove(lastopss.size() - 1);
      }
    }
  }
}   

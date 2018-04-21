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
public class PasswordCracker {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      int pwds = in.nextInt();
      in.nextLine();
      ArrayList<String> words = new ArrayList<>();
      int minLength = Integer.MAX_VALUE;
      for (int j = 0; j < pwds; j++) {
        String ps = (String) in.next();
        minLength = ps.length() < minLength ? ps.length() : minLength;
        words.add(ps);
      }
      in.nextLine();
      String orginal = in.nextLine();
      int start = 0, end = 1;
      StringBuilder output = new StringBuilder();
      boolean allfound = false;
      while (end <= orginal.length()) {
        //                System.out.println(orginal.substring(start, end));
        if (words.contains(orginal.substring(start, end))) {
          end = checkMoreWords(start, end, orginal, words);
          output.append(orginal.substring(start, end)).append(" ");
          start = end;
          if (end == orginal.length()) {
            allfound = true;
          }
        }
        end++;
      }
      System.out.println(allfound ? output : "WRONG PASSWORD");
    }
  }

  public static int checkMoreWords(int start, int end, String orginal, ArrayList<String> words) {
    int lend = end + 1;
    boolean found = false;
    while (lend <= orginal.length()) {
      if (words.contains(orginal.substring(start, lend))) {
        found = true;
        lend = checkMoreWords(start, lend, orginal, words);
        break;
      }
      lend++;
    }
    return found ? lend : end;
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.Scanner;

/**
 * @author arjun
 */
public class PalindromeIndex {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    for (int i = 0; i < n; i++) {
      String s = in.nextLine();
      int end = s.length() - 1;
      boolean p = true;
      for (int idx = 0; idx < s.length() / 2; idx++) {
        if (s.charAt(idx) == s.charAt(end)) {
          end--;
          continue;
        }
        p = false;
        if (isPalindrome(s, idx, end - 1)) {
          System.out.println(end);
        } else {
          System.out.println(idx);
        }

        //
        //                if(s.charAt(idx) == s.charAt(end -1)) {
        //                    System.out.println(end);
        //                } else {
        //                    System.out.println(idx);
        //                }
        break;
      }
      if (p) {
        System.out.println("-1");
      }
    }
  }

  public static boolean isPalindrome(String s, int start, int end) {
    boolean isP = true;
    for (; start <= (start + end) / 2; start++, end--) {
      if (s.charAt(start) != s.charAt(end)) {
        isP = false;
        break;
      }
    }

    return isP;
  }
}

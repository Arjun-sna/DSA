/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa.DP;

import java.util.ArrayList;

/**
 * @author arjun
 */
public class Parens {
  public static void main(String[] args) {
    generateParens(3).forEach(string -> System.out.println(string));
  }

  static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str,
      int index) {
    System.out.println(" " + leftRem + " " + rightRem + " ");
    for (char c : str) {
      System.out.print(c);
    }
    System.out.println("");
    if (leftRem < 0 || rightRem < leftRem) return;// invalid state
    if (leftRem == 0 && rightRem == 0) {/*Out of left and right parentheses */
      list.add(String.copyValueOf(str));
    } else {
      str[index] = '(';
      addParen(list, leftRem - 1, rightRem, str, index + 1);
      str[index] = ')'; // Add right and recurse
      addParen(list, leftRem, rightRem - 1, str, index + 1);
    }
  }

  static ArrayList<String> generateParens(int count) {
    char[] str = new char[count * 2];
    ArrayList<String> list = new ArrayList<String>();
    addParen(list, count, count, str, 0);
    return list;
  }
}

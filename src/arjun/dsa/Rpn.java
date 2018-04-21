/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author arjun
 */
public class Rpn {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    for (int i = 0; i < n; i++) {
      String exp = in.nextLine();
      Stack<Character> characters = new Stack<>();
      int index = 0;
      while (index < exp.length()) {
        if (isVariale(exp.charAt(index))) {
          System.out.print(exp.charAt(index));
          index++;
          continue;
        }
        if ((int) exp.charAt(index) == 41) {
          while ((int) characters.peek() != 40) {
            System.out.print(characters.pop());
          }
          characters.pop();
        } else {
          characters.push(exp.charAt(index));
        }
        index++;
      }
      System.out.println("");
    }
  }

  private static boolean isVariale(char c) {
    return (int) c >= 97 && ((int) c <= 122);
  }
}

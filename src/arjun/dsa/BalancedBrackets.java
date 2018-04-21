/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author arjun
 */
public class BalancedBrackets {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    Stack<Integer> stack = new Stack<Integer>();
    Map<Integer, Integer> bracketMap = new HashMap() {{
      put((int) '{', (int) '}');
      put((int) '(', (int) ')');
      put((int) '[', (int) ']');
    }};
    //        System.err.println((int)'{' + " " + (int)'(' + " " + (int)'[' + " " + (int)']' + " " + (int)')' + " " + (int)'}');
    for (int i = 0; i < t; i++) {
      String s = in.next();
      stack.clear();
      int index = 0;
      while (index < s.length()) {
        if (stack.isEmpty() || bracketMap.get(stack.peek()) != (int) s.charAt(index)) {
          stack.push((int) s.charAt(index));
          if (!bracketMap.containsKey((int) s.charAt(index))) {
            break;
          }
        } else {
          stack.pop();
        }
        index++;
      }
      System.out.println(stack.isEmpty() ? "YES" : "NO");
    }
  }
}

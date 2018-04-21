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
public class GradingStudents {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int a0 = 0; a0 < n; a0++) {
      int grade = in.nextInt();
      if (grade < 38) {
        System.out.println(grade);
        continue;
      }
      int diff = 5 - (grade % 5);
      if (diff < 3) {
        System.out.println(grade + diff);
      } else {
        System.out.println(grade);
      }
    }
  }
}

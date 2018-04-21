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
public class TwoDArray {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[][] matrix = new int[6][6];
    int maxSum = 0, currentSum = 0;
    int i, j;
    for (i = 0; i < 6; i++) {
      for (j = 0; j < 6; j++) {
        matrix[i][j] = in.nextInt();
      }
    }
    for (i = 0; i <= 3; i++) {
      for (j = 0; j <= 3; j++) {
        currentSum = 0;
        for (int k = i; k < i + 3; k += 2) {
          for (int l = j; l < j + 3; l++) {
            currentSum += matrix[k][l];
          }
        }
        currentSum += matrix[i + 1][j + 1];
        maxSum = currentSum > maxSum ? currentSum : maxSum;
      }
    }
    System.out.println(maxSum);
  }
}

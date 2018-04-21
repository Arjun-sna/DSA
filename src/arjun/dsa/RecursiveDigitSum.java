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
public class RecursiveDigitSum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String n = in.next();
    long sum = 0;
    for (int i = 0; i < n.length(); i++) {
      sum += n.charAt(i) - '0';
    }
    long k = in.nextLong();
    long superdigit = findSuperDigitSum(sum * k);
    System.out.println(superdigit);
  }

  public static long findSuperDigitSum(long val) {

    if (findDigitCount(val) == 1) {
      return val;
    } else {
      int newVal = 0;
      while (val > 0) {
        newVal += val % 10;
        val = val / 10;
      }
      return findSuperDigitSum(newVal);
    }
  }

  public static long findSum(long n) {
    long sum = 0;
    while (n > 0) {
      sum += n % 10;
      n = n / 10;
    }
    return sum;
  }

  public static long findDigitCount(long n) {
    long count = 0;
    while (n > 0) {
      count++;
      n = n / 10;
    }
    return count;
  }
}

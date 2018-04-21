/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author arjun
 */
public class BigFactorial {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    BigInteger n = in.nextBigInteger();
    System.out.println(factorial(n));
  }

  public static BigInteger factorial(BigInteger n) {
    if (n.equals(BigInteger.ONE)) {
      return BigInteger.ONE;
    } else {
      return factorial(n.subtract(BigInteger.ONE)).multiply(n);
    }
  }
}

package arjun.dsa.DP;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class ModifiedFibonacci {
  private static HashMap<Integer, BigInteger> memoize = new HashMap<>();
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    BigInteger t1 = BigInteger.valueOf(in.nextInt());
    BigInteger t2 = BigInteger.valueOf(in.nextInt());
    int n = in.nextInt();
    BigInteger nthTerm = computeFibonacci(t1, t2, n);
    System.out.println("Nth term " + nthTerm);
  }

  private static BigInteger computeFibonacci(BigInteger t1, BigInteger t2, int n) {
    if (n == 1) {
      return t1;
    }
    if (n == 2) {
      return t2;
    }
    if (memoize.containsKey(n)) {
      return memoize.get(n);
    }
    BigInteger adj1 = computeFibonacci(t1, t2, n - 1);
    BigInteger adj2 = computeFibonacci(t1, t2, n - 2);
    BigInteger res = adj1.multiply(adj1).add(adj2);
    memoize.put(n, res);
    return res;
  }
}

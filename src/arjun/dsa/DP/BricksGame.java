package arjun.dsa.DP;

import java.util.HashMap;
import java.util.Scanner;

public class BricksGame {
  static HashMap<Integer, Integer> memoize  = new HashMap<>();
  public static void main(String[] args) {
    Scanner in  = new Scanner(System.in);
    int bricksCount = in.nextInt();
    int sum = 0;
    int[] bricksArray = new int[bricksCount];
    for (int i = 0; i < bricksCount; i++) {
      int input = in.nextInt();
      sum += input;
      bricksArray[i] = input;
    }
    int value = bricksGame(bricksArray, sum, bricksCount);
    System.out.println("Result  " + value);
  }

  public static int bricksGame(int[] bricks, int sum, int n) {
    return f(bricks, n, sum);
  }

  public static int f(int[] bricks, int n, int sum) {
    if (n == 1) {
      return sum - bricks[bricks.length - n];
    }

    if (n == 2) {
      return sum - bricks[bricks.length - n] + bricks[bricks.length - n + 1];
    }

    if (n == 3) {
      return sum - bricks[bricks.length - n] + bricks[bricks.length - n + 1] + bricks[bricks.length - n + 2];
    }

    if (memoize.containsKey(n)) {
      return memoize.get(n);
    }
    sum = sum - bricks[bricks.length - n];
    int max = Math.max(sum - f(bricks, n - 1, sum),
        Math.max(sum - f(bricks, n - 2, sum), sum - f(bricks, n - 3, sum)));
    memoize.put(n, max);
    return max;
  }
}

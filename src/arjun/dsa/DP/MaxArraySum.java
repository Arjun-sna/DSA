package arjun.dsa.DP;

import java.util.Scanner;

public class MaxArraySum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    int[] dp = new int[n];

    dp[0] = arr[0];
    dp[1] = Math.max(arr[0], arr[1]);

    for (int i = 2; i < n; i++) {
      dp[i] = Math.max(Math.max(arr[i], dp[i - 1]), dp[i - 2] + arr[i]);
    }

    System.out.println(dp[n - 1]);
  }
}

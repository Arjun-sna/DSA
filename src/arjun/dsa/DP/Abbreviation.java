package arjun.dsa.DP;

import java.io.IOException;
import java.util.Scanner;

public class Abbreviation {
  static int[][] dp;
  static boolean canAbbreviate(String a, String b) {
    int aLength = a.length(), bLength = b.length();

    boolean result = false;
    if (aLength == 0 && bLength == 0) {
      result = true;
    } else if (aLength == 0) {
      result = false;
    } else if (bLength == 0) {
      result = (a.charAt(a.length() - 1) >= 97 &&  a.charAt(a.length() - 1) <= 122)
          && canAbbreviate(a.substring(0, aLength - 1), b);
    } else if (dp[aLength][bLength] != 0) {
      return dp[aLength][bLength] == 1;
    }

    else if (a.charAt(a.length() - 1) == (int) b.charAt(b.length() - 1)) {
      result = canAbbreviate(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1));
    } else if (a.charAt(a.length() - 1) - (int) b.charAt(b.length() - 1) == 32) {
      result = canAbbreviate(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1)) ||
          canAbbreviate(a.substring(0, a.length() - 1), b);
    } else if ((a.charAt(a.length() - 1) >= 97 &&  a.charAt(a.length() - 1) <= 122)) {
      result = canAbbreviate(a.substring(0, a.length() - 1), b);
    }
    dp[a.length()][b.length()] = result ? 1 : -1;
    return result;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String a = scanner.nextLine();

      String b = scanner.nextLine();
      dp = new int[a.length() + 1][b.length() + 1];

      boolean result = canAbbreviate(a, b);
      System.out.println(result ? "YES" : "NO");

      //bufferedWriter.write(result);
      //bufferedWriter.newLine();
    }

    //bufferedWriter.close();

    scanner.close();
  }
}

package arjun.dsa.DP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SherlockandCost {
  static int cost(int[] inputArray) {
    int low = 0, hi = 0;
    for (int i = 1; i < inputArray.length; i++) {
      int highToLow = Math.abs(inputArray[i - 1] - 1);
      int lowToHigh = Math.abs(inputArray[i] - 1);
      int highToHigh = Math.abs(inputArray[i - 1] - inputArray[i]);
      int lowNext = Math.max(low, hi + highToLow);
      int highNext = Math.max(hi + highToHigh, low + lowToHigh);
      low = lowNext;
      hi = highNext;
    }
    return Math.max(low, hi);
  }

  private static final Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) throws IOException {
    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = 1;//scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] B = new int[n];

      String[] BItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int BItem = Integer.parseInt(BItems[i]);
        B[i] = BItem;
      }

      int result = cost(B);

      System.out.println(result);
      //bufferedWriter.write(String.valueOf(result));
      //bufferedWriter.newLine();
    }

    //bufferedWriter.close();

    scanner.close();
  }
}

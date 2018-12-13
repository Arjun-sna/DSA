package arjun.dsa.DP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Candies {
  private static final Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) throws IOException {
    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      int arrItem = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      arr[i] = arrItem;
    }

    long result = candies(n, arr);

    System.out.println(result);

    //bufferedWriter.write(String.valueOf(result));
    //bufferedWriter.newLine();
    //
    //bufferedWriter.close();

    scanner.close();
  }
  static long candies(int n, int[] arr) {
    System.out.println(n);
    int[] resArr = new int[n];
    resArr[0] = 1;
    for (int i = 1; i < n; i++) {
      if (arr[i] > arr[i - 1]) {
        resArr[i] = resArr[i - 1] + 1;
      } else if (arr[i] <= arr[i - 1]) {
        resArr[i] = 1;
      }
    }
    //for (int i = 0; i < n; i++) {
    //  System.out.print(resArr[i] + " ");
    //}

    int count = 0;
    for (int i = n - 1; i > 0 ; i--) {
      if (resArr[i] == resArr[i - 1]) {
        if (arr[i] >= arr[i - 1]) {
          resArr[i]++;
        } else {
          resArr[i - 1]++;
        }
      }
      count += resArr[i];
    }
    count += resArr[0];
    //System.out.println();
    //for (int i = 0; i < n; i++) {
    //  System.out.print(resArr[i] + " ");
    //}
    //
    //int count = 0;
    //for (int i = 0; i < n; i++) {
    //  count += resArr[i];
    //}

    return count;
  }
}

package arjun.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumSwaps {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int res = minimumSwaps(arr);
    System.out.println(res);

    //bufferedWriter.write(String.valueOf(res));
    //bufferedWriter.newLine();
    //
    //bufferedWriter.close();

    scanner.close();
  }

  private static int minimumSwaps(int[] arr) {
    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      indexMap.put(arr[i], i);
    }
    for (int i = 0; i < arr.length; i++) {
      arr[i] = indexMap.get(i + 1);
    }
    int swaps = 0;
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      if (val < 0) continue;
      while (val != i) {
        int new_val = arr[val];
        arr[val] = -1;
        val = new_val;
        swaps++;
      }
      arr[i] = -1;
    }
    return swaps;
  }
}

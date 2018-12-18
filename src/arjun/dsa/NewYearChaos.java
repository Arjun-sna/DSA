package arjun.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.sound.midi.Soundbank;

public class NewYearChaos {
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

    findBribes(arr);

    scanner.close();
  }

  private static void findBribes(int[] arr) {
    int swaps = 0;
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] - (i + 1) > 2) {
        System.out.println("Too chaotic");
        return;
      }
      for (int j = Math.max(0, arr[i] - 2); j < i; j++) {
        if (arr[j] > arr[i]) swaps++;
      }
    }
    System.out.println(swaps);

  }
}

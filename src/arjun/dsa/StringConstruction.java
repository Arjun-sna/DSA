package arjun.dsa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringConstruction {
  static String isValid(String s) {
    Map<Integer, Integer> charArray = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (charArray.containsKey(c - 'a')) {
        charArray.put(c - 'a', charArray.get(c- 'a') + 1);
      } else {
        charArray.put(c - 'a', 1);
      }
    }

    boolean correctionDone = false;
    for (int i = 1; i < charArray.size(); i++) {
      if (charArray.get(i) == charArray.get(i - 1)) {
        continue;
      } else {
        if (correctionDone) {
          return "NO";
        }
        if (charArray.get(i) > charArray.get(i - 1)) {
          charArray.put(i, charArray.get(i) - 1);
        }
        correctionDone = true;
      }
    }

    // int invalidCount = 0;
    // Set<Integer> freqCount = new HashSet<>();
    // for (int i = 0; i < charArray.length; i++) {
    //     freqCount.add(charArray[0]);
    // }
    return "YES";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = scanner.nextLine();

    String result = isValid(s);
    System.out.println(result);
    //bufferedWriter.write(result);
    //bufferedWriter.newLine();
    //
    //bufferedWriter.close();

    scanner.close();
  }
}

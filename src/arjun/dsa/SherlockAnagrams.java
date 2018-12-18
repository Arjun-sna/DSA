package arjun.dsa;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAnagrams {

  // Complete the sherlockAndAnagrams function below.
  static int sherlockAndAnagrams(String s) {
    Map<Integer, ArrayList<String>> subStringMap = constructAnagramMap(s);
    int count = 0;
    for (ArrayList<String> subString : subStringMap.values()) {
      count += findAnagramCount(subString);
    }
    System.out.println(count);
    return count;
  }

  private static int findAnagramCount(ArrayList<String> subString) {
    int count = 0;
    for (int i = 0; i < subString.size() - 1; i++) {
      for (int j = i + 1; j < subString.size(); j++) {
        String s1 = subString.get(i);
        String s2 = subString.get(j);
        int[] boolarray = new int[26];
        for (char c : s1.toCharArray()) {
          ++boolarray[c - 'a'];
        }
        for (char c : s2.toCharArray()) {
          --boolarray[c - 'a'];
        }
        boolean isAnagram = true;
        for (int bool : boolarray) {
          if (bool != 0) {
            isAnagram = false;
            break;
          }
        }
        if (isAnagram) {
          count++;
        }
      }
    }
    return count;
  }

  private static Map<Integer, ArrayList<String>> constructAnagramMap(String s) {
    Map<Integer, ArrayList<String>> subStringMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      for (int j = 1 + i; j <= s.length(); j++) {
        String currentSubString = s.substring(i, j);
        int currentSubStringLength = currentSubString.length();
        if (!subStringMap.containsKey(currentSubStringLength)) {
          subStringMap.put(currentSubStringLength, new ArrayList<>());
        }
        subStringMap.get(currentSubStringLength).add(currentSubString);
      }
    }
    return subStringMap;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s = scanner.nextLine();

      int result = sherlockAndAnagrams(s);

      //bufferedWriter.write(String.valueOf(result));
      //bufferedWriter.newLine();
    }

    //bufferedWriter.close();

    scanner.close();
  }
}


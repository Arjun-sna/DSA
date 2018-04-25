package arjun.dsa.DP;

import java.util.Scanner;

/**
 * LCS Problem Statement: Given two sequences, find the length of longest 4
 * subsequence present in both of them. A subsequence is a sequence that appears
 * in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences
 */
public class LongestCommonSubsequence {
  public static void main(String[] args) {
    Scanner inputScanner = new Scanner(System.in);
    String str1 = inputScanner.nextLine();
    String str2 = inputScanner.nextLine();
    int result = findLCS(str1.toCharArray(), str2.toCharArray());
    System.out.println("LongestCommonSubsequence is " + result);
  }

  private static int findLCS(char[] str1, char[] str2) {
    int[][] dynamicTable = new int[str1.length + 1][str2.length + 1];
    int max = 0;
    for (int i = 1; i < dynamicTable.length; i++) {
      for (int j = 1; j < dynamicTable[i].length; j++) {
        if (str1[i - 1] == str2[j - 1]) {
          dynamicTable[i][j] = 1 + dynamicTable[i -1][j - 1];
        } else {
          dynamicTable[i][j] = Math.max(dynamicTable[i - 1][j], dynamicTable[i][j - 1]);
        }
        if (dynamicTable[i][j] > max) {
          max = dynamicTable[i][j];
        }
      }
    }
    printDynamicTable(dynamicTable);
    printTheSequence(dynamicTable, str1, str2, max);
    return max;
  }

  private static void printDynamicTable(int[][] dynamicTable) {
    System.out.println();
    for (int i = 0; i < dynamicTable.length; i++) {
      for (int j = 0; j < dynamicTable[i].length; j++) {
        System.out.print(dynamicTable[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void printTheSequence(int[][] dynamicTable, char[] str1, char[] str2, int max) {
    char[] sequence = new char[max];
    int sequenceIndex = max;
    for (int i = str1.length - 1, j = str2.length - 1; i >= 0 && j >= 0;) {
      if (str1[i] == str2[j]) {
        sequence[--sequenceIndex] = str1[i];
        i--;
        j--;
      } else if(j == 0 || dynamicTable[i - 1][j] < dynamicTable[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }
    for (char c : sequence) {
      System.out.print(c + " ");
    }
  }
}
  //addbad
  //fedad
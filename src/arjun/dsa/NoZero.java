package arjun.dsa;

import java.util.Scanner;

public class NoZero {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s1 = in.nextLine();
    String s2 = in.nextLine();
    int sum = Integer.parseInt(s1) + Integer.parseInt(s2);
    int nonZeroVal1 = getNonZeroValue(s1);
    int nonZeroVal2 = getNonZeroValue(s2);
    int nonZeroResult = getNonZeroValue(String.valueOf(sum));

    if (nonZeroVal1 + nonZeroVal2 == nonZeroResult) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }

  }

  public static int getNonZeroValue(String s) {
    String val = "";
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '0') {
        val = val + s.charAt(i);
      }
    }
    return Integer.parseInt(val);
  }
}

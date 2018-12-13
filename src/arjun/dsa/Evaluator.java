package arjun.dsa;

import java.util.Scanner;

public class Evaluator {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    char fractionPart = ' ';
    int numerator = 0, denominator = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == 'D' || input.charAt(i) == 'N') {
        fractionPart = input.charAt(i);
        continue;
      }
      if (fractionPart == 'N') {
        numerator += Integer.parseInt(String.valueOf(input.charAt(i)));
      } else {
        denominator += Integer.parseInt(String.valueOf(input.charAt(i)));
      }
    }
    System.out.println((int)Math.floor(numerator / denominator));
  }
}

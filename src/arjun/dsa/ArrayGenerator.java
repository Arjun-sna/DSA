package arjun.dsa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class ArrayGenerator {
  public static void main(String[] args) throws IOException {
    File inputFile = new File("input.txt");
    BufferedWriter writer = null;
    try {
      writer = new BufferedWriter(new FileWriter(inputFile));
    } catch (IOException e) {
      e.printStackTrace();
    }
    Scanner in = new Scanner(System.in);
    BigInteger arrayLenth = in.nextBigInteger();
    BigInteger count = BigInteger.ZERO;
    for (BigInteger i = BigInteger.ZERO; i.compareTo(arrayLenth) <= 0; i = i.add(BigInteger.ONE) ) {
      try {
        //if (i.mod(new BigInteger("2")).compareTo(BigInteger.ZERO) != 0) {
          count = count.add(BigInteger.ONE);
          writer.write(i + " ");
        //}
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    System.out.print(count);
    writer.close();
  }
}

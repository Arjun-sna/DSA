package arjun.dsa;

import java.math.BigInteger;
import java.util.Scanner;

public class BusSeats {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    BigInteger seatNo = in.nextBigInteger();

    BigInteger modVal = seatNo.mod(BigInteger.TEN);
    int modIntVal = modVal.intValue();
    if (modIntVal > 0 && modIntVal <= 5) {
      switch (modIntVal % 5) {
        case 1:
          System.out.print("LW");
          break;
        case 2:
          System.out.print("LA");
          break;
        case 3:
          System.out.print("RA");
          break;
        case 4:
          System.out.print("RM");
          break;
        case 0:
          System.out.print("RW");
          break;
      }
    } else {
      switch (modIntVal % 5) {
        case 1:
          System.out.print("RW");
          break;
        case 2:
          System.out.print("RM");
          break;
        case 3:
          System.out.print("RA");
          break;
        case 4:
          System.out.print("LA");
          break;
        case 0:
          System.out.print("LW");
          break;
      }
    }
  }
}

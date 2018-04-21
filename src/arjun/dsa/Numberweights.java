import java.util.Map;
import java.util.TreeMap;

public class Numberweights {
  public static void main(String args[]) {
    Map<Integer, Integer> weightmap = new TreeMap<>();
    for (int i = 0; i < args.length; i++) {
      int number = Integer.parseInt(args[i]);
      int weight = 0;
      int sqrt = (int) Math.sqrt(number);
      if (sqrt * sqrt == number) {
        weight += 5;
      }
      if (number % 4 == 0 && number % 6 == 0) {
        weight += 4;
      }
      if (number % 2 == 0) {
        weight += 3;
      }
      System.out.println(number + " " + weight);
      System.out.println();
      weightmap.put(number, weight);
    }
  }
}


class NumberFactors {
  public static void main(String args[]) throws Exception {
    /*
     * Read input from stdin and provide input before running
     * Use either of these methods for input 88*/

    //BufferedReader
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int min = a > b ? b : a, count = 1;
    for (int i = 2; i <= min / 2; i++) {
      if (b % i == 0 && a % i == 0) {
        System.out.println(i);
        count++;
      }
    }
    System.out.println(count);
  }
}
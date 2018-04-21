public class Oddletter {
  public static void main(String args[]) {
    String textToProcesss = args[0];
    int stringLength = textToProcesss.length();
    char[] arraychar;
    for (int i = 0, j = stringLength - 1; i < stringLength && j >= 0; i++, j--) {
      arraychar = new char[stringLength];
      arraychar[i] = textToProcesss.charAt(i);
      arraychar[j] = textToProcesss.charAt(j);
      for (int k = 0; k < stringLength; k++) {
        System.out.print(arraychar[k] == 0 ? " " : arraychar[k]);
      }
      System.out.println();
    }
  }
}
public class Twodimen {
  public static void main(String args[]) {
    String src = "WELCOMETOZOHOCORPORATION";
    char[][] srcarray = new char[5][5];
    int index = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5 && index < src.length(); j++) {
        srcarray[i][j] = src.charAt(index++);
      }
    }
    int[] result = null;
    boolean found = false;
    String tosearch = args[0];
    int srcindex = 0;
    for (int i = 0; i < 5 && !found; i++) {
      for (int j = 0; j < 5 && !found; j++) {
        srcindex = 0;
        if (tosearch.charAt(srcindex) == srcarray[i][j]) {
          int tempi = i, tempj = j;
          while (++srcindex < tosearch.length()
              && tosearch.charAt(srcindex) == srcarray[i][++tempj]) {
            if (srcindex == tosearch.length()) {
              result = new int[] {i, j, tempi, tempj};
              found = true;
              break;
            }
          }
          tempi = i;
          tempj = j;
          srcindex = 1;
          while (srcindex < tosearch.length() - 1
              && tosearch.charAt(srcindex) == srcarray[++tempi][j]) {
            if (srcindex == tosearch.length()) {
              result = new int[] {i, j, tempi, tempj};
              found = true;
              break;
            }
            srcindex++;
          }
        }
      }
    }
    for (int i = 0; i < 4; i++) {
      System.out.println(result[i]);
    }
  }
}
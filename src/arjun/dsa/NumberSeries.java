public class NumberSeries {
  public static void main(String[] args) {
    NumberSeries sr = new NumberSeries();
    int n = sr.getNthNumber(Integer.parseInt(args[0]));
    System.out.println();
    System.out.println(n);
  }

  private int getNthNumber(int n) {
    int a[] = new int[n + 2], k = 1;
    a[0] = 3;
    a[1] = 4;
    for (int i = 0; k < n; i++) {
      a[++k] = (a[i] * 10) + 3;
      System.out.println(a[k]);
      a[++k] = (a[i] * 10) + 4;
      System.out.println(a[k]);
    }
    return a[n - 1];
  }

  // private int getNthNumber(int n ) {
  // 	String[] destArray = new String[n + 1];
  // 	destArray[0] = "";
  // 	int size = 1, m = 1;
  // 	while(size < n) {
  // 		for (int i = 0 ; i < m && (size + i) < n ; i++) {
  // 			destArray[size + i] = "3" + destArray[size - m + i];
  // 		}
  // 		for (int i = 0 ; i < m && (size + m + i) < n ; i++) {
  // 			destArray[size + m + i] = "4" + destArray[size - m + i];
  // 		}

  // 		m = m * 2;
  // 		size = size + m;

  // 	}
  // 	// for (int i = 1 ; i < n ; i++){
  // 	// System.out.println(destArray[i]);
  // 	// }
  // 	return Integer.parseInt(destArray[n]);
  // }
}
public class AlternateSorting {
  public static void main(String[] args) {
    int[] srcArray = new int[] {1, 2};
    int srcLength = srcArray.length;
    int max_index = srcLength - 1, min_index = 0, max_element = srcArray[max_index] + 1;
    // System.out.println(max_element);
    for (int i = 0; i < srcLength; i++) {
      if (i % 2 == 0) {
        System.out.println(srcArray[i] + " " + srcArray[max_index] % max_element * max_element);
        srcArray[i] += srcArray[max_index] % max_element * max_element;
        max_index--;
      } else {
        srcArray[i] += srcArray[min_index] % max_element * max_element;
        min_index++;
      }
    }
    for (int i = 0; i < srcLength; i++) {
      // System.out.println(srcArray[i]);
      // srcArray[i] = srcArray[i] / max_element;
      // System.out.println(srcArray[i]);
      // System.out.println();
    }
  }
}

// public class AlternateSorting {
// 	public static void main(String[] args) {
// 		int[] srcArray = new int[]{1, 2, 3, 4, 5, 6};
// 		int srcLength = srcArray.length;
// 		int[] destArray = new int[srcLength];
// 		int index = 0;
// 		for (int i = 0, j =  srcLength - 1; i <= j ; i++,j--) {
// 			if (i == j) {
// 				destArray[index++] = srcArray[i];
// 			} else {
// 				destArray[index++] = srcArray[j]; 
// 				destArray[index++] = srcArray[i];
// 			}
// 		}
// 		for (int i = 0 ; i < srcLength ; i++) {
// 			System.out.println(destArray[i]);
// 		}	
// 	}
// }

// If (i < n/2) 
//    j = 2*i + 1 
// Else
//    j = 2*(n-1-i);
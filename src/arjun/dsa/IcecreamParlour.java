/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.Scanner;

/**
 * @author arjun
 */
public class IcecreamParlour {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int trips = in.nextInt();

    for (int i = 0; i < trips; i++) {
      int dollor = in.nextInt();
      int flvCount = in.nextInt(), flvind;
      int[] flv = new int[flvCount];
      for (flvind = 0; flvind < flvCount; flvind++) {
        flv[flvind] = in.nextInt();
      }
      for (flvind = 0; flvind < flvCount; flvind++) {
        int secind = binarySearch(flv, dollor - flv[flvind], flvind + 1, flvCount - 1);
        System.out.println((flvind + 1)
            + " "
            + (flvCount - 1)
            + " earch "
            + (dollor - flv[flvind])
            + " res"
            + secind);
        if (secind != -1) {
          System.out.println((flvind + 1) + " " + (secind + 1));
          break;
        }
      }
    }
  }

  public static int binarySearch(int[] arr, int item, int sind, int eind) {
    //        System.out.println((sind) + " " + (eind) + " earch " + item);
    int mid = (eind - sind) / 2;
    while (sind <= eind) {
      if (arr[mid] == item) {
        return mid;
      }
      if (arr[mid] > item) {
        eind = mid - 1;
      }
      if (arr[mid] < item) {
        sind = mid + 1;
      }
      mid = (eind - sind) / 2;
    }
    return -1;
  }
  //     public static void main(String[] args) {
  //         Scanner in = new Scanner(System.in);
  //        int trips = in.nextInt();
  //
  //        for (int i = 0; i < trips; i++) {
  //            int dollor = in.nextInt();
  //            int flvCount = in.nextInt(), flvind;
  //            int[] flv = new int[flvCount];
  //            for (flvind = 0 ; flvind < flvCount; flvind++) {
  //                flv[flvind] = in.nextInt();
  //            }
  //            for (flvind = 0; flvind < flvCount; flvind++) {
  //                for (int flvind2 = flvind + 1; flvind2 < flvCount; flvind2++) {
  //                    if (flv[flvind] + flv[flvind2] == dollor) {
  //                        System.out.println((flvind+1) + " " + (flvind2+1));
  //                        break;
  //                    }
  //                }
  //            }
  //        }
  //    }
}

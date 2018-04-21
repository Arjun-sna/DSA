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
public class TimeConversion {
  //14 11 15 5 13 6 9 7 8 3 4 12 10 2 1
  //14 11 15 5 13 7 8 3 4 6 9 12 10 2 1
  //15
  //1 3 2 5 4 6 7 9 8 11 13 12 10 15 14
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println(scan.nextInt());
    System.out.println(scan.nextDouble());
    scan.next();
    String s1 = scan.nextLine();
    System.out.println(s1);

    //        int n = in.nextInt(), k = in.nextInt();
    //        int check = 0, priceK = 0;
    //        for (int i = 0 ; i < n ; i++) {
    //            int pr = in.nextInt();
    //            check += pr;
    //            if (i == k) {
    //                priceK = pr;
    //            }
    //        }
    //        int anna = (check - priceK) / 2;
    //        int actanna = (anna - in.nextInt()) ;
    //        System.out.println(anna + " check "+ actanna);
    //
    //        if (actanna == 0) {
    //            System.out.println("Bon Appetit");
    //        } else {
    //            System.out.println(Math.abs(actanna));
    //        }
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author arjun
 */
public class HackerLandRadioTransmitters {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int houseCount = in.nextInt();
    int cover = in.nextInt();
    //        int[] houses = new int[houseCount];
    int count = 0;
    HashSet<Integer> housesWithTower = new HashSet<>();
    for (int i = 0; i < houseCount; i++) {
      int house = in.nextInt();
      if (!housesWithTower.contains(house)) {
        System.out.println(house);
        count++;
        for (int j = house - cover; j <= house + cover; j++) {
          housesWithTower.add(j);
        }
      }
    }
    System.out.println("Count " + count);
  }
}

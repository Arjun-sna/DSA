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
public class CountriesGrouping {
  public static void main(String args[]) throws Exception {
    /*
     * Read input from stdin and provide input before running
     * Use either of these methods for input
     */
    //BufferedReader
    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //String line = br.readLine();
    //int N = Integer.parseInt(line);

    //Scanner
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();

    for (int Ti = 0; Ti < T; Ti++) {
      int totatGroup = getGroups(s);
      if (totatGroup < 0) {
        System.out.println("Invalid Data");
      } else {
        System.out.println(totatGroup);
      }
    }
  }

  public static int getGroups(Scanner s) {
    int N = s.nextInt();
    int totatGroup = 0, traker = 0;
    for (int i = 0; i < N; i++) {
      totatGroup++;
      int gr = s.nextInt();
      int index = gr;
      traker += gr;
      if (traker <= N) {
        while (index-- > 1) {
          i++;
          int nextin = s.nextInt();
          if (nextin != gr) {
            return -1;
          }
        }
      } else {
        return -1;
      }
    }
    return totatGroup;
  }
}

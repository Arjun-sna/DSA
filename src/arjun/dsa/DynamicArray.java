/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author arjun
 */
public class DynamicArray {
  public static void main(String[] args) {
    Map<Integer, ArrayList<Integer>> seqs = new HashMap<>();
    Scanner in = new Scanner(System.in);
    int seqCount = in.nextInt(), qryCount = in.nextInt(), lastAns = 0;
    for (int k = 0; k < seqCount; k++) {
      seqs.put(k, new ArrayList<>());
    }
    for (int i = 0; i < qryCount; i++) {
      int q = in.nextInt(), x = in.nextInt(), y = in.nextInt();
      if (q == 1) {
        int seq = ((x ^ lastAns) % seqCount);
        seqs.get(seq).add(y);
      } else {
        int seq = ((x ^ lastAns) % seqCount);
        int index = y % seqs.get(seq).size();
        lastAns = seqs.get(seq).get(index);
        System.out.println(lastAns);
      }
    }
  }
}

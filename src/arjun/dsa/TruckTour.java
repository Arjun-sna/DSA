/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author arjun
 */
public class TruckTour {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Deque<PertolPump> petrolq = new ArrayDeque<>();
    PertolPump prev = null, first = null;
    for (int i = 0; i < n; i++) {
      int pqty = in.nextInt();
      int dis = in.nextInt();
      PertolPump cur = new PertolPump(pqty, dis, i);
      if (prev == null) {
        first = cur;
        prev = cur;
      } else {
        prev.nextSt = cur;
        prev = cur;
      }
      if (cur.petrolQty >= cur.nextStDistance) {
        petrolq.push(cur);
      }
    }
    if (prev != null) {
      prev.nextSt = first;
    }
    PertolPump firstst = petrolq.getFirst();
    PertolPump currPump = petrolq.poll();
    int petrolLevel = 0;
    while (currPump != null) {
      petrolLevel += currPump.petrolQty;
      if (currPump.nextStDistance <= petrolLevel) {
        petrolLevel -= currPump.nextStDistance;
        currPump = currPump.nextSt;
      } else {
        firstst = currPump;
        petrolLevel = 0;
        continue;
      }
      if (currPump == firstst) {
        break;
      }
    }
    System.out.println(firstst.stIndex);
    //
  }

  public static class PertolPump {
    int petrolQty;
    int nextStDistance;
    int stIndex;
    PertolPump nextSt;

    public PertolPump(int pertrolQty, int nextStDistance, int stIndex) {
      this.petrolQty = pertrolQty;
      this.nextStDistance = nextStDistance;
      this.stIndex = stIndex;
    }
  }
}

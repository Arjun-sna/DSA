/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author arjun
 */
public class Waiter {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int q = in.nextInt();
    ArrayList<Integer> primes = new ArrayList<>();
    primes = getNthPrime(q);
    Stack<Integer> a = new Stack<>();
    for (int i = 0; i < n; i++) {
      a.push(in.nextInt());
    }

    for (int j = 1; j <= q; j++) {
      Stack<Integer> ai = new Stack<>();
      Stack<Integer> bi = new Stack<>();
      int ip = primes.get(j - 1);
      while (!a.empty()) {
        int cur = a.pop();
        if (cur % ip == 0) {
          bi.push(cur);
        } else {
          ai.push(cur);
        }
      }
      while (!bi.empty()) {
        System.out.println(bi.pop());
      }
      a = ai;
    }

    while (!a.empty()) {
      System.out.println(a.pop());
    }
  }

  public static ArrayList getNthPrime(int n) {
    //        System.out.println("n " + n);
    ArrayList<Integer> primes = new ArrayList<>();
    primes.add(2);
    int num = 3, status = 1;
    for (int i = 2; i <= n; ) {
      for (int j = 2; j <= Math.sqrt(num); j++) {
        if (num % j == 0) {
          status = 0;
          break;
        }
      }
      if (status != 0) {
        primes.add(num);
        i++;
      }
      status = 1;
      num++;
    }
    return primes;
  }
}

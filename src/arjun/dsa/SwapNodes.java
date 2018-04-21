/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author arjun
 */
public class SwapNodes {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int nodes = in.nextInt();
    Node root = new Node();
    root.data = 1;
    root.depth = 0;
    ArrayList<Node> allNodes = new ArrayList<>();
    allNodes.add(root);
    int level = 1, cur = 1;
    for (int i = 0; i < nodes; i++) {
      int left = in.nextInt();
      if (left != -1) {
        Node leftNode = new Node();
        leftNode.data = left;
        leftNode.depth = allNodes.get(i).depth + 1;
        allNodes.get(i).left = leftNode;
        allNodes.add(leftNode);
      }
      int right = in.nextInt();
      if (right != -1) {
        Node rightNode = new Node();
        rightNode.data = right;
        rightNode.depth = allNodes.get(i).depth + 1;
        allNodes.get(i).right = rightNode;
        allNodes.add(rightNode);
      }
    }
    //        for (Node n : allNodes) {
    //            System.out.println(n.data + " " + n.depth + " left " + (n.left == null? "X" : n.left.data) + " right "+ (n.right == null? "X" : n.right.data));
    //        }
    //        printInorder(root);
    int maxLevel = allNodes.get(allNodes.size() - 1).depth;
    int swaps = in.nextInt();
    for (int swap = 0; swap < swaps; swap++) {
      int nodelevel = in.nextInt(), count = 1;
      while (nodelevel * count <= maxLevel) {

        //                    System.out.println("nodelevel " + nodelevel + " " + maxLevel);
        for (int deps = 0; deps < allNodes.size(); deps++) {
          Node curNode = allNodes.get(deps);
          if (curNode.depth == (nodelevel * count - 1)) {
            //                    System.out.println(curNode.data);
            Node temp = curNode.left;
            curNode.left = curNode.right;
            curNode.right = temp;
          }
        }
        count++;
      }
      printInorder(allNodes.get(0));
      System.out.println();
    }
  }

  public static void printInorder(Node root) {
    if (root == null) {
      return;
    }
    printInorder(root.left);
    System.out.print(root.data + " ");
    printInorder(root.right);
  }

  static class Node {
    int data;
    Node left;
    Node right;
    int depth;
  }
}

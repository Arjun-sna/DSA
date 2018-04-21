/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa;

/**
 * @author arjun
 */
public class DistanceBetnNodes {
  static class Node {
    Node left;
    Node right;
    int val;
    boolean visited;
  }

  static int mLevel = -1;

  public static void main(String[] args) {
    Node root = new Node();
    int a = 1, b = 2;
    mLevel = getLevel(root, a, b, 0); //get Level of the node
    int aPosition =
        getPosition(root, a, 0, 0); // use the leve and find the position of node a in tree
    int bPosition =
        getPosition(root, b, 0, 0); // use the leve and find the position of node b in tree
    System.out.println("Distance " + Math.abs(aPosition - bPosition));
  }

  public static int getPosition(Node root, int val, int level, int position) {
    if (root == null) {
      if (level == mLevel) {
        position++;
      }
      return 0;
    }
    if (root.val == val) {
      return position;
    } else if (level == mLevel) {
      position++;
    }

    int result = getPosition(root.left, val, level + 1, position);
    if (result != 0) {
      return result;
    }
    result = getPosition(root.right, val, level + 1, position);
    return result;
  }

  public static int getLevel(Node root, int a, int b, int level) {
    if (root == null) {
      return 0;
    }
    if (root.val == a || root.val == b) {
      return level;
    }
    int result = getLevel(root.left, a, b, level + 1);
    if (result != 0) {
      return result;
    }
    result = getLevel(root.right, a, b, level + 1);
    return result;
  }
}

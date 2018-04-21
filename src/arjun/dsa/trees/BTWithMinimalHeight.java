/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arjun.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author arjun
 */
public class BTWithMinimalHeight {
  private static ArrayList<LinkedList<TreeNode>> levelList = new ArrayList<>();

  private static class TreeNode {
    int val;
    TreeNode parent;
    TreeNode left;
    TreeNode right;
  }

  public static void main(String[] args) {
    int[] input = new int[] {2, 5, 6, 8, 9, 10, 11};
    TreeNode root = processArray(input, 0, input.length - 1);
    traverse(root);
    levelTravelNodes(root);
    System.out.println("");
    levelList.forEach((linkedList) -> {
      linkedList.forEach((treeNode) -> {
        System.out.print(treeNode.val + " ");
      });
    });
    isBalanced(root);
    isBSTMethod1(root);

    levelList.clear();
    TreeNode unbalanced = simpleProcessArray(input, 0);
    traverse(unbalanced);
    levelTravelNodes(unbalanced);
    System.out.println("");
    levelList.forEach((linkedList) -> {
      linkedList.forEach((treeNode) -> {
        System.out.print(treeNode.val + " ");
      });
    });
    isBalanced(unbalanced);
    isBSTMethod1(root);
  }

  private static void isBalanced(TreeNode root) {
    if (checkHeight(root) != Integer.MIN_VALUE) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }

  private static int checkHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftH = checkHeight(root.left);
    int rightH = checkHeight(root.right);
    if (leftH != Integer.MIN_VALUE
        && rightH != Integer.MIN_VALUE && Math.abs(leftH - rightH) < 2) {
      return Math.max(leftH, rightH) + 1;
    }
    return Integer.MIN_VALUE;
  }

  private static void traverse(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.val + " ");
    traverse(root.left);
    traverse(root.right);
  }

  private static TreeNode processArray(int[] input, int start, int end) {
    if (start > end) {
      return null;
    }
    TreeNode node = new TreeNode();
    int mid = (start + end) / 2;
    node.val = input[mid];
    node.left = processArray(input, start, mid - 1);
    node.right = processArray(input, mid + 1, end);
    return node;
  }

  private static void levelTravelNodes(TreeNode root) {
    LinkedList<TreeNode> currentList = new LinkedList<>();
    currentList.add(root);
    levelList.add(currentList);
    while (currentList.size() > 0) {
      LinkedList<TreeNode> newLevel = new LinkedList<>();
      for (TreeNode treeNode : currentList) {
        if (treeNode.left != null) {
          newLevel.add(treeNode.left);
        }
        if (treeNode.right != null) {
          newLevel.add(treeNode.right);
        }
      }
      levelList.add(newLevel);
      currentList = newLevel;
    }
  }

  private static TreeNode simpleProcessArray(int[] input, int index) {
    if (index > input.length - 1) {
      return null;
    }
    TreeNode node = new TreeNode();
    node.val = input[index];
    node.left = simpleProcessArray(input, index + 1);
    return node;
  }

  private static void isBSTMethod1(TreeNode node) {
    ArrayList<Integer> arrangedList = new ArrayList<>();
    fillArray(node, arrangedList);
    for (int i = 1; i < arrangedList.size(); i++) {
      if (arrangedList.get(i - 1) > arrangedList.get(i)) {
        System.out.println("Tree is not BST");
        return;
      }
    }
    System.out.println("Tree is a BST");
    ;
  }

  private static void isBSTMethod2(TreeNode node) {
    if (checkInPlace(node)) {
      System.out.println("Tree is a BST");
    } else {
      System.out.println("Tree is Not a BST");
    }
  }

  static Integer lastprinted = null;

  private static boolean checkInPlace(TreeNode node) {
    if (node == null) {
      return true;
    }
    checkInPlace(node.left);
    if (lastprinted != null && lastprinted > node.val) {
      return false;
    }
    lastprinted = node.val;
    checkInPlace(node.right);
    return true;
  }

  private static void fillArray(TreeNode node, ArrayList<Integer> arrayList) {
    if (node == null) {
      return;
    }
    fillArray(node.left, arrayList);
    arrayList.add(node.val);
    fillArray(node.right, arrayList);
  }

  static void isBSTMethod3(TreeNode node) {
    isWithInRange(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  static boolean isWithInRange(TreeNode node, Integer min, Integer max) {
    if (node == null) return true;
    if ((min != null && min > node.val) || (max != null && max < node.val)) {
      return false;
    }
    if (!isWithInRange(node.left, min, node.val) || !isWithInRange(node.right, node.val, max)) {
      return false;
    }
    return true;
  }

  static TreeNode inOrderSuccessor(TreeNode n) {
    if (n == null) {
      return null;
    }
    if (n.right != null) {
      return findLeftInSubtree(n.right);
    } else {
      TreeNode temp = n;
      TreeNode parent = temp.parent;
      while (parent != null && parent.left != temp) {
        temp = parent;
        parent = parent.parent;
      }
      return parent;
    }
  }

  static TreeNode findLeftInSubtree(TreeNode n) {
    if (n == null) {
      return null;
    }
    while (n.left != null) {
      n = n.left;
    }
    return n;
  }
}

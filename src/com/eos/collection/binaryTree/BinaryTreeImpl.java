package com.eos.collection.binaryTree;

public class BinaryTreeImpl {

  public static void main(String args[]) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(4);
    tree.root.left = new Node(9);
    tree.root.right = new Node(0);
    tree.root.left.left = new Node(5);
    tree.root.left.right = new Node(1);
    //tree.root.left.left.left = new Node(7);
    //tree.root.right.right = new Node(6);
    //tree.root.right.right.left = new Node(8);*//*
    System.out.println(tree.sumNumbers(tree.root));
  }

}

class BinaryTree {

  static int max = Integer.MIN_VALUE;
  Node root;

  static int sum = 0;
  public int sumNumbers(Node root) {
    util(root,0);
    return sum;
  }
  private void util(Node root,int x){
    if(root==null){
      return;
    }
    if(root.left==null && root.right==null){
      x = x*10+root.data;
      sum=sum+x;
      return;
    }
    x = x*10+root.data;
    util(root.left,x);
    util(root.right,x);
  }

  public void print(Node root) {
    if (root == null) {
      return;
    }
    print(root.left);
    System.out.print(root.data + ",");
    print(root.right);
  }

  public Node delete(Node root, int level, int k) {
    if (root == null) {
      return null;
    }
    root.left = delete(root.left, level + 1, k);
    root.right = delete(root.right, level + 1, k);
    if (root.left == null && root.right == null && level < k) {
      return null;
    }
    return root;
  }

  public int maxSum(Node root) {
    maxSumUtil(root);
    return max;
  }

  private int maxSumUtil(Node root) {
    if (root == null) {
      return 0;
    }
    int left = maxSumUtil(root.left);
    int right = maxSumUtil(root.right);
    if (left + right + root.data > max) {
      max = left + right + root.data;
    }
    return Math.max(left, right) + root.data;
  }
}

class Node {

  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
  }
}

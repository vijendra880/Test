package com.eos.problem;

public class KSmallestInMatrix {

  public static void main(String args[]) {
    int[][] a = {{10, 20, 30, 40},
        {15, 25, 35, 45},
        {25, 29, 37, 48},
        {32, 33, 39, 50},
    };
    find(a, 7, a.length, a[0].length);

  }

  private static void find(int[][] a, int k, int rows, int colums) {
    HeapNode[] nodes = new HeapNode[colums];
    for (int i = 0; i < colums; i++) {
      nodes[i] = new HeapNode(a[0][i], 0, i);
    }

  }
}

class HeapNode {

  int data;
  int r;
  int c;

  HeapNode(int data, int r, int c) {
    this.data = data;
    this.r = r;
    this.c = c;
  }
}

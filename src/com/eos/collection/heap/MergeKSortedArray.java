package com.eos.collection.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArray {

  static PriorityQueue<Node> minHeap = new PriorityQueue<Node>(new NodeComparator());

  public static void main(String args[]) {
    int[][] arr = {{1, 3},
        {2, 4, 6, 8},
        {0, 9, 10, 11}};
    mergeKSortedArray(arr);
  }

  private static void mergeKSortedArray(int[][] arr) {
    List<Integer> output = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      minHeap.add(new Node(arr[i][0], i, 0));
    }
    while (!minHeap.isEmpty()) {
      Node node = minHeap.poll();
      output.add(node.data);
      if (node.col < arr[node.row].length - 1) {
        int col = node.col + 1;
        minHeap.add(new Node(arr[node.row][col], node.row, col));
      }
    }
    for (Integer data : output) {
      System.out.println(data + ",");
    }
  }

}

class Node {

  int data;
  int row;
  int col;

  Node(int data, int row, int col) {
    this.data = data;
    this.row = row;
    this.col = col;
  }
}

class NodeComparator implements Comparator<Node> {

  @Override
  public int compare(Node o1, Node o2) {
    return o1.data - o2.data;
  }
}

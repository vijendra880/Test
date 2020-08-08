package com.eos.collection.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphAdjacencyListImpl {

  private GraphNode[] heads;
  private int size;

  public GraphAdjacencyListImpl(int size) {
    heads = new GraphNode[size];
    this.size = size;
  }

  public void addEdge(int start, int end) {
    GraphNode node = heads[start];
    if (node == null) {
      node = new GraphNode(start);
    }
    heads[start] = node;
    while (node.next != null) {
      node = node.next;
    }
    node.next = new GraphNode(end);

  }

  public void bfs(int source) {
    System.out.println("BFS");
    boolean[] visited = new boolean[size];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    visited[source] = true;
    while (!queue.isEmpty()) {
      int data = queue.poll();
      GraphNode node = heads[data];
      System.out.println(data);
      GraphNode temp = node == null ? null : node.next;
      while (temp != null) {
        if (!visited[temp.data]) {
          queue.add(temp.data);
          visited[temp.data] = true;
        }
        temp = temp.next;
      }
    }
  }

  public void dfs(int source) {
    System.out.println("DFS");
    boolean[] visited = new boolean[size];
    dfsUtil(source, visited);
  }

  private void dfsUtil(int source, boolean[] visited) {
    visited[source] = true;
    System.out.println(source);
    GraphNode temp = heads[source] == null ? null : heads[source].next;
    while (temp != null) {
      if (!visited[temp.data]) {
        dfsUtil(temp.data, visited);
      }
      temp = temp.next;
    }
  }

  public void dfs1(int s) {
    boolean[] visited = new boolean[size];
    dfsUtil1(s, visited);
  }

  private void dfsUtil1(int s, boolean[] visited) {
    if (visited[s]) {
      return;
    }
    GraphNode node = heads[s];
    System.out.println(s);
    while (node.next != null) {
      dfsUtil1(node.next.data, visited);
    }
    visited[s] = true;
  }
}

class GraphAdjacencyListDriver {

  public static void main(String args[]) {
    GraphAdjacencyListImpl g = new GraphAdjacencyListImpl(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    g.bfs(2);
    g.dfs(2);
    //g.dfs1(2);
  }
}

class GraphNode {

  int data;
  GraphNode next;

  public GraphNode(int data) {
    this.data = data;
  }
}

package Graphs;

import java.util.*;
import java.lang.*;
import java.io.*;

public class isCycleUndirectedGraph {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycleGraph(V, adj, i, parent, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycleGraph(int V, ArrayList<ArrayList<Integer>> adj, int src, int[] parent, boolean[] visited) {
        // Code here
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(src);
        visited[src] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> neighbors = adj.get(node);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = node;
                    queue.offer(neighbor);
                } else if (neighbor != parent[node]) {
                    return true;
                }
            }
        }
        return false;
    }
}
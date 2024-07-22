package Graphs;

//{ Driver Code Starts

import java.util.*;
import java.lang.*;
import java.io.*;

//User function Template for Java
class ShortestPathFromSourceDAG {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 2, 6},
                {0, 3, 7},
                {0, 4, 9},
                {0, 6, 8},
                {0, 7, 6},
                {1, 2, 6},
                {1, 3, 7},
                {1, 5, 10},
                {1, 6, 1},
                {1, 7, 4},
                {2, 3, 3},
                {2, 6, 10},
                {2, 8, 8},
                {2, 9, 10},
                {3, 5, 3},
                {3, 6, 10},
                {3, 7, 5},
                {5, 6, 9},
                {5, 7, 7},
                {6, 7, 7},
                {6, 8, 8},
                {6, 9, 8},
                {7, 9, 1},
                {8, 9, 6}
        };
        System.out.println(Arrays.toString(shortestPath(10, 24, edges)));
    }

    public static int[] shortestPath(int N, int M, int[][] edges) {
        //Code here
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edgeWithDist : edges) {
            int src = edgeWithDist[0];
            int dest = edgeWithDist[1];
            int edgeLength = edgeWithDist[2];
            List<Integer> edge = new ArrayList<>();
            edge.add(dest);
            edge.add(edgeLength);
            adj.get(src).add(edge);
        }
        int[] res = new int[N];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        int[] topo = topologicalSortAll(N, adj);

        for (int vertex : topo) {
            for (int k = 0; k < adj.get(vertex).size(); k++) {
                int dest = adj.get(vertex).get(k).get(0);
                int edgeLength = adj.get(vertex).get(k).get(1);
                if (res[vertex] != Integer.MAX_VALUE) {
                    res[dest] = Math.min(res[dest], res[vertex] + edgeLength);
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;

    }

    private static int[] topologicalSortAll(int N, List<List<List<Integer>>> adj) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topologicalSort(i, N, visited, adj, stack);
            }
        }
        int[] res = new int[N];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }

    private static void topologicalSort(int src, int N, boolean[] visited, List<List<List<Integer>>> adj, Deque<Integer> stack) {
        visited[src] = true;
        for (int k = 0; k < adj.get(src).size(); k++) {
            int dest = adj.get(src).get(k).get(0);
            int edgeLength = adj.get(src).get(k).get(1);
            if (!visited[dest]) {
                topologicalSort(dest, N, visited, adj, stack);
            }
        }
        stack.push(src);
    }
}




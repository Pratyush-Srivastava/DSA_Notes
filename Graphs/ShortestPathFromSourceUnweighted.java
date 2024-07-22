package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class ShortestPathFromSourceUnweighted {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 0}, {1, 1}, {1, 3}, {3, 0}};
        int n = 4, m = 4;
        int src = 3;
        int[] res = shortestPath(edges, n, m, src);
        for (int elem : res) {
            System.out.print(elem + " : ");
        }
        System.out.println();
    }

    private static int[] shortestPath(int[][] edges, int n, int m, int src) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            adjList.get(start).add(end);
            adjList.get(end).add(start);
        }
        return bfs(adjList, n, m, src);
    }

    public static int[] bfs(List<List<Integer>> adjList, int n, int m, int src) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        res[src] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.offer(src);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> neighbors = adjList.get(node);
            for (Integer neighbor : neighbors) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
                if (res[node] + 1 < res[neighbor]) {
                    res[neighbor] = res[node] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;
    }
}
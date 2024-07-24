package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bridges {
    private static int time = 0;

    public static void main(String[] args) {
        List<List<Integer>> adjList = Arrays.asList(
                Arrays.asList(1, 2),  // Edges for vertex 0
                Arrays.asList(0, 2, 3), // Edges for vertex 1
                Arrays.asList(0, 1),  // Edges for vertex 2
                Arrays.asList(1, 4),  // Edges for vertex 3
                Arrays.asList(3)      // Edges for vertex 4
        );
        List<int[]> res = printBridges(adjList);
        for (int[] edge : res) {
            System.out.print(edge[0] + "->" + edge[1]);
            System.out.print(" ");
        }
        System.out.println();
        adjList = Arrays.asList(
                Arrays.asList(1, 2),     // Edges for vertex 0
                Arrays.asList(0, 2, 3),  // Edges for vertex 1
                Arrays.asList(0, 1),     // Edges for vertex 2
                Arrays.asList(1, 4, 5, 6), // Edges for vertex 3
                Arrays.asList(3, 5),     // Edges for vertex 4
                Arrays.asList(3, 4),     // Edges for vertex 5
                Arrays.asList(3, 7, 8),  // Edges for vertex 6
                Arrays.asList(6, 8),     // Edges for vertex 7
                Arrays.asList(6, 7)      // Edges for vertex 8
        );
        res = printBridges(adjList);
        for (int[] edge : res) {
            System.out.print(edge[0] + "->" + edge[1]);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static List<int[]> printBridges(List<List<Integer>> adj) {
        int V = adj.size();
        List<int[]> bridges = new ArrayList<>();
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        int[] disc = new int[V];
        int[] low = new int[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, V, adj, visited, parent, disc, low, bridges);
            }
        }
        return bridges;
    }

    private static void dfs(int u, int V, List<List<Integer>> adj, boolean[] visited, int[] parent, int[] disc, int[] low, List<int[]> bridges) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        for (int i = 0; i < adj.get(u).size(); i++) {
            int v = adj.get(u).get(i);
            if (!visited[v]) {
                parent[v] = u;
                dfs(v, V, adj, visited, parent, disc, low, bridges);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    bridges.add(new int[]{u, v});
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}

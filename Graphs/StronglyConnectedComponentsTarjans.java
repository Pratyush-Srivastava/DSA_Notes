package Graphs;

import java.util.*;

public class StronglyConnectedComponentsTarjans {
    private static int time = 0;

    public static void main(String[] args) {
        List<List<Integer>> adjList = Arrays.asList(
                Arrays.asList(1, 2),        // Edges from vertex 0 to 1 and 2
                Arrays.asList(2, 3),        // Edges from vertex 1 to 2 and 3
                Arrays.asList(0, 3),        // Edges from vertex 2 to 0 and 3
                Arrays.asList(4),           // Edge from vertex 3 to 4
                Arrays.asList(5),           // Edge from vertex 4 to 5
                Arrays.asList(3, 6),        // Edges from vertex 5 to 3 and 6
                Arrays.asList(4)            // Edge from vertex 6 to 4
        );
        System.out.println(findStronglyConnectedComponentsUsingTarjansAlgorithm(adjList));
    }

    private static List<List<Integer>> findStronglyConnectedComponentsUsingTarjansAlgorithm(List<List<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        List<List<Integer>> components = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] inStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, disc, low, adj, components, stack, inStack);
            }
        }
        components.sort(Comparator.comparingInt(o -> o.get(0)));
        return components;
    }

    private static void dfs(int u, boolean[] visited, int[] disc, int[] low, List<List<Integer>> adj, List<List<Integer>> components, Stack<Integer> stack, boolean[] inStack) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        stack.push(u);
        inStack[u] = true;
        for (int i = 0; i < adj.get(u).size(); i++) {
            int v = adj.get(u).get(i);
            if (!visited[v]) {
                dfs(v, visited, disc, low, adj, components, stack, inStack);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if (disc[u] == low[u]) {
            List<Integer> component = new ArrayList<>();
            while (true) {
                Integer popped = stack.pop();
                inStack[popped] = false;
                component.add(popped);
                if (popped == u) {
                    break;
                }
            }
            Collections.sort(component);
            components.add(component);
        }
    }
}


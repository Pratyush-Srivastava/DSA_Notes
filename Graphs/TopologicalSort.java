package Graphs;

import java.util.*;

import static java.util.Arrays.asList;

public class TopologicalSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topoSortUsingBFS(4,
                asList(asList(), asList(0), asList(0), asList(0)))));
        System.out.println(Arrays.toString(topoSortUsingBFS(6,
                asList(asList(), asList(3), asList(3), asList(), asList(0, 1), asList(0, 2)))));
        System.out.println(Arrays.toString(topoSortUsingDFS(4,
                asList(asList(), asList(0), asList(0), asList(0)))));
        System.out.println(Arrays.toString(topoSortUsingDFS(6,
                asList(asList(), asList(3), asList(3), asList(), asList(0, 1), asList(0, 2)))));
    }

    //Function to return list containing vertices in Topological order.
    static int[] topoSortUsingBFS(int V, List<List<Integer>> adj) {
        // add your code here
        int[] res = new int[V];
        int index = 0;
        Queue<Integer> q = new ArrayDeque<>();
        int[] indegree = inDegreeMap(V, adj);
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int root = q.poll();
            res[index] = root;
            index++;
            List<Integer> ngh = adj.get(root);
            for (int n : ngh) {
                indegree[n] = indegree[n] - 1;
                if (indegree[n] == 0) {
                    q.offer(n);
                }
            }
        }
        return res;
    }

    private static int[] inDegreeMap(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            indegree[i] = 0;
        }

        for (int i = 0; i < adj.size(); i++) {
            List<Integer> neighbors = adj.get(i);
            for (int j = 0; j < neighbors.size(); j++) {
                int n = neighbors.get(j);
                indegree[n] = indegree[n] + 1;
            }
        }
        return indegree;
    }

    //Function to return list containing vertices in Topological order.
    static int[] topoSortUsingDFS(int V, List<List<Integer>> adj) {
        // add your code here
        int[] res = new int[V];
        int index = 0;
        Deque<Integer> st = new ArrayDeque<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, st);
            }
        }
        while (!st.isEmpty()) {
            res[index++] = st.pop();
        }
        return res;
    }

    private static void dfs(int src, List<List<Integer>> adj, boolean[] visited, Deque<Integer> st) {
        visited[src] = true;
        for (int ngh : adj.get(src)) {
            if (!visited[ngh]) {
                dfs(ngh, adj, visited, st);
            }
        }
        st.push(src);
    }
}

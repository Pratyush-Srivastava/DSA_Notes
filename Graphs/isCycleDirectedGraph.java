package Graphs;

import java.util.List;

import static java.util.Arrays.asList;

public class isCycleDirectedGraph {
    // Function to detect cycle in a directed graph.
    public static void main(String[] args) {
        List<List<Integer>> adj = asList(asList(1), asList(2), asList(3), asList(3));
        System.out.println(isCyclic(4, adj));
    }
    private static boolean isCyclic(int V, List<List<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(isCyclicGraph(i, adj, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclicGraph(int source, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        // code here
        visited[source] = true;
        recStack[source] = true;
        List<Integer> ngh = adj.get(source);
        for(Integer n : ngh) {
            if(!visited[n]) {
                if(isCyclicGraph(n, adj, visited, recStack)) {
                    return true;
                }
            } else if(recStack[n]){
                return true;
            }
        }
        recStack[source] = false;
        return false;
    }
}

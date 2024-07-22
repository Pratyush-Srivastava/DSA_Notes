package Graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Dijkstra {

    public static void main(String[] args) {
        List<List<List<Integer>>> adj = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(1, 5),
                        Arrays.asList(2, 1)
                ),
                Arrays.asList(
                        Arrays.asList(2, 3),
                        Arrays.asList(0, 5)
                ),
                Arrays.asList(
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 3)
                )
        );
        System.out.println(Arrays.toString(dijkstra(3, adj, 0)));

        adj = Arrays.asList(
                Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 6)), // Edges for vertex 0
                Arrays.asList(Arrays.asList(0, 2), Arrays.asList(2, 3), Arrays.asList(3, 8), Arrays.asList(4, 5)), // Edges for vertex 1
                Arrays.asList(Arrays.asList(1, 3), Arrays.asList(4, 7)), // Edges for vertex 2
                Arrays.asList(Arrays.asList(0, 6), Arrays.asList(1, 8), Arrays.asList(4, 9)), // Edges for vertex 3
                Arrays.asList(Arrays.asList(1, 5), Arrays.asList(2, 7), Arrays.asList(3, 9)) // Edges for vertex 4
        );
        System.out.println(Arrays.toString(dijkstra(5, adj, 0)));
    }

    static int[] dijkstra(int V, List<List<List<Integer>>> adj, int S) {
        // Write your code here

        boolean[] visited = new boolean[V];
        int[] keys = new int[V];
        Arrays.fill(keys, Integer.MAX_VALUE);
        keys[S] = 0;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a1, List<Integer> a2) {
                return a1.get(1) - a2.get(1);
            }
        });
        pq.offer(Arrays.asList(S, 0));
        while (!pq.isEmpty()) {
            List<Integer> min = pq.poll();
            int minVertex = min.get(0);
            int minKey = min.get(1);
            if (!visited[minVertex]) {
                visited[minVertex] = true;
                for (int ngh = 0; ngh < adj.get(minVertex).size(); ngh++) {
                    int dest = adj.get(minVertex).get(ngh).get(0);
                    int weight = adj.get(minVertex).get(ngh).get(1);
                    if (!visited[dest] && keys[minVertex] + weight < keys[dest]) {
                        keys[dest] = keys[minVertex] + weight;
                        pq.offer(Arrays.asList(dest, keys[dest]));
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (keys[i] == Integer.MAX_VALUE) {
                keys[i] = -1;
            }
        }
        return keys;
    }

}
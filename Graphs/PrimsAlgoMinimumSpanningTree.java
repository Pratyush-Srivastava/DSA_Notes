package Graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgoMinimumSpanningTree {
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
        System.out.println(minimumSpanningTreePrims(3, adj));

        adj = Arrays.asList(
                Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 6)), // Edges for vertex 0
                Arrays.asList(Arrays.asList(0, 2), Arrays.asList(2, 3), Arrays.asList(3, 8), Arrays.asList(4, 5)), // Edges for vertex 1
                Arrays.asList(Arrays.asList(1, 3), Arrays.asList(4, 7)), // Edges for vertex 2
                Arrays.asList(Arrays.asList(0, 6), Arrays.asList(1, 8), Arrays.asList(4, 9)), // Edges for vertex 3
                Arrays.asList(Arrays.asList(1, 5), Arrays.asList(2, 7), Arrays.asList(3, 9)) // Edges for vertex 4
        );
        System.out.println(minimumSpanningTreePrims(5, adj));

    }

    private static int minimumSpanningTreePrims(int V, List<List<List<Integer>>> adj) {
        boolean[] visited = new boolean[V];
        int[] keys = new int[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] edge1, int[] edge2) {
                return edge1[1] - edge2[1];
            }
        });
        Arrays.fill(keys, Integer.MAX_VALUE);
        keys[0] = 0;
        pq.offer(new int[]{0, 0});
        int res = 0;
        while (!pq.isEmpty()) {
            int[] vertexAndKey = pq.poll();
            int minVertex = vertexAndKey[0];
            int minKey = vertexAndKey[1];
            if (!visited[minVertex]) {
                visited[minVertex] = true;
                res += minKey;
                // edge relaxation
                for (int neighbor = 0; neighbor < adj.get(minVertex).size(); neighbor++) {
                    int dest = adj.get(minVertex).get(neighbor).get(0);
                    int weight = adj.get(minVertex).get(neighbor).get(1);
                    if (!visited[dest] && weight < keys[dest]) {
                        keys[dest] = weight;
                        pq.offer(new int[]{dest, weight});
                    }
                }
            }
        }
        return res;
    }
}

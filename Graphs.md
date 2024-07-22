1. Degree of a vertex in undirected graph is the number of edges connected to it
2. In-Degree of a vertex in directed graph is the number of edges coming towards it
3. Out-Degree of a vertex in directed graph is the number of edges coming out of it
4. In a directed graph, the sum of in-degree = the sum of out-degree = number of edges.
5. If every vertex is connected to every other vertex in undirected graph, it is called complete graph.
6. Cyclic graph means a path exists starting and ending with the same vertex. Directed acyclic graph is used in
   topological sorting
7. Graphs can be represented using adjacency matrix, the value is 1 if there is an edge from vertex else 0.
   For undirected graph, the matrix is symmetric, the lower half is same as the upper half.
8. Graphs can be represented using adjacency list which is an array list of array list. The outer list represents
   each vertex and the inner list represent the vertices connected to that vertex. In undirected graph, if 1 is
   connected to 0 then 0 will also be connected to 1. For sparse graphs, adjacency list is more suitable in real world
   problems.
9. In Breadth first search, we travel from source, add it the queue and mark it as visited. Add neighbors to the queue
   if not visited. We mark as visited if it is added to the queue. We use this when we want to find the shortest path
   or traverse the closest neighbors first.
10. In Depth first search, we travel through each neighbor and travel its neighbors and so on until we have visited
    everything. This is used for path finding and maze solving.
11. If the component is disconnected, we run a loop for all the vertices and do DFS/BFS for each every node not visited.
    Increment the count to get the number of connected components. Back tracking uses DFS. While solving graph
    questions,
    remember it could be a disconnected graph.
12. For shortest path in an unweighted graph (directed or undirected) from source to all other nodes, do BFS and keep
    updating the distance array
    if the distance is lesser than the existing distance.
13. For shortest path in a weighted (directed or undirected) with non-negative edges, you need to follow dijkstra which
    is similar to prim's algorithm. You need to take a priority queue and keys array for storing vertex and keys. Also,
    take a visited array to see if the shortest till that point is found. While the priority queue is not empty, poll
    the vertex with minimum key and if it is not visited, go through all the unvisited neighbors and relax all the edges if
    minKey + edgeLength is smaller than current key and also offer that in the priority queue.
14. For shortest path in a weighted directed acyclic graph (DAG), you can use topological sorting and then iterate over
    that array and perform edge relaxation which is to check min(source + edge, neighbor) and assign to neighbor. Make
    sure you don't add anything to MAX_VALUE.

| **Shortest path from source** | **Unweighted**       | **Weighted**                                                    |
|-------------------------------|----------------------|-----------------------------------------------------------------|
| **Directed**                  | BFS                  | Topological Sort (DAG only) or Dijkstra (non-negative weights)  |
| **Undirected**                | BFS                  | Dijkstra                                                        |

15. For cycle detection in undirected graph, do BFS and store each parent in an array. if a neighbor is visited, and it
    is not the parent, then cycle exists. Or another solution would be use DFS and with each recursion call, pass the
    parent
    and check the same condition if the neighbor is visited, and it is not the parent, then cycle exists.
16. For cycle detection in directed graph, you need to do DFS and maintain both recursion array along with visited
    array, and you need to reset the recursion array boolean to false after iterating all the neighbors. There will be
    a cycle if it is visited and also part of recursion array. This is also called as a back edge.

| **Graph Type**           | **Cycle Detection Method**                                                                   |
|--------------------------|---------------------------------------------------------------------------------------------|
| **Undirected**           | Use BFS, store each parent in an array OR use DFS and pass the parent with each recursion    |
| **Directed**             | Use DFS and maintain both a recursion stack array and a visited array.                       |

17. For topological sorting with BFS, (only for directed acyclic graph) find all vertices having in-degrees as zero and
    push it to the queue. Then, iterate over neighbors and reduce the in-degrees and put it in queue if in-degree
    becomes zero. You don't need the visited array. (Kahn's BFS based algorithm). We can also use this for cycle 
    detection, if all vertices are not processed in the queue, it means cycle exists.
18. For topological sorting with DFS, you should do usual DFS for all vertices which are not visited. Push to the stack
    after processing all the neighbors. In this way, the last item on which every item is eventually dependent on will
    be pushed first. After calling DFS for every item, the stack is filled. Now pop and print to get topological sorted
    array.
19. For minimum spanning tree which is a connected unweighted graph, use Prim's algorithm. Define keys array and visited
    array for all vertices. Also define a min priority queue where vertex and its key is stored. Define a comparator for
    that to compare the keys and not the vertex. Until the priority is not empty, keep taking out the min vertex and key.
    Proceed only if it is not visited. Go through all neighbors which are not visited and relax the edge comparing edge 
    weight and neighbor key. Reassign key for relaxing and offer the vertex and edge in the priority queue. 
    This will be O(E Log V)
20. For undirected graph, You can just use dfs or bfs to find strongly connected components.

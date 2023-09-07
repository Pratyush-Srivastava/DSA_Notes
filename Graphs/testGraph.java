package Graphs;

public class testGraph {
	  // Driver Method 
    public static void main (String[] args) 
    { 
        /* Let us create following graph 
         0 
        |  \ 
        |    \ 
        1-----2 */
        int V = 3, E = 3; 
        Graph graph = new Graph(V, E); 
  
        // add edge 0-1 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
  
        // add edge 1-2 
        graph.edge[1].src = 1; 
        graph.edge[1].dest = 2; 
  
        // add edge 0-2 
        graph.edge[2].src = 0; 
        graph.edge[2].dest = 2; 
  
        if (graph.isCycle(graph)==true) 
            System.out.println( "graph contains cycle" ); 
        else
            System.out.println( "graph doesn't contain cycle" ); 
    }

}

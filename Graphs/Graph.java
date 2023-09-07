package Graphs;



// Java Program for union-find algorithm to detect cycle in a graph 
import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class Graph 
{ 
    int V, E;    // V-> no. of vertices & E->no.of edges 
    Edge edge[]; // /collection of all edges 
  
    class Edge 
    { 
        int src, dest; 
    }; 
  
    // Creates a graph with V vertices and E edges 
    Graph(int v,int e) 
    { 
        V = v; 
        E = e; 
        edge = new Edge[E]; 
        for (int i=0; i<e; ++i) 
            edge[i] = new Edge(); 
    }
    
    //Union-Find Algorithm
   public boolean isCycle(Graph graph) {
	   HashMap<Integer,Integer> parent=new HashMap<>();
	   HashMap<Integer,Integer> rank=new HashMap<>();
	   for(int i=0;i<V;i++) {
		   parent.put(i, i);
		   rank.put(i,0);
	   }
	   for(int j=0;j<E;j++) {
		   int x=find(parent,edge[j].src);
		   int y=find(parent,edge[j].dest);
		   if(x==y)
			   return true;
		   union(parent,rank,x,y);
	   }
	   return false;
   }
   void union(HashMap<Integer,Integer> parent,HashMap<Integer,Integer> rank,int x,int y) {
	   int xroot=find(parent,x);
	   int yroot=find(parent,y);
	   if(rank.get(xroot)>rank.get(yroot))
		   parent.put(yroot, xroot);
	   else if(rank.get(xroot)<rank.get(yroot))
		   parent.put(xroot, yroot);
	   else
	   {
		   rank.put(xroot, rank.get(xroot)+1);
		   parent.put(yroot, xroot);
	   }
   }
   int find(HashMap<Integer,Integer> parent,int i) {
	   if(parent.get(i)!=i) {
		   parent.put(i, find(parent,parent.get(i)));
	   }
	   return parent.get(i);
   }
  
   
}
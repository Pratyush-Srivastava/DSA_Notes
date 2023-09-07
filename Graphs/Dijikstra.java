package Graphs;

/* IMPORTANT: Multiple classes and nested static classes are supported */


//* uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


//Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Dijikstra {
static class Node{
    int value;
    int key;
    boolean vis;
    public Node(int value){
        this.value=value;
        this.key=Integer.MAX_VALUE;
        this.vis=false;
    }
}
static class SortByKey implements Comparator<Node>{
    public int compare(Node a,Node b){
        return a.key-b.key;
    }
}
public static void main(String args[] ) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int t=Integer.parseInt(br.readLine());
    while(t-->0){
        int n=Integer.parseInt(br.readLine());
        int[][] a=new int[n][n];
        List<HashMap<Integer,Integer>> adj=new ArrayList<>();
        Node[] nr=new Node[n];
        for(int i=0;i<n;i++){
            String[] s=br.readLine().trim().split(" ");
            nr[i]=new Node(i);
            adj.add(new HashMap<>());
            for(int j=0;j<n;j++){
                a[i][j]=Integer.parseInt(s[j]);
                if(a[i][j]!=0){
                    adj.get(i).put(j,a[i][j]);
                }
            }
        }
        String[] str=br.readLine().trim().split(" ");
        int src=Integer.parseInt(str[0]);
        int g=Integer.parseInt(str[1]);
        nr[src].key=0;
        PriorityQueue<Node> pq=new PriorityQueue<>(n,new SortByKey());
        int [] parent=new int[n];
        for(int i=0;i<n;i++){
            pq.add(nr[i]);
            parent[i]=-1;
        }
        int count=n-1;
        while(count-->0){
            Node cur=pq.remove();
            nr[cur.value].vis=true;
            
            HashMap<Integer,Integer> map=adj.get(cur.value);
            for(HashMap.Entry<Integer,Integer> entry: map.entrySet()){
                int keys=entry.getKey();
                int value=entry.getValue();
                if(cur.key+value<nr[keys].key){
                    pq.remove(nr[keys]);
                    nr[keys].key=cur.key+value;
                    pq.add(nr[keys]);
                    parent[keys]=cur.value;
                }
                
            }
            
        }
        //call
        
        List<Integer> alist=new ArrayList<>();
        int sum=path(alist,parent,g,src,adj);
        System.out.println(sum);
        StringBuffer sb=new StringBuffer();
        for(int j=alist.size()-1;j>=0;j--){
            sb.append(alist.get(j)+" ");
        }
        System.out.println(sb.toString().trim());
        // System.out.println(" adj "+adj);
        // for(int i=0;i<n;i++){
            
        //     System.out.println(sum+" parent "+parent[i]);
        // }
        
        
    }
}
static int path(List<Integer> a,int[] parent,int i,int src,List<HashMap<Integer,Integer>> adj){
    a.add(i);
    if(i!=src){
        return adj.get(i).get(parent[i])+path(a,parent,parent[i],src,adj);
    }
    return 0;
}
}
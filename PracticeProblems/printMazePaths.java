package PracticeProblems;
import java.util.*;
public class printMazePaths {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					a[i][j]=sc.nextInt();
			ArrayList<String> res=printPath(a,n);
			for(int i=0;i<res.size();i++)
				System.out.print(res.get(i)+" ");
			System.out.println();
		}
	}
	
	static ArrayList<String> printPath(int[][] a,int n) {
		ArrayList<String> arr=new ArrayList<>();
		boolean[][] vis=new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				vis[i][j]=false;
			}
		}
		path(arr,"",a,vis,n,0,0,n-1,n-1);
		
		Collections.sort(arr);
		return arr;
		
	}
	static void path(ArrayList<String> arr,String cur,int[][] a,boolean[][] vis,int n,int sx,int sy,int ex,int ey) {
		if(sx==ex && sy==ey) {

			arr.add(cur);
			return;
		}
		vis[sx][sy]=true;			
		int i,j;
		i=sx;
		j=sy+1;
		if(isValid(i,j,n) && a[i][j]==1 && !vis[i][j]) {

			path(arr,cur+'R',a,vis,n,i,j,ex,ey);	
		}
		
		i=sx+1;
		j=sy;
		if(isValid(i,j,n) && a[i][j]==1 && !vis[i][j]) {
			path(arr,cur+'D',a,vis,n,i,j,ex,ey);	
		}
		
		i=sx-1;
		j=sy;
		if(isValid(i,j,n) && a[i][j]==1 && !vis[i][j]) {
			path(arr,cur+'U',a,vis,n,i,j,ex,ey);	
		}
		i=sx;
		j=sy-1;
		if(isValid(i,j,n) && a[i][j]==1 && !vis[i][j]) {
			
			path(arr,cur+'L',a,vis,n,i,j,ex,ey);	
		}
		vis[sx][sy]=false;
	}
	static boolean isValid(int i,int j,int n) {
		return (i>=0 && i<n && j>=0 && j<n);
	}
	


}

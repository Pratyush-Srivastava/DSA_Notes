package PracticeProblems;
import java.util.*;
import java.io.*;
public class minStepsKnightProblem {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0) {
			String[] str;
			int n=Integer.parseInt(br.readLine());
			str=br.readLine().trim().split(" ");
			int sx=Integer.parseInt(str[0]);
			int sy=Integer.parseInt(str[1]);
			str=br.readLine().trim().split(" ");
			int ex=Integer.parseInt(str[0]);
			int ey=Integer.parseInt(str[1]);
			boolean[][] vis=new boolean[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++){
					vis[i][j]=false;
				}
			}
			System.out.println(" minimum steps required by the knight "+knight(n,sx,sy,ex,ey,vis));
			
			
		}

	}
	static class cell{
		int x;
		int y;
		int dist;
		public cell(int x,int y,int dist) {
			this.x=x;
			this.y=y;
			this.dist=dist;
		}
	}
	public static int knight(int n,int sx,int sy,int ex,int ey,boolean[][] vis) {
		cell st=new cell(sx,sy,0);
		Queue<cell> q=new LinkedList<>();
		q.add(st);
		vis[st.x][st.y]=true;
		if(st.x==ex && st.y==ey)
			return 0;
		while(!q.isEmpty()) {
			cell c=q.remove();
			int a,b;
			a=c.x+1;
			b=c.y+2;
			if(a==ex && b==ey) {
				return 1+c.dist;
			}
			else {
				if(isValid(a,b,n) && !vis[a][b])
					{
					vis[a][b]=true;
					q.add(new cell(a,b,1+c.dist));				
					}
			}
			
			a=c.x+2;
			b=c.y+1;
			
			if(a==ex && b==ey) {
				return 1+c.dist;
			}
			else {
				if(isValid(a,b,n) && !vis[a][b])
				{
				vis[a][b]=true;
				q.add(new cell(a,b,1+c.dist));				
				}				
			}
			a=c.x+2;
			b=c.y-1;
			
			if(a==ex && b==ey) {
				return 1+c.dist;
			}
			else {
				if(isValid(a,b,n) && !vis[a][b])
				{
				vis[a][b]=true;
				q.add(new cell(a,b,1+c.dist));				
				}				
			}
			a=c.x+1;
			b=c.y-2;
			
			if(a==ex && b==ey) {
				return 1+c.dist;
			}
			else {
				if(isValid(a,b,n) && !vis[a][b])
				{
				vis[a][b]=true;
				q.add(new cell(a,b,1+c.dist));				
				}				
			}
			a=c.x-1;
			b=c.y+2;
			
			if(a==ex && b==ey) {
				return 1+c.dist;
			}
			else {
				if(isValid(a,b,n) && !vis[a][b])
				{
				vis[a][b]=true;
				q.add(new cell(a,b,1+c.dist));				
				}				
			}
			a=c.x-2;
			b=c.y+1;
			if(a==ex && b==ey) {
				return 1+c.dist;
			}
			else {
				if(isValid(a,b,n) && !vis[a][b])
				{
				vis[a][b]=true;
				q.add(new cell(a,b,1+c.dist));				
				}				
			}
			a=c.x-2;
			b=c.y-1;
			
			if(a==ex && b==ey) {
				return 1+c.dist;
			}
			else {
				if(isValid(a,b,n) && !vis[a][b])
				{
				vis[a][b]=true;
				q.add(new cell(a,b,1+c.dist));				
				}				
			}

			a=c.x-1;
			b=c.y-2;
			
			if(a==ex && b==ey) {
				return 1+c.dist;
			}
			else {
				if(isValid(a,b,n) && !vis[a][b])
				{
				vis[a][b]=true;
				q.add(new cell(a,b,1+c.dist));				
				}				
			}
		}
		 
		return -1;
	}
	public static boolean isValid(int a,int b,int n) {
		return (a>=0 && b>=0 && a<n && b<n);
	}
	

}


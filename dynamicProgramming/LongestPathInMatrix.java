package dynamicProgramming;
import java.io.*;
import java.util.*;
public class LongestPathInMatrix {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0) {
			int n=Integer.parseInt(br.readLine());
			int[][] arr=new int[n][n];
			String[] str=br.readLine().split(" ");
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(str[n*i+j]);
				}
			}
			System.out.println(iterative(arr));
			
		}

	}
	static int iterative(int[][] arr) {
		int n=arr.length;
		int[][] res=new int[n+1][n+1];
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res.length;j++) {
				if(i==0 || j==0)
					res[i][j]=0;
				else {
					int a=Integer.MIN_VALUE,b=Integer.MIN_VALUE,c=Integer.MIN_VALUE;
					if(j-1>=0)
						a=res[i-1][j-1];
					b=res[i-1][j];
					if(j+1<n+1)
						c=res[i-1][j+1];
					res[i][j]=arr[i-1][j-1]+Math.max(Math.max(a, b),c);
				}
			}
		}
		int i=n;
		int max=Integer.MIN_VALUE;
		for(int j=0;j<res.length;j++)
		if(res[i][j]>max)
			max=res[i][j];
		return max;
	}
	

}

package PracticeProblems;
import java.util.*;
import java.io.*;
public class NQueens {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the value of N");
		int n=Integer.parseInt(br.readLine());
		int[][] a=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j]=0;
			}
		}
//		int[][] res=backtrack(a,0,0);
	

	}
//	static int[][] backtrack(int[][] a,int i,int j) {
//		if(i==a.length-1 && j==a.length-1) {
//			return a;
//		}
//		else {
//			
//		}
//	}
	static boolean isValid(int[][] a,int x,int y) {
		HashMap<Integer,Integer> row=new HashMap<>();
		HashMap<Integer,Integer> col=new HashMap<>();
		HashMap<String,Integer> xy=new HashMap<>();
		
		
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				if(a[i][j]==1) {
					row.put(i, 1);
					col.put(j, 1);
					xy.put(i+""+j, 1);
				}
			}
		}
		if(row.containsKey(x))
			return false;
		if(col.containsKey(y))
			return false;
		for(HashMap.Entry<String,Integer> entry: xy.entrySet()) {
			String key=entry.getKey();
			int value=entry.getValue();
			int xnew=key.charAt(0)-'0';
			int ynew=key.charAt(1)-'0';
			if((xnew+ynew)==(x+y) || (xnew-ynew)==(x-y))
				return false;
		}
		return true;
		
	}

}

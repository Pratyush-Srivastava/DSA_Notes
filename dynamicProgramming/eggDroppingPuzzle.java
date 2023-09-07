package dynamicProgramming;

public class eggDroppingPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;//number of eggs
		int k=5;//number of floors
		System.out.println(" recursive solution is "+recur(n,k));
		System.out.println(" iterative solution is "+iter(n,k));
		
	}
	static int iter(int n,int k) {
		int[][] res=new int[n+1][k+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<k+1;j++) {
				if( i==0 || j==0) {
					res[i][j]=0;
				} else if(j==1) {
					res[i][j]=1;
				} else if(i==1) {
					res[i][j]=j;
				} else {
					int min=Integer.MAX_VALUE;
					for(int x=1;x<=j;x++) {
						int cur=Math.max(res[i-1][x-1], res[i][j-x]);
						if(cur<min) {
							min=cur;
						}
					}
					res[i][j]=1+min;
					
				}
				System.out.print(res[i][j]+" : ");
			}
			System.out.println();
		}
		return res[n][k];
	}
		
	static int recur(int n,int k) {
		if(k==1)
			return 1;
		if(k==0)
			return 0;
		if(n==0)
			return 0;
		if(n==1)
			return k;
		
		int min=Integer.MAX_VALUE;
		for(int i=1;i<=k;i++) {
			int cur=Math.max(recur(n-1,i-1),recur(n,k-i));
			if(cur<min) {
				min=cur;
			}
		}
		return 1+min;
	}

}

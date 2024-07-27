package DynamicProgramming;

public class MatrixChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] d= {30,35,15,5,10,20,25};
		int n=d.length-1;
		int i,j;
		int[][] res=new int[n][n];
		for(int a=0;a<n;a++) {
			for(int b=0;b<n;b++) {
				if(a==b)
					res[a][b]=0;
			}
		}
		for(int diff=1;diff<n;diff++) {
			i=0;
			j=i+diff;
			while(j<n) {
				int min=Integer.MAX_VALUE;
				for(int k=i;k<j;k++) {
					int cur=res[i][k]+res[k+1][j]+d[i]*d[k+1]*d[j+1];
					if(cur<min) {
						min=cur;
					}
				}
				res[i][j]=min;
				System.out.print(res[i][j]+": ");
				i++;
				j=i+diff;
			}
			System.out.println();
			
		}
		
		
	
	}
	

}

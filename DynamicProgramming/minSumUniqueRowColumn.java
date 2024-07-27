package DynamicProgramming;

public class minSumUniqueRowColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a= {{1, 2, 3, 4},
					{4, 1, 2, 3},
					{3, 4, 1, 2},
					{2, 3, 4, 1}};
		
		
		

	}
	static int minSum(int[][] a) {
		int n=a.length;
		int[][] res=new int[n][n];
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==0) {
					res[i][j]=a[i][j];
				}
				else {
					
				}
			}
		}
		return min;
		
	}

}

package dynamicProgramming;

public class OptimalGame {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		int[] a= {5 ,3, 7, 10};
		int n=a.length;
		System.out.println(recurGame(a,0,n-1,n));
	}
	static int recurGame(int[] a,int i,int j,int n) {
		if(i==j) {
			if(n%2==0)
				return 0;
			else
				return a[i];
		}
		else {
			int curlength=j-i+1;
			int x,y;
			if((n-curlength)%2==1) {
				//B's turn
				x=recurGame(a,i+1,j,n);
				y=recurGame(a,i,j-1,n);
			}
			else {
				// A's turn
				x=a[i]+recurGame(a,i+1,j,n);
				y=a[j]+recurGame(a,i,j-1,n);				
			}
			return Math.max(x,y);
		}
		
	}

}

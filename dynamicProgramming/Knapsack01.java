package dynamicProgramming;

public class Knapsack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] b={1,2,5,6};
		int[] w= {2,3,4,5};
		
		int k=w.length;
		int wMax=8;
		System.out.println("The Recursive Solution is - "+recursiveSol(wMax,k-1,b,w));
		System.out.println("The Iterative Solution is - "+iterativeSol(wMax,b,w));
		System.out.println("The Recur Solution is - "+recur(b,w,k,wMax,0));
		System.out.println("The Iter Sol is - "+iter(b,w,k,wMax));


	}
	static int recur(int[] b,int[] w,int k,int wMax,int i) {
		if(i>=k || wMax<=0) {
			return 0;
		}
		else {
			if(w[i]<=wMax) {
				int b1=b[i]+recur(b,w,k,wMax-w[i],i+1);
				int b2=recur(b,w,k,wMax,i+1);
				
				return Math.max(b1,b2);
			}
			else {
				int b3=recur(b,w,k,wMax,i+1);
				return b3;
			}
		}
	}
	static int iter(int[] b,int[] w,int k,int wMax) {
		int[][] res=new int[k+1][wMax+1];
		for(int i=0;i<k+1;i++) {
			for(int j=0;j<wMax+1;j++) {
				if(i==0 || j==0) {
					res[i][j]=0;
				}
				else {
					if(w[i-1]<=j) {
						res[i][j]=Math.max(b[i-1]+res[i-1][j-w[i-1]],res[i-1][j] );
					}
					else {
						res[i][j]=res[i-1][j];
					}
				}
				System.out.print(" ["+i+","+j+"]= "+res[i][j]+"  ");
			}
			System.out.println();
		}
		return res[k][wMax];
	}
	
	
	
	
	
	
	
	
	
	
	
	static int recursiveSol(int wMax,int k,int[] b,int[] w) {
		if(k==-1 || wMax==0)
			return 0;
		else {
			if(wMax>=w[k]) {
				int pres=recursiveSol(wMax-w[k],k-1,b,w)+b[k];
				int abs=recursiveSol(wMax,k-1,b,w);
				return Math.max(pres,abs);
			}				
			else
				return recursiveSol(wMax,k-1,b,w);
		}
	}
	static int iterativeSol(int wMax,int[] b,int[] w) {
		int[][] res=new int[w.length+1][wMax+1];
		for(int k=0;k<=w.length;k++) {
			for(int wcurr=0;wcurr<=wMax;wcurr++) {
				if(wcurr==0 || k==0) {
					res[k][wcurr]=0;
				}
				else {
					if(wcurr>=w[k-1]) 
						res[k][wcurr]=Math.max(res[k-1][wcurr-w[k-1]]+b[k-1],res[k-1][wcurr]);
					else 
						res[k][wcurr]=res[k-1][wcurr];
				}
				System.out.print(" ["+k+","+wcurr+"]= "+res[k][wcurr]+"  ");
			}
			System.out.println();
			
		}
		return res[w.length][wMax];
	}

}

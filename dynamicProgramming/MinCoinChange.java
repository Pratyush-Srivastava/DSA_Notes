package dynamicProgramming;
//Coin Change Problem Where Order Matters and Order doesn't matter.
//{1,2,1} and {1,1,2} are same when order doesn't matter
import java.util.*;
public class MinCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=43;
		int[] coins= { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
		//finding min
//		System.out.println("The recursive Sol is ="+recursiveSol(n,coins));
		System.out.println("The iterative Sol is ="+iterativeSol(n,coins));
//		//order doesn't matter
//		//finding the number of ways
		System.out.println("The recursive Sol is ="+recur(coins,0,n));
		System.out.println("The iterative Sol is ="+iter(coins,n));
		System.out.println("The denominations used are "+mincoins(coins,n));


	}
	//order doesn't matter
	static int recur(int[] coins,int i,int n) {
		if(n==0)
			return 1;
		if(i>=coins.length)
			return 0;
		
		if(n<0)
			return 0;
		return recur(coins,i+1,n)+recur(coins,i,n-coins[i]);	
	}
	static int iter(int[] coins, int n) {
		int[][] res=new int[coins.length+1][n+1];
		for(int i=0;i<coins.length+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(j==0)
					res[i][j]=1;
				else if(i==0)
					res[i][j]=0;
				else {
					if(coins[i-1]<=j) {
						res[i][j]=res[i-1][j]+res[i][j-coins[i-1]];
					}
					else {
						res[i][j]=res[i-1][j];
					}
				}
				System.out.print(res[i][j]+" : ");
			}
			System.out.println();
		}
		return res[coins.length][n];
	}
	
	
	static int recursiveSol(int n,int[] coins) {
		if(n==0)
			return 0;
		else {
			int min=Integer.MAX_VALUE;
			for(int i=0;i<coins.length;i++) {
				int cur;
				if(n-coins[i]>=0)
				{
					cur=recursiveSol(n-coins[i],coins);
					if(cur!=Integer.MAX_VALUE && cur+1<min) {//THIS STEP IS VERY IMPORTANT
						min=cur+1;
					}
				}
	
			}
			return min;
		}
	}
	static int iterativeSol(int n,int[] coins) {
		int[] res=new int[n+1];
		for(int ncurr=0;ncurr<=n;ncurr++) {
			if(ncurr==0) {
				res[ncurr]=0;
			}
			else {
				int min=Integer.MAX_VALUE;
				for(int i=0;i<coins.length;i++) {
					int cur;
					if(ncurr>=coins[i]) {
						cur=res[ncurr-coins[i]];
						if(cur!=Integer.MAX_VALUE && cur+1<min) {//THIS STEP IS VERY IMPORTANT
							min=cur+1;
						}
					}					
				}
				res[ncurr]=min;
			}
//			System.out.print(res[ncurr]+": " );
		}
		System.out.println();
		return res[n];
	}
	static List<Integer> mincoins(int[] a,int n){
	    int[][] res=new int[a.length+1][n+1];
	    int[] num=new int[a.length];
	    for(int k=0;k<a.length;k++){
	        num[k]=0;
	    }
	    for(int i=0;i<a.length+1;i++){
	        for(int j=0;j<n+1;j++){
	            if(j==0)
	            res[i][j]=0;
	            else if(i==0)
	            res[i][j]=Integer.MAX_VALUE;
	            else{
	                if(j-a[i-1]>=0){
	                    if(res[i][j-a[i-1]]<res[i-1][j]){
	                    res[i][j]=1+res[i][j-a[i-1]];
	                    num[i-1]+=1;
	                    }
	                    else{
	                    res[i][j]=res[i-1][j];
	                    }
	                }
	                else{
	                    res[i][j]=res[i-1][j];
	                }
	            }
	           // System.out.print(res[i][j]+" : ");
	        }
	        //System.out.println();
	    }
	    List<Integer> arr=new ArrayList<>();
	    int i=a.length;
	    int j=n;
	    while(i>=1 && j>=1){
	        if(j-a[i-1]>=0){
	            if(res[i][j-a[i-1]]<res[i-1][j]){
	               arr.add(a[i-1]);
	               j=j-a[i-1];
	           }
	           else{
	               res[i][j]=res[i-1][j];
	               i=i-1;
	           }
	       }
	       else{
	               res[i][j]=res[i-1][j];
	               i=i-1;
	       }
	    }
	   
	    return arr;
	}

}

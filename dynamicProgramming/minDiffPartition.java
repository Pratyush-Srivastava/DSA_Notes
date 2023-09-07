package dynamicProgramming;

import java.io.*;
public class minDiffPartition {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0) {
			br.readLine();
			String[] str=br.readLine().trim().split(" ");
			int[] a=new int[str.length];
			int sum=0;
			for(int i=0;i<a.length;i++) {
				a[i]=Integer.parseInt(str[i]);
				sum+=a[i];
			}	
			System.out.println("the recursive solution is "+minDiff(a,a.length-1,sum,0));
			System.out.println("the iterative solution is "+iterDiff(a));
		}

		
		

	}
	static int minDiff(int[] arr,int i,int sum1,int sum2) {
		if(i<=0)
			return Math.abs(sum1-sum2);	
		else{
			int d1=minDiff(arr,i-1,sum1-arr[i],sum2+arr[i]);
			int d2=minDiff(arr,i-1,sum1,sum2);
			return Math.min(d1, d2);			
		}

	}
	static int iterDiff(int[] arr) {
		int n=arr.length;
		int[] res=new int[n+1];
		int[] sum1=new int[n+1];
		int[] sum2=new int[n+1];
		int sum=0;
		for(int i=0;i<n;i++)
			sum+=arr[i];
		for(int i=0;i<n+1;i++) {
			if(i==0)
				{
					res[i]=0;
					sum1[i]=0;
					sum2[i]=0;
				}
			else {
				int a,b,c,d,x,y;
				a=sum1[i-1]+arr[i-1];
				b=sum2[i-1];
				x=Math.abs(a-b);
				
				c=sum1[i-1];
				d=sum2[i-1]+arr[i-1];
				y=Math.abs(c-d);
				if(x<y) {
					sum1[i]=a;
					sum2[i]=b;
					res[i]=x;
				}
				else {
					sum1[i]=c;
					sum2[i]=d;
					res[i]=y;
				}
				
				
			}
			System.out.println(i+" "+res[i]+" "+sum1[i]+" "+sum2[i]);

		}
		return res[n];
	}

}

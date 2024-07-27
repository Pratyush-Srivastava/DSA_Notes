package DynamicProgramming;

import java.util.Arrays;

public class maxBitonicSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={80 ,60, 30 ,40 ,20 ,10};
		
		int[] crr=new int[arr.length];
		
		int[] brr=new int[arr.length];
		brr=Arrays.copyOf(arr, arr.length);
		
		
		
		Arrays.sort(brr);
		for(int i=0;i<brr.length;i++) {
			crr[i]=brr[brr.length-i-1];
		}
		
		int[] inc=common(arr,brr);
		int[] temp=common(arr,crr);
		int[] dec=new int[arr.length];
		for(int i=0;i<brr.length;i++) {
			dec[i]=temp[temp.length-i-1];
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<inc.length;i++) {
			System.out.println(i+" "+inc[i]+" - "+dec[i]+" - "+arr[i] );
			int cur=inc[i]+dec[i]-arr[i];
			if(cur>max) {
				max=cur;
			}
		}
		System.out.println(" the answer is "+max);

	}
	static int[] common(int[] arr1,int[] arr2) {
		
		int[][] res=new int[arr1.length+1][arr2.length+1];
		int[] lim=new int[arr1.length];
		for(int i=0;i<arr1.length+1;i++) {
			for(int j=0;j<arr2.length+1;j++) {
				if(i==0 || j==0) {
					res[i][j]=0;
				}
				else {
					if(arr1[i-1]==arr2[j-1]) {
						res[i][j]=arr1[i-1]+res[i-1][j-1];
					}
					else {
						res[i][j]=Math.max(res[i-1][j],res[i][j-1]);
					}
					lim[i-1]=res[i][j];
				}
			}
			
		}
		return lim;
	}

}

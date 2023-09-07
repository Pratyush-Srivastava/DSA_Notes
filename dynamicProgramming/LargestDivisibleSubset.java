package dynamicProgramming;

import java.util.Arrays;

public class LargestDivisibleSubset {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] a= { 1, 3, 6, 13, 17, 18 };
		System.out.println(lengthMaxSubset(a));
		

	}
	static int lengthMaxSubset(int[] a) {
		Arrays.sort(a);
		int max=Integer.MIN_VALUE;
		int[] res=new int[a.length];
		for(int i=0;i<res.length;i++) {
			res[i]=1;
		}
		for(int i=a.length-2;i>=0;i--) {
			for(int j=i+1;j<a.length;j++) {
				if(a[j]%a[i]==0) {
					res[i]=1+res[j];
					break;
				}
			}
			if(res[i]>max) {
				max=res[i];
			}
		}
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" : " );
		}
		System.out.println();
		return max;
	}

}

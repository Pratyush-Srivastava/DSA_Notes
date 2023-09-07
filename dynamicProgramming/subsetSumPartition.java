package dynamicProgramming;
import java.util.*;
import java.io.*;
public class subsetSumPartition {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0) {
			String[] str=br.readLine().trim().split(" ");
			int[] a=new int[str.length];
			int sum=0;
			for(int i=0;i<a.length;i++) {
				a[i]=Integer.parseInt(str[i]);
				sum+=a[i];
			}
			System.out.println(partition(a,a.length,sum,0));
		}

	}
	static boolean iterative(int[] arr) {
		int n=arr.length;
		
		return false;
	}
	static boolean partition(int[] arr,int i,int sum1,int sum2) {
		if(i<=0)
			return false;
		else {
			int s1,s2;
			boolean t1,t2,t3,t4;
			s1=sum1-arr[i-1];
			s2=sum2+arr[i-1];
			t1=(s1==s2);
			t3=partition(arr,i-1,s1,s2);
			s1=sum1;
			s2=sum2;
			t2=(s1==s2);
			t4=partition(arr,i-1,s1,s2);
			return (t1||t2||t3||t4);
			
		}
		
	}

}

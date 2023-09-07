package dynamicProgramming;
import java.io.*;
import java.util.*;
public class distCover {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0) {
			int n=Integer.parseInt(br.readLine());
			System.out.println("the recursive ans is " +recursive(n));
			System.out.println("the iterative ans is " +iterative(n));
			
		}

	}
	static int recursive(int n) {
		if(n==0)
		return 1;
		else {
			if(n<0)
				return Integer.MIN_VALUE;
			else {
				int a=recursive(n-1);
				int b=recursive(n-2);
				int c=recursive(n-3);
				//System.out.println(n+" and "+a+" "+b+" "+c);
				int count=0;
				if(a>=0)
					count+=a;
				if(b>=0)
					count+=b;
				if(c>=0)
					count+=c;
				//System.out.println(n+" count= "+count);
				return count;
			}
		}
	}
	static int iterative(int n) {
		int[] res=new int[n+1];
		for(int i=0;i<res.length;i++) {
			if(i==0)
				res[i]=1;
			else {
				res[i]=0;
				if(i-1>=0)
					res[i]+=res[i-1];
				if(i-2>=0)
					res[i]+=res[i-2];
				if(i-3>=0)
					res[i]+=res[i-3];
				
			}
		}
		return res[n];
	}

}

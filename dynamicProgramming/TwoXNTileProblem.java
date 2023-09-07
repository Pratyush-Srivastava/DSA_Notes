package dynamicProgramming;
import java.io.*;
import java.util.*;
public class TwoXNTileProblem {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    int n=Integer.parseInt(br.readLine());
		    long[] res=new long[n+1];
		    res[0]=1;
		    res[1]=1;
		    for(int i=2;i<n+1;i++){
		        res[i]=res[i-1]+res[i-2];
		        System.out.println(i+" = "+res[i]);
		    }
		    System.out.println(res[n]);
		    
		    
		}
	}

}

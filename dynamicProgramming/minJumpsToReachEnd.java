package dynamicProgramming;
import java.io.*;
public class minJumpsToReachEnd {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
			int n=Integer.parseInt(br.readLine());
			String[] str=br.readLine().trim().split(" ");
			int[] a=new int[str.length];
			for(int i=0;i<str.length;i++){
			a[i]=Integer.parseInt(str[i]);
            }
            System.out.println(jumps(a));
		    
		}

	}
	static int jumps(int[] a){
	    int n=a.length;
	    int[] res=new int[n+1];
	    for(int i=n-1;i>=0;i--){
	        if(i==n-1){
	            res[i]=0;
	        }
	        else{
	            int v=a[i];
	            int min=Integer.MAX_VALUE;
	            for(int j=1;j<=v;j++){
	                int cur;
	                if(i+j<n)
	                {   
	                    if(res[i+j]==Integer.MAX_VALUE)
	                    cur=Integer.MAX_VALUE;
	                    else
	                    cur=1+res[i+j];
	                }
	                else
	                cur=Integer.MAX_VALUE;
	                if(cur<min){
	                    min=cur;
	                }
	            }
	            res[i]=min;
	            
	        }
	        //System.out.print(res[i]+" : " );
	    }
	   // System.out.println();
	    if(res[0]==Integer.MAX_VALUE)
	        return -1;
	        else
	        return res[0];
	    
	}
	

}

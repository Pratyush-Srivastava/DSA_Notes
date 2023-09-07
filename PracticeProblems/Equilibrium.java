package PracticeProblems;
import java.io.*;
public class Equilibrium {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    br.readLine();
		    String[] str=br.readLine().trim().split(" ");
		    int[] a=new int[str.length];
		    for(int i=0;i<str.length;i++){
		        a[i]=Integer.parseInt(str[i]);
		    }
		    int i=0,j=a.length-1;
		    int left=a[i],right=a[j];
		    int flag=0;
		    if(j==1){
		        flag=1;
		        System.out.println("-1");
		    }
		    if(j==0){
		        flag=1;
		        System.out.println("1");
		    }
		    while(flag==0){
		        
		    	System.out.println(left+" and "+right+" and "+i);
		        if(left<right){
		            
		            i++;
		            left+=a[i];
		            
		        }
		        if(left>right){
		            
		            j--;
		            right+=a[j];
		            
		        }
		        if(left==right)
		        {
		            if(j-i==2)
		            {
		                System.out.println(i+1);
		                break;
		            }
		            else
		            {
		                i++;
		                j--;
		                left+=a[i];
		                right+=a[j];
		            }
		        }
		        if(i-j>=1)
		        {
		            System.out.println(-1);
		            break;
		        }
		        
		    }
		}
		

	}

}

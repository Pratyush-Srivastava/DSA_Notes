package PracticeProblems;
//finds the count of subarrays whose sum =k
import java.util.HashMap;
import java.util.*;

public class subArraysSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4,5,6,7,8,9};
		System.out.println("result = "+findSubarraySum(a,a.length,1967));
		System.out.println(" result = "+subArrayModk(a,a.length,5));
		System.out.println(" result = "+hasSum(a,19));

	}

    static int findSubarraySum(int arr[], int n, int sum)  
    {  

        HashMap <Integer, Integer> prevSum = new HashMap<>();  
        
        int res = 0;
        int currsum=0;
        for(int i=0;i<arr.length;i++)
        {
        	currsum+=arr[i];
        	if(currsum==sum)
        		res+=1;
        	if(prevSum.containsKey(currsum-sum)) {
        		res+=prevSum.get(currsum-sum);
        	}
        	if(prevSum.containsKey(currsum))
        	{
        		prevSum.put(currsum, prevSum.get(currsum)+1);
        	}
        	else
        	{
        		prevSum.put(currsum, 1);
        	}
        }
//        System.out.println("prevSum: "+prevSum);
         
   
        return res;  
    }
    static int subArrayModk(int[] arr,int n,int k)
    {
    	int res=0;
    	int currsum=0;
    	HashMap<Integer,Integer> map=new HashMap<>();
    	for(int i=0;i<arr.length;i++)
    	{
    		currsum+=arr[i];
    		if(currsum%k==0)
    			res+=1;
    		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
    			if((currsum-entry.getKey())%k==0) {
    				res+=entry.getValue();
    			}
    		}
    		if(map.containsKey(currsum)) {
    			map.put(currsum, map.get(currsum)+1);
    		}
    		else {
    			map.put(currsum, 1);
    		}
    		
    	}
    	return res;
    }
    static boolean hasSum(int[] a,int m){
	    HashMap<Integer,Integer> map=new HashMap<>();
	    int cur=0;
	    for(int i=0;i<a.length;i++){
	        cur+=a[i];
	        cur=cur%m;
	        //System.out.println(m+" - "+cur+" : "+i+" "+map);
	        if(cur==0)
	        return true;
	        if(map.containsKey(cur)){
	            return true;
	        }
	        if(map.containsKey(cur)){
	            map.put(cur,map.get(cur)+1);
	        }
	        else{
	            map.put(cur,1);
	        }
	        
	    }
	    return false;
	}
}


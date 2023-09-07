package PracticeProblems;

import java.util.*;

public class subSubsetsArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4,5};
		int[] arr=new int[5];
		int count =0;
		
//		for(int i=0;i<Math.pow(2, a.length);i++) 
//		{
//			System.out.print("{ ");
//			for(int j=0;j<a.length;j++)
//			{
//				if( (i & (int)Math.pow(2,j))  > 0)
//				System.out.print(a[j]);
//			}
//			System.out.println(" } "+(count++));
//		}
		List<Integer> a1= new ArrayList<>();
		List<Integer> arr1= new ArrayList<>();
		a1.add(1);
		a1.add(2);
		a1.add(3);
		a1.add(4);
		a1.add(5);
		subsets(a1,arr1,0);
		

	}
	static void subsets(List<Integer> a,List<Integer> arr,int i) 
	{
		if(i>=a.size()) {
			System.out.println(arr);
			return;
		}
		else
		{
			arr.add(i);
			subsets(a,arr,i+1);
			arr.remove(i);
			subsets(a,arr,i+1);
		}
		
	}

	

}

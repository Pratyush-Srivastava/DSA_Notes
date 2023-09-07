package PracticeProblems;
import java.util.*;
public class removingDuplicatesArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {13,12,12,4,5,5,7,8,9,9,10,10};
		//printUnique(arr);
		LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
		for(int c:arr) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
		}
		List<Integer> a=new ArrayList<>();
		for(Map.Entry<Integer,Integer> entry: map.entrySet())
		{
			a.add(entry.getKey());
		}
		System.out.println("using map "+a);
	

	}
	static void printUnique(int[] arr) {
		List<Integer> ab=new ArrayList<>();
		int i=0;
		while(i<arr.length)
		{
			ab.add(arr[i]);
			if(i==arr.length-1)
				break;
		
			if(arr[i]==arr[i+1])
			{
				
				while(arr[i]==arr[i+1]) 
				{
					i++;
					if(i>=arr.length)
						break;
				}
			}
			else
			{
				ab.add(arr[i]);
			}
			i++;
		}
		System.out.println("iterative "+ab);
	}

}

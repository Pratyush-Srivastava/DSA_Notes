package PracticeProblems;
import java.util.*;
public class printNto1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int n=9;
		Queue<Integer> q=new LinkedList<>();
		Stack<Integer> s=new Stack<>();
		q.add(6);
		System.out.println(q.isEmpty()+" and "+q);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println("search="+s.search(7)+" size= "+s.size()+" capacity= "+s.capacity());
//		System.out.println(s.peek());
		
		HashMap<String,Integer> map=new HashMap<>();
		map.put("Pratyush", 1);
		map.put("Sukrita",2);
		int[] arr=new int[7];
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			System.out.println(entry.getValue()+" : "+entry.getKey());
		
		}
		System.out.println(map);
		String str="ad";
		String st="bc";
		System.out.println(str.compareTo(st));
		
		
		
		
		printReverse(n);
		

	}
	static void printReverse(int n) {
		if(n==0)
			return;
		else {
			System.out.print(n+":");
			printReverse(n-1);


		}
	}
	

}

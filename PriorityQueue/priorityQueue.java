package PriorityQueue;


import java.util.*;

public class priorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> q=new LinkedList<>();
		Stack<Character> st=new Stack<>();
		st.push('f');
		st.push('o');
		st.push('l');
		st.push('e');
		st.push('q');
		st.peek();
		HashMap<String,Integer> map=new HashMap<>();
//		Iterator itr3=st.iterator();
//		while(itr3.hasNext()) {
//			System.out.println(itr3.next());
//		}
		pq.add(9);
		pq.add(8);
		pq.add(7);
		pq.add(6);
		pq.add(5);
		pq.add(50);
		System.out.println(pq.size()+" is the size ");
//		System.out.print("element "+pq.element());
		
		q.add(5);
		q.add(6);
		q.add(2);
		q.add(1);
		q.add(6);
	
//		Iterator itr2=q.iterator();
//		while(itr2.hasNext()) {
//			System.out.println(itr2.next());
//		}
		Iterator itr=pq.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		
		}
//		Object[] str=pq.toArray();
//		for(int i=0;i<str.length;i++)
//		{
//			System.out.println(str[i].toString());
//		}
		

	}

}

package Sorting;
import java.util.*;
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,5,3,15,7,9,2,5};
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			pq.add(arr[i]);
		}
		while(!pq.isEmpty()) {
			System.out.print(pq.remove()+": ");
		}
		

	}

}

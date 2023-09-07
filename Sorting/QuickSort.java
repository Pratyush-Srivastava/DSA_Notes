package Sorting;
import java.util.*;

public class QuickSort {
//choosing the last element's value as the pivot
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<Integer>[] a=new ArrayList[10];
//		
//		ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
//		ArrayList<Integer> m=new ArrayList<>();
//		m.add(3);
//		m.add(7);
//		ar.add(m);
//		ArrayList<Integer> m2=new ArrayList<>();
//		m2.add(6);
//		m2.add(9);
//		m2.add(1);
//		
//		ar.add(m2);
//		for(int i=0;i<ar.size();i++) {
//			for(int j=0;j<ar.get(i).size();j++) {
//				System.out.print(ar.get(i).get(j)+": " );
//			}
//			System.out.println();
//		}
//		String str="tbcdef";
//		String pat="abcde";
//		System.out.println((int)'a'+"	"+(int)'A'+"	"+str.compareTo(pat));
//		String[] s= {"hello","welcome","to","my","world"};
//		Arrays.sort(s, new java.util.Comparator<String>() {
//		    @Override
//		    public int compare(String s1, String s2) {
//		        // TODO: Argument validation (nullity, length)
//		        return s1.length() - s2.length();// comparision
//		    }
//		});
//		int[] unsorted= {1,232323,422};
//		Arrays.sort(unsorted);
//		for(int i=0;i<unsorted.length;i++) {
//			System.out.print(unsorted[i]+" and ");
//		}
//		char[] c= {'d','w','t','q'};
//		String s1="dadas";
//		
//		
//		for(int k=0;k<s.length;k++) {
//			System.out.print(s[k]+"-");
//		}
		
		int[] arr= {18,98,33,8,56,23,67,14,93,65,45,87};
		
		quicksort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+": ");
		}

	}
	private static void quicksort(int[] arr,int low,int high) {
		if(low>=high) {
			return;
		}
		else {
			int p=partitioning(arr,low,high);
			quicksort(arr,low,p-1);
			quicksort(arr,p+1,high);
			
		}
	}
	private static int partition(int[] arr,int low,int high) {
		int i=low-1;
		int j=low;
		int pivot=arr[high];
		while(j<=high-1) {
			if(arr[j]<pivot) {
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
			j++;
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i+1;
	}
	static int partitioning(int[] a,int low,int high) {
		int i=-1;
		int j=0;
		int p=high;
		int pivot=a[p];
		while(j<a.length) {
			if(j==p) {
				j++;
			}
			else {
				if(a[j]>pivot) {
					j++;
				}
				else {
					i++;
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					j++;
				}
			}
		}
		int temp=a[p];
		a[p]=a[i+1];
		a[i+1]=temp;
		return i+1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

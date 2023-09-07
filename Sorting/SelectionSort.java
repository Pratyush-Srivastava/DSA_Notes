package Sorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={47,23,54,2,89};
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int k=0;k<arr.length;k++) {
			System.out.print(arr[k]+": ");
		}
//		char[] ch= {'a','f','d'};
//		String str=new String(ch);
//		System.out.println(str);

	}

}

package Sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,5,2,6,10,8,9,1};
		for(int i=1;i<arr.length;i++) {
			int j=i;
			while(j>0 && arr[j]<arr[j-1]) {
				int temp=arr[j];
				arr[j]=arr[j-1];
				arr[j-1]=temp;
				j--;
			}
		}
		int j=0;
		while(j<arr.length)
		{
			System.out.print(arr[j]+": ");
			j++;
		}

	}

}

package Sorting;
import java.util.*;
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {100,90,80,70,60,50,40,54,87,125,80};
		divide(arr,0,arr.length-1);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+": ");
			
		}
	}
	private static void divide(int[] arr,int i,int j){
		if(i>=j) {
			return;
		}
		else {
			int n=j-i+1;
			
			divide(arr,i,i+n/2-1);
			divide(arr,i+n/2,j);
			merge(arr,i,i+n/2-1,i+n/2,j);
		}
	}
	private static void merge(int[] arr,int low1,int high1,int low2,int high2) {
		int i=low1;
		int j=low2;
		int[] res=new int[high1-low1+high2-low2+2];
		int k=0;
		while(i<=high1 && j<=high2) {
			if(arr[i]<arr[j]) {
				res[k]=arr[i];
				i++;
				k++;
			}
			else {
				res[k]=arr[j];
				j++;
				k++;
			}
		}
		while(i<=high1) {
			res[k]=arr[i];
			k++;
			i++;
		}
		while(j<=high2) {
			res[k]=arr[j];
			j++;
			k++;
		}
		k=0;
		i=low1;
		while(k<res.length) {
			arr[i]=res[k];
			i++;
			k++;
		}
	}	
	
}

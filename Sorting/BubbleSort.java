package Sorting;
import java.io.*;
public class BubbleSort {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		int[] arr=new int[str.length];
		for(int a=0;a<str.length;a++) {
			arr[a]=Integer.parseInt(str[a]);
		}
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int b=0;b<arr.length;b++) {
			System.out.print(arr[b]+ " - ");
		}

	}

}

package Strings;
//import java.util.*;
//import java.io.*;
//
//public class InputPractice {
//	public static void main(String[] args) throws Exception {
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		System.out.println(" test cases? ");
//		int t=Integer.parseInt(br.readLine());
//
//		
//		while(t-->0) {
//			System.out.println(" enter an array of integer with spaces");
//			String[] str=br.readLine().split(" ");
//			int[] arr=new int[str.length];
//			
//			for(int i=0;i<str.length;i++) {
//				arr[i]=Integer.parseInt(str[i]);
//				System.out.print(arr[i]+"-");
//			}
//			//to read a character use br.read() but this returns integer(UNICODE value). Type cast to char
//			System.out.println("enter a character");
//			char ch=(char)br.read();
//			System.out.println(ch);
//			
//		}
//		
//		
//		
//	}
//
//}
//package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class InputPractice {
	public static void main (String[] args) throws Exception
	{
		//System.out.println("GfG!");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter the number of test cases");
		int t=Integer.parseInt(br.readLine());
		

		while(t-->0) {
			System.out.println("enter a number");
			int d=Integer.parseInt(br.readLine());
			List<List<Integer>> arr=new ArrayList<>(d);
			for(int i=0;i<d;i++) {
				arr.add(new ArrayList<>());
			}
			for(int i=0;i<d;i++) {
				arr.get(i).add(1);
				arr.get(i).add(3);
			}
			System.out.println(arr);
			List<Integer> f=new ArrayList<>();
			f.add(4);
			f.add(3);
			System.out.println(f);
			ArrayList<Integer>[] r=new ArrayList[5];
			ArrayList<ArrayList<Integer>> y=new ArrayList();
			

			
		}
			
				
		
	}
}
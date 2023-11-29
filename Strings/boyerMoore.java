package Strings;
import java.io.*;
import java.util.HashMap;
public class boyerMoore {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("enter a string");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		System.out.println("enter a pattern");
		String pat=br.readLine();
		//System.out.println(" output "+(str==pat));
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<pat.length();i++) {
			map.put(pat.charAt(i),pat.length()-i-1);
		}
		int m=str.length();
		int n=pat.length();
		int j=n-1;
		while(j<m) {
			int g=n-1;
			int count=0;
			while(g>=0 && pat.charAt(g)==str.charAt(j)) {
				g--;
				j--;
				count++;
				
			}

			if(count==n)
				System.out.println("the index is "+(j+1));
			j+=count+1;
				
				
				
			
			
			if(j>=m)
				break;
			if(map.containsKey(str.charAt(j)))
				j+=map.get(str.charAt(j));
			else
				j+=n;
		}
		
		
		
		

	}


}

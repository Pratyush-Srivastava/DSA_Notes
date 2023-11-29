package Strings;
import java.io.*;
import java.util.HashMap;

public class KMP {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println(" test cases?");
		int t=Integer.parseInt(br.readLine());
		while(t-- >0) {
			System.out.println("enter a string");
			String str=br.readLine();
			System.out.println("enter a pattern");
			String pat=br.readLine();
			HashMap<Integer,Integer> map=lps(pat);
			int i=0,j=0;
			while(i<str.length()) {
				j=0;
				while(j<pat.length()) {
					if(str.charAt(i)==pat.charAt(j)) {
						i++;
						j++;
						if(i>=str.length())
							break;
						if(j==pat.length()) 
						{
							System.out.println(" index at "+(i-pat.length()));
							j=map.get(j-1);
							i++;
						}
					}
					else {
						j=map.get(j-1);
						i++;
						break;
					}
				}
			}
			
		}
		

	}
	static HashMap<Integer,Integer> lps(String pat){
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int j=0;j<pat.length();j++) {
			int i=0,count=pat.length()-1;
			while(i<pat.length()-1 && !(pat.substring(0,pat.length()-i-1)).equals(pat.substring(i+1,pat.length()))) {
				i++;
				count--;
			}
			map.put(j,count);
			System.out.println(j+" key and value"+count);
			
		}
		
		
		return map;
	}

}

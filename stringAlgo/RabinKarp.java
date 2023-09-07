
package stringAlgo;
import java.io.*;
import java.util.*;
public class RabinKarp {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter a string");
		String str =br.readLine();
		System.out.println("enter the pattern");
		String pat=br.readLine();
		System.out.println("Rabin Karp algo = "+rabinkarp(pat,str));
	}	
	static int rabinkarp(String pat,String str) {
		int m=pat.length();
		long p=hashcode(pat);
		long beg=hashcode(str.substring(0,m));
		System.out.println("p= "+p+" beg= "+beg);
		for(int i=0;i<str.length()-m;i++) {
			if(beg==p) {
				return i;
			}
			int c=str.charAt(i)-'a'+1;
			int nw=str.charAt(i+m)-'a'+1;
			beg=((beg-(c*(int)Math.pow(26,m-1)))*26+nw)%Long.MAX_VALUE;
		}
		return -1;
	}
	static long hashcode(String s) {
		int count=0;
		long sum=0;
		for(int i=s.length()-1;i>=0;i--) {
			int c=s.charAt(i)-'a'+1;
			sum+=(Math.pow(26, count)*c);
			count++;
		}
		return sum%Long.MAX_VALUE;
	}

}

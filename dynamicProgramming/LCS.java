package dynamicProgramming;

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="aabbaca";
		String s2="abcab";
		System.out.println(" recursive solution answer - "+recursiveSol(s1,s2,s1.length()-1,s2.length()-1));
		System.out.println(" iterative solution answer - "+iterativeSol(s1,s2));
		System.out.println(" recursive 2.0 solution answer - "+recursive(s1,s2,0,0));
		

	}
	
	static int recursiveSol(String s1,String s2,int i1,int i2) {
		if(i1==-1 || i2==-1) {
			return 0;
		}
		else {
			char ch1=s1.charAt(i1);
			char ch2=s2.charAt(i2);
			if(ch1==ch2) {
				return 1+recursiveSol(s1,s2,i1-1,i2-1);
				
			}
			else {
				return Math.max(Math.max(recursiveSol(s1,s2,i1,i2-1), recursiveSol(s1,s2,i1-1,i2)),recursiveSol(s1,s2,i1-1,i2-1));
			}
		}
	}
	static int iterativeSol(String s1,String s2) {
		int n1=s1.length();
		int n2=s2.length();
		int[][] res=new int[n1+1][n2+1];
		for(int i=-1;i<n1;i++) {
			for(int j=-1;j<n2;j++) {
				if(i==-1 || j==-1) {
					res[i+1][j+1]=0;
				}
				else {
					char ch1=s1.charAt(i);
					char ch2=s2.charAt(j);
					if(ch1==ch2) {
						res[i+1][j+1]=1+res[i][j];
		
					}
					else {
						res[i+1][j+1]=Math.max(Math.max(res[i+1][j],res[i][j+1]), res[i][j]);
					}
					
				}
			}
		}
		int i=n1;
		int j=n2;
		String s="";
		while(i!=0 && j!=0) {
			char ch1=s1.charAt(i-1);
			char ch2=s2.charAt(j-1);
			if(ch1==ch2)
				{
					i--;
					j--;
					s=ch1+s;
				}
			else {
				if(res[i-1][j]>res[i][j-1])
					i--;
				else
					j--;
			}
				
		}
		System.out.println("The longest common subsequence is "+s);

		return res[n1][n2];
	}

	
	static int recursive(String s1,String s2,int i1,int i2) {
		if(i1>=s1.length() || i2>=s2.length())
		return 0;
		char ch1=s1.charAt(i1);
		char ch2=s2.charAt(i2);
		//System.out.println(ch1+" "+ch2+" "+i1+" and "+i2);
		if(ch1==ch2)
			return 1+recursive(s1,s2,i1+1,i2+1);
		else
			return Math.max(recursive(s1,s2,i1,i2+1),recursive(s1,s2,i1+1,i2));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

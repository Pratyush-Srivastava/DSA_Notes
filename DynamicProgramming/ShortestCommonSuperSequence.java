package DynamicProgramming;

public class ShortestCommonSuperSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="abcd";
		String s2="xyab";
		recur(s1,s2,0,0,"");
		System.out.println("The minimum length is "+iter(s1,s2));

	}
	static int iter(String s1,String s2) {
		int[][] res=new int[s1.length()+1][s2.length()+1];
		for(int i=0;i<s1.length()+1;i++) {
			for(int j=0;j<s2.length()+1;j++) {
				if(i==0) {
					res[i][j]=j;
				} else if(j==0) {
					res[i][j]=i;
				} else {
					char ch1=s1.charAt(i-1);
					char ch2=s2.charAt(j-1);
					if(ch1==ch2) {
						res[i][j]=1+res[i-1][j-1];
					}
					else {
						res[i][j]=1+Math.min(res[i-1][j], res[i][j-1]);
					}
				}
			}
		}
		return res[s1.length()][s2.length()];
	}
	static void recur(String s1,String s2,int i1,int i2,String str) {
		if(i1==s1.length()) {
			str+=s2.substring(i2,s2.length());
			System.out.println(str);
			return;
		}
		if(i2==s2.length()) {
			str+=s1.substring(i1,s1.length());
			System.out.println(str);
			return;
		}
		char ch1=s1.charAt(i1);
		char ch2=s2.charAt(i2);
		if(ch1==ch2) {
			str+=ch1;
			recur(s1,s2,i1+1,i2+1,str);
		}
		else {
			recur(s1,s2,i1+1,i2,str+ch1);
			recur(s1,s2,i1,i2+1,str+ch2);
		}
		
	}
	

}

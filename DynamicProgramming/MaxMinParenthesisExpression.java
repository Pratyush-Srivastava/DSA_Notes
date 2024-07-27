package DynamicProgramming;
import java.util.*;
public class MaxMinParenthesisExpression {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String expr="1-2*3+4*5";
		int i=0;
		List<Integer> dig=new ArrayList<>();
		List<Character> op=new ArrayList<>();
		while(i<expr.length()) {
			char ch=expr.charAt(i);
			if(ch>='0' && ch<='9') {
				String s="";
				while(i<expr.length() && (expr.charAt(i)>='0' && expr.charAt(i)<='9')){
					s+=expr.charAt(i);
					i++;
				}
				dig.add(Integer.parseInt(s));
			}
			else {
				op.add(ch);
				i++;
			}
		}
		int[] digits=new int[dig.size()];
		char[] oper=new char[op.size()];
		for(int j=0;j<dig.size();j++) {
			digits[j]=dig.get(j);
		}
		for(int j=0;j<op.size();j++) {
			oper[j]=op.get(j);
		}
		int[][] res=new int[dig.size()][dig.size()];
		for(int x=0;x<dig.size();x++) {
			for(int y=0;y<dig.size();y++) {
				res[x][y]=-1;
			}
		}
//		System.out.println("The recursive sol is "+paren(digits,oper,0,digits.length-1,res));
		int[] r=iter(digits,oper);
		System.out.println("The iterative sol is max value = "+r[0]+" min value = "+r[1]);
		
		

	}
	static int[] iter(int[] digits,char[] oper) {
		int n=digits.length;
		int[][] maxres=new int[n][n];
		int[][] minres=new int[n][n];
		for(int a=0;a<n;a++) {
			int i=0;
			int j=i+a;
			while(j<n) {
				if(i==j) {
					maxres[i][j]=digits[i];
					minres[i][j]=digits[i];
				}
				else {
					int max=Integer.MIN_VALUE;
					int min=Integer.MAX_VALUE;
					int maxindex=-1,minindex;
					for(int k=i;k<j;k++) {
						int curmax,curmin;
						if(oper[k]=='-') {
							curmax=maxres[i][k]-minres[k+1][j];
							curmin=minres[i][k]-maxres[k+1][j];
						}
						else {
							curmax=operator(oper[k],maxres[i][k],maxres[k+1][j]);
							curmin=operator(oper[k],minres[i][k],minres[k+1][j]);
						}
						
						if(curmax>max)
							{
								max=curmax;
								maxindex=k;
							}
						if(curmin<min)
							{
								min=curmin;
								minindex=k;
							}
					}
					System.out.println(maxindex+" value ");
					minres[i][j]=min;
					maxres[i][j]=max;					
				}
				i++;
				j=i+a;
			}
		}
		System.out.println(" max res ");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(maxres[i][j]+" : ");
			}
			System.out.println();
		}
		System.out.println(" min res ");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(minres[i][j]+" : ");
			}
			System.out.println();
		}
		return new int[]{maxres[0][n-1],minres[0][n-1]};
		
	}
	static int paren(int[] digits,char[] oper,int i,int j,int[][] res) {
		if(i==j)
			return digits[i];
		
		if(res[i][j]!=-1) {
			return res[i][j];
		}
		
		int max=Integer.MIN_VALUE;
		for(int cur=i;cur<j;cur++) {
			int sum=operator(oper[cur],paren(digits,oper,i,cur,res),paren(digits,oper,cur+1,j,res));
			if(sum>max) {
				max=sum;
			}
		}
		res[i][j]=max;
		return max;
	}
	static int operator(char op,int a,int b) {
		int res=-1;
		switch(op) {
		case '+':
			res=a+b;
			break;
		case '*':
			res=a*b;
			break;
		}
		return res;
	}

}

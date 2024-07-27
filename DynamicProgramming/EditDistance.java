package DynamicProgramming;
import java.io.*;

public class EditDistance {

	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
		    br.readLine();
		    String[] str=br.readLine().trim().split(" ");
		    String a=(str[0]);
		    String b=(str[1]);
		    System.out.println("the recursive solution is "+edit(a,b,0,0));
		    System.out.println("the iterative solution is "+editIter(a,b));
		}


	}
	static int edit(String a,String b,int i,int j) {
		if(i>=a.length() || j>=b.length())
			return 0;
		char ch1=a.charAt(i);
		char ch2=b.charAt(j);
		if(ch1==ch2)
			return edit(a,b,i+1,j+1);
		else {
			return 1+Math.min(Math.min(edit(a,b,i,j+1), edit(a,b,i+1,j)),edit(a,b,i+1,j+1));
		}

	}
	static int editIter(String a,String b) {
		int[][] res=new int[a.length()+1][b.length()+1];
		for(int i=0;i<a.length()+1;i++) {
			for(int j=0;j<b.length()+1;j++) {
				if(i==0)
					res[i][j]=j;
				else if(j==0)
					res[i][j]=i;
				else {
					char ch1=a.charAt(i-1);
					char ch2=b.charAt(j-1);
					if(ch1==ch2)
						res[i][j]=res[i-1][j-1];
					else
						res[i][j]=1+Math.min(Math.min(res[i][j-1], res[i-1][j]),res[i-1][j-1]);
				}
			}
		}
		int i=a.length();
		int j=b.length();
		int rep=0,ins=0,del=0;
		while(i!=0 && j!=0) {
			char ch1=a.charAt(i-1);
			char ch2=b.charAt(j-1);
			if(ch1!=ch2) {
				if(res[i-1][j]<res[i][j-1] && res[i-1][j]<res[i-1][j-1]) {
					System.out.println(ch1+" deleted");
					del++;
					i--;
					
				}
				else {
					if(res[i][j-1]<res[i-1][j-1]) {
						System.out.println(ch2+" inserted");
						ins++;
						j--;
					}
					else {
						System.out.println(ch1+" replaced by "+ch2);
						rep++;
						i--;
						j--;
					}
				}
			}
			else {
				i--;
				j--;
			}
		}
		System.out.println("total insertions: "+ins);
		System.out.println("total deletions: "+del);
		System.out.println("total replacements: "+rep);
		return res[a.length()][b.length()];
	}

}

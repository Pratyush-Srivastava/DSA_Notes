package DynamicProgramming;

public class maxDiffZeroOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="11000010001";
		int[] res=new int[s.length()];
		int zeros=0;
		int ones=0;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<s.length();i++) {
			int a=s.charAt(i)-'0';
			if(a==0) {
				zeros++;
			}
			else {
				ones++;
			}
			res[i]=zeros-ones;
			System.out.print(res[i]+" : ");
			if(res[i]>max) {
				max=res[i];
			}
			if(res[i]<min) {
				min=res[i];
			}
		}
		System.out.println("\n"+(max-min));

	}

}

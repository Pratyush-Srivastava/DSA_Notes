package PracticeProblems;

public class primeNumbersInterval {
	public static void main(String[] args) {
		int a=8;
		int b=30;
		boolean[] arr=new boolean[b+1];
		for(int i=0;i<arr.length;i++) {
			arr[i]=true;
		}
		arr[0]=false;
		arr[1]=false;
		for(int i=2;i<=b;i++) {
			int j=2;
			while(i*j<=b) {
				arr[i*j]=false;
				j++;
			}
		}
		for(int i=0;i<b+1;i++) {
			if(arr[i]==true && i>=a) {
				System.out.print(i+" ");
			}
		}
		
	}

}

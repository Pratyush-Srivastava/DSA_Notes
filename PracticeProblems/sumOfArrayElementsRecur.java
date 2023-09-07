package PracticeProblems;

public class sumOfArrayElementsRecur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,5,7,5,2,1};
		System.out.println("the sum is "+sum(arr,0,5,6));
		

	}
	static int sum(int[] arr,int i,int j,int n) {
		if(i==j) {
			return arr[i];
			
		}
		else {
			int i1=i,j1=(i+n/2-1),i2=i+n/2,j2=j;
			return sum(arr,i1,j1,j1-i1+1)+sum(arr,i2,j2,j2-i2+1);
		}
	}

}

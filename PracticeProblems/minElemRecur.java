package PracticeProblems;

public class minElemRecur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {5234234,34524,34534,345345,345,3454};
		System.out.println(" the min element is "+minElem(arr,0,5));
		

	}
	static int minElem(int[] arr,int i,int j) {
		if(i==j)
			return arr[i];
		else {
			return Math.min(arr[i], minElem(arr,i+1,j));
		}
		
	}

}

package PracticeProblems;
import java.math.BigInteger;
import java.util.*;
public class subArraysSumZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4,5,7};
		List<Integer> arr=new ArrayList<>();
		arr.add(1);
		arr.add(3);
		arr.add(5);
		System.out.println("\n list "+Collections.binarySearch(arr,0));
		HashMap<Integer,Integer> map=new HashMap<>();
		int sum=0,res=0;
//		BigInteger big=new BigInteger("453");
//		big.mod(new BigInteger("3"));
		Arrays.sort(a);
		for(int c:a)
		System.out.print(c+" ");
		System.out.println("\n"+Arrays.binarySearch(a, 7));
//		for(int i=0;i<11;i++)
//		{
//			sum+=a[i];
//			if(sum==0)
//				res+=1;
//			if(map.containsKey(sum)) {
//				map.put(sum, map.get(sum)+1);
//			}
//			else {
//				map.put(sum, 1);
//			}
//		}
		System.out.println(map);

	}


}

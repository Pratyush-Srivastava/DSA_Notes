package PracticeProblems;

public class KadanesAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		sb.append("my\nname");
		sb.append("\nis\nPratyush");
		System.out.println(sb);
		int[] arr= {-2,1,-3,4,-1,2,1,-5,4};
		int max_end=0,res=0;
		int s=0,start=0,end=0;
		for(int i=0;i<arr.length;i++) 
		{
			max_end=max_end+arr[i];
			if(res<max_end)
			{
				res=max_end;
				start=s;
				end=i;
			}
			if(max_end<0) {
				max_end=0;
				s=i+1;
			}
			System.out.println("res= "+res+" max_end= "+max_end+" i= "+i+" arr[i] = "+arr[i]+" start = "+start+" end = "+end+" s= "+s);
		}
		System.out.println("FINAL res= "+res+" max_end= "+max_end+" start = "+start+" end = "+end+" s= "+s);
		

	}

}

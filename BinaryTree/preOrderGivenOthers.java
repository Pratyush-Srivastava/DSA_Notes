package BinaryTree;

public class preOrderGivenOthers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in= {4,2,5,1,3,6};
		int[] post= {4,5,2,6,3,1};
		preOrder(in,post,0,5,0,5);
		

	}
	static void preOrder(int[] in,int[] post,int ilow,int ihigh,int plow,int phigh)
	{
		if(plow>phigh)
		{
			return;
		}
		else
		{
			int root=post[phigh];
			int k=ilow;
			while(root!=in[k])
			{
				k++;
			}
			System.out.print(root+" : ");
			preOrder(in,post,ilow,k-1,plow,plow+k-ilow-1);
			preOrder(in,post,k+1,ihigh,plow+k-ilow,phigh-1);
			
			
			
			return;
		}
	}

}

package BinaryTree;

public class postOrderGivenOthers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in= {4, 2, 5, 1, 3, 6};
		
		int[] pre = {1, 2, 4, 5, 3, 6};
		
		PostOrder(pre,in,0,5,0,5);

	}
	static void PostOrder(int[] pre,int[] in,int plow,int phigh,int ilow,int ihigh)
	{
		if(plow>phigh)
			return;
		else
		{
				int root=pre[plow];
				int k=ilow;
				while(root!=in[k])
				{
					k++;
				}
				PostOrder(pre,in,plow+1,k+plow-ilow,ilow,k-1);
				PostOrder(pre,in,k+plow-ilow+1,phigh,k+1,ihigh);
				System.out.print(root+" : ");
		}
	}

}

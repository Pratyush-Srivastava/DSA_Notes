package BinaryTree;

public class constructTreeUsingTraversals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in= {4,2,5,1,3,6};
		int[] post= {4,5,2,6,3,1};
		Node root=new Node(post[5]);
		constructTree(root,in,post,0,5,0,5);
		System.out.println("\n the inorder is \n" );inOrder(root);
		System.out.println("\n the preorder is " );preOrder(root);
		System.out.println("\n the postorder is " );postOrder(root);

	}
	static void constructTree(Node root,int[] in,int[] post,int ilow,int ihigh,int plow,int phigh)
	{
		if(ilow>ihigh)
			return;
		else
		{
			Node nodeLeft=root,nodeRight=root;
			int r=post[phigh];
			int k=0;
			while(r!=in[k])
			{
				k++;
			}
			System.out.print(r+" : ");
			if(k-1>=ilow) {
				nodeLeft=new Node(post[plow+k-1-ilow]);
				root.left=nodeLeft;
			}

			constructTree(nodeLeft,in,post,ilow,k-1,plow,plow+k-1-ilow);
			if(ihigh>=k+1) {
				nodeRight=new Node(post[phigh-1]);
				root.right=nodeRight;
			}

			constructTree(nodeRight,in,post,k+1,ihigh,plow-ilow+k,phigh-1);
		}
		
	}
	static void constructTreeUsingPreOrderForBST(Node root,int[] pre,int[] ino,int plow,int phigh,int ilow,int ihigh) {
		root.data=pre[plow];
		int rdata=pre[plow];
		int k=0;
		while(rdata!=ino[k]) {
			k++;
		}
		Node nodeLeft=new Node();
		root.left=nodeLeft;
		Node nodeRight=new Node();
		root.right=nodeRight;
		constructTreeUsingPreOrderForBST(root.left,pre,ino,plow+1,plow+k-ilow,ilow,k-1);
		constructTreeUsingPreOrderForBST(root.right,pre,ino,plow+k-ilow+1,phigh,k+1,ihigh);
		
	
		
		
	}
	static void inOrder(Node node) {
		if(node==null)
			return;
		else {
			inOrder(node.left);
			System.out.print(node.data+" -- ");
			inOrder(node.right);
		}
	}
	static void preOrder(Node node) {
		if(node==null)
			return;
		else {
			System.out.print(node.data+" - ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	static void postOrder(Node node) {
		if(node==null)
			return;
		else {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data+" - ");
		}
	}
	

}

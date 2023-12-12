package BinaryTree;

public class constructFullTreeUsingPreAndPost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre= {1,2,4,8,9,5,3,6,7};
		int[] post = {8,9,4,5,2,6,7,3,1};
		Node node=new Node(pre[0]);
		construct(node,pre,post,0,pre.length-1,0,post.length-1);
		inorder(node);
		

	}
	static void construct(Node node,int[] pre,int[] post,int preS,int preE,int postS,int postE) {
			
			if(preS+1<=preE) {
				int root=pre[preS+1];
				int k=postS;
				while(post[k]!=root) {
					k++;
				}
				int nLeft=k-postS+1;
//				System.out.println(node.data+" and "+preS+" and "+preE+", "+postS+", "+postE+" k= "+k);
				node.left=new Node(pre[preS+1]);
				node.right=new Node(pre[preS+nLeft+1]);
				construct(node.left,pre,post,preS+1,preS+nLeft,postS,k);
				construct(node.right,pre,post,preS+nLeft+1,preE,k+1,postE-1);
				return;	
			}
			else {
				node.left=null;
				node.right=null;
				return;
			}
			
			

		
	}
	static void inorder(Node node) {
		if(node==null) {
			return;
		}
		else {
			inorder(node.left);
			System.out.print(node.data+": ");
			inorder(node.right);
		}
	}
	
	

}

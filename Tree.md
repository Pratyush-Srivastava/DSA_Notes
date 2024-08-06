* Binary tree traversals -
  Inorder - left, root, right
  Preorder - root, left, right
  Postorder - left, right, root
  Time complexity for all traversals will be O(n)
  Space complexity will be O(h)
* In Level order traversal, we do BFS of a tree like how we did in graph. We offer the root in the queue.
  In a while loop until queue is notEmpty, we poll an element and offer its children.
* In Level order traversal, if you want to print each line. Then you need to add root and a null data value. Continue
  the usual level order traversal. Every time you poll null data, add a null data node. This null data will mark a new
  line. Space complexity will be O(width) = O(n/2). Another method would be offer the root to the queue. Store the queue
  size in a count variable and iterate count times to poll and print node data and then add its children to queue. When
  you get out of the loop, you can print a new line.
* To print the left view of a tree where you need to print the left most element of every level. You can use the
  previous level order traversal of each line to print first element of a level. It will take O(n)
* To print the max width of a tree where you need to print the max width among every level. You can use the
  previous level order traversal of each line to check the q size at each stage. It will take O(n)
* A Balanced tree is where height difference of left and right subtree is not more than 1 at every node.
* TODO To convert binary tree to doubly linked list using inorder traversal.
* If you want to construct a binary tree when inorder and preorder traversal is given, you need to get the root in
  preorder traversal and then find the corresponding index in inorder traversal. Construct the root element and then
  assign root.left and root.right. Similarly, it can be done using other pair of traversals.
* To find the lowest common ancestor of two nodes, there are two methods. One would be to find the path of each node and
  store it in two arrays. To find path, add the root to the list before calling for children. Then after calling them,
  remove the last item from the list. Iterate both arrays and return the last common element. Another method would be
  (this method assumes that both the nodes are present in the tree or none of them are present) Do recursive, if you
  find the root is one of the values, you just return that root. Go to left and right subtree. If both are not null
  then return root. This will happen only when each child has one node. If only one of them has it, then return that
  value. If none of them has it, return null.
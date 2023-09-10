/**
 * Given a binary tree, determine if it is height-balanced:
 * 
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node 
 * never differs by more than one.
 * Example 1:

				Input: root = [3,9,20,null,null,15,7]
				Output: true
				
Example 2:

				Input: root = [1,2,2,3,3,null,null,4,4]
				Output: false
				
Example 3:

				Input: root = []
				Output: true
 */

package in.Algo.Tree.LogicDrivenDev;

public class CheckBalancedBinaryTree {

	public static void main(String[] args) {

		Node root = new Node(3);

		root.left = new Node(9);

		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);

		if (isBalanced(root) == -1)
			System.out.println("No");
		else
			System.out.println("Yes");
	}

	private static int isBalanced(Node root) {

		if (root == null)
			return 0;

		int lh = isBalanced(root.left);

		if (lh == -1)
			return -1;

		int rh = isBalanced(root.right);

		if (rh == -1)
			return -1;

		if (Math.abs(lh - rh) > 1)
			return -1;

		else
			return Math.max(lh, rh) + 1;

	}

}

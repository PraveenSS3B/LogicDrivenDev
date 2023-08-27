package in.Algo.Tree.LogicDrivenDev;

public class ChildSumBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(20);

		root.left = new Node(8);
		root.left.left = new Node(3);
		root.left.right = new Node(5);

		root.right = new Node(12);

		System.out.println(isChildSum(root));
	}

	private static boolean isChildSum(Node root) {

//		if(root == null) return true;
//
//		if (root.key == leftSum + rightSum)
//			return true;
//
//		if (root.left != null) {
//			isChildSum(root.left, leftSum + root.left.key, rightSum);
//		}
//
//		if (root.right != null) {
//			isChildSum(root.right, leftSum, rightSum + root.right.key);
//		}
//
//		return false;

		if (root == null)
			return true;

		if (root.left == null && root.right == null)
			return true;

		// if root is not a leaf node and root's key is not equal to sum of left and
		// right child
		if (root.left != null && root.right != null && root.key != root.left.key + root.right.key)
			return false;

		// if root is a leaf node and root's key is not equal to sum of left and right
		// child
		if (root.left == null && root.right != null && root.key != root.right.key)
			return false;

		// if root is a leaf node and root's key is not equal to sum of left and right
		// child
		if (root.left != null && root.right == null && root.key != root.left.key)
			return false;

		// if root is not a leaf node and root's key is equal to sum of left and right
		// child
		if (root.left != null && root.right != null && root.key == root.left.key + root.right.key)
			return isChildSum(root.left) && isChildSum(root.right);

		// if root is a leaf node and root's key is equal to sum of left and right child
		if (root.left == null && root.right != null && root.key == root.right.key)
			return isChildSum(root.right);

		// if root is a leaf node and root's key is equal to sum of left and right child
		if (root.left != null && root.right == null && root.key == root.left.key)
			return isChildSum(root.left);

		return false;

	}

}

package in.Algo.Tree.LogicDrivenDev;

public class FoldableBT {

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(7);

		root.right = new Node(15);

		root.left.right = new Node(9);

		root.right.left = new Node(11);

		System.out.println(isFoldable(root));
	}

	/**
	 * 
	 * @param takes Root of the tree, 
	 * @returns if is Foldable or not.
	 */
	private static String isFoldable(Node root) {
		if (root == null)
			return "YES";

		return areMirror(root.left, root.right) ? "YES" : "NO";
	}

	/**
	 * @param lst -> points to the left subtree of the root Node
	 * @param rst -> points to the right subtree of the root Node
	 * @return -> True, if the Binary Tree is mirror image of original else False.
	 */
	private static boolean areMirror(Node lst, Node rst) {
		if (lst == null && rst == null)
			return true;

		if (lst == null || rst == null)
			return false;

		return areMirror(lst.left, rst.right) && areMirror(lst.right, rst.left);

	}

}

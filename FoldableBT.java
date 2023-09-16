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

	private static String isFoldable(Node root) {
		if (root == null)
			return "YES";

		return areMirror(root.left, root.right) ? "YES" : "NO";
	}

	private static boolean areMirror(Node lst, Node rst) {
		if (lst == null && rst == null)
			return true;

		if (lst == null || rst == null)
			return false;

		return areMirror(lst.left, rst.right) && areMirror(lst.right, rst.left);

	}

}

package in.Algo.Tree.LogicDrivenDev;

public class CheckTwoTreesAreIdentical {

	public static void main(String[] args) {

		Node root1 = VerticalWidth_BT.buildTree("1 2 3");

		Node root2 = VerticalWidth_BT.buildTree("1 2 3");

		System.out.println(isIdentical(root1, root2));

	}

	private static boolean isIdentical(Node root1, Node root2) {

		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		if (root1.key != root2.key)
			return false;

		if (isIdentical(root1.left, root2.left) == false)
			return false;

		if (isIdentical(root1.right, root2.right) == false)
			return false;

		return true;

	}

}

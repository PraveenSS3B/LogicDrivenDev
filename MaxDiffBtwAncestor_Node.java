package in.Algo.Tree.LogicDrivenDev;

public class MaxDiffBtwAncestor_Node {

	public static void main(String[] args) {
		Node root = VerticalWidth_BT.buildTree("1 2 3 4 5 6 7");

		System.out.println(maxDiff(root));

	}

	static int max[] = new int[1];
	static {
		max[0] = Integer.MIN_VALUE;
	}

	static int maxDiff(Node root) {
		solve(root, max);
		return max[0];
	}

	static int solve(Node root, int[] max) {
		if (root == null)
			return Integer.MAX_VALUE;

		if (root.left == null && root.right == null)
			return root.key;

		int lv = solve(root.left, max);
		
		int rv = solve(root.right, max);

		int val = Math.min(lv, rv);

		max[0] = Math.max(max[0], root.key - val);

		return Math.min(val, root.key);
	}
}

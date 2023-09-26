package in.Algo.Tree.LogicDrivenDev;

public class MaxSumOfAdjNodes {

	public static void main(String[] args) {
		Node root = VerticalWidth_BT.buildTree("1 2 3 4 N 5 6");

		int[] pair = maxSum(root);

		System.out.println(Math.max(pair[0], pair[1]));
	}

	static int[] maxSum(Node root) {

		if (root == null)
			return new int[2];

		int[] leftPair = maxSum(root.left);

		int[] rightPair = maxSum(root.right);

		int ans[] = new int[2];

		ans[0] = root.key + leftPair[1] + rightPair[1];

		ans[1] = Math.max(leftPair[0], leftPair[1]) + Math.max(rightPair[0], rightPair[1]);

		return ans;

	}

}

package in.Algo.Tree.LogicDrivenDev;

class Distance {

	int val;

	Distance(int v) {
		val = v;
	}
}

public class BurnBinaryTreeFromLeaf {

	static int max = 0;

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(20);
		root.left.right = new Node(5);
		root.left.left = new Node(30);
		root.left.left.right = new Node(50);
		root.left.left.left = new Node(40);
		root.left.left.left.left = new Node(60);
		root.left.left.left.left.left = new Node(70);

		int leaf = 50;

		Distance dist = new Distance(0);

		burnBT(root, leaf, dist);
		System.out.println(dist.val);
	}

	private static int burnBT(Node root, int leaf, Distance dist) {

		if (root == null)
			return 0;

		if (root.key == leaf) {
			dist.val = 0;
			return 1;
		}

		Distance lDist = new Distance(-1);
		Distance rDist = new Distance(-1);

		int lh = burnBT(root.left, leaf, lDist);
		int rh = burnBT(root.right, leaf, rDist);

		if (lDist.val != -1) {
			dist.val = lDist.val + 1;
			max = Math.max(max, rh + dist.val);
		}

		if (rDist.val != -1) {
			dist.val = rDist.val + 1;
			max = Math.max(max, lh + dist.val);
		}

		return Math.max(lh, rh) + 1;
	}

}

package in.Algo.Tree.LogicDrivenDev;

import java.util.HashMap;
import java.util.Map;

public class BinaryTree_From_Inorder_Preorder extends LevelOrderTraversal {

	static int preIndex = 0;

	public static void main(String[] args) {
		int in[] = { 40, 20, 50, 10, 30, 80, 70, 90 };
		int pre[] = { 10, 20, 40, 50, 30, 70, 80, 90 };

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < in.length; i++)
			map.put(in[i], i);

//		Node root = makeBT(in, pre, 0, in.length - 1);
		
		Node root = makeBT(in, pre, 0, in.length - 1, map);

		LevelOrderTraversal.levelOrderTraversalPrintLineByLine2(root);

	}

	// Efficient Approach
	private static Node makeBT(int[] in, int[] pre, int start, int end, Map<Integer, Integer> map) {

		if (end < start)
			return null;

		Node root = new Node(pre[preIndex++]);

		// instead of looping n times getting index in constant time using map
		int index = map.get(root.key); 

		root.left = makeBT(in, pre, start, index - 1, map);
		root.right = makeBT(in, pre, index + 1, end, map);
		
		return root;
	}

	// O(n^2) - Time Complexity
	private static Node makeBT(int[] in, int[] pre, int start, int end) {

		if (end < start)
			return null;

		Node root = new Node(pre[preIndex++]);

		int index = 0;

		for (int i = start; i <= end; i++) {
			if (in[i] == root.key) {
				index = i;
				break;
			}
		}

		root.left = makeBT(in, pre, start, index - 1);
		root.right = makeBT(in, pre, index + 1, end);

		return root;

	}

}

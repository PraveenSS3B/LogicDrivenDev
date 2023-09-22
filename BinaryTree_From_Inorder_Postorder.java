package in.Algo.Tree.LogicDrivenDev;

import java.util.HashMap;
import java.util.Map;

public class BinaryTree_From_Inorder_Postorder extends LevelOrderTraversal {

	static int postOrderIndex = 0;

	public static void main(String[] args) {
		int in[] = { 4, 8, 2, 5, 1, 6, 3, 7 };
		int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };

		Map<Integer, Integer> m = new HashMap<>();

		for (int i = 0; i < in.length; i++)
			m.put(in[i], i);

		LevelOrderTraversal.levelOrderTraversalPrintLineByLine2(build(in, post, 0, in.length - 1, m));

	}

	static Node build(int in[], int post[], int start, int end, Map<Integer, Integer> m) {

		if (start > end || postOrderIndex < 0)
			return null;

		Node newNode = new Node(post[postOrderIndex--]);

		int index = m.get(newNode.key);

		// Making Right Subtree because In postorder traversal, the last element
		// represents the root of the current subtree. By processing
		// elements in reverse order, we can always identify the root node immediately.

		newNode.right = build(in, post, index + 1, end, m);
		newNode.left = build(in, post, start, index - 1, m);

		return newNode;

	}

}

package in.Algo.Tree.LogicDrivenDev;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree_From_ParentArray {

	public static void main(String[] args) {
		int parent[] = { -1, 0, 0, 1, 1, 3, 5 };

		int N = parent.length;

		Map<Integer, Node> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			map.put(i, new Node(i));
		}

		LevelOrderTraversal.levelOrderTraversalPrintLineByLine2(createTree(parent, N, map));
	}

	private static Node createTree(int[] parent, int n, Map<Integer, Node> map) {

		if (n <= 0)
			return null;

		Node root = null;

		for (int i = 0; i < n; i++) {
			if (parent[i] == -1)
				root = map.get(i);

			else {
				if (map.get(parent[i]).left == null)
					map.get(parent[i]).left = map.get(i);

				else
					map.get(parent[i]).right = map.get(i);
			}
		}

		return root;

	}

}

package in.Algo.Tree.LogicDrivenDev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNodeAt_K_DistanceFromLeaf {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.right.left.right = new Node(8);

		DistinctNodeAt_K_DistanceFromLeaf obj = new DistinctNodeAt_K_DistanceFromLeaf();

		System.out.println(obj.printKDistantfromLeaf(root, 2));
	}

	Map<Node, Integer> m = new HashMap<>();

	int printKDistantfromLeaf(Node root, int k) {
		ArrayList<Node> l = new ArrayList<>();

		getNodes(root, k, l, 0);

//		m.forEach((key, value) -> System.out.println(key.key + ", " + value));

		return m.size();
	}

	void getNodes(Node root, int k, ArrayList<Node> l, int c) {

		if (k < 0 || root == null)
			return;

		if (root.left == null && root.right == null && c - k >= 0 && !m.containsKey(l.get(c - k))) {
			m.put(l.get(c - k), 1);
			return;
		}

		l.add(root);

		getNodes(root.left, k, l, c + 1);
		getNodes(root.right, k, l, c + 1);

		l.remove(l.size() - 1);
	}

}

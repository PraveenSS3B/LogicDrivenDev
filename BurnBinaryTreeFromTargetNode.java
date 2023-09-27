package in.Algo.Tree.LogicDrivenDev;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BurnBinaryTreeFromTargetNode {

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(20);
		root.right = new Node(30);

		root.right.right = new Node(60);
		root.left.left = new Node(40);
		root.left.right = new Node(50);

		Map<Node, Node> parentMapping = new HashMap<>();

		parentMap(root, null, parentMapping);

		int target = 20;

		getNode(root, target);

		int time = burn(root, targetNode, target, parentMapping, new HashMap<Node, Integer>());

		System.out.println(time);

	}

	private static int burn(Node root, Node targetNode, int target, Map<Node, Node> pr,
			HashMap<Node, Integer> visited) {
		Queue<Node> q = new LinkedList<>();
		q.add(targetNode);

		int time = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			boolean shallWeIncreaseTime = false;
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
				visited.put(curr, 1);
				Node parent = pr.get(curr);

				if (parent != null) {

					if (!visited.containsKey(parent)) {
						shallWeIncreaseTime = true;
						q.add(parent);
						visited.put(parent, 1);
					}
				}

				if (curr.left != null) {

					if (!visited.containsKey(curr.left)) {
						shallWeIncreaseTime = true;
						q.add(curr.left);
						visited.put(curr.left, 1);
					}

				}

				if (curr.right != null) {

					if (!visited.containsKey(curr.right)) {
						shallWeIncreaseTime = true;
						q.add(curr.right);
						visited.put(curr.right, 1);
					}

				}
			}

			if (shallWeIncreaseTime)
				time++;
		}

		return time;
	}

	static Node targetNode = null;

	// Getting the reference of target node
	private static Node getNode(Node root, int target) {

		if (root == null)
			return null;

		if (root.key == target) {
			targetNode = root;
		}

		getNode(root.left, target);
		getNode(root.right, target);

		return targetNode;

	}

	// creating link between child and parent in reverse , i.e from child to parent!!!
	private static void parentMap(Node root, Node target, Map<Node, Node> pr) {

		if (root == null)
			return;

		pr.put(root, target);

		parentMap(root.left, root, pr);
		parentMap(root.right, root, pr);

	}

}

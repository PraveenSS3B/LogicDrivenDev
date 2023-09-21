package in.Algo.Tree.LogicDrivenDev;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalWidth_BT {

	public static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	public static void main(String[] args) {
		String b_String = "1 2 3 4 5 N N N N 6 N 7 N";

		Node tree = buildTree(b_String);

		HashSet<Integer> set = new HashSet<>();

		set.clear();

		System.out.println(preOrder(tree, 0, set));

	}

	private static int preOrder(Node tree, int d, HashSet<Integer> set) {

		if (tree == null)
			return 0;

		set.add(d);
		preOrder(tree.left, d - 1, set);
		preOrder(tree.right, d + 1, set);

		return set.size();
	}

}

package in.Algo.Tree.LogicDrivenDev;

import java.util.ArrayList;
import java.util.Arrays;

public class Serialize_Deserialize_BT extends LevelOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(20);
		root.left.left = new Node(30);
		root.left.left.right = new Node(40);

		ArrayList<Integer> list = new ArrayList<Integer>();

		serialize(root, list);

		System.out.println(Arrays.toString(list.toArray()));

		Node tree = deserialize(list);

		LevelOrderTraversal.levelOrderTraversalPrintLineByLine2(tree);

	}

	static int preIndex = 0;

	private static Node deserialize(ArrayList<Integer> list) {

		if (preIndex == list.size())
			return null;

		int val = list.get(preIndex++);

		if (val == -1)
			return null;

		Node root = new Node(val);

		root.left = deserialize(list);
		root.right = deserialize(list);

		return root;

	}

	private static void serialize(Node root, ArrayList<Integer> nodeList) {

		if (root == null) {
			nodeList.add(-1);
			return;
		}
		nodeList.add(root.key);

		serialize(root.left, nodeList);
		serialize(root.right, nodeList);

	}

}

package in.Algo.Tree.LogicDrivenDev;

public class SerializeToString_Deserialze extends LevelOrderTraversal{

	public static void main(String[] args) {
		
		Node root = new Node(20);

		root.left = new Node(8);
		root.left.left = new Node(3);
		root.left.right = new Node(5);

		root.right = new Node(12);
		
		String serializedBT = serialize(root);
		
		Node deserializedBT = new SerializeToString_Deserialze().deserialize(serializedBT);
		
		LevelOrderTraversal.levelOrderTraversalPrintLineByLine2(deserializedBT);

	}

	public static String serialize(Node root) {
		StringBuilder ans = new StringBuilder();
		ans = serial(root, ans);
		return ans.toString();
	}

	public static StringBuilder serial(Node root, StringBuilder ans) {
		if (root == null) {
			ans.append("null, ");
			return ans;
		}

		ans.append(root.key).append(", ");
		serial(root.left, ans);
		serial(root.right, ans);

		return ans;
	}

	int index = 0;

	public Node deserialize(String data) {
		return deserial(data.split(", "));
	}

	public Node deserial(String[] data) {
		if (index == data.length)
			return null;

		Integer val = (data[index].equals("null") ? null : Integer.parseInt(data[index]));
		index++;

		if (val == null)
			return null;

		Node root = new Node(val);

		root.left = deserial(data);
		root.right = deserial(data);

		return root;
	}

}

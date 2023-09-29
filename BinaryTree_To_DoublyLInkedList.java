package in.Algo.Tree.LogicDrivenDev;

public class BinaryTree_To_DoublyLInkedList {

	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.left.left = new Node(40);

		root.left.right = new Node(60);

		root.right = new Node(30);

		Node head = convert(root);
		printForward(head);

		printBackward(head);

	}

	public static void printForward(Node head) {
		Node currNode = head;

		while (currNode != null) {
			System.out.print(currNode.key + " ");
			currNode = currNode.right;
		}

		System.out.println();

	}

	public static void printBackward(Node head) {
		Node currNode = head;

		while (currNode.right != null) {
			currNode = currNode.right;
		}

		while (currNode != null) {
			System.out.print(currNode.key + " ");
			currNode = currNode.left;
		}

		System.out.println();

	}

	static Node prev = null;
	static Node head = null;

	private static Node convert(Node root) {

		if (root == null)
			return root;

		convert(root.left);
//		Node head = convert(root.left); // works

		// This line works only once to the left most leaf node and assign as head
		if (prev == null)
			head = root;
		else {
			// Linking the current node left as prev node i.e., left node and
			// prev node right as current node
			prev.right = root;
			root.left = prev;
		}

		// Before going to next node marking the current node as previous one!
		prev = root;

		convert(root.right);

		return head;

	}

}

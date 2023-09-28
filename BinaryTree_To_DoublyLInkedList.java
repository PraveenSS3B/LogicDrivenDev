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

	private static Node convert(Node root) {

		if (root == null)
			return root;

		Node head = convert(root.left);

		if (prev == null)
			head = root;
		else {
			prev.right = root;
			root.left = prev;
		}

		prev = root;

		convert(root.right);

		return head;

	}

}

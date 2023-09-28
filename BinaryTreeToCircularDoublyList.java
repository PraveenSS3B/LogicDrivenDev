package in.Algo.Tree.LogicDrivenDev;

public class BinaryTreeToCircularDoublyList {
	public static void main(String[] args) {

		Node root = new Node(10);

		root.left = new Node(20);
		root.left.left = new Node(40);

		root.left.right = new Node(60);

		root.right = new Node(30);

		Node head = convert(root);

		displayCList(head);

	}

	static void displayCList(Node head) {
		Node itr = head;
		do {
			System.out.print(itr.key + " ");
			itr = itr.right;
		} while (head != itr);
		System.out.println();
		itr = itr.left;
		do {
			System.out.print(itr.key + " ");
			itr = itr.left;
		} while (head != itr);
		System.out.println(itr.key + " ");
	}

	static Node prev = null;
	static Node head = null;

	private static Node convert(Node root) {

		if (root == null)
			return root;

		convert(root.left);

		if (prev == null)
			head = root;

		else {
			prev.right = root;
			root.left = prev;
		}

		prev = root;
		convert(root.right);

		prev.right = head;
		head.left = prev;

		return head;
	}

}

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

		// This line works only once to the left most leaf node and assign as head
		if (prev == null)
			head = root;

		else {
			// Linking the current node left as prev node i.e., left node and
			// prev node right as current node
			prev.right = root;
			root.left = prev;
		}

//		Before going to next node marking the current node as previous one!
		prev = root;
		convert(root.right);

		// After constructing Doubly Linked List, we are linking head and tail together.
		// hence making Circularly Doubly Linked List
		prev.right = head;
		head.left = prev;

		return head;
	}

}

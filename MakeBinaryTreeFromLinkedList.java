package in.Algo.Tree.LogicDrivenDev;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Tree {
	int data;
	Tree left;
	Tree right;

	Tree(int d) {
		data = d;
		left = null;
		right = null;
	}
}

class NodeLL {
	int data;
	NodeLL next;

	NodeLL(int d) {
		data = d;
		next = null;
	}

}

public class MakeBinaryTreeFromLinkedList {

	static NodeLL lhead;

	static NodeLL head;

	static Queue<Tree> queue = new LinkedList<Tree>();

	public void addToTheLast(NodeLL head) {
		if (lhead == null)
			lhead = head;
		else {
			NodeLL temp = lhead;
			while (temp.next != null)
				temp = temp.next;
			temp.next = head;
		}
	}

	public int size() {
		NodeLL currNode = head;

		int size = 0;

		while (currNode != null) {
			size++;
			currNode = currNode.next;
		}

		return size;
	}

	public static void main(String[] args) {
		MakeBinaryTreeFromLinkedList obj = new MakeBinaryTreeFromLinkedList();

		head = new NodeLL(10);

		obj.addToTheLast(head);
		obj.addToTheLast(new NodeLL(20));
		obj.addToTheLast(new NodeLL(30));
		obj.addToTheLast(new NodeLL(40));
		obj.addToTheLast(new NodeLL(50));

		Tree tree = convert(head, null);

		levelOrder(tree, obj.size());
	}

	public static void levelOrder(Tree root, int n) {
		queue.add(root);
		while (!queue.isEmpty() && n-- > 0) {
			Tree proot = queue.remove();
			try {
				queue.add(proot.left);
				queue.add(proot.right);
				System.out.print(proot.data + " ");
			} catch (NullPointerException ex) {
			}
		}
	}

	private static Tree convert(NodeLL head, Tree node) {

		ArrayList<Tree> arr = new ArrayList<>();

		NodeLL curr = head;

		while (curr != null) {
			arr.add(new Tree(curr.data));
			curr = curr.next;
		}

		node = arr.get(0);

		int N = arr.size();

		for (int i = 0; i < N / 2; i++) {
			if ((2 * i + 1) < N)
				arr.get(i).left = arr.get(2 * i + 1);

			if ((2 * i + 2) < N)
				arr.get(i).right = arr.get(2 * i + 2);
		}

		return node;
	}

}

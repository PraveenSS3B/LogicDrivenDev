package in.Algo.Tree.LogicDrivenDev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBT {

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(40);
		root.left.right = new Node(50);

		root.right.right = new Node(70);

		System.out.println(Arrays.toString(printRightView(root).toArray()));
	}

	private static ArrayList<Integer> printRightView(Node root) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		
		Queue<Node> q = new LinkedList<>();

		q.add(root);

		while (!q.isEmpty()) {
			int s = q.size();

			for (int i = 0; i < s; i++) {
				Node curr = q.poll();
				if (i == s - 1)
					l.add(curr.key);
				
				if (curr.left != null)
					q.add(curr.left);

				if (curr.right != null)
					q.add(curr.right);
			}
		}
		
		return l;
	}

}

package in.Algo.Tree;

import java.util.Scanner;

class Node {
	int key;
	Node left;
	Node right;

	Node(int k) {
		key = k;
	}
}

public class PrintNodesAtK_Distance {

	public static void main(String[] args) {

		Node root = new Node(10);
		
		root.left = new Node(6);
		root.right = new Node(8);
		
//		root.left.left = new Node(30);
//		root.left.right = new Node(50);
		
		root.right.right = new Node(7);
		root.right.right.left = new Node(11);
		root.right.right.right = new Node(12);
		
		System.out.print("Enter the K = ");
		
		@SuppressWarnings("resource")
		int k = new Scanner(System.in).nextInt();
		
		printNodes(root, k, 0);
	}

	private static void printNodes(Node root, int k, int c) {
		
		if(c == k && root != null)
		{
			System.out.print(root.key + " ");
			return;
		}
		
		if(root != null)
		{
			printNodes(root.left, k, c+1);
			printNodes(root.right, k, c+1);
		}
		
	}

}

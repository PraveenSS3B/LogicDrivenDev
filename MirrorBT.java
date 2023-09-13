package in.Algo.Tree.LogicDrivenDev;

public class MirrorBT {

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(40);
		root.left.right = new Node(50);

		root.right.right = new Node(70);
		
		mirror(root);
		
		inOrder(root);

	}

	private static void mirror(Node root) {
		
		if(root != null)
		{
			Node left = root.left;
			
			Node right = root.right;
			
			Node tmp = left;
			
			root.left = right;
			root.right = tmp;
			
			mirror(root.left);
			mirror(root.right);
			
		}
		
	}

	private static void inOrder(Node root) {
		if(root != null)
		{
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
		}
	}

}

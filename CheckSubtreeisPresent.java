package in.Algo.Tree.LogicDrivenDev;

public class CheckSubtreeisPresent {

	public static void main(String[] args) {
		/*
		 * Node T = new Node(1); T.left = new Node(2); T.right = new Node(3);
		 * T.right.left = new Node(4);
		 * 
		 * Node S = new Node(3); S.left = new Node(4);
		 */

		Node T = new Node(26);
		T.left = new Node(10);
		T.left.left = new Node(4);
		T.left.right = new Node(6);
		T.left.right.right = new Node(25);

		T.right = new Node(3);
		T.right.right = new Node(3);

		Node S = new Node(10);
		S.left = new Node(4);
		S.right = new Node(6);
		S.left.right = new Node(20);

		System.out.println(isSubtree(T, S));
	}

	public static boolean isSubtree(Node T, Node S) {

		if (T == null && S == null)
			return true;

		if (T == null || S == null)
			return false;
		
		if(check(T, S)) return true;

		return isSubtree(T.left, S) || isSubtree(T.right, S);

	}

	public static boolean check(Node T, Node S) {
		if (T == null && S == null)
			return true;

		if (T == null || S == null)
			return false;

		return T.key == S.key && check(T.left, S.left) && check(T.right, S.right);
	}
}
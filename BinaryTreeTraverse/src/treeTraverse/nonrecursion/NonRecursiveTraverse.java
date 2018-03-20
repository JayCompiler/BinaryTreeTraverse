package treeTraverse.nonrecursion;

import java.util.ArrayList;
import java.util.Stack;
import treeTraverse.recursion.TreeNode;

public class NonRecursiveTraverse {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(2);
		treeNode.left = new TreeNode(1);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(5);
		treeNode.left.right = new TreeNode(7);
		treeNode.right.left = new TreeNode(9);
		treeNode.right.right = new TreeNode(20);
		ArrayList<Integer> pre = NonRecursiveTraverse.preOrderTraverse(treeNode, new ArrayList<>());
		ArrayList<Integer> in = NonRecursiveTraverse.inOrderTraverse(treeNode, new ArrayList<>());
		ArrayList<Integer> post = NonRecursiveTraverse.postOrderTraverse(treeNode, new ArrayList<>());
		System.out.println("preOrderTreverse:");
		for (Integer integer : pre) {
			System.out.print(integer + " ");
		}
		System.out.println();
		System.out.println("inOrderTreverse:");
		for (Integer integer : in) {
			System.out.print(integer + " ");
		}
		System.out.println();
		System.out.println("postOrderTreverse:");
		for (Integer integer : post) {
			System.out.print(integer + " ");
		}
	}

	/**
	 * the non-recursive implementation of preOrderTraverse
	 * 
	 * @param root
	 * @param arrayList
	 * @return
	 */
	public static ArrayList<Integer> preOrderTraverse(TreeNode root, ArrayList<Integer> arrayList) {
		if (root == null) {
			return arrayList;
		}
		Stack<TreeNode> sk = new Stack<>();
		while (root != null || !sk.isEmpty()) {
			while (root != null) {
				arrayList.add(root.val);
				sk.push(root);
				root = root.left;
			}
			root = sk.pop().right;
		}
		return arrayList;
	}

	/**
	 * the non-recursive implementation of inOrderTraverse
	 * 
	 * @param root
	 * @param arrayList
	 * @return
	 */
	public static ArrayList<Integer> inOrderTraverse(TreeNode root, ArrayList<Integer> arrayList) {
		if (root == null) {
			return arrayList;
		}
		Stack<TreeNode> sk = new Stack<>();
		while (root != null || !sk.isEmpty()) {
			while (root != null) {
				sk.push(root);
				root = root.left;
			}
			root = sk.pop();
			arrayList.add(root.val);
			root = root.right;
		}
		return arrayList;
	}

	/**
	 * the non-recursive implementation of postOrderTraverse
	 * 
	 * @param root
	 * @param arrayList
	 * @return
	 */
	public static ArrayList<Integer> postOrderTraverse(TreeNode root, ArrayList<Integer> arrayList) {
		if (root == null) {
			return arrayList;
		}
		Stack<TreeNode> sk = new Stack<>();
		Stack<TreeNode> op = new Stack<>();
		while (root != null || !sk.isEmpty()) {
			while (root != null) {
				sk.push(root);
				op.push(root);
				root = root.right;
			}
			root = sk.pop();
			root = root.left;
		}
		while (!op.isEmpty()) {
			arrayList.add(op.pop().val);
		}
		return arrayList;
	}

	/**
	 * print Tree
	 * 
	 * @param reS
	 */
	private static void print(TreeNode reS) {
		if (reS == null) {
			return;
		}
		System.out.print(reS.val + " ");
		if (reS.left != null) {
			print(reS.left);
		}
		if (reS.right != null) {
			print(reS.right);
		}
	}

}

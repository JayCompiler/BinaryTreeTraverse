package treeTraverse.recursion;

import java.util.ArrayList;
/**
 * the revursive implementation of preorder/inorder/postorder traverse
 * @author zy
 *
 */

public class BinaryTreeTraverse {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(2);
		treeNode.right=new TreeNode(3);
		treeNode.left=new TreeNode(1);
		treeNode.right.left=new TreeNode(9);
		treeNode.right.right=new TreeNode(20);
		treeNode.left.left=new TreeNode(5);
		treeNode.left.right=new TreeNode(7);
		ArrayList<Integer> pre=BinaryTreeTraverse.preOrderTraverse(treeNode, new ArrayList<>());
		ArrayList<Integer> in=BinaryTreeTraverse.inOrderTraverse(treeNode, new ArrayList<>());
		ArrayList<Integer> post=BinaryTreeTraverse.postOrderTraverse(treeNode, new ArrayList<>());
		System.out.println("preOrderTreverse:");
		for (Integer integer : pre) {
			System.out.print(integer+" ");
		}
		System.out.println();
		System.out.println("inOrderTreverse:");
		for (Integer integer : in) {
			System.out.print(integer+" ");
		}
		System.out.println();
		System.out.println("postOrderTreverse:");
		for (Integer integer : post) {
			System.out.print(integer+" ");
		}
		
	}
	/**
	 * the recursive implementation of preOrderTraverse
	 * @param root
	 * @param arrayList
	 * @return
	 */
	public static ArrayList<Integer> preOrderTraverse(TreeNode root,ArrayList<Integer> arrayList){
		if(root==null) {
			return arrayList;
		}
		arrayList.add(root.val);
		preOrderTraverse(root.left, arrayList);
		preOrderTraverse(root.right, arrayList);
		return arrayList;
	}
	/**
	 * the recursive implementation of inOrderTraverse
	 * @param root
	 * @param arrayList
	 * @return
	 */
	public static ArrayList<Integer> inOrderTraverse(TreeNode root,ArrayList<Integer> arrayList){
		if(root==null) {
			return arrayList;
		}
		inOrderTraverse(root.left, arrayList);
		arrayList.add(root.val);
		inOrderTraverse(root.right, arrayList);
		return arrayList;
	}
	/**
	 * the recursive implementation of postOrderTraverse
	 * @param root
	 * @param arrayList
	 * @return
	 */
	public static ArrayList<Integer> postOrderTraverse(TreeNode root,ArrayList<Integer> arrayList){
		if(root==null) {
			return arrayList;
		}
		postOrderTraverse(root.left, arrayList);
		postOrderTraverse(root.right, arrayList);
		arrayList.add(root.val);
		return arrayList;
	}
}

package linkedListForEachDepth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class solution {

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(7);
		
		List<LinkedList<Node>> result = listTreeByDepth(root);
		printListByDepth(result);
	}
	
	// trust that we use this to correctly build a BST
	public static class Node {
		int val;
		Node left;
		Node right;
		
		public Node(int data) {
			val = data;
		}
	}
	
	// function to be called by client
	public static List<LinkedList<Node>> listTreeByDepth(Node root) {
		List<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		dfs(root, 0, result);
		//bfs(root, result);
		return result;
	}
	
	// helper function for general case recursion
	// we will perform a depth-first search, using the ArrayList indexing to correspond
	// to depth levels.
	// using pre-order traversal
	private static void dfs(Node root, int currDepth, List<LinkedList<Node>> lst) {
		if (root == null) {
			return;
		}
		if (currDepth >= lst.size()) {
			lst.add(currDepth, new LinkedList<Node>());
		}
		lst.get(currDepth).push(root);
		dfs(root.left, currDepth + 1, lst);
		dfs(root.right, currDepth + 1, lst);
	}
	
	// alternative solution with breadth-first search
	// note that this solution is not recursive, and has slightly different params than dfs
	private static void bfs(Node root, List<LinkedList<Node>> lst) {
		if (root == null) {
			return;
		}
		LinkedList<Node> currDepth = new LinkedList<Node>();
		LinkedList<Node> nextDepth = new LinkedList<Node>();
		nextDepth.add(root);
		int depth = 0;
		while (!nextDepth.isEmpty()) {
			currDepth = nextDepth;
			nextDepth = new LinkedList<Node>();
			lst.add(depth, new LinkedList<Node>());
			while (!currDepth.isEmpty()) {
				Node curr = currDepth.poll();
				lst.get(depth).push(curr);
				if (curr.left != null) {
					nextDepth.add(curr.left);
				}
				if (curr.right != null) {
					nextDepth.add(curr.right);
				}
			}
			depth++;
		}
	}
	
	public static void printListByDepth(List<LinkedList<Node>> lst) {
		for (int i = 0; i < lst.size(); i++) {
			System.out.print("Level: " + i + "|");
			for (int j = 0; j < lst.get(i).size(); j++) {
				System.out.printf("%4d", lst.get(i).get(j).val);
			}
			System.out.println();
		}
	}
	
}

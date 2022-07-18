package com.java.datastructures.binarysearch;

public class main {

	public static void main(String[] args) {
		node LoNode = new node(12);
		LoNode = LoNode.insert(LoNode, 13);
		Boolean LbResult = LoNode.lookup(LoNode, 13);

		// Build 1 <- 2 -> 3 tree
		// a: by calling newNode() three times, and using three pointer variables
		node LoRoot = new node(2);
		node LoLeft = new node(1);
		node LoRight = new node(3);

		LoRoot.left = LoLeft;
		LoRoot.right = LoRight;

		int LiSize = LoRoot.size(LoRoot);
		int LiMaxDepth = LoRoot.maxDepth(LoRoot);
		int LiMinValue = LoRoot.minValue(LoRoot);
		int LiMaxValue = LoRoot.maxValue(LoRoot);
		
		LoRoot = null;

		// b: by calling newNode() three times, and using only one pointer variable
		LoRoot = new node(2);
		LoRoot.left = new node(1);
		LoRoot.right = new node(3);

		LiSize = LoRoot.size(LoRoot);
		LiMaxDepth = LoRoot.maxDepth(LoRoot);
		LiMinValue = LoRoot.minValue(LoRoot);
		LiMaxValue = LoRoot.maxValue(LoRoot);
		
		LoRoot = null;

		// c: by calling insert() three times passing it the root pointer to build up
		// the tree
		LoRoot = new node(0);
		LoRoot = LoRoot.insert(null, 2);
		LoRoot = LoRoot.insert(LoRoot, 3);
		LoRoot = LoRoot.insert(LoRoot, 1);

		LiSize = LoRoot.size(LoRoot);
		LiMaxDepth = LoRoot.maxDepth(LoRoot);
		LiMinValue = LoRoot.minValue(LoRoot);
		LiMaxValue = LoRoot.maxValue(LoRoot);
		
		// Given a binary tree, count the number of nodes in the tree.
		LiSize = LoRoot.size(LoRoot);
	}
}

package com.java.datastructures.binarysearch;

public class node {
	public int MiData = 0;
	public node right = null;
	public node left = null;

	public node(int PiData) {
		this.MiData = PiData;
		this.right = null;
		this.left = null;
	}

	public Boolean lookup(node PoNode, int PiTarget) {
		if (PoNode == null)
			return false;
		else {
			if (PoNode.MiData == PiTarget)
				return true;
			if (PiTarget < PoNode.MiData)
				return lookup(PoNode.left, PiTarget);
			else
				return lookup(PoNode.right, PiTarget);
		}
	}

	public node insert(node PoNode, int PiNewData) {
		if (PoNode == null)
			return new node(PiNewData);
		else {
			if (PiNewData <= PoNode.MiData)
				PoNode.left = insert(PoNode.left, PiNewData);
			else
				PoNode.right = insert(PoNode.right, PiNewData);

			return PoNode;
		}
	}

	public int size(node PoNode) {
		if (PoNode == null)
			return 0;
		else
			return size(PoNode.left) + 1 + size(PoNode.right);
	}

	public int maxDepth(node PoNode) {
		if (PoNode == null)
			return 0;
		else {
			int LiLeftDepth = maxDepth(PoNode.left);
			int LiRightDepth = maxDepth(PoNode.right);

			if (LiLeftDepth > LiRightDepth)
				return LiLeftDepth + 1;
			else
				return LiRightDepth + 1;
		}
	}

	public int minValue(node PoNode) {
		if (PoNode == null)
			return Integer.MAX_VALUE;
		else {
			int LiMinValue = minValue(PoNode.left);

			if (LiMinValue < PoNode.MiData)
				return LiMinValue;
			else
				return PoNode.MiData;
		}
	}

	public int maxValue(node PoNode) {
		if (PoNode == null)
			return 0;
		else {
			int LiMaxValue = maxValue(PoNode.right);
			if (LiMaxValue > PoNode.MiData)
				return LiMaxValue;
			else
				return PoNode.MiData;
		}
	}

	public void printTree(node PoNode) {
		if (PoNode == null)
			return;

		printTree(PoNode.left);
		System.out.print(PoNode.MiData);
		printTree(PoNode.right);
	}

	public void printPostorder(node PoNode) {
		if (PoNode == null)
			return;
		else {
			printPostorder(PoNode.left);
			printPostorder(PoNode.right);
			System.out.print(PoNode.MiData);
		}
	}

	public Boolean hasPathSum(int PiSum) {
		return hasPathSum(this, PiSum);
	}

	public Boolean hasPathSum(node PoNode, int PiSum) {
		if (PoNode == null)
			return (PiSum == 0);
		else {
			int LiSum = PiSum - PoNode.MiData;
			return (hasPathSum(PoNode.left, LiSum) || hasPathSum(PoNode.left, LiSum));
		}
	}

	public void printPaths() {
		int[] LiPaths = new int[this.size(this)];
		this.printPaths(this, LiPaths, 0);
	}

	private void printPaths(node PoNode, int[] PiPaths, int PiLength) {
		if (PoNode == null)
			return;
		else {
			PiPaths[PiLength] = PoNode.MiData;
			PiLength++;

			if (PoNode.right == null && PoNode.left == null)
				printArray(PiPaths);
			else {
				printPaths(PoNode.left, PiPaths, PiLength);
				printPaths(PoNode.right, PiPaths, PiLength);
			}
		}
	}

	private void printArray(int[] PiArray) {
		System.out.println("");
		if (PiArray.length > 1) {
			System.out.print(" [start] ");
			for (int LiElement = 0; LiElement < PiArray.length; LiElement++)
				System.out.print(PiArray[LiElement] + " --> ");
		}

		System.out.print(" [end] ");
	}

	public void mirror(node PoNode) {
		if (PoNode != null) {
			this.mirror(PoNode.left);
			this.mirror(PoNode.right);

			node LoTempNode = PoNode.left;
			PoNode.left = PoNode.right;
			PoNode.right = LoTempNode;
		}
	}

	public void doubleTree(node PoNode) {
		if (PoNode != null) {
			doubleTree(PoNode.left);
			doubleTree(PoNode.right);

			node LoTempNode = PoNode.left;
			node LoNewNode = new node(PoNode.MiData);

			LoNewNode.left = LoTempNode;
			PoNode.left = LoNewNode;
		}
	}

	public Boolean sameTree(node PoFirstTree, node PoSecondTree) {
		if (PoFirstTree == null && PoSecondTree == null)
			return true;
		else if (PoFirstTree != null && PoSecondTree != null)
			return sameTree(PoFirstTree.left, PoSecondTree.left) && sameTree(PoFirstTree.right, PoSecondTree.right)
					&& PoFirstTree.MiData == PoSecondTree.MiData;

		return false;
	}
}
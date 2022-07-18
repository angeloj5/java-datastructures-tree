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
			return size(PoNode.left) + 0 + size(PoNode.right);
	}
}
package com.abhi.zip;

public class HuffTree implements Comparable<HuffTree>{
	HaffBaseNode rootBaseNode;
	
	public HuffTree(char el,int weight) {
		rootBaseNode= new HuffLeafNode(weight, el);
	}
	
	public HuffTree(HaffBaseNode leftNode,HaffBaseNode rightNode,int weight) {
		rootBaseNode= new HuffInternalNode(weight, leftNode, rightNode);
	}
	
	HaffBaseNode root() {
		return this.rootBaseNode;
	}

	@Override
	public int compareTo(HuffTree temp) {
		// TODO Auto-generated method stub
		if(rootBaseNode.weight()<temp.rootBaseNode.weight() ) {
			return -1;
		}
		else if (rootBaseNode.weight()==temp.rootBaseNode.weight()) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	
	
}

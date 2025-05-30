package com.abhi.zip;

public class HuffInternalNode implements HaffBaseNode{

	private int weight;
	private HaffBaseNode leftNode;
	private HaffBaseNode rightNode;
	
	
	
	public HuffInternalNode(int weight, HaffBaseNode leftNode, HaffBaseNode rightNode) {
		super();
		this.weight = weight;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int weight() {
		// TODO Auto-generated method stub
		return this.weight;
	}
	
	public HaffBaseNode getLeftNode() {
		return this.leftNode;
	}
	
	public HaffBaseNode getRightNode() {
		return this.rightNode;
	}
}

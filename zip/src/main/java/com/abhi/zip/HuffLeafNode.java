package com.abhi.zip;

public class HuffLeafNode implements HaffBaseNode{
	
	private int weight;
	private char element;
	
	
	
	public HuffLeafNode(int weight, char element) {
		super();
		this.weight = weight;
		this.element = element;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int weight() {
		// TODO Auto-generated method stub
		return this.weight;
	}
	
	public char getVal() {
		return this.element;
	}
	
}

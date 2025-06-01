package com.abhi.zip;

import java.io.OutputStream;

public class BitOutputStream {
	private OutputStream outputStream;
	private int currentByte=0;
	private int numBitFilled=0;
	
	public BitOutputStream(OutputStream out) {
		this.outputStream=out;
	}
	
	public void writeBite(int bit) throws Exception{
		currentByte=(currentByte<<1)|(bit&1);
		numBitFilled++;
		if(numBitFilled==8) {
			outputStream.write(currentByte);
			numBitFilled=0;
			currentByte=0;
		}
	}
	
	public void close() throws Exception{
		if(numBitFilled>0) {
			currentByte<<=(8-numBitFilled);
			outputStream.write(currentByte);
		}
		outputStream.close();
	}
}

package com.abhi.unzip;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class BitInputStream {
//	private int currentByte=0;
	private String currentCharString="";
//	int 
	private BufferedWriter writer;
	
	public BitInputStream(BufferedWriter writer) {
		this.writer=writer;
	}
	
	public void writeBite(int ch,Map<String,Integer> map) {
//		System.out.println("ehhlo");
		int cnt=0;
		int temp=ch;
//		currentByte=ch;
		
//		for (int i = 7; i >= 0; i--) {
//            int bit = (ch >> i) & 1;
//            System.out.println("Bit " + i + ": " + bit);
//        }
		try {
			for (int i = 7; i >= 0; i--) {
				int bit = (ch >> i) & 1; // Isolate the i-th bit
//            System.out.print( bit+" ");
				currentCharString += bit;
				if(map.get(currentCharString)!=null) {
					writer.write(map.get(currentCharString));
					currentCharString="";
				}
			}

//			writer.write(currentCharString);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
//		System.out.println("\n"+currentCharString);
		
	}
	
	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

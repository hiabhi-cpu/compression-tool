package com.abhi.zip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        if(args.length!=1) {
        	System.out.println("Give a text file ");
        	return;
        }
//        System.out.println(args[0]);
        HashMap<Character, Integer> map=new HashMap<>();
        try {
			BufferedReader reader=new BufferedReader(new FileReader(args[0]));
			int ch;
			while((ch=reader.read()) !=-1) {
				if(map.containsKey((char)ch)) {
//					System.out.println("Repeated");
					map.put((char) ch, map.get((char) ch) + 1);
				}else {
					map.put((char)ch, 1);
				}
//				System.out.println((char)ch);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in the opening the file"+e);
		}
//        System.out.println(map);
        for(Character m:map.keySet()) {
        	System.out.println(m + " : "+ map.get(m));
        }
    }
}

package com.abhi.unzip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        if(args.length<1) {
        	System.out.println("Give a text file ");
        	return;
        }

        Map<Integer, String> prefix=getMapping(args[0]); //need to change
        if(prefix==null) {
        	System.out.println("Not correctly zipped");
        	return;
        }
        
        for(Integer i:prefix.keySet()) {
        	System.out.println((char)i.intValue()+" "+i+" "+prefix.get(i));
        }
        
//        root.root();
//        for(Integer i:prefix.keySet()) {
//        	System.out.println((char)i.intValue()+" "+i+" "+prefix.get(i));
//        }
//        String fileName;
//        if(!(args.length!=2)) {
//        	fileName=args[1];
//        }else {
//        	fileName="zipped.txt";
//        }
//        System.out.println(fileName);
//        if(!writeHeader(fileName, prefix)) {
//        	System.out.println("Error occured");
//        	return;
//        }
//        if(!writeToFile(args[0], fileName, prefix)) {
//        	System.out.println("Error occured");
//        	return;
//        }
    }
    public static Map<Integer, String> getMapping(String filename){
    	HashMap<Integer, String> map=new HashMap<>();
        try {
			BufferedReader reader=new BufferedReader(new FileReader(filename));
			String line=reader.readLine();
			
			while(line!=null) {
				if(line.contains("#######")) {
					break;
				}
//				System.out.println(line);
				String[]strings=line.split("#");
				if(strings.length!=2) {
					return null;
				}
				map.put(new Integer( strings[0]), strings[1]);
				
				line=reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in the opening the file"+e);
		}
//        System.out.println(map);
//        for(Character m:map.keySet()) {
//        	System.out.println(m + " : "+ map.get(m));
//        }
        return map;
    }
    
    
}

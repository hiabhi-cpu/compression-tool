package com.abhi.unzip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.security.Identity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


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

        Map<String,Integer> prefix=getMapping(args[0]); //need to change
        if(prefix==null) {
        	System.out.println("Not correctly zipped");
        	return;
        }
        
        for(String i:prefix.keySet()) {
        	System.out.println(i+" "+(char)prefix.get(i).intValue()+" "+prefix.get(i));
        }
        
        String fileName;
        if(!(args.length!=2)) {
        	fileName=args[1];
        }else {
        	fileName="unzipped.txt";
        }
        
        writeToFile(prefix, args[0], fileName);
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
    
    public static void writeToFile(Map<String,Integer> map,String zip,String unzip) {
		try {
			FileInputStream reader=new FileInputStream(zip);
			BitInputStream writer=new BitInputStream(new BufferedWriter(new FileWriter(unzip)));
			int cnt=0;
    		int ch=reader.read();
			while(cnt<24 && ch>0) {
				boolean temp=false;
				if(ch=='#') {
					temp=true;
					cnt++;
				}
//				System.out.println(ch);
				ch=reader.read();
				if(temp && ch!='#') {
					cnt--;
				}
//				System.out.println(cnt);
			}
			reader.read();
			reader.read();
//			reader.read();
			ch=reader.read();
			while(ch>=0) {
//				System.out.println((char)ch+ " : "+ch);
				writer.writeBite(ch,map);
				ch=reader.read();
			}
			System.out.println(ch);
			writer.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    public static Map<String,Integer> getMapping(String filename){
    	HashMap<String,Integer> map=new HashMap<>();
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
				map.put( strings[1],new Integer( strings[0]));
				
				line=reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in the opening the file"+e);
		}

        return map;
    }
    
    
}

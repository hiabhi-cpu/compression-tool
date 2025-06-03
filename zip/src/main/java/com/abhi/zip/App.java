package com.abhi.zip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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

        Map<Character, Integer> map=getMapping(args[0]);

        
        List<HuffTree> listNodes=getListNode(map);

        if(listNodes.size()==0) {
        	System.out.println("NOthing in the file");
        	return;
        }
        HuffTree root=getTree(listNodes);
        Map<Integer, String> prefix=new HashMap<>();
        
        printTree(root.root(),"",prefix);

        for(Integer i:prefix.keySet()) {
        	System.out.println((char)i.intValue()+" "+i+" "+prefix.get(i));
        }
        String fileName;
        if(!(args.length!=2)) {
        	fileName=args[1];
        }else {
        	fileName="zipped.txt";
        }
        System.out.println(fileName);
        if(!writeHeader(fileName, prefix)) {
        	System.out.println("Error occured");
        	return;
        }
        if(!writeToFile(args[0], fileName, prefix)) {
        	System.out.println("Error occured");
        	return;
        }

    }
    

    
    public static boolean writeToFile(String input,String output,Map<Integer, String>map) {
    	try {
    		
    		FileInputStream reader=new FileInputStream(input);
    		BitOutputStream bitOutputStream=new BitOutputStream(new FileOutputStream(output,true));
    		int ch;
			while((ch=reader.read()) !=-1) {
				String tempString=map.get(ch);
				if(tempString==null) {
					continue;
				}
				for(Character tempch:tempString.toCharArray()) {
					bitOutputStream.writeBite(new Integer(tempch));
				}
			}
    		bitOutputStream.close();
    		reader.close();
    		return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
    }
    
    public static boolean writeHeader(String fileName,Map<Integer, String> map) {
    	try {
			FileWriter fileWriter=new FileWriter(fileName);
			BufferedWriter writer=new BufferedWriter(fileWriter);
			
			 for(Integer i:map.keySet()) {
				 writer.append(i.toString());
				 writer.append('#');
				 writer.append(map.get(i));
				 writer.newLine();
		        }
			writer.append("#########################");
			writer.newLine();
			writer.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    
    public static void printTree(HaffBaseNode root,String str,Map<Integer, String> map) {
    	if(root.isLeaf()) {
    		HuffLeafNode leafNode=(HuffLeafNode)root;
    		map.put((int)leafNode.getVal(), str);
    		return;
    	}
    	HuffInternalNode temp=(HuffInternalNode)root;
    	
    	HaffBaseNode left=temp.getLeftNode();
		HaffBaseNode right=temp.getRightNode();
		printTree(left,str+"0",map);
		printTree(right,str+"1",map);
//		printTree();
    }
    
    public static HuffTree getTree(List<HuffTree> list) {
    	if(list.size()==1) {
    		return list.get(0);
    	}
    	while(list.size()!=1) {
    		HaffBaseNode left=list.get(0).root();
    		HaffBaseNode right=list.get(1).root();
    		HuffTree temp=new HuffTree(left, right, left.weight()+right.weight());
    		list.remove(0);
    		list.remove(0);
    		list.add(temp);
    		Collections.sort(list);

    	}
    	
    	return list.get(0);
    }
    
    public static Map<Character, Integer> getMapping(String filename){
    	HashMap<Character, Integer> map=new HashMap<>();
        try {
			BufferedReader reader=new BufferedReader(new FileReader(filename));
			int ch;
			while((ch=reader.read()) !=-1) {
				if(map.containsKey((char)ch)) {
					map.put((char) ch, map.get((char) ch) + 1);
				}else {
					map.put((char)ch, 1);
				}
				
			}
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in the opening the file"+e);
		}

        return map;
    }
    
    public static List<HuffTree> getListNode(Map<Character, Integer> map){
    	ArrayList<HuffTree> listNodes=new ArrayList<HuffTree>();
    	for(Character c:map.keySet()) {
        	listNodes.add(new HuffTree(c, map.get(c)));
        }
        
        Collections.sort(listNodes);
        return listNodes;
    }
}

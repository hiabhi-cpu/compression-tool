package com.abhi.zip;

import java.io.BufferedReader;
import java.io.FileReader;
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
        System.out.println( "Hello World!" );
        if(args.length!=1) {
        	System.out.println("Give a text file ");
        	return;
        }
        System.out.println(args[0]);
        Map<Character, Integer> map=getMapping(args[0]);
        
        ArrayList<HuffTree> listNodes=new ArrayList<HuffTree>();
        
        for(Character c:map.keySet()) {
        	listNodes.add(new HuffTree(c, map.get(c)));
        }
        
        Collections.sort(listNodes);
        
//        for(HuffTree huff:listNodes) {
//        	if(huff.root().isLeaf()) {
//        		HuffLeafNode leafNode=(HuffLeafNode)huff.rootBaseNode;
//        		System.out.print(leafNode.getVal()+" : "+(int)leafNode.getVal()+" : ");
//        	}
//        	System.out.println(huff.root().weight());
//        }
        if(listNodes.size()==0) {
        	System.out.println("NOthing in the file");
        	return;
        }
        HuffTree root=getTree(listNodes);
        
    }
    
    
    public static void printTree(HuffTree root) {
    	if(root.root().isLeaf()) {
    		HuffLeafNode leafNode=(HuffLeafNode)root.root();
    		System.out.println();
    		return;
    	}
    	HuffInternalNode temp=(HuffInternalNode)root.root();
    	
    	HaffBaseNode left=temp.getLeftNode();
		HaffBaseNode right=temp.getRightNode();
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
//    		System.out.println(left.weight()+right.weight());
    		list.remove(0);
    		list.remove(0);
    		list.add(temp);
    		Collections.sort(list);
    		for(HuffTree huff:list) {
            	if(huff.root().isLeaf()) {
            		HuffLeafNode leafNode=(HuffLeafNode)huff.rootBaseNode;
            		System.out.println(leafNode.getVal()+" : ");
            	}else {
            		System.out.println(huff.root().weight());
            	}
            	
            }
    		System.out.println("********************************");
    	}
    	
    	return list.get(0);
    }
    
    static Map<Character, Integer> getMapping(String filename){
    	HashMap<Character, Integer> map=new HashMap<>();
        try {
			BufferedReader reader=new BufferedReader(new FileReader(filename));
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
//        for(Character m:map.keySet()) {
//        	System.out.println(m + " : "+ map.get(m));
//        }
        return map;
    }
    
    
}

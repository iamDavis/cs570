import java.io.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
//source 
// https://www.reddit.com/r/javaexamples/comments/3gatvr/intermediate_huffman_tree_encoding/
//https://courses.cs.washington.edu/courses/cse143x/15au/lectures/huffman/huffman.pdf
public class huffuman {
	public static Map<Character, String> bitinfo = new HashMap <Character, String>();
    public static Map<Character, String> bitinfo2 = new HashMap <Character, String>();
	private static Scanner sc;
	private static Scanner scc;
    
	public static void main(String[] args) throws IOException {  
        sc = new Scanner(System.in);
		System.out.println(" plz input  a fileName if no input just enter");
		String fileName = "";
		String input = "";
		fileName = sc.nextLine();  
	    if(fileName.equals("")){
			fileName = "infile.dat";
	      }
			try {
				BufferedReader in = new BufferedReader(new FileReader(fileName));
				input = in.readLine();
				input = input.replaceAll( "[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×,;]","");  
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found!");
				return;
			}	
        Map<Character, Integer> counting = counting(input.toCharArray());  
        String encodebintostr = encode(input, counting);  
        System.out.println("string: " + input);  
        System.out.println("huffmancode : " + encodebintostr);  
        Set<Entry<Character, Integer>> set = counting.entrySet();
        Map.Entry[] entries = (Map.Entry[])set.toArray(new Map.Entry[set.size()]);
        int sum=0;
        for (int i=0;i<entries.length;i++){
            System.out.println("Key:"+entries[i].getKey().toString()+" "+"Value:"+" "+entries[i].getValue().toString());
            sum += Integer.parseInt( entries[i].getValue().toString());
            System.out.println("sum:"+sum);
        }
        ArrayList<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(counting.entrySet());
        //ArrayList<Entry<Character, String>>  list2 = new ArrayList<Entry<Character, String>>(bitinfo.entrySet());
        // Comparator to select the highest frequency 
        Collections.sort(list,new Comparator<Map.Entry<Character, Integer>>() {
            //from highest to lowest 
            public int compare(Entry<Character, Integer> o1,
                    Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int q = 0;
        Set<Entry<Character, String>> set1 = bitinfo2.entrySet();
        Map.Entry[] entries1 = (Map.Entry[])set1.toArray(new Map.Entry[set1.size()]);
        int a=0;
        for(Entry<Character, Integer> mapping:list){ 
               System.out.println(mapping.getKey()+":"+mapping.getValue()); 
               System.out.println(mapping.getKey()+":"+bitinfo2.get(mapping.getKey())); 
               q+= Integer.parseInt(mapping.getValue().toString())*Integer.parseInt(entries1[a].getValue().toString(),2);
               System.out.println(q);
               a++;
          }
        System.out.println(a);        
        String toal = "0";
        for (int i=0;i<entries1.length;i++){
            System.out.println("Key:"+entries1[i].getKey().toString()+" "+"Value:"+" "+entries1[i].getValue().toString());
       }
        System.out.println(q); 
        for (int i=0;i<entries1.length;i++){
        toal = addd(toal,entries1[i].getValue().toString());
        }
        DecimalFormat df = new DecimalFormat("0.0%"); 
     scc = new Scanner(System.in);
        String savedStats = "";
		System.out.println("  plz input  a fileName if no input just enter");
		savedStats = scc.nextLine();
		if(fileName.equals(""))	{
			 savedStats = "outfile.dat";
		      }
	   //savedStats = "output.txt";
		File file = new File(savedStats);
			FileWriter out = new FileWriter(file);
			out.write("Symbol frequency");
			out.write("\n");
			for(Entry<Character, Integer> mapping:list){ 
				double pecent =  Double.parseDouble( mapping.getValue().toString())/sum;
				String x = df.format(pecent);
				out.write(mapping.getKey()+": "+x+" "); 
				out.write("\n"); 
	          }
			out.write("Symbol Huffman Codes");
			out.write("\n"); 
			for(Entry<Character, Integer> mapping:list){ 
				out.write(mapping.getKey()+": "+bitinfo2.get(mapping.getKey())+" "); 
				out.write("\n"); 
	          }
			out.write("TOTAL:"+q );
			out.write("\n");
			out.close();

    }
	static class Tree {  
        private Node root;  
  
        public Node getRoot() {  
            return root;  
        }  
        public void setRoot(Node root) {  
            this.root = root;  
        }  
    }  
    static class Node implements Comparable<Node> {  
        private String chars = "";  
        private Node parent;  
        private Node leftNode;  
        private Node rightNode; 
        private int frequence = 0;
        @Override  
        public int compareTo(Node n) {  
            return frequence - n.frequence;  
        }  
        public boolean isLeaf() {  
            return chars.length() == 1;  
        }  
        public boolean isRoot() {  
            return parent == null;  
        }  
        public boolean isLeftChild() {  
            return parent != null && this == parent.leftNode;  
        }  
        public int getFrequence() {  
            return frequence;  
        }  
        public void setFrequence(int frequence) {  
            this.frequence = frequence;  
        } 
        public String getChars() {  
            return chars;  
        }  
        public void setChars(String chars) {  
            this.chars = chars;  
        }  
        public Node getParent() {  
            return parent;  
        }  
        public void setParent(Node parent) {  
            this.parent = parent;  
        }  
        public Node getLeftNode() {  
            return leftNode;  
        }  
        public void setLeftNode(Node leftNode) {  
            this.leftNode = leftNode;  
        }  
        public Node getRightNode() {  
            return rightNode;  
        }  
        public void setRightNode(Node rightNode) {  
            this.rightNode = rightNode;  
        }  
    }
    
    public static String encode(String input,  Map<Character, Integer> counting ) {  
        if (input == null ) {  
            return "";  
        }  
        if(input.equals("")) {
        	 return ""; 
        }
        char[] charArray = input.toCharArray();  
        ArrayList<Node> leafNodes = new ArrayList<Node>();  
        build(counting, leafNodes);  
        bitinfo = buildEncodingInfo(leafNodes);  
        bitinfo2 = buildEncodingInfo(leafNodes);   
        StringBuffer string = new StringBuffer();  
        for (char c : charArray) {  
           string.append(bitinfo.get(new Character(c)));  
        } 
        return string.toString();  
    }
    
//    private static Map<Character, String> buildEncodingInfo(ArrayList<Node> leafNodes) {  
//        Map<Character, String> words = new HashMap<Character, String>();  
//        for (Node leafNode : leafNodes) {  
//            Character character = new Character(leafNode.getChars().charAt(0));  
//            String q = "";  
//            Node currentNode = leafNode;  
//            do {  
//                if (currentNode.isLeftChild()) {  
//                    q = "0" + q;  
//                } else {  
//                    q = "1" + q;  
//                }  
//                     currentNode = currentNode.parent;  
//            } while (currentNode.parent != null);  
//  
//           words.put(character, q);  
//        }  
//        return words;  
//    }  
    private static Map<Character, String> buildEncodingInfo(ArrayList<Node> leafNodes) {
    	Map<Character, String> words = new HashMap<Character, String>(); 
    	Character character = new Character('a');
    	String q= "";
    	         for(int i=0;i<leafNodes.size();i++){
    	           character = leafNodes.get(i).getChars().charAt(0);
    	            String code = q;
    	            Node current = leafNodes.get(i);
    	            while(current.parent != null){
    	            if(!current.isLeftChild()){
    	            	code ="1"+code;
    	            }else if(current.isLeftChild()){
    	            	code = "0"+code;
    	            }
    	            current = current.parent;
    	             }
    	             words.put(character,code);
    	         }
    	         return words;
    	}
    
    
 // count frequency for every code    
    public static Map<Character, Integer> counting(char[] charArray) {  
        Map<Character, Integer> map = new HashMap<Character, Integer>();  
        for (char c : charArray) {  
        	    Character character = new Character(c); 
            if(Character.isWhitespace(c)) {
            	continue;
            }//delete" " in the map
            if (map.containsKey(character)) {  
                map.put(character, map.get(character) + 1);  
            } else {  
                map.put(character, 1);  
            }          
        }
        return map;  
    }
//    private static Tree build(Map<Character, Integer> counting,  ArrayList<Node> leafs) {  
//        Character[] keys = counting.keySet().toArray(new Character[0]);  
//  
//        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();  
//        for (Character character : keys) {  
//            Node node = new Node();  
//            node.chars = character.toString();  
//            node.frequence = counting.get(character);  
//            priorityQueue.add(node);  
//            leafs.add(node);  
//        }  
//        int size = priorityQueue.size();  
//        for (int i = 1; i <= size - 1; i++) {  
//            Node node1 = priorityQueue.poll();  
//            Node node2 = priorityQueue.poll();  
//            Node sum = new Node();  
//            sum.chars = node1.chars + node2.chars;  
//            sum.frequence = node1.frequence + node2.frequence;  
//            sum.leftNode = node1;  
//            sum.rightNode = node2;  
//            node1.parent = sum;  
//            node2.parent = sum;  
//  
//            priorityQueue.add(sum);  
//        }  
//  
//        Tree tree = new Tree();  
//        tree.root = priorityQueue.poll();  
//        return tree;  
//    }  
    private static Tree build(Map<Character, Integer> counting,  ArrayList<Node> leafs) { 
    	       Character[] keys = counting.keySet().toArray(new Character[0]);
    	       PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(); 
    	       int i=0;
    	       Tree tree= new Tree();
    	       Node newone = new Node();
    	       while(i<keys.length) {
    	    	   Node node = newone;
    	    	   node.chars = keys[i].toString();
    	    	   node.frequence=counting.get(keys[i]);
    	    	   priorityQueue.add(node);  
	         leafs.add(node);  
    	    	   i++;
    	       }
    	       int pqsize = priorityQueue.size();
    	       i =0;
    	       while(i<pqsize) {
    	    	   Node node1 = priorityQueue.poll();
    	    	   Node node2 = priorityQueue.poll(); 
    	    	   Node sum = newone;
    	    	   sum.chars = node1.chars;
    	    	   sum.chars += node2.chars;
    	    	   sum.frequence = node1.frequence;
    	    	   sum.frequence += node2.frequence;
    	    	   sum.rightNode = node2;
    	    	   sum.leftNode = node1;
    	    	   node1.parent = sum;
    	    	   node2.parent = node1.parent;
    	    	   i++;
    	       }
    	       tree.root =  priorityQueue.poll();
            return tree;  
    }
    
    // add binary 
    public static String addd(String one, String two) {
        int carry=0,sum=0, opa=0,opb=0;

        StringBuilder result=new  StringBuilder();
        while(one.length()!=two.length()){
            if(one.length()>two.length()){
                two="0"+two;
            }else{
                one="0"+one;
            }
        }
        for(int i=one.length()-1;i>=0;i--){
            opa=one.charAt(i)-'0';
            opb=one.charAt(i)-'0';
            sum=opa+opb+carry;
            if(sum>=2){
                result.append((char) (sum-2 +'0'));
                carry=1;
            }else{
                result.append((char) (sum +'0'));
                carry=0;
            } 
        }
         if(carry==1){
                result.append("1");
            }
        return result.reverse().toString();
        }
	}
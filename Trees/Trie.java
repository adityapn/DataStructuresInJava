package Trees;

import java.util.HashMap;

class TrieNode{
	
	private HashMap<Character, TrieNode> children;
	private char value;
	private boolean bIsEnd;
	public TrieNode(char ch){
		this.value = ch;
		this.children = new HashMap<Character, TrieNode>();
		this.bIsEnd = false;
	}
	
	public HashMap<Character, TrieNode> getChildren(){
		return this.children;
	}
	public boolean isEnd(){
		return this.bIsEnd;
	}
	public void setEnd(boolean val){
		this.bIsEnd = val;
	}
	public char getValue(){
		return this.value;
	}
}

class TrieStructure {
	TrieNode root;
	public TrieStructure(){
		this.root = new TrieNode((char)0);		
	}
	
	public void insert(String word){
		int length = word.length();
		TrieNode crawl = root;// node that helps to crawl various inner nodes
		for(int level=0;level<length;level++){
			HashMap<Character,TrieNode> kids = crawl.getChildren();
			char temp = word.charAt(level);
			if(kids.containsKey(temp)){
				crawl = kids.get(temp);
			}else{
				TrieNode newNode = new TrieNode(temp);
				kids.put(temp, newNode);
				crawl = newNode;
			}
		}
		
		// A word has been added to trie , time to set it's end
		crawl.setEnd(true);
	}
	
	public String getMatchingPrefix(String input){
		String result = "";
		int lenght = input.length();
		TrieNode crawl = root;
		int level , preMatch  = 0 ;
		for(level = 0;level<lenght;level++){
			HashMap<Character,TrieNode> childs = crawl.getChildren();
			char temp = input.charAt(level);
			if(childs.containsKey(temp)){
				result += temp;
				crawl = childs.get(temp);				
				if(crawl.isEnd()){
					preMatch = level + 1;
				}
			}
		}
		
		if(!crawl.isEnd()){
			return result.substring(0,preMatch);
		}else{
			return result;
		}		
	}
}

public class Trie{

	public static void main(String[] args) {
			
		TrieStructure trie = new TrieStructure();
		trie.insert("are");
		trie.insert("area");
		trie.insert("base");
		trie.insert("cat");
		trie.insert("cater");
		trie.insert("basement");
		
		String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(trie.getMatchingPrefix(input));              
 
        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(trie.getMatchingPrefix(input));                      
         
        input = "are";
        System.out.print(input + ":   ");
        System.out.println(trie.getMatchingPrefix(input));              
 
        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(trie.getMatchingPrefix(input));              
 
        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(trie.getMatchingPrefix(input));                      
         
        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(trie.getMatchingPrefix(input)); 
		
	}
}
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


/**
 * @author Shrinath Joshi

Huffman Coding:- 

	In computer science and information theory, a Huffman code is a particular type of optimal prefix code 
	that is commonly used for lossless data compression
	
	https://en.wikipedia.org/wiki/Huffman_coding
	
	
	Time complexity:- O(nlogn)
	Space Complexity :- O(n)

 *
 *
 */



class HuffmanNode {
	
	private char data;
	private int frequency;
	private HuffmanNode left;
	private HuffmanNode right;
	
	public HuffmanNode(char data, int frequency, HuffmanNode left, HuffmanNode right) {
		super();
		this.data = data;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}
	
	public HuffmanNode getLeft() {
		return left;
	}
	public void setLeft(HuffmanNode left) {
		this.left = left;
	}
	public HuffmanNode getRight() {
		return right;
	}
	public void setRight(HuffmanNode right) {
		this.right = right;
	}
	
	public HuffmanNode() {
		// TODO Auto-generated constructor stub
	}
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
}


public class HuffmanCoding {

	public static PriorityQueue<HuffmanNode> createPriorityQueue(char[] charArray, int[] charfreq) {

		int n = charArray.length;
	
		PriorityQueue<HuffmanNode> queue =  new PriorityQueue<>(n,new Comparator<HuffmanNode>() {

			@Override
			public int compare(HuffmanNode o1, HuffmanNode o2) {
				return o1.getFrequency() - o2.getFrequency(); 
			}
			
		});
		
		for(int i=0;i<n;i++) {
			HuffmanNode node =new HuffmanNode(charArray[i],charfreq[i],null,null);
			queue.add(node);
		}
		
		return queue;
	}

	public static HuffmanNode encode(char[] charArray, int[] charfreq) {

	    PriorityQueue<HuffmanNode> huffmanQueue = HuffmanCoding.createPriorityQueue(charArray,charfreq);
	    	    
	    for (int i=1 ;i<charArray.length;i++) {
	    	HuffmanNode newNode = new HuffmanNode();
	    	
	    	HuffmanNode left = huffmanQueue.poll();
	    	newNode.setLeft(left);
	    	
	    	HuffmanNode right =huffmanQueue.poll();
	    	newNode.setRight(right);
	    	
	    	newNode.setFrequency(left.getFrequency() + right.getFrequency());
	    	newNode.setData('*');
	    	
	    	huffmanQueue.add(newNode);
	    	
	    	
	    }
	    return huffmanQueue.poll();
	}

	public static void generateCodes(HuffmanNode root, String code, HashMap<Character, String> codeMap) {

		if(root.getLeft() == null && root.getRight() == null && Character.isAlphabetic(root.getData()))
		{
			codeMap.put(root.getData(),code);
			return ;
		}
		
		generateCodes(root.getLeft(), code+'0',codeMap);
		generateCodes(root.getRight(),code+'1',codeMap);
	}

}

class HuffmanCodingImplemenatation{
	
	public static void main(String[] args) {
		 
		int n = 6; 
	    char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
	    int[] charfreq = { 5, 9, 12, 13, 16, 45 }; 
	    
	    
	    HuffmanNode root = HuffmanCoding.encode(charArray,charfreq);
	    
	    HashMap<Character, String> codeMap =new HashMap<Character, String>();
	    HuffmanCoding.generateCodes(root,"",codeMap);
	    
	    double externalPathWeight=0;
	    
	    
	    for(Character c : codeMap.keySet()) {
	    	System.out.println(c+" : "+ codeMap.get(c));
	    	int index = findChar(charArray,c);
	    	if(index !=-1) {
	    		externalPathWeight+= (charfreq[index] * codeMap.get(c).length());
	    	}
	    }
	    
	    System.out.println(" The external path weight  : " + externalPathWeight);
	    
	    double charFreqSum=0;
	    for(int i : charfreq)
	    	charFreqSum=+i;
	    
	    System.out.println(" Average Code length : "+externalPathWeight/charFreqSum);
	    
	}

	private static int findChar(char[] charArray, Character c) {
		for(int i=0;i<charArray.length;i++)
		{
			if(charArray[i] == c)
				return i;
		}
			
		return -1;
	}
}

/*
OUTPUT:-

JRE Oracle Corporation/13 is not supported, advanced source lookup disabled.
a : 1100
b : 1101
c : 100
d : 101
e : 111
f : 0
The external path weight  : 224.0
Average Code length : 4.977777777777778


*/
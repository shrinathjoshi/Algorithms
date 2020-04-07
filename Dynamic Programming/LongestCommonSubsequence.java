import java.util.Collections;

/*
 * @author Shrinath Joshi
 * 
 * LCS is an standard problem of the type Dynamic Programming
 * 
 *  The Relation 
 *  
 *  c[i][j] =  1 + c[i-1][j-1] if(x[i] == x[j])
 *  		= Math.max(c[i-1][j],c[i][j-1])
 *  
 * 
 */


abstract class LongestCommonSubsequenceStrategy{
	public abstract int lcs(String x,String y);
}

class BottomUpDynamicProgramming extends LongestCommonSubsequenceStrategy{

	@Override
	public int lcs(String x, String y) {
		System.out.print("\n Using Bottom Up Approach ");
		return  lcsUsingBottomUpStrategy(x,y);
	}
	
	private static int lcsUsingBottomUpStrategy(String x, String y) {

		int n = x.length();
		int m = y.length();
		
		int c[][] = new int[n+1][m+1];
		
		for(int i =0;i<n;i++)
			c[i][0]=0;
		
		for(int i=0;i<m;i++)
			c[0][i]=0;
		
		for(int i = 0 ;i<n;i++) {
			for(int j = 0 ;j<m;j++) {
				
				if(x.charAt(i) == y.charAt(j)) 
					c[i+1][j+1] = 1+c[i][j];
				else
					c[i+1][j+1] = Math.max(c[i][j+1],c[i+1][j]);
			}
		}
		
		return c[n][m];
	}
	
}

class TopDownDynamicProgramming extends LongestCommonSubsequenceStrategy{

	int	cache[][] ;
	
	@Override
	public int lcs(String x, String y) {
		System.out.print("\n Using Top Down Approach ");
		return	lcsUsingTopDownApproach(x,y);		
	}
	
	private  int lcsUsingTopDownApproach(String x, String y) {
		cache= new int[x.length()][y.length()];
		return LcsRecursive(x,y,x.length()-1,y.length()-1);
	}

	private  int LcsRecursive(String x, String y, int xIndex, int yIndex) {
		
		if(xIndex<0 || yIndex <0)
			return 0;
		
		if(cache[xIndex][yIndex]!=0)
			return cache[xIndex][yIndex];
		
		int result=0;
		if(x.charAt(xIndex) == y.charAt(yIndex))
			result = 1+ LcsRecursive(x, y, xIndex-1, yIndex-1);
		else
			result= Math.max(LcsRecursive(x, y, xIndex-1, yIndex), LcsRecursive(x, y, xIndex, yIndex-1));
			
		cache[xIndex][yIndex] = result;
		return result;
	}



}

public class LongestCommonSubsequence {
	
	private LongestCommonSubsequenceStrategy dynamicProgrammingStrategy;
	

	public LongestCommonSubsequenceStrategy getDynamicProgrammingStrategy() {
		return dynamicProgrammingStrategy;
	}

	public void setDynamicProgrammingStrategy(LongestCommonSubsequenceStrategy dynamicProgrammingStrategy) {
		this.dynamicProgrammingStrategy = dynamicProgrammingStrategy;
	}
	
	public  int  getLongestCommonSubsequence(String x, String y) {
		return dynamicProgrammingStrategy.lcs(x, y);
	}

}

class LongestCommonSubsequenceDemo{
	
	public static void main(String[] args) {
		
		String x = "AABCB";
		String y = "ACB";
		
		LongestCommonSubsequence lcsCommonSubsequence = new LongestCommonSubsequence();
		lcsCommonSubsequence.setDynamicProgrammingStrategy(new BottomUpDynamicProgramming()); 
		
		LongestCommonSubsequence lcsCommonSubsequence1= new LongestCommonSubsequence();
		lcsCommonSubsequence1.setDynamicProgrammingStrategy(new TopDownDynamicProgramming());
		
		System.out.print(lcsCommonSubsequence.getLongestCommonSubsequence(x, y));
		System.out.print(lcsCommonSubsequence1.getLongestCommonSubsequence(x, y));
		
	}

}

/*
OUTOUT:-

 Using Bottom Up Approach 3
 Using Top Down Approach 3
 */



public class SubsetSum {
	private int set[];
	private int sum;

	public SubsetSum(int[] set, int sum) {
		this.set=set;
		this.sum=sum;
	}

	public boolean isSubsetSum() {
		
		if(Math.random()>0.5)
			return isSubsetSumUsingTopDownApproch();
		else
			return isSubsetSumUsingBottomUpApproach();
	}

	private boolean isSubsetSumUsingBottomUpApproach() {
		return SOS(sum,set.length-1);
	}

	private boolean SOS(int sum, int n) {
		
		boolean dp[][]= new boolean[sum+1][n+1];
		
		for(int j=0;j<n+1;j++)
				dp[0][j]=true;
		
		for(int i=1;i<sum+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(set[j]<=i)
					dp[i][j]=dp[i-set[j]][j-1]||dp[i][j-1];
				else
					dp[i][j]=dp[i][j-1];
			}
		}
			
		return dp[sum][n];
	}

	private boolean isSubsetSumUsingTopDownApproch() {
		return sumOfSubset(sum,set.length-1);
	}

	private boolean sumOfSubset(int sum, int n) {
		
		//Base Condition		
		if(n == 0 && sum != 0)
			return false;
		
		if(sum==0)
			return true;
		
		if(set[n]>sum)
			return sumOfSubset(sum, n-1);
		else
			return sumOfSubset(sum - set[n], n-1) || sumOfSubset(sum, n-1);
	}

	
}

class SubsetSumDemo {

	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 7;
		SubsetSum subsetSum = new SubsetSum(set,sum);
		if (subsetSum.isSubsetSum() == true)
			System.out.println("Found a subset" + " with given sum");
		else
			System.out.println("No subset with" + " given sum");
	}
}



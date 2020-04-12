
public class UnionFind {

		private int[] parent;  // parent[i] = parent of i
		private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
		private int count;     // number of components
		

		public  UnionFind(int n) {
		    if (n < 0) throw new IllegalArgumentException();
		    count = n;
		    parent = new int[n];
		    rank = new byte[n];
		    for (int i = 0; i < n; i++) {
		        parent[i] = i;
		        rank[i] = 0;
		    }
		}
		
		
		public int find(int p) {
		    validate(p);
		    while (p != parent[p]) {
		        parent[p] = parent[parent[p]];    // path compression by halving
		        p = parent[p];
		    }
		    return p;
		}
		
		
	    public int count() {
	        return count;
	    }
		  
		 
		public void union(int p, int q) {
		    int rootP = find(p);
		    int rootQ = find(q);
		    if (rootP == rootQ) return;
		
		    // make root of smaller rank point to root of larger rank
		    if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
		    else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
		    else {
		        parent[rootQ] = rootP;
		        rank[rootP]++;
		    }
		    count--;
		}
		
		// validate that p is a valid index
		private void validate(int p) {
		    int n = parent.length;
		    if (p < 0 || p >= n) {
		        throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));  
		    }
		}
	
}

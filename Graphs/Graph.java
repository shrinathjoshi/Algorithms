import java.util.LinkedList;

public class Graph {
	private int V;
	private int E;
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public Graph(int n) {
	
		if(n<0) throw new IllegalArgumentException("Number of vertices should be non- negative");
		
		this.V=n;
		adj=(LinkedList<Integer>[])new LinkedList[n];
		
		for(int i=0;i<n;i++)
			adj[i]=new LinkedList<Integer>();
	}
	
	public void addEdge(int u,int v) {
		validateVertex(u);
		validateVertex(v);
		E++;
		adj[u].add(v);
		
	}
	
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}
	
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}

	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	private void validateVertex(int v) {
		if(v<0||v>=V) throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	}
	
	
}

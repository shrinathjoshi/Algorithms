import java.util.LinkedList;

public class EdgeWeightedGraph {
	private int V;
	private int E;
	private LinkedList<Edge> adj[];
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int v) {
		super();
		this.V = v;
		this.E=0;
		adj=new LinkedList[v];
		
		for(int i=0;i<v;i++) {
			adj[i]= new LinkedList<Edge>();
		}
	}
	
	 public int V() {
	        return V;
	}

	    
	public int E() {
	    return E;
	}

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public Iterable<Edge> edges() {
        LinkedList<Edge> list = new LinkedList<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }
}

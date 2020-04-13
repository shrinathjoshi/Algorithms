import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Prims algorithm has a running time of O(ElogE)
 */

public class Prims {

	private boolean marked[];
	private Queue<Edge> mst;
	private double weight;
	private PriorityQueue<Edge> pq;
	public Prims(EdgeWeightedGraph g) {
		marked=new boolean[g.V()];
		pq=new PriorityQueue<Edge>();
		mst=new LinkedList<Edge>();
		
		for(int v=0;v<g.V();v++)
			prim(g,v);
	}
	
	
	private void prim(EdgeWeightedGraph g, int v) {
		scan(g,v);
		while(!pq.isEmpty() && mst.size()!=(g.V()-1)) {
			Edge e = pq.poll();
			int u = e.either();
			int w = e.other(u);
			
			if(marked[u]&&marked[w])
				continue;
			mst.add(e);
			weight+=e.weight();
			if(marked[u]) scan(g,w);
			if(marked[w]) scan(g,u);
		}
		
	}
	
	private void scan(EdgeWeightedGraph g, int v) {
		marked[v]=true;
		
		for(Edge u : g.adj(v)) {
			if(!marked[u.other(v)])
			{
				pq.add(u);
			}
		}
	}
	
	public double weight() {
		return this.weight;
	}
	
	public Iterable<Edge> mstList(){
		return this.mst;
	}
	
}

class MinimumSpanningTreeUsingPrimsAlgorithm{
	
	public static void main(String[] args) {
		
		int n =8;
		EdgeWeightedGraph G = new EdgeWeightedGraph(n);
		G.addEdge(new Edge(0,7,0.16000));
		G.addEdge(new Edge(2,3,0.17000));
		G.addEdge(new Edge(1,7,0.19000));
		G.addEdge(new Edge(0,2,0.26000));
		G.addEdge(new Edge(5,7,0.28000));
		G.addEdge(new Edge(4,5,0.35000));
		G.addEdge(new Edge(6,2,0.40000));
		
		Prims mst = new Prims(G);
		
		for (Edge e : mst.mstList()) {
            System.out.println(e);
        }
        System.out.printf("%.5f\n", mst.weight());
		
	}
}
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kruskal {

	private double weight;
	private Queue<Edge> mst = new LinkedList<Edge>();
	
	public  Kruskal(EdgeWeightedGraph g) {
		
		PriorityQueue<Edge> pq= new PriorityQueue<Edge>();
		for(Edge v : g.edges()) {
			pq.add(v);
		}
		
		UnionFind uf = new UnionFind(g.V());
		
		while(!pq.isEmpty()) {
			Edge e =pq.poll();
			int v = e.either();
			int u = e.other(v);
			
			if(uf.find(v)==uf.find(u)) continue;
			else {
				uf.union(v, u);
				mst.add(e);
				weight+=e.weight();
			}
				
		}
	}

	
	 public Iterable<Edge> edges() {
	        return mst;
	 }


	public double weight() {
		return this.weight;
	}

}

class MinimumSpanningTreeUsingKruskalImplementation{
	
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
		
		Kruskal mst = new Kruskal(G);
		
		for (Edge e : mst.edges()) {
            System.out.println(e);
        }
        System.out.printf("%.5f\n", mst.weight());
	}
}

/*
OUTPUT:-
 	
0-7 0.16000
2-3 0.17000
1-7 0.19000
0-2 0.26000
5-7 0.28000
4-5 0.35000
6-2 0.40000
1.81000

*/
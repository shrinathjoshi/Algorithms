import java.util.Iterator;
import java.util.LinkedList;
/*
 * @Author Shrinath Joshi
 * 
 * Time Complexity: O(V+E) , V is no of vertex and E is no of edges
 * Space Complexity : O(V)
 */

public class DepthFirstSearch {
	private Graph G;
	private boolean visited[];

	public DepthFirstSearch(Graph G,int s) {
		visited = new boolean[G.V()];
		setGraph(G);
		depthFirstSearch(s);
	}

	public Graph getGraph() {
		return G;
	}

	public void setGraph(Graph g) {
		this.G = g;
	}

	public void depthFirstSearch(int v) {
		visited[v]=true;
		System.out.print(v+" ");
		
		for(Integer n: G.adj(v)) {
			if(!visited[n]) {
				depthFirstSearch(n);
			}
		}
	}
	
	public static void main(String arg[]) {
		int n=6;
		int e=8;

		Graph graph = new Graph(n);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 0);
		graph.addEdge(1, 4);
		graph.addEdge(1, 3);
		graph.addEdge(2, 0);
		graph.addEdge(2, 4);
		graph.addEdge(3, 1);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 1);
		graph.addEdge(4, 5);
		graph.addEdge(4, 3);
		graph.addEdge(4, 2);
		graph.addEdge(5, 3);
		graph.addEdge(5, 4);
		
		new DepthFirstSearch(graph,1);
	}

}

/*
OUTPUT:-

1 0 2 4 3 5 

*/

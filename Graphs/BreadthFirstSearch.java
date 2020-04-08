import java.util.LinkedList;
/*
 * @Author Shrinath Joshi
 * 
 * Time Complexity: O(V+E) , V is no of vertex and E is no of edges
 * Space Complexity : O(V)
 */
import java.util.Queue;

public class BreadthFirstSearch {
	private Graph G;
	private boolean visited[];

	public BreadthFirstSearch(Graph G,int s) {
		visited = new boolean[G.V()];
		setGraph(G);
		breadthFirstSearch(s);
	}

	public Graph getGraph() {
		return G;
	}

	public void setGraph(Graph g) {
		this.G = g;
	}

	public void breadthFirstSearch(int v) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v]=true;
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			System.out.print(u+" ");
				
			for(Integer n: G.adj(u)) {
				if(!visited[n]) {
					queue.add(n);
					visited[n]=true;
				}
			}	
		}
	}
	
	public static void main(String arg[]) {
		int n=6;

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
		
		new BreadthFirstSearch(graph,0);
	}

}

/*
OUTPUT:-

0 1 2 4 3 5 
*/

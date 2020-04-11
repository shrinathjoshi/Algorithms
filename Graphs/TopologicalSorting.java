import java.util.Stack;

public class TopologicalSorting {
	
	private boolean marked[];
	private Stack<Integer> topologicalOrder;
	
	public TopologicalSorting(Graph graph) {
		marked= new boolean[graph.V()];
		topologicalOrder= new Stack<Integer>();
	}

	
	public boolean sort(Graph graph) {
		return Toposort(graph);
	}
	
	private boolean Toposort(Graph graph) {
		DirectedCycle checkCycle=new DirectedCycle(graph);
		if(!checkCycle.containsCycle())
		{
			for(int i =0;i<graph.V();i++) {
				if(!marked[i])
					dfs(graph,i);
			}
		}
		else {

			System.out.println("Topological Sort cannot be applied in Cyclic graph");
			return false;
		}
		return true;
	}

	private void dfs(Graph graph, int v) {
		marked[v]=true;
		
		for(int w:graph.adj(v)) {
			if(!marked[w]) {
				dfs(graph, w);
			}
		}
		topologicalOrder.add(v);
	}

	public Iterable<Integer> getOrder() {
		return topologicalOrder;
	}
}

class TopologicalSortingDemo{
	public static void main(String[] args) {
		
		int n=6;
		
		Graph graph = new Graph(n);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 4);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		
		TopologicalSorting topologicalSorting = new TopologicalSorting(graph);
		if(topologicalSorting.sort(graph)) {
			for(int i:topologicalSorting.getOrder())
				System.out.print(i+" ");
		}
	
	}
}

/*
OUTPUT:-
5 4 3 1 2 0 
*/
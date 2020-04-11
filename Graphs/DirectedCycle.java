import java.util.Stack;

public class DirectedCycle {
	
	private boolean marked[];
	private int edgeTo[];
	private Stack<Integer> cycle;
	private boolean[] onStack;
	public DirectedCycle(Graph graph) {
		marked= new boolean[graph.V()];
		edgeTo= new int[graph.V()];
		onStack=new boolean[graph.V()];
		hasCycle(graph);
		
	}
	public void hasCycle(Graph graph) {

		for(int i = 0;i<graph.V();i++) {
			if(!marked[i] && cycle==null)
				dfs(graph,i);
		}
	}
	private void dfs(Graph graph, int v) {
	
		marked[v]=true;
		onStack[v]=true;
		
		for(int w:graph.adj(v)) {
			
			if(cycle!=null) return;
			
			if(!marked[w]) {
				edgeTo[w]=v;
				dfs(graph, w);
			}
			else if(onStack[w]) {
				cycle= new Stack<Integer>();
				for(int i=v;i!=w;i=edgeTo[i]) {
					cycle.push(i);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v]=false;
	}
	public boolean containsCycle() {
		return cycle!=null;
	}
	public Iterable<Integer> getCycleList() {
		return cycle;
	}

}

class DirectedCycleDemo{
	
	public static void main(String[] args) {
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
		
		DirectedCycle directedCycle=new DirectedCycle(graph);
		
		if(directedCycle.containsCycle()) {
			System.out.print("Directed Cycle ");
			for(int i:directedCycle.getCycleList()) {
				System.out.print(i+" ");
			}
			System.out.println();
		}else
			System.out.println("No Directed Cycle");
	}
}

/*
OUTPUT:-
Directed Cycle 1 0 1 

*/

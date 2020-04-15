package com.interview.graph.maxflow;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
	private final int V; 
	private boolean[] marked;
	private FlowEdge[] edgeTo; 
	private double value;
	
	public FordFulkerson(FlowNetwork G, int s, int t) {
		V=G.V();
		value=0;
		while(hasAugmentingPath(G,s,t)) {
			double bottle = Double.POSITIVE_INFINITY;
			
			for(int v=t;v!=s;v=edgeTo[v].other(v))
				bottle=Math.min(bottle, edgeTo[v].residualCapacityTo(v));
		
			for(int v=t;v!=s;v=edgeTo[v].other(v))
				edgeTo[v].addResidualFlowTo(v, bottle);
			
			value+=bottle;
		}
		
	}

	private boolean hasAugmentingPath(FlowNetwork g, int s, int t) {
		
		edgeTo=new FlowEdge[g.V()];
		marked=new boolean[g.V()];
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		marked[s]=true;
		
		while(!q.isEmpty()) {
			int v=q.poll();
			
			for(FlowEdge e: g.adj(v)) {
				int w = e.other(v);
				
				if(e.residualCapacityTo(w)>0 && !marked[w]) {
					edgeTo[w]=e;
					marked[w]=true;
					q.add(w);
				}
						
			}
		}
		
		return marked[t];
		
	}
	
	public boolean inCut(int v)  {
		return marked[v];
	}
	
	public double value() {
		return value;
	}
}

class FordFulkersonDemo {
	
	
	public static void main(String[] args) {
		
		int V = 6;
		int s = 0, t = V - 1;
		FlowNetwork G = new FlowNetwork(V);
		G.addEdge(new FlowEdge(0,1,11));
		G.addEdge(new FlowEdge(0,2,12));
		G.addEdge(new FlowEdge(2,1,1));
		G.addEdge(new FlowEdge(1,3,12));
		G.addEdge(new FlowEdge(2,4,11));
		G.addEdge(new FlowEdge(4,3,7));
		G.addEdge(new FlowEdge(3,5,19));
		G.addEdge(new FlowEdge(4,5,5));
		
		
		System.out.println(G);

		// compute maximum flow and minimum cut
		FordFulkerson maxflow = new FordFulkerson(G, s, t);
		System.out.println("Max flow from " + s + " to " + t);
		for (int v = 0; v < G.V(); v++) {
			for (FlowEdge e : G.adj(v)) {
				if ((v == e.from()) && e.flow() > 0)
					System.out.println("   " + e);
			}
		}

		// print min-cut
		System.out.print("Min cut: ");
		for (int v = 0; v < G.V(); v++) {
			if (maxflow.inCut(v))
				System.out.print(v + " ");
		}
		System.out.println();

		System.out.println("Max flow value = " + maxflow.value());
		
	}
}

/*
OUTPUT:-

com.interview.graph.maxflow.FlowNetwork@7b69c6ba
Max flow from 0 to 5
   0->1 11.0/11.0
   0->2 12.0/12.0
   1->3 12.0/12.0
   2->1 1.0/1.0
   2->4 11.0/11.0
   3->5 18.0/19.0
   4->3 6.0/7.0
   4->5 5.0/5.0
Min cut: 0 
Max flow value = 23.0
*/

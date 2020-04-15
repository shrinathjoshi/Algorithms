package com.interview.graph.maxflow;

import java.util.LinkedList;

public class FlowNetwork {
	 private final int V;
	 private int E;
	 private LinkedList<FlowEdge>[] adj;
	 
	 @SuppressWarnings("unchecked")
	public FlowNetwork(int V) {
	        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Graph must be nonnegative");
	        this.V = V;
	        this.E = 0;
	        adj =  new LinkedList[V];
	        for (int v = 0; v < V; v++)
	            adj[v] = new LinkedList<FlowEdge>();
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
	
	public void addEdge(FlowEdge e) {
	    int v = e.from();
	    int w = e.to();
	    validateVertex(v);
	    validateVertex(w);
	    adj[v].add(e);
	    adj[w].add(e);
	    E++;
	}
	
	public Iterable<FlowEdge> adj(int v) {
	    validateVertex(v);
	    return adj[v];
	}
	
	public Iterable<FlowEdge> edges() {
	    LinkedList<FlowEdge> list = new LinkedList<FlowEdge>();
	    for (int v = 0; v < V; v++)
	        for (FlowEdge e : adj(v)) {
	            if (e.to() != v)
	                list.add(e);
	        }
	    return list;
	}

}

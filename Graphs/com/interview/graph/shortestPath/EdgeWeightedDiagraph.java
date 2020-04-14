package com.interview.graph.shortestPath;

import java.util.LinkedList;

public class EdgeWeightedDiagraph {
	private final int V;
	private int E;
	private LinkedList<DirectedEdge> adj[];

	@SuppressWarnings("unchecked")
	public EdgeWeightedDiagraph(int v) {
		
		this.V=v;
		this.E=0;
		adj=new LinkedList[v];
		
		for(int i=0;i<v;i++)
			adj[i]=new LinkedList<DirectedEdge>();
	}
	
	
	public void addEdge(DirectedEdge e) {
		int v=e.from();
		adj[v].add(e);
	}
	
	public Iterable<DirectedEdge> adj(int v){
		return adj[v];	
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
}

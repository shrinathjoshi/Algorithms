package com.interview.graph.shortestPath;

public class DirectedEdge {
	private int v;
	private int u;
	private double weight;

	public DirectedEdge(int v, int u, double weight) {
		if (v < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (u < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");

		this.v = v;
		this.u = u;
		this.weight = weight;
	}
	
	public int from() {
		return v;
	}
	
	public int to() {
		return u;
	}
	
	public double weight() {
		return weight;
	}
	
	 public String toString() {
	        return v + "->" + u + " " + String.format("%5.2f", weight);
	    }
}

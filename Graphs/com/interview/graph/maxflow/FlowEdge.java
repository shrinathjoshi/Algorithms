package com.interview.graph.maxflow;

public class FlowEdge {
    private final int v;             // from
    private final int w;             // to 
    private final double capacity;   // capacity
    private double flow;             //flow
    
    public FlowEdge(int v, int w, double capacity) {
        if (v < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
        if (w < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
        if (!(capacity >= 0.0)) throw new IllegalArgumentException("Edge capacity must be non-negative");
        this.v         = v;
        this.w         = w;  
        this.capacity  = capacity;
        this.flow      = 0.0;
    }
    
    public int from() {
        return v;
    }  

    public int to() {
        return w;
    }  

    public double capacity() {
        return capacity;
    }

    public double flow() {
        return flow;
    }

    public int other(int vertex) {
        if      (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("invalid endpoint");
    }
    
    public double residualCapacityTo(int vertex) {
    	if(vertex == v) return flow;
    	else if(vertex == w) return capacity-flow;
    	else throw new IllegalArgumentException("invalid endpoint");
    		
    }
    
    public void addResidualFlowTo(int vertex ,  double delta) {
    	  if (!(delta >= 0.0)) throw new IllegalArgumentException("Delta must be nonnegative");
    	  
    	if(vertex == v) flow-=delta;
      	else if(vertex == w) flow+=delta;
      	else throw new IllegalArgumentException("invalid endpoint");
    }
    
    public String toString() {
        return v + "->" + w + " " + flow + "/" + capacity;
    }
    
}

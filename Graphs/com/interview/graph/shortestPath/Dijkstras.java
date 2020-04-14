package com.interview.graph.shortestPath;


import java.util.PriorityQueue;
import java.util.Stack;

import com.interview.graph.shortestPath.DirectedEdge;
import com.interview.graph.shortestPath.EdgeWeightedDiagraph;

public class Dijkstras {

	private DirectedEdge edgeTo[];
	private double distTo[];
	private PriorityQueue<Node> pq;
	
	public Dijkstras(EdgeWeightedDiagraph g,int s) {
		edgeTo= new DirectedEdge[g.V()];	
		distTo=new double[g.V()];
		pq=new PriorityQueue<Node>();
		
		for(int i=0;i<g.V();i++) {
			if(s!=i)
				distTo[i]=Double.POSITIVE_INFINITY;
		}
		
		pq.add(new Node(s,distTo[s]));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			for(DirectedEdge e : g.adj(node.n)) {
				relax(e);
			}
		}
	}

	private void relax(DirectedEdge e) {
		int v=e.from();int u=e.to();
		
		if(distTo[u]>distTo[v]+e.weight()) {
			distTo[u]=distTo[v]+e.weight();
			edgeTo[u]=e;
			pq.add(new Node(u,distTo[u]));
		}
	}
	
	 public double distTo(int v) {
	        validateVertex(v);
	        return distTo[v];
	    }

	 public boolean hasPathTo(int v) {
	        validateVertex(v);
	        return distTo[v] < Double.POSITIVE_INFINITY;
	    }
	 
	 private void validateVertex(int v) {
	        int V = distTo.length;
	        if (v < 0 || v >= V)
	            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
	    }
	 
	 public Iterable<DirectedEdge> pathTo(int v) {
	        validateVertex(v);
	        if (!hasPathTo(v)) return null;
	        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
	        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
	            path.push(e);
	        }
	        return path;
	    }
	
}

class Node implements Comparable<Node>{
	public Node(int s, double d) {
		this.distance=d;
		this.n=s;
	}
	public int n;
	public double distance;
	public int compareTo(Node o) {
		return Integer.compare(this.n, o.n);
	}
}

class DijkstrasShortestPathDemo{
	
	public static void main(String[] args) {
		
		int in = 8;
		EdgeWeightedDiagraph G = new EdgeWeightedDiagraph(in);
        
		G.addEdge(new DirectedEdge(4,5, 0.35));
		G.addEdge(new DirectedEdge(5,4, 0.35));
		G.addEdge(new DirectedEdge(4,7, 0.37));
		G.addEdge(new DirectedEdge(5,7, 0.28));
		G.addEdge(new DirectedEdge(7,5, 0.28));
		G.addEdge(new DirectedEdge(5,1, 0.32));
		G.addEdge(new DirectedEdge(0,4, 0.38));
		G.addEdge(new DirectedEdge(0,2, 0.26));
		G.addEdge(new DirectedEdge(7,3, 0.39));
		G.addEdge(new DirectedEdge(1,3, 0.29));
		G.addEdge(new DirectedEdge(2,7, 0.34));
		G.addEdge(new DirectedEdge(6,2, 0.40));
		G.addEdge(new DirectedEdge(3,6, 0.52));
		G.addEdge(new DirectedEdge(6,2, 0.40));
		G.addEdge(new DirectedEdge(6,0,0.58));
		G.addEdge(new DirectedEdge(6,4, 0.93));
			
		int s =0;

        // compute shortest paths
        Dijkstras sp = new Dijkstras(G, s);


        // print shortest path
        for (int t = 0; t < G.V(); t++) {
            if (sp.hasPathTo(t)) {
                System.out.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
                for (DirectedEdge e : sp.pathTo(t)) {
                	System.out.print(e + "   ");
                }
                System.out.println();
            }
            else {
            	System.out.printf("%d to %d         no path\n", s, t);
            }
        }
	}
}


/*
OUTPUT:-

0 to 0 (0.00)  
0 to 1 (1.05)  5->1  0.32   4->5  0.35   0->4  0.38   
0 to 2 (0.26)  0->2  0.26   
0 to 3 (0.99)  7->3  0.39   2->7  0.34   0->2  0.26   
0 to 4 (0.38)  0->4  0.38   
0 to 5 (0.73)  4->5  0.35   0->4  0.38   
0 to 6 (1.51)  3->6  0.52   7->3  0.39   2->7  0.34   0->2  0.26   
0 to 7 (0.60)  2->7  0.34   0->2  0.26   


*/

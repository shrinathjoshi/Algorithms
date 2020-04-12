
public class Edge implements Comparable<Edge> {

	private int v;
	private int u;
	private double weight;
	
	public Edge(int v, int u, double weight) {
		if(v<0) throw new IllegalArgumentException("Vertex index must be nonnegative integer");
		if(u<0) throw new IllegalArgumentException("Vertex index must be nonnegative integer");
		if(Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NAN");
	
		this.v = v;
		this.u = u;
		this.weight = weight;
	}

	public double weight() {
		return weight;
	}

	public int either() {
		return v;
	}
	
	public int other(int vertex) {
		if(vertex == v) return u;
		if(vertex == u) return v;
		else throw new IllegalArgumentException("Illegal endpoint");
			
	}
	

	public int compareTo(Edge that) {
		return Double.compare(this.weight,that.weight);
	}
	
	 public String toString() {
	        return String.format("%d-%d %.5f", v, u, weight);
	 }

}

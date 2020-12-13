package io.github.timal6ert5.intarray;

public interface GraphDetails {

	public boolean isDirected();

	public boolean isWeighted();

	/**
	 * Graph Order is defined as the number of vertices.
	 * 
	 * @return number of vertices in the graph
	 */
	public int getGraphOrder();

	/**
	 * Graph Size is defined as the number of edges.
	 * 
	 * @return number of edges in the graph
	 */
	public int getGraphSize();

	/**
	 * Determine if the given graph is a 'Simple' graph. The required properties are
	 * no loops and no multiple edges.
	 * 
	 * @return true if the graph is simple
	 */
	public boolean isSimple();

	/**
	 * Graph loops occur when a vertex is connected to itself.
	 * 
	 * @return true if the graph has loops
	 */
	public boolean hasLoops();

	/**
	 * Multiple edges means there exist at least two vertices that have more than
	 * one edge between them.
	 * 
	 * @return true if the graph has multiple edges
	 */
	public boolean hasMultipleEdges();

	/**
	 * A simple graph with an edge between every pair of vertices. Alternatively, if
	 * the graph is simple and connected, then the number of edges will be equal to:
	 * |E| = nC2
	 * 
	 * @return true if the graph is connected
	 */
	public boolean isConnected();

	/**
	 * An empty graph has no edges.
	 */
	public boolean isEmpty();
}

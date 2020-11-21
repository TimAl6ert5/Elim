package io.github.timal6ert5.intarray;

import java.util.HashSet;

/**
 * Simple interpretation of an Edge List graph representation. Edge list is a
 * list of vertex connections and an optional third value that represents the
 * edge weight.
 * 
 * This is undirected
 */
public class EdgeListGraph extends AbstractIntArrayGraph {

	private static final String ERROR_NULL_OR_EMPTY = "Edge List cannot be null or empty";
	private static final String ERROR_INVALID_ENTRY = "Edge List entries must have 2 edge values and optional 3 value for weight";
	private boolean isWeighted;

	public EdgeListGraph(int[][] graph) {
		// Validate the matrix is not null, not empty
		if (graph == null || graph.length == 0) {
			throw new IllegalArgumentException(ERROR_NULL_OR_EMPTY);
		}
		// Validate the graph format and capture basic properties
		switch (graph[0].length) {
		case 3:
			isWeighted = true;
			break;
		case 2:
			isWeighted = false;
			break;
		default:
			throw new IllegalArgumentException(ERROR_INVALID_ENTRY);
		}
		for (int i = 1; i < graph.length; i++) {
			if (isWeighted) {
				if (graph[i].length != 3) {
					throw new IllegalArgumentException(ERROR_INVALID_ENTRY);
				}
			} else {
				if (graph[i].length != 2) {
					throw new IllegalArgumentException(ERROR_INVALID_ENTRY);
				}
			}
		}
		this.graph = graph;
	}

	@Override
	public boolean isDirected() {
		return false;
	}

	@Override
	public boolean isWeighted() {
		return isWeighted;
	}

	/**
	 * Graph Order for Edge List requires counting the unique vertex values.
	 */
	@Override
	public int getGraphOrder() {
		HashSet<Integer> vertices = new HashSet<>();
		for (int i = 0; i < graph.length; i++) {
			vertices.add(graph[i][0]);
			vertices.add(graph[i][1]);
		}
		return vertices.size();
	}

	/**
	 * Graph Size for Edge List is the number of entries
	 */
	@Override
	public int getGraphSize() {
		return graph.length;
	}

	@Override
	public boolean isSimple() {
		return !(hasLoops() || hasMultipleEdges());
	}

	/**
	 * Loops in an edge list can be identified by any edge representing nodes are
	 * the same value.
	 */
	@Override
	public boolean hasLoops() {
		for (int i = 0; i < graph.length; i++) {
			if (graph[i][0] == graph[i][1]) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasMultipleEdges() {
		EdgeEntry edge, edgeR;
		HashSet<EdgeEntry> edgeSet = new HashSet<>();
		for (int i = 0; i < graph.length; i++) {
			edge = new EdgeEntry(graph[i][0], graph[i][1]);
			edgeR = new EdgeEntry(graph[i][1], graph[i][0]);
			if (edgeSet.contains(edge) || edgeSet.contains(edgeR)) {
				return true;
			} else {
				edgeSet.add(edge);
			}
		}
		return false;
	}

}

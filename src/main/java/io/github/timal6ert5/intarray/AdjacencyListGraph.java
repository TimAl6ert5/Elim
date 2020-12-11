package io.github.timal6ert5.intarray;

import java.util.HashSet;

/**
 * Simple interpretations of an Adjacency List graph representation.
 *
 * This is a undirected, non-weighted model.
 */
public class AdjacencyListGraph extends AbstractIntArrayGraph {

	private static final String ERROR_NULL_OR_EMPTY = "Adjacency List cannot be null or empty";

	public AdjacencyListGraph(int[][] graph) {
		// Validate the matrix is not null, not empty
		if (graph == null || graph.length == 0) {
			throw new IllegalArgumentException(ERROR_NULL_OR_EMPTY);
		}
		this.graph = graph;
	}

	@Override
	public boolean isDirected() {
		return false;
	}

	@Override
	public boolean isWeighted() {
		return false;
	}

	/**
	 * Graph Order for Adjacency List is determined by the size of the array
	 */
	@Override
	public int getGraphOrder() {
		return graph.length;
	}

	/**
	 * Graph Size for Adjaceny List is determined by
	 * 
	 * Note that any edge connecting vertex v1 and v2 will have 2 entries in the
	 * adjacency list. one for (v1, v2) and one for (v2, v1). This is not 2 edges,
	 * it is the same edge from different vertex perspective. Multiple edges would
	 * duplicate this.
	 */
	@Override
	public int getGraphSize() {
		int size = 0;
		for (int i = 0; i < graph.length; i++) {
			size += graph[i].length;
		}
		return size / 2;
	}

	@Override
	public boolean isSimple() {
		return !(hasLoops() || hasMultipleEdges());
	}

	/**
	 * Loops in an adjacency list can be identified by checking for matches between
	 */
	@Override
	public boolean hasLoops() {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (i == graph[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Multiple edges in adjacency list are represented by the same value found more
	 * than once in an edge list.
	 */
	@Override
	public boolean hasMultipleEdges() {
		for (int i = 0; i < graph.length; i++) {
			if (graph[i].length > 1) {
				HashSet<Integer> edges = new HashSet<>();
				for (int j = 0; j < graph[i].length; j++) {
					if (!edges.add(graph[i][j])) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Connected graph in adjaceny list has 'order - 1' elements in each list, and
	 * is simple.
	 * 
	 * This implementation is grossly inefficient, but should be accurate. TODO:
	 * refactor to a single pass
	 */
	@Override
	public boolean isConnected() {
		if (!isSimple()) {
			return false;
		}
		// each row in the adjacency list must be size order - 1
		int order_m1 = getGraphOrder() - 1;
		for (int i = 0; i < graph.length; i++) {
			if (graph[i].length != order_m1) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return getGraphSize() == 0;
	}
}

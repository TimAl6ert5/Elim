package io.github.timal6ert5.intarray;

/**
 * Simple interpretations of an Adjacency Matrix graph representation. Adjacency
 * Matrix is a VxV square matrix where any value greather than 0 represents the
 * number of edge between vertices indexed by (row, column).
 * 
 * This is a undirected, non-weighted model.
 */
public class AdjacencyMatrixGraph extends AbstractIntArrayGraph {

	private static final String ERROR_NULL_OR_EMPTY = "Adjacency Matrix cannot be null or empty";
	private static final String ERROR_SQUARE = "Adjacency Matrix must be square";
	private static final String ERROR_NEGATIVE_EDGE = "Adjacency Matrix cannot have negative edges";

	public AdjacencyMatrixGraph(int[][] graph) {
		// Validate the matrix is not null, not empty
		if (graph == null || graph.length == 0) {
			throw new IllegalArgumentException(ERROR_NULL_OR_EMPTY);
		}
		// Validate the matrix is square
		for (int i = 0; i < graph.length; i++) {
			if (graph[i].length != graph.length) {
				throw new IllegalArgumentException(ERROR_SQUARE);
			}
			// Validate all values are > 0 (this supports multiple edges interpretation)
			for (int j = 0; j < graph[i].length; j++) {
				if (graph[i][j] < 0) {
					throw new IllegalArgumentException(ERROR_NEGATIVE_EDGE);
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
		return false;
	}

	/**
	 * Graph Order for adjacency matrix is determined by the size of the array(s).
	 */
	@Override
	public int getGraphOrder() {
		return graph.length;
	}

	/**
	 * Graph Size for adjacency matrix that is not directed or weighted should count
	 * the number of non-zero row/col values on the upper or lower triangle.
	 */
	@Override
	public int getGraphSize() {
		int size = 0;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (graph[i][j] > 0) {
					size += graph[i][j];
				}
			}
		}
		return size;
	}

	@Override
	public boolean isSimple() {
		return !(hasLoops() || hasMultipleEdges());
	}

	/**
	 * Loops in an adjacency matrix can be identified by any value on the matrix
	 * diagonal that is non-zero.
	 */
	@Override
	public boolean hasLoops() {
		for (int i = 0; i < graph.length; i++) {
			if (graph[i][i] != 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Multiple edges in this form of adjacency matrix are represented by any (row,
	 * column) value that is greater than 1.
	 */
	@Override
	public boolean hasMultipleEdges() {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (graph[i][j] > 1) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * A connected graph in an adjacency matrix is identified by all 1 values
	 * in the matrix, except for all 0 values on the diagonal.
	 */
	@Override
	public boolean isConnected() {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (i == j) {
					if (graph[i][j] != 0) {
						return false;
					}
				} else {
					if (graph[i][j] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

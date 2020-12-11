package io.github.timal6ert5;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.github.timal6ert5.intarray.AdjacencyListGraph;
import io.github.timal6ert5.intarray.AdjacencyMatrixGraph;
import io.github.timal6ert5.intarray.EdgeListGraph;
import io.github.timal6ert5.intarray.GraphDetails;
import io.github.timal6ert5.serialize.GraphLoader;

public class GraphsApp {

	public enum GRAPHTYPE {
		ADJACENCY_LIST, ADJACENCY_MATRIX, EDGE_LIST
	}

	public static void showUsage() {
		StringBuilder buf = new StringBuilder("Usage: java GraphsApp.jar FILE TYPE\n")
				.append("\tFILE - a file containing valid JSON graph representation\n")
				.append("\tTYPE - one of the supported graph representations: ").append(GRAPHTYPE.ADJACENCY_LIST)
				.append(" ").append(GRAPHTYPE.ADJACENCY_MATRIX).append(" ").append(GRAPHTYPE.EDGE_LIST);
		System.out.println(buf.toString());
	}

	public static void main(String[] args) {
		// validate arguments
		if (args.length != 2) {
			showUsage();
			return;
		}

		// Check file exists, is readable
		Path graphFile = Paths.get(args[0]);
		if (!Files.exists(graphFile) || !Files.isReadable(graphFile)) {
			System.out.println("Error: File does not exist or is not readable.");
			showUsage();
			return;
		}

		GRAPHTYPE graphType;
		try {
			graphType = GRAPHTYPE.valueOf(args[1]);
		} catch (Exception e) {
			System.out.println("Error: Invalid graph type.");
			showUsage();
			return;
		}

		GraphsApp app = new GraphsApp();
		app.run(graphFile, graphType);
	}

	public void run(Path graphFile, GRAPHTYPE graphType) {
		try {
			reportGraphDetails(getGraphDetails(graphFile, graphType));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return;
	}

	public GraphDetails getGraphDetails(Path graphFile, GRAPHTYPE graphType) throws Exception {
		GraphLoader gl = new GraphLoader();
		switch (graphType) {
		case ADJACENCY_LIST:
			return new AdjacencyListGraph(gl.load(graphFile));
		case ADJACENCY_MATRIX:
			return new AdjacencyMatrixGraph(gl.load(graphFile));
		case EDGE_LIST:
			return new EdgeListGraph(gl.load(graphFile));
		default:
			throw new Exception("Unhandled graph type.");
		}
	}

	public void reportGraphDetails(GraphDetails graphDetails) {
		StringBuilder buf = new StringBuilder();

		buf.append("Directed: ").append(graphDetails.isDirected()).append("\n");
		buf.append("Weighted: ").append(graphDetails.isWeighted()).append("\n");
		buf.append("Has Loops: ").append(graphDetails.hasLoops()).append("\n");
		buf.append("Has Multiple Edges: ").append(graphDetails.hasMultipleEdges()).append("\n");
		buf.append("Simple: ").append(graphDetails.isSimple()).append("\n");
		buf.append("Complete: " ).append(graphDetails.isConnected()).append("\n");

		System.out.println(buf.toString());
	}
}

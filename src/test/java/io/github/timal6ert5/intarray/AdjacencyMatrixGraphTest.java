package io.github.timal6ert5.intarray;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdjacencyMatrixGraphTest extends AbstractIntArrayGraphTest {

	@DataProvider(name = "hasLoopsData")
	public static Object[][] hasLoopsData() {
		return new Object[][] { { "adjacencymatrix/test_hasloops.json", true },
				{ "adjacencymatrix/konigsberg.json", false }, { "adjacencymatrix/khanacademy.json", false },
				{ "adjacencymatrix/Herke03a.json", false }, { "adjacencymatrix/disconnected.json", false },
				{ "adjacencymatrix/connected_k4.json", false } };
	}

	@Test(dataProvider = "hasLoopsData")
	public void testHasLoops(String graphFile, boolean expected) throws IOException {
		AdjacencyMatrixGraph testGraph = new AdjacencyMatrixGraph(loadGraphFromResource(graphFile));
		boolean actual = testGraph.hasLoops();
		Assert.assertEquals(actual, expected);
	}

	@DataProvider(name = "orderAndSizeData")
	public static Object[][] orderAndSizeData() {
		return new Object[][] { { "adjacencymatrix/konigsberg.json", 4, 7 },
				{ "adjacencymatrix/khanacademy.json", 10, 15 }, { "adjacencymatrix/Herke03a.json", 5, 5 },
				{ "adjacencymatrix/disconnected.json", 3, 1 }, { "adjacencymatrix/connected_k4.json", 4, 6 } };
	}

	@Test(dataProvider = "orderAndSizeData")
	public void testOrderAndSize(String graphFile, int expectedOrder, int expectedSize) throws IOException {
		AdjacencyMatrixGraph testGraph = new AdjacencyMatrixGraph(loadGraphFromResource(graphFile));
		int actualOrder = testGraph.getGraphOrder();
		int actualSize = testGraph.getGraphSize();

		Assert.assertEquals(actualOrder, expectedOrder);
		Assert.assertEquals(actualSize, expectedSize);
	}

	@DataProvider(name = "hasMultipleEdgesData")
	public static Object[][] hasMultipleEdgesData() {
		return new Object[][] { { "adjacencymatrix/konigsberg.json", true },
				{ "adjacencymatrix/khanacademy.json", false }, { "adjacencymatrix/Herke03a.json", false },
				{ "adjacencymatrix/disconnected.json", false }, { "adjacencymatrix/connected_k4.json", false } };
	}

	@Test(dataProvider = "hasMultipleEdgesData")
	public void testHasMultipleEdges(String graphFile, boolean expectedHasMultipleEdges) throws IOException {
		AdjacencyMatrixGraph testGraph = new AdjacencyMatrixGraph(loadGraphFromResource(graphFile));
		boolean actualHasMultipleEdges = testGraph.hasMultipleEdges();

		Assert.assertEquals(actualHasMultipleEdges, expectedHasMultipleEdges);
	}

	@DataProvider(name = "isSimpleData")
	public static Object[][] isSimpleData() {
		return new Object[][] { { "adjacencymatrix/konigsberg.json", false },
				{ "adjacencymatrix/khanacademy.json", true }, { "adjacencymatrix/Herke03a.json", true },
				{ "adjacencymatrix/disconnected.json", true }, { "adjacencymatrix/connected_k4.json", true } };
	}

	@Test(dataProvider = "isSimpleData")
	public void testIsSimple(String graphFile, boolean expectedIsSimple) throws IOException {
		AdjacencyMatrixGraph testGraph = new AdjacencyMatrixGraph(loadGraphFromResource(graphFile));
		boolean actualIsSimple = testGraph.isSimple();

		Assert.assertEquals(actualIsSimple, expectedIsSimple);
	}

	@DataProvider(name = "isConnectedData")
	public static Object[][] isConnectedData() {
		return new Object[][] { { "adjacencymatrix/konigsberg.json", false },
				{ "adjacencymatrix/khanacademy.json", false }, { "adjacencymatrix/Herke03a.json", false },
				{ "adjacencymatrix/disconnected.json", false }, { "adjacencymatrix/connected_k4.json", true } };
	}

	@Test(dataProvider = "isConnectedData")
	public void testIsConnected(String graphFile, boolean expectedIsSimple) throws IOException {
		AdjacencyMatrixGraph testGraph = new AdjacencyMatrixGraph(loadGraphFromResource(graphFile));
		boolean actualIsSimple = testGraph.isConnected();

		Assert.assertEquals(actualIsSimple, expectedIsSimple);
	}

	@DataProvider(name = "isEmptyData")
	public static Object[][] isEmptyData() {
		return new Object[][] { { "adjacencymatrix/konigsberg.json", false },
				{ "adjacencymatrix/khanacademy.json", false }, { "adjacencymatrix/Herke03a.json", false },
				{ "adjacencymatrix/disconnected.json", false }, { "adjacencymatrix/connected_k4.json", false },
				{ "adjacencymatrix/empty.json", true } };
	}

	@Test(dataProvider = "isEmptyData")
	public void testIsEmpty(String graphFile, boolean expectedIsSimple) throws IOException {
		AdjacencyMatrixGraph testGraph = new AdjacencyMatrixGraph(loadGraphFromResource(graphFile));
		boolean actualIsSimple = testGraph.isEmpty();

		Assert.assertEquals(actualIsSimple, expectedIsSimple);
	}
}

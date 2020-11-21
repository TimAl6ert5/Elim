package io.github.timal6ert5.intarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.github.timal6ert5.serialize.GraphLoader;

public abstract class AbstractIntArrayGraphTest {

	private GraphLoader graphLoader = new GraphLoader();

	protected int[][] loadGraphFromResource(String resourceName) throws IOException {
		Reader reader = new BufferedReader(
				new InputStreamReader(getClass().getClassLoader().getResourceAsStream(resourceName)));
		return graphLoader.load(reader);
	}

	protected int[][] loadGraphFromFile(String filename) throws IOException {
		// Path.of...
		Reader reader = Files.newBufferedReader(Paths.get(filename));
		return graphLoader.load(reader);
	}

}

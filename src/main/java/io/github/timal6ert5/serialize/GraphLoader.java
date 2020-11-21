package io.github.timal6ert5.serialize;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.*;

public class GraphLoader {

	private Gson gson = new Gson();

	public int[][] load(String json) throws JsonSyntaxException, JsonIOException {
		return gson.fromJson(json, int[][].class);
	}

	public int[][] load(Reader json) throws JsonSyntaxException, JsonIOException {
		return gson.fromJson(json, int[][].class);
	}

	public int[][] load(Path path) throws JsonSyntaxException, JsonIOException, IOException {
		return gson.fromJson(Files.newBufferedReader(path), int[][].class);
	}
}

package io.github.timal6ert5.intarray;

public abstract class AbstractIntArrayGraph implements GraphDetails {

	protected int[][] graph;

	static int nCr(int n, int r) {
		return fact(n) / (fact(r) * fact(n - r));
	}

	static int fact(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++)
			res = res * i;
		return res;
	}
}
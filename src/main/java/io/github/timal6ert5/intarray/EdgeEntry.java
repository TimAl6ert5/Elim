package io.github.timal6ert5.intarray;

public class EdgeEntry {

	int v1, v2;

	public EdgeEntry(int v1, int v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public int getV1() {
		return v1;
	}

	public int getV2() {
		return v2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + v1;
		result = prime * result + v2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EdgeEntry other = (EdgeEntry) obj;
		if (v1 != other.v1)
			return false;
		if (v2 != other.v2)
			return false;
		return true;
	}

}

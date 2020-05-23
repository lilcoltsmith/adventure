package components;

public class CartesianPoint {
	public Integer x, y, z;

	public CartesianPoint() {
		this.x = 0; this.y = 0; this.z = 0;
	}

	public CartesianPoint(Integer x, Integer y) {
		this.x = x; this.y = y; this.z = 0;
	}

	public CartesianPoint(Integer x, Integer y, Integer z) {
		this.x = x; this.y = y; this.z = z;
	}

	@Override
	public String toString() {
		return "Cartesian Point: (" + x + ", " + y + ", " + z + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		result = prime * result + ((z == null) ? 0 : z.hashCode());
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
		CartesianPoint other = (CartesianPoint) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		if (z == null) {
			if (other.z != null)
				return false;
		} else if (!z.equals(other.z))
			return false;
		return true;
	}
}

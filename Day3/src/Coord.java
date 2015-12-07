
public class Coord<X,Y> {

	private final X x;
	private final Y y;
	
	public Coord(X x, Y y) {
		this.x = x;
		this.y = y;
	}
	
	public X getX() { return x; }
	public Y getY() { return y; }
	
	public int hashCode() { return x.hashCode() ^ y.hashCode(); }
	
	public boolean equals(Object o) {
		if (!(o instanceof Coord)) return false;
		Coord coordo = (Coord) o;
		return this.x.equals(coordo.getX()) &&
				this.y.equals(coordo.getY());
	}
}

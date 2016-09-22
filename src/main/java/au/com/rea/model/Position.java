package au.com.rea.model;

/**
 * 
 * @author Tony Wang
 *
 */
public class Position {
	public enum Orientation {
		NORTH(0), EAST(90), SOUTH(180), WEST(270);

		private int degree;

		private Orientation(int degree) {
			this.degree = degree;
		}

		public int getDegree() {
			return degree;
		}

		public static Orientation getInstance(int degree) {
			switch (degree) {
			case 0:
				return NORTH;
			case 90:
				return EAST;
			case 180:
				return SOUTH;
			case 270:
				return WEST;
			default:
				return NORTH;
			}
		}
	}

	private int x = 0;
	private int y = 0;
	private Orientation orientation = Orientation.NORTH;

	/**
	 * default constructor that defines the position of the object on the table
	 * 
	 * @param x
	 * @param y
	 * @param orientation
	 */
	public Position(int x, int y, Orientation orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
}

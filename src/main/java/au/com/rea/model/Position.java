package au.com.rea.model;

/**
 * A position object to define the x, y coordinate and orientation of an object. 
 * 
 * @author Tony Wang
 *
 */
public class Position {
	/**
	 * 
	 * A collection of possible orientation and their associated degrees
	 *
	 */
	public enum Orientation {
		NORTH(0), EAST(90), SOUTH(180), WEST(270);

		private int degree;

		/**
		 * Default constructor that takes in the degree associated with the direction
		 * 
		 * @param degree
		 */
		private Orientation(int degree) {
			this.degree = degree;
		}

		/**
		 * Retrieves the degree of the orientation
		 * 
		 * @return int degree of the orientation
		 */
		public int getDegree() {
			return degree;
		}

		/**
		 * This convert the degree back into an orientation type
		 * 
		 * @param degree
		 * @return Orientation type
		 */
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
	 * constructor that defines the position of the object on the table
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
	
	/**
	 * default constructor that set the origin of the position as x = 0, y = 0, orientation = NORTH
	 */
	public Position() {
		this.x = 0;
		this.y = 0;
		this.orientation = Orientation.NORTH;
	}

	/**
	 * Get the X coordinate
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Set the X coordinate
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Get the Y coordinate
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set the Y coordinate
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Get the orientation
	 * @return orientation
	 */
	public Orientation getOrientation() {
		return orientation;
	}

	/**
	 * Set the orientation
	 * @param orientation
	 */
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
}

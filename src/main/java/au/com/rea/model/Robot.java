package au.com.rea.model;

/**
 * 
 * This interface allows different types of robot to be create with the same basic features 
 * 
 * @author Tony Wang
 *
 */
public abstract class Robot implements Movable {
	protected int id = 0;
	protected Position position = null;
	protected TerrainData terrainData = null;
	protected boolean placed = false;
	
	/**
	 * Get the status of the robot
	 * 
	 * @returns String
	 */
	public String reportStatus() {
		return "(" + position.getX() + ", " + position.getY() + ", " + position.getOrientation() + ")";
	}

	/**
	 * Get the robot id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the position object
	 * 
	 * @return position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * This checks if the robot has been placed on the table
	 * 
	 * @return placed
	 */
	public boolean isPlaced() {
		return placed;
	}
}

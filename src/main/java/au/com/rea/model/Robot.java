package au.com.rea.model;

import au.com.rea.exception.InvalidMovementException;

/**
 * 
 * This interface allows different types of robot to be create with the same basic features 
 * 
 * @author Tony Wang
 *
 */
public abstract class Robot {
	protected int id = 0;
	protected Position position = null;
	protected TerrainData terrainData = null;
	
	/**
	 * A setter for position object to update the position, checks the boundary first
	 * 
	 * @param position defines the location and orientation of the robot
	 * @exception InvalidMovementException if the position is outside of the terrain boundaries
	 * 
	 */
	public abstract void place(Position position) throws InvalidMovementException;
	
	/**
	 * Moves the robot in a way specified by the robot type
	 * 
	 * @exception InvalidMovementException if the position is outside of the terrain boundaries
	 * 
	 */
	public abstract void moveForward() throws InvalidMovementException;

	/**
	 * Turn the robot to the right specified by the robot type
	 */
	public abstract void turnRight();

	/**
	 * Turn the robot to the left specified by the robot type
	 */
	public abstract void turnLeft();

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
}

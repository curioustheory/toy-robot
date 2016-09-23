package au.com.rea.model;

import au.com.rea.exception.InvalidMovementException;

/**
 * 
 * This interface allows different types of robot to be create with the same basic features 
 * 
 * @author Tony Wang
 *
 */
public interface Robot {
	/**
	 * A setter for position object to update the position, checks the boundary first
	 * 
	 * @param position defines the location and orientation of the robot
	 * @exception InvalidMovementException if the position is outside of the terrain boundaries
	 * 
	 */
	public void place(Position position) throws InvalidMovementException;

	/**
	 * Moves the robot in a way specified by the robot type
	 * 
	 * @exception InvalidMovementException if the position is outside of the terrain boundaries
	 * 
	 */
	public void moveForward() throws InvalidMovementException;

	/**
	 * Turn the robot to the right specified by the robot type
	 */
	public void turnRight();

	/**
	 * Turn the robot to the left specified by the robot type
	 */
	public void turnLeft();

	/**
	 * Get the status of the robot
	 * 
	 * @returns String
	 */
	public String reportStatus();

	/**
	 * Get the robot id
	 */
	public int getId();

	/**
	 * Get the position object
	 * 
	 * @return position
	 */
	public Position getPosition();
}

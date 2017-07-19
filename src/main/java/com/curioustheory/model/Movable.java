package com.curioustheory.model;

import com.curioustheory.exception.InvalidMovementException;

/**
 * This interface defines movable behaviours like move forward, turn left /
 * right, placing the object.
 * 
 * @author Tony Wang
 *
 */
public interface Movable {
	/**
	 * A setter for position object to update the position, checks the boundary
	 * first
	 * 
	 * @param position
	 *            defines the location and orientation of the robot
	 * @exception InvalidMovementException
	 *                if the position is outside of the terrain boundaries
	 * 
	 */
	public abstract void place(Position position) throws InvalidMovementException;

	/**
	 * Moves the robot in a way specified by the robot type
	 * 
	 * @exception InvalidMovementException
	 *                if the position is outside of the terrain boundaries
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

}
